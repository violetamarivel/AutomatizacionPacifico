package com.pacifico.framework.utilities;

import com.pacifico.framework.base.EmailType;
import com.pacifico.framework.config.Settings;
import org.jsoup.Jsoup;
import org.testng.Assert;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.io.*;
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
                return new PasswordAuthentication("email_userName", "email_password");
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

//                    String bodyText = Jsoup.parse(innerHtmlFound).text();
//                    if (bodyText.contains(titular)){
                    System.out.println("--------------------------------");
                    inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), true));
                    return mapReg;
//                    break;

//                    }

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

//    public static Map<String, Object> markAllMailsRead(String host, String email_userName, String email_password) {
//
//        Map<String, Object> mapReg = new HashMap<>();
//        Properties properties = null;
//        Session session = null;
//        Store store = null;
//        Folder inbox = null;
//
//        properties = new Properties();
//        properties.setProperty("mail.host", host);
//        properties.setProperty("mail.port", "443");
//        properties.setProperty("mail.transport.protocol", "imaps");
//
////        String expEmailSubject = getSubjectByEmailType(type);
//
//        session = Session.getInstance(properties, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("email_userName", "email_password");
//            }
//        });
//        try {
//            store = session.getStore("imaps");
//            store.connect();
//            inbox = store.getFolder("INBOX");
//
//            inbox.open(Folder.READ_WRITE);
//            Message messages[] = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
//            inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), true);
//
//            inbox.close(true);
//            store.close();
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> EMAIL READ >>>>>>>>>>>>>>>>>>>>>>>>");
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
////        System.out.println("Subject [" + expEmailSubject + "] wasn't found");
//        return mapReg;
//    }



//    private static String getSubjectByEmailType(String type) {
//        switch (type) {
//            case "INVITATION_ACCOUNT":
//                return "¡No te falta nada para viajar sin preocupaciones!";
//            case "NOTIFY_HEALTH_MANAGEMENT":
//                return "[" + Settings.EmailEnv + "] Gestión de la salud";
//
//        }
//        return "";
//    }

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

    //=========================================================

    public static void sendEmail(String attachmentPath, String attachmentName, String mailList) throws IOException {

        final String username = "jericosegura@gmail.com";
        final String password = "g994769799Ee";

        String[] mails = mailList.split(",");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        for (int i = 0; i < mails.length; i++) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("thesufferfestappium@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(mails[i]));
                message.setSubject("AppiumTestReport " + getDate());
                message.setText("Dear SufferFest Tester," + "\n\n Test report attached!");
                message.setSubject("Testing Subject");
                message.setText("PFA");

                MimeBodyPart messageBodyPart = new MimeBodyPart();
                Multipart multipart = new MimeMultipart();
                messageBodyPart = new MimeBodyPart();


                File att = new File(new File(attachmentPath), attachmentName);
                messageBodyPart.attachFile(att);

                DataSource source = new FileDataSource(att);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(attachmentName);
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);

                System.out.println("Sending");
                Transport.send(message);
                Transport.send(message);
                System.out.println("Done");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void sendEmailSSL() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("userautomationTest@gmail.com", "useR2017");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("userautomationTest@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("jerico_s@hotmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler," +
                    "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void check() {
//        https://www.tutorialspoint.com/javamail_api/javamail_api_checking_emails.htm
//        (String host, String storeType, String user, String password
        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String user = "userAutomationTest@gmail.com";// change accordingly
        String password = "useR2017";// change accordingly

        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fetch(String pop3Host, String storeType, String user, String password) {

        try {
            // create properties field
//            Properties properties = new Properties();
//            properties.put("mail.store.protocol", "pop3");
//            properties.put("mail.pop3.host", pop3Host);
//            properties.put("mail.pop3.port", "995");
//            properties.put("mail.pop3.starttls.enable", "true");
//            Session emailSession = Session.getDefaultInstance(properties);

            Properties properties = System.getProperties();
            Session emailSession = Session.getDefaultInstance(properties);

            // emailSession.setDebug(true);

            // create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(pop3Host, user, password);

            // create the folder object and open it
            Folder emailFolder = store.getFolder("inbox"); //INBOX
            emailFolder.open(Folder.READ_ONLY);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // search for all "unseen" messages
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            Message messages[] = emailFolder.search(unseenFlagTerm);

            if (messages.length == 0) System.out.println("No messages found.");

            for (int i = 0; i < messages.length; i++) {
                // stop after listing ten messages
                if (i > 10) {
                    System.exit(0);
                    emailFolder.close(true);
                    store.close();
                }

                System.out.println("Message " + (i + 1));
                System.out.println("From : " + messages[i].getFrom()[0]);
                System.out.println("Subject : " + messages[i].getSubject());
                System.out.println("Sent Date : " + messages[i].getSentDate());
                System.out.println();
            }


            // retrieve the messages from the folder in an array and print it
//            Message[] messages = emailFolder.getMessages();
//            Message[] messages = emailFolder.getMessages();
//            System.out.println("messages.length---" + messages.length);
//            Flags seen = new Flags(Flags.Flag.RECENT);
//            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
//            messages = emailFolder.search(unseenFlagTerm);

//            for (int i = messages.length-1; i > 0; i--) {
//
//                Message message = messages[i];
//                System.out.println("---------------------------------");
//                writePart(message);
//                String line = reader.readLine();
//                if ("YES".equals(line)) {
//                    message.writeTo(System.out);
//                } else if ("QUIT".equals(line)) {
//                    break;
//                }
//            }

            // close the store and folder objects
//            emailFolder.close(false);
//            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * This method checks for content-type
     * based on which, it processes and
     * fetches the content of the message
     */
    public static void writePart(Part p) throws Exception {
        if (p instanceof Message)
            //Call methos writeEnvelope
            writeEnvelope((Message) p);

        System.out.println("----------------------------");
        System.out.println("CONTENT-TYPE: " + p.getContentType());

//        //check if the content is plain text
//        if (p.isMimeType("text/plain")) {
//            System.out.println("This is plain text");
//            System.out.println("---------------------------");
//            System.out.println((String) p.getContent());
//        }
//        //check if the content has attachment
//        else if (p.isMimeType("multipart/*")) {
//            System.out.println("This is a Multipart");
//            System.out.println("---------------------------");
//            Multipart mp = (Multipart) p.getContent();
//            int count = mp.getCount();
//            for (int i = 0; i < count; i++)
//                writePart(mp.getBodyPart(i));
//        }
//        //check if the content is a nested message
//        else if (p.isMimeType("message/rfc822")) {
//            System.out.println("This is a Nested Message");
//            System.out.println("---------------------------");
//            writePart((Part) p.getContent());
//        }
//        //check if the content is an inline image
//        else if (p.isMimeType("image/jpeg")) {
//            System.out.println("--------> image/jpeg");
//            Object o = p.getContent();
//
//            InputStream x = (InputStream) o;
//            // Construct the required byte array
//            System.out.println("x.length = " + x.available());
//            while ((i = (int) ((InputStream) x).available()) > 0) {
//                int result = (int) (((InputStream) x).read(bArray));
//                if (result == -1)
//                    int i = 0;
//                byte[] bArray = new byte[x.available()];
//
//                break;
//            }
//            FileOutputStream f2 = new FileOutputStream("/tmp/image.jpg");
//            f2.write(bArray);
//        }
//        else if (p.getContentType().contains("image/")) {
//            System.out.println("content type" + p.getContentType());
//            File f = new File("image" + new Date().getTime() + ".jpg");
//            DataOutputStream output = new DataOutputStream(
//                    new BufferedOutputStream(new FileOutputStream(f)));
//            com.sun.mail.util.BASE64DecoderStream test =
//                    (com.sun.mail.util.BASE64DecoderStream) p
//                            .getContent();
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = test.read(buffer)) != -1) {
//                output.write(buffer, 0, bytesRead);
//            }
//        }
//        else {
//            Object o = p.getContent();
//            if (o instanceof String) {
//                System.out.println("This is a string");
//                System.out.println("---------------------------");
//                System.out.println((String) o);
//            }
//            else if (o instanceof InputStream) {
//                System.out.println("This is just an input stream");
//                System.out.println("---------------------------");
//                InputStream is = (InputStream) o;
//                is = (InputStream) o;
//                int c;
//                while ((c = is.read()) != -1)
//                    System.out.write(c);
//            }
//            else {
//                System.out.println("This is an unknown type");
//                System.out.println("---------------------------");
//                System.out.println(o.toString());
//            }
//        }

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
