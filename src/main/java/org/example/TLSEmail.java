package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;



/**
 * Send Email in Java SMTP with TLS Authentication
 * With attachment and image
 */
public class TLSEmail {

    /**
     Outgoing Mail (SMTP) Server
     requires TLS or SSL: smtp.gmail.com (use authentication)
     Use Authentication: Yes
     Port for TLS/STARTTLS: 587
     */
    public static void main(String[] args) {

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        try {
            String to="shariqbtech@gmail.com";
            String from="mohammedshariqalvi@outlook.com";

            //Properties props = new Properties();
//            props.put("mail.smtp.socketFactory.port", "587");
//            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.socketFactory.fallback", "true");
            props.put("mail.smtp.host", "smtp-mail.outlook.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.auth", "true");
            //props.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");
            //props.put("mail.transport.protocol", "smtp");
            //props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("mohammedshariqalvi@outlook.com","Pristine4588");
                        }
                    });
            session.setDebug(true);

//            Session emailSession = Session.getDefaultInstance(props, null);

            String msgBody = "Sending email using JavaMail API...";

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from, "NoReply"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to, "Mr. Recipient"));
            msg.setSubject("Welcome To Java Mail API");
            msg.setText(msgBody);
            Transport.send(msg);
            System.out.println("Email sent successfully...");
           // logger.error("Email sent successfully...");
        } catch (AddressException e) {
            //logger.error(e.getMessage());
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            //logger.error(e.getMessage());
        }

    }

}
