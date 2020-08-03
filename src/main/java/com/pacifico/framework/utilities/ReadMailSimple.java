package com.pacifico.framework.utilities;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadMailSimple {
    Properties properties = null;
    private String userName = "jpecho";// provide user name
    private String password = "Papa288";// provide password

    public ReadMailSimple() {

    }

    public static void main(String[] args) {
        ReadMailSimple sample = new ReadMailSimple();
        sample.readMails();
    }

    public void readMails() {
        properties = new Properties();
        properties.setProperty("mail.host", "10.1.9.51");
        properties.setProperty("mail.port", "443");
        properties.setProperty("mail.transport.protocol", "imaps");
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        try {
            Store store = session.getStore("imaps");
            store.connect();
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message messages[] = inbox.search(new FlagTerm(
                    new Flags(Flag.SEEN), false));

            System.out.println("Number of mails = " + messages.length);
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                Address[] from = message.getFrom();
                System.out.println("-------------------------------");
                System.out.println("Date : " + message.getSentDate());
                System.out.println("From : " + from[0]);
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Content :");
                processMessageBody(message);
                System.out.println("--------------------------------");

            }
            inbox.close(true);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void processMessageBody(Message message) {
        try {
            Object content = message.getContent();
            // check for string
            // then check for multipart
            if (content instanceof String) {
                System.out.println(content);
            } else if (content instanceof Multipart) {
                Multipart multiPart = (Multipart) content;
                procesMultiPart(multiPart);
            } else if (content instanceof InputStream) {
                InputStream inStream = (InputStream) content;
                int ch;
                while ((ch = inStream.read()) != -1) {
                    System.out.write(ch);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void procesMultiPart(Multipart content) {

        try {
            int multiPartCount = content.getCount();
            for (int i = 0; i < multiPartCount; i++) {
                BodyPart bodyPart = content.getBodyPart(i);
                Object o;

                o = bodyPart.getContent();
                if (o instanceof String) {
                    System.out.println(o);
                } else if (o instanceof Multipart) {
                    procesMultiPart((Multipart) o);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
