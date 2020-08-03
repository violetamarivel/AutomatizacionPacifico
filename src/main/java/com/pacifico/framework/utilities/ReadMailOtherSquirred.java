package com.pacifico.framework.utilities;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class ReadMailOtherSquirred {

    public static void main(String[] args) {
        ReadMailOtherSquirred readMailOther = new ReadMailOtherSquirred();
        readMailOther.read();
    }

    public void read() {
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "10.10.0.154");
            Session session = Session.getInstance(props, null);
            session.setDebug(true);
            // session.setDebug(true);

            // Get a Store object
            Store store = session.getStore("imap");

            // Connect
            store.connect("10.10.0.154", "acctintegration", "goc0d4");

            // Open a Folder
            Folder folder = store.getFolder("inbox");

            folder.open(Folder.READ_WRITE);

            Message[] message = folder.getMessages();
            Message[] msgs = folder.getMessages(message.length - 1, message.length);

            for (int i = 0; i < msgs.length; i++) {
                System.out.println("subject" + msgs[i].getSubject());
                System.out.println("content" + msgs[i].getContent());
                //System.out.println("Message "+ msgs[i].getMessageNumber() + ":");
                /**MimeMultipart mimeMultipart=(MimeMultipart)msgs[i].getContent();


                 for (int j = 0; j < mimeMultipart.getCount(); j++) {

                 BodyPart bodyPart = mimeMultipart.getBodyPart(j);

                 String disposition = bodyPart.getDisposition();

                 if (disposition != null && (disposition.equalsIgnoreCase("ATTACHMENT"))) {
                 System.out.println("Mail have some attachment");

                 DataHandler handler = bodyPart.getDataHandler();
                 System.out.println("file name : " + handler.getName());
                 }
                 else {
                 //  content = getText(bodyPart);  // the changed code
                 }
                 }

                 //	System.out.println("subject"+mimeMultipart.get);
                 message[i].writeTo(System.out);**/
            }


            /**
             // Add messageCountListener to listen for new messages
             folder.addMessageCountListener(new MessageCountAdapter() {

             public void messagesAdded(MessageCountEvent ev) {
             System.out.println("message listner invoked.");
             Message[] msgs = ev.getMessages();

             System.out.println("Got " + msgs.length + " new messages");

             // Just dump out the new messages
             for (int i = 0; i < msgs.length; i++) {
             System.out.println("-----");
             try {
             System.out.println("subject"+msgs[i].getSubject());
             System.out.println("Message "+ msgs[i].getMessageNumber() + ":");
             msgs[i].writeTo(System.out);
             } catch (MessagingException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
             } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
             }
             }
             }

             /*
             * (non-Javadoc)
             *
             * @see
             * javax.mail.event.MessageCountListener#messagesRemoved(javax
             * .mail.event.MessageCountEvent)
             */
            /**public void messagesRemoved(MessageCountEvent arg0) {
             // TODO Auto-generated method stub

             }

             });

             // Check mail once in "freq" MILLIseconds
             int freq = Integer.parseInt("5000");

             for (;;) {
             System.out.println("Theread will sleep for 5 seconds");
             Thread.sleep(freq); // sleep for freq milliseconds
             System.out.println("Thread awake after 5 seconds");
             System.out.println("message count in folder is "+ folder.getMessageCount());
             System.out.println();
             System.out.println();
             }**/

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
