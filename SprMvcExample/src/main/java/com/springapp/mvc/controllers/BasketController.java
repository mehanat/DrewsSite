package com.springapp.mvc.controllers;

import com.springapp.mvc.classes.Basket;
import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.service.InrerfaceService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Анатолий on 17.11.2015.
 */
@Controller
@SessionAttributes(value = "basket")
public class BasketController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/addToBasket", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody Basket addToBasket(@RequestParam Long itemId, @RequestParam int amount, HttpSession session){
        Item item=itemService.getItemById(itemId);

        Basket basket= (Basket) session.getAttribute("basket");
        basket.addItem(item, amount);

        return basket;
    }
    @RequestMapping(value = "/getBasket", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody HashMap<Item, Basket.StackInfo> getBasketList(HttpSession session){
        Basket basket= (Basket) session.getAttribute("basket");
        return basket.getItems();
    }
    @RequestMapping(value = "/deleteFromBasket", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody Basket deleteFromBasketList(@RequestParam Long itemId, HttpSession session){
        Basket basket= (Basket) session.getAttribute("basket");
        basket.deleteItem(itemId);

        return basket;
    }

}
