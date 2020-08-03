package com.pacifico.framework.utilities;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    public static void main(String[] args) {
        try {

            Properties props = new Properties();

            props.put("mail.smtp.host", "10.1.9.51"); //SMTP Host
            props.put("mail.smtp.socketFactory.port", "443"); //SSL Port
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
            props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
            props.put("mail.smtp.port", "443");

            /**props.setProperty("mail.host", "10.1.9.51");
             props.setProperty("mail.port", "443");
             props.setProperty("mail.transport.protocol", "ssl");**/

            /**props.put("mail.smtp.host", "10.1.9.51");
             props.put("mail.smtp.socketFactory.port", "443");
             props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
             props.put("mail.smtp.auth", "true");
             props.put("mail.smtp.port", "443");**/


            /**props.put("mail.smtp.host", "10.10.0.154");
             //props.put("mail.smtp.socketFactory.port", "443");
             //props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
             props.put("mail.smtp.auth", "true");
             //props.put("mail.smtp.port", "443");**/

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            //return new PasswordAuthentication("jpecho@axcess-financial.com","Papa288");
                            return new PasswordAuthentication("jpecho", "Papa288");
                        }
                    });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jpecho@axcess-financial.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("jpecho@axcess-financial.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler," +
                    "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

            // Session session = Session.getInstance(props, null);
            /** Store store = session.getStore();
             store.connect("imap.gmail.com", "jppm1850@gmail.com", "nathaly288");
             Folder inbox = store.getFolder("INBOX");
             inbox.open(Folder.READ_ONLY);
             Message msg = inbox.getMessage(inbox.getMessageCount());
             Address[] in = msg.getFrom();
             for (Address address : in) {
             System.out.println("FROM:" + address.toString());
             }

             Object obj = msg.getContent();
             //Multipart mp = (Multipart)obj;

             Multipart mp = (Multipart) msg.getContent();

             for(int i=0;i<mp.getCount();i++) {
             BodyPart bodyPart = mp.getBodyPart(i);
             if (bodyPart.isMimeType("text/*")) {
             String s = (String) bodyPart.getContent();
             }
             System.out.println("CONTENT:" + bodyPart.getContent().toString());
             }

             // MimeBodyPart part = (MimeBodyPart)mp.getBodyPart(0);
             // BodyPart bp = ((Multipart) msg.getContent()).getBodyPart(0);

             // Object body = msg.getContent();

             //String value = String.valueOf(body);

             System.out.println("SENT DATE:" + msg.getSentDate());
             System.out.println("SUBJECT:" + msg.getSubject());**/
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
