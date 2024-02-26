package com.example.BackendCrud.UserProduct.management.system.services;

import com.example.BackendCrud.UserProduct.management.system.entities.Product;
import com.example.BackendCrud.UserProduct.management.system.entities.User;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.Properties;

@Service
public class MailingService {

    //sender and password should be injected and not hardcoded
    final private static String sender = "example@email.com";
    final private static String password = "some password from gmail SMTP";


    private MailingService(){} //no instance is needed to use the service


    public static void send(String from,String password,String to,String sub,String msg) {
        //Get properties object

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message
        try {
            javax.mail.internet.MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (javax.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public static void sendTransactionEmail(Product product, User user){

        String recipientEmail = user.getEmail();
        String subject = "Successful Transaction";
        String content = """
                Dear Customer, We Want to inform you that your Transaction has been done successfully
                you have bought %s that cost %.2f
                """;
        content = String.format(content, product.getName(), product.getPrice() );

        send(sender, password,recipientEmail, subject, content);
        System.out.println("Email sent successfully.");
    }
}
