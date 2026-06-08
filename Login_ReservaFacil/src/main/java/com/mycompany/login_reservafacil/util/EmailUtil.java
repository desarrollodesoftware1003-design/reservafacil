package com.mycompany.login_reservafacil.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {

    public static void enviarCorreo(String destino, String enlace) {

        final String remitente = "reservafacillapp@gmail.com";
        final String password = "aubxvnviyyduufba";

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, password);
            }
        });

        try {

            Message mensaje = new MimeMessage(session);

            mensaje.setFrom(new InternetAddress(remitente));

            mensaje.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destino)
            );

            mensaje.setSubject("Recuperación de contraseña - ReservaFácil");

            mensaje.setText(
            "Hola,\n\n" +
            "Haz clic en el siguiente enlace para restablecer tu contraseña:\n\n" +
            enlace +
            "\n\nSi no solicitaste este cambio, ignora este correo.\n\n" +
            "Equipo ReservaFácil"
            );

            Transport.send(mensaje);

            System.out.println("Correo enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}