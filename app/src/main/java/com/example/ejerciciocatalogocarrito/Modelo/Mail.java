package com.example.ejerciciocatalogocarrito.Modelo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import com.example.ejerciciocatalogocarrito.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class Mail {
    private String remitente;
    private String remitentePass;
    private String destinatario;
    private String asunto;
    private String mensaje;

    public Mail(Resources resources, String destinatario, String asunto, String mensaje) {
        remitente = resources.getString(R.string.mail_user);
        remitentePass = resources.getString(R.string.mail_pass);
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public void enviarMensaje() throws MessagingException {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host","smtp.googlemail.com");
        propiedades.put("mail.smtp.socketFactory.port","465");
        propiedades.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        propiedades.put("mail.smtp.auth","true");
        propiedades.put("mail.smtp.port","465");

        StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);

        Session session = Session.getDefaultInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, remitentePass);
            }
        });

        if(session != null){
            Message aviso = new MimeMessage(session);
            aviso.setFrom(new InternetAddress(remitente));
            aviso.setSubject(asunto);
            aviso.setRecipient(Message.RecipientType.TO, InternetAddress.parse(destinatario)[0]);
            aviso.setContent(mensaje, "text/html; charset=utf-8");
            Transport.send(aviso);
        }
    }

    public void enviarMensaje(Resources resources, Carrito carrito) throws MessagingException, IOException {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host","smtp.googlemail.com");
        propiedades.put("mail.smtp.socketFactory.port","465");
        propiedades.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        propiedades.put("mail.smtp.auth","true");
        propiedades.put("mail.smtp.port","465");

        StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);

        Session session = Session.getDefaultInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, remitentePass);
            }
        });

        if(session != null){
            Message aviso = new MimeMessage(session);
            aviso.setFrom(new InternetAddress(remitente));
            aviso.setSubject(asunto);
            aviso.setRecipient(Message.RecipientType.TO,InternetAddress.parse(destinatario)[0]);

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(mensaje, "text/html; charset=utf-8");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();

            Drawable drawable = resources.getDrawable(R.drawable.box);
            BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            InputStream is = new ByteArrayInputStream(stream.toByteArray());

            DataSource fds = new ByteArrayDataSource(is, "image/png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);

            aviso.setContent(multipart);
            Log.e("YoMero: ", "send()");
            Transport.send(aviso);
        }
    }
}
