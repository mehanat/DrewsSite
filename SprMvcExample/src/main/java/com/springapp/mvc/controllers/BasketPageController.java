package com.springapp.mvc.controllers;

import com.springapp.mvc.classes.Basket;

import com.springapp.mvc.classes.Item;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.*;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Анатолий on 21.11.2015.
 */
@Controller
@RequestMapping("/basket")
public class BasketPageController {
    @RequestMapping(method = RequestMethod.GET)
    public String getBasketPage(HttpSession session, ModelMap model){
        Basket basket= (Basket) session.getAttribute("basket");
        model.addAttribute(basket);
        return "basket-page";
    }

    @RequestMapping(value = "/new-order", method = RequestMethod.POST)
    public String mekeOrder(HttpSession session, HttpServletResponse response, @RequestParam(required = false) String name, @RequestParam(required = false) String deliveryType, @RequestParam(required = false) String comments) throws UnsupportedEncodingException {

        response.setCharacterEncoding("UTF-8");
        String letter=String.format("%s %s %s Покупки:", name, deliveryType, comments);
        Basket basket=(Basket)session.getAttribute("basket");
        Iterator<Map.Entry<Item, Basket.StackInfo>> iterator=basket.getItems().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Item, Basket.StackInfo> pair=iterator.next();
            letter+=String.format(" %s x%s", pair.getKey().getName(), pair.getValue().getAmount());
        }
        letter+=" Итог: "+basket.getTotalCost();
        session.setAttribute("basket", new Basket());
        try{
            final String fromEmail = "hse.choco.shop@gmail.com"; //requires valid gmail id
            final String password = "hsenumberone"; // correct password for gmail id
            final String toEmail = "hse.choco.shop@gmail.com"; // can be any email id

            System.out.println("TLSEmail Start");
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

            message.setText(letter);

            Transport.send(message);
        }catch(Exception ex){
            System.out.println("Mail fail");
            System.out.println(ex);
        }


        return "redirect:/";
    }
}
