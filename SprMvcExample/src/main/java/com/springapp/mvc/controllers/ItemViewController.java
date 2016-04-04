package com.springapp.mvc.controllers;

import com.springapp.mvc.classes.Basket;
import com.springapp.mvc.classes.Comment;
import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.service.InrerfaceService.AssortmentService;
import com.springapp.mvc.data.service.InrerfaceService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Анатолий on 16.11.2015.
 */
@Controller
@RequestMapping("/item/{itemId}")
public class ItemViewController {
    @Autowired
    ItemService itemService;
    @Autowired
    AssortmentService assortmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String showItemView(@PathVariable Long itemId, ModelMap modelMap){
        assortmentService.getCountOfItemsByType("type");
        Map<String, Integer> categories=new HashMap<String, Integer>();
        categories.put("type", assortmentService.getCountOfItemsByType("type"));
        modelMap.addAttribute("countByType", categories);

        Item item=(Item)itemService.getItemById(itemId);
        modelMap.put("item", item);
        return "item-window";
    }

    @RequestMapping(value = "/add-comment",method = RequestMethod.POST)
    public String addNewComment( HttpServletResponse response, @PathVariable long itemId, @RequestParam(required = false) String name, @RequestParam(required = true) String text) {
        response.setCharacterEncoding("UTF-8");
        System.out.println(text);
        if (name.equals("")) name="Anonymous";
        Comment comment = new Comment(name, text, itemId);
        itemService.addComment(comment);
        return "redirect:/item/" + itemId;
    }
    @RequestMapping(value = "/getComments", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody
    List<Comment> getCommentsList(@PathVariable long itemId){
        return itemService.getComments(itemId);
    }

}
