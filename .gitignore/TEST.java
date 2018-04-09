Import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
 
public class SendEmail {
     public static void main(String args[]){
         String msgBody = "這是 JavaMail APIs.傳送的訊息\n李俊緯 上";
         Properties props = new Properties();
         props.put("mail.smtp.host", "mail.ncku.edu.tw"); //設定SMTP Server
         Session session = Session.getDefaultInstance(props, null); //取得與SMTP Server的連線
         try {
              Message msg = new MimeMessage(session); //取得一Mime的Message
            //設定自己的email帳號
              InternetAddress from = new InternetAddress("cww5@mail.ncku.edu.tw");
              // InternetAddress from = new InternetAddress("juiwei830401@gmail.com", "李俊緯");
              msg.setFrom(from);
             //設定接收者的帳號，可以有多個帳號同時傳送
              InternetAddress[] address = {new InternetAddress("juiwei830401@gmail.com")};
              msg.setRecipients(Message.RecipientType.TO, address);
             /* 有需要時，可以加入CC /BCC，
                如果只一位receipt可用
                Address addr = new InternetAddress("cww@mail.hosp.ncku.edu.tw")
                msg.serReceipt(Message.RecipientType.TO, addr)
                InternetAddress ccAddress = new InternetAddress("juiwei830401@gmail.com");
                InternetAddress bccAddress = new InternetAddress("juiwei830401@gmail.com");
                msg.addRecipient(Message.RecipientType.CC, ccAddress);
                msg.addRecipient(Message.RecipientType.BCC, bccAddress);
             */
              msg.setSubject("您好，這是JavaMail的信件");
              msg.setContent(msgBody, "text/plain;charset=big5");
              Transport.send(msg);
             /*也可以如此做
               msg.saveChanges(); 
               Transport transport = session.getTransport("smtp");
               transport.connect(“mail.ncku.edu.tw”, “UID”, “PWD”);
               transport.sendMessage(msg, msg.getAllRecipients());
               transport.close();
              */
         } catch (MessagingException mex) {mex.printStackTrace();
} catch (Exception e) {}
     }
}
