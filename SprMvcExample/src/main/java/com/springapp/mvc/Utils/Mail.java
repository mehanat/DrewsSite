package com.springapp.mvc.Utils;

import com.springapp.mvc.classes.Basket;
import com.springapp.mvc.classes.Item;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Анатолий on 06.04.2016.
 */
public class Mail {

    private String name;
    private String delivery;
    private String comment;
    private Basket basket;

    public Mail(String name, String delivery, String comment, Basket basket) {
        this.name = name;
        this.delivery = delivery;
        this.comment = comment;
        this.basket = basket;
    }

    public void sendMail(){
        try{
            final String fromEmail = "hse.choco.shop@gmail.com"; //requires valid gmail id
            final String password = "hsenumberone"; // correct password for gmail id
            final String toEmail = "hse.choco.shop@gmail.com"; // can be any email id

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            javax.mail.Session sessionMail = javax.mail.Session.getInstance(props, auth);

            MimeMessage message = new MimeMessage(sessionMail);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            message.setSubject("Заказ");

            message.setText(this.toString());

            Transport.send(message);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String letter=String.format("%s %s %s Покупки:", name, delivery, comment);
        for (Map.Entry<Item, Basket.StackInfo> pair : basket.getItems().entrySet()) {
            letter += String.format(" %s x%s", pair.getKey().getName(), pair.getValue().getAmount());
        }
        letter+=" Итог: "+basket.getTotalCost();
        return letter;
    }
}
