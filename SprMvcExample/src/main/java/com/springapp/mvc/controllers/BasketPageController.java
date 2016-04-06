package com.springapp.mvc.controllers;

import com.springapp.mvc.Utils.Mail;
import com.springapp.mvc.classes.Basket;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


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

        Basket basket=(Basket)session.getAttribute("basket");

        Mail mail = new Mail(name, deliveryType, comments, basket);
        mail.sendMail();

        session.setAttribute("basket", new Basket());
        return "redirect:/";
    }
}
