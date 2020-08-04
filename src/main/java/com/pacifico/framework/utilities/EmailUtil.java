package com.pacifico.framework.utilities;

import com.pacifico.framework.base.EmailType;
import com.pacifico.framework.config.Settings;
import org.jsoup.Jsoup;
import org.testng.Assert;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by jsegura on 31/08/17.
 */
public class EmailUtil {

    public static Map<String, Object> readMails(String host, String email_userName, String email_password, EmailType type) {

        Map<String, Object> mapReg = new HashMap<>();
        Properties properties = null;
        Session session = null;
        Store store = null;
        Folder inbox = null;

        properties = new Properties();
        properties.setProperty("mail.host", host);
        properties.setProperty("mail.port", "443");
        properties.setProperty("mail.transport.protocol", "imaps");

        String expEmailSubject = getSubjectByEmailType(type);

        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email_userName, email_password);
            }
        });
        try {
            store = session.getStore("imaps");
            store.connect();

            inbox = store.getFolder("INBOX");

            inbox.open(Folder.READ_WRITE);
            Message messages[] = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            System.out.println("Number of mails = " + messages.length + "\n");
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];

                System.out.println("Subject found [" + message.getSubject() + "]");
                System.out.println("Subject expected [" + expEmailSubject + "]");

                if (message.getSubject().toLowerCase().contains(expEmailSubject.toLowerCase()) || expEmailSubject.equals("")) {

                    Address[] from = message.getFrom();
                    System.out.println("-------------------------------");
                    System.out.println("Date : " + message.getSentDate());
                    System.out.println("From : " + from[0]);
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("Content :");
                    String innerHtmlFound = processMessageBody(message).toString();

                    mapReg.put("date", message.getSentDate());
                    mapReg.put("from", from[0]);
                    mapReg.put("subject", message.getSubject());
                    mapReg.put("innerHtml", innerHtmlFound);
                    mapReg.put("htmlText", Jsoup.parse(innerHtmlFound).text());
                    mapReg.put("totalEmails", messages.length);

                    System.out.println("--------------------------------");
                    inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), true));
                    return mapReg;

                }

            }

            inbox.close(true);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("Subject [" + expEmailSubject + "] wasn't found");
        return mapReg;
    }

    public static Map<String, Object> markAllMailsRead(String host, String email_userName, String email_password) {

        Map<String, Object> mapReg = new HashMap<>();
        Properties properties = null;
        Session session = null;
        Store store = null;
        Folder inbox = null;

        properties = new Properties();
        properties.setProperty("mail.host", host);
        properties.setProperty("mail.port", "443");
        properties.setProperty("mail.transport.protocol", "imaps");

        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email_userName, email_password);
            }
        });
        try {
            store = session.getStore("imaps");
            store.connect();
            inbox = store.getFolder("INBOX");

            inbox.open(Folder.READ_WRITE);
            Message messages[] = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), true);

            inbox.close(true);
            store.close();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> EMAIL READ >>>>>>>>>>>>>>>>>>>>>>>>");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

//        System.out.println("Subject [" + expEmailSubject + "] wasn't found");
        return mapReg;
    }

    private static String getSubjectByEmailType(EmailType type) {

        switch (type) {
            case NOTIFY_VEHICLE_CONFIRM_EMAIL:
                return Settings.EmailEnv + " Tu seguro de auto ha sido activado";
            default:
                Assert.fail("Email type don't exist");
        }
        return "";
    }

    public static Object processMessageBody(Message message) {
        try {
            Object content = message.getContent();
            // check for string
            // then check for multipart
            if (content instanceof String) {
                System.out.println(content);
                return content;
            } else if (content instanceof Multipart) {
                Multipart multiPart = (Multipart) content;
                return procesMultiPart(multiPart);
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
        return null;
    }

    public static Object procesMultiPart(Multipart content) {

        Object strText = "";
        try {
            int multiPartCount = content.getCount();
            for (int i = 0; i < multiPartCount; i++) {
                BodyPart bodyPart = content.getBodyPart(i);
                Object o = bodyPart.getContent();
                if (o instanceof String) {
                    //System.out.println(o);
                    strText = o;
                    //System.out.println(strText + "YAAAAAAAAAAAAAAAAAAAAAAaa");
                } else if (o instanceof Multipart) {
                    procesMultiPart((Multipart) o);
                    strText = initialMulti((Multipart) o);
                    System.out.println("====================> Entro 2");
                } else {
                    System.out.println("Don't exist instance");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return strText;
    }

    private static Object initialMulti(Multipart content) {

        Object strText = "";
        try {
            BodyPart bodyPart = content.getBodyPart(0);
            Object o = bodyPart.getContent();
            if (o instanceof String) {
                strText = o;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

//        strText = strText.toString().replaceAll("\\s+","");
        return strText;
    }

    /*
     * This method would print FROM,TO and SUBJECT of the message
     */
    public static void writeEnvelope(Message m) throws Exception {
        System.out.println("This is the message envelope");
        System.out.println("---------------------------");
        Address[] a;

        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++) {
                System.out.println("FROM: " + a[j].toString());
            }

        }

        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++)
                System.out.println("TO: " + a[j].toString());
        }

        // SUBJECT
        if (m.getSubject() != null)
            System.out.println("SUBJECT: " + m.getSubject());

        System.out.println("DATE: " + m.getSentDate());
    }


    public static String getDate() {
        String date = "";
//
//        DateTime dateTime = new DateTime();
//        date = date + dateTime.year().getAsString()+"_";
//        date = date + dateTime.monthOfYear().getAsString()+"_";
//        date = date + dateTime.dayOfMonth().getAsString()+"_";
//        date = date + dateTime.hourOfDay().getAsString()+"_";
//        date = date + dateTime.minuteOfHour().getAsString()+"_";
//        date = date + dateTime.secondOfMinute().getAsString()+"_";
//        date = date + dateTime.millisOfSecond().getAsString();

        return date;
    }
}
