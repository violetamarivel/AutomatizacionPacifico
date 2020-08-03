package com.pacifico.framework.utilities;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class ReadMail {

    public static void main(String[] args) {
        try {

            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imap");

            Session session = Session.getInstance(props, null);
            Store store = session.getStore("imap");
            store.connect("10.10.0.154", "acctintegration", "password");
            System.out.println(store);

            Folder inbox = store.getFolder("Inbox");
            System.out.println("No of Unread Messages : " + inbox.getUnreadMessageCount());


            /**Properties props = new Properties();


             props.put("mail.smtp.host", "10.10.0.154");
             props.put("mail.smtp.auth", "true");


             Session session = Session.getDefaultInstance(props,
             new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication("acctintegration","goc0d4");
             }
             });

             Store store=session.getStore();

             Folder inbox = store.getFolder("INBOX");
             inbox.open(Folder.READ_ONLY);
             Message msg = inbox.getMessage(inbox.getMessageCount());
             Address[] in = msg.getFrom();
             for (Address address : in) {
             System.out.println("FROM:" + address.toString());
             }

             Object obj = msg.getContent();


             Multipart mp = (Multipart) msg.getContent();

             for(int i=0;i<mp.getCount();i++) {
             BodyPart bodyPart = mp.getBodyPart(i);
             if (bodyPart.isMimeType("text/*")) {
             String s = (String) bodyPart.getContent();
             }
             System.out.println("CONTENT:" + bodyPart.getContent().toString());
             }



             System.out.println("SENT DATE:" + msg.getSentDate());
             System.out.println("SUBJECT:" + msg.getSubject());**/
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
