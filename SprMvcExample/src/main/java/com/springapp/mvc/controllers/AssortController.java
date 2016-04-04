package com.springapp.mvc.controllers;

import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.service.InrerfaceService.AssortmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Анатолий on 10.11.2015.
 */
@Controller
@RequestMapping("/assortment-types")
public class AssortController {
    @Autowired
    AssortmentService assortmentService;


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        assortmentService.getCountOfItemsByType("type");
        Map<String, Integer> categories=new HashMap<String, Integer>();
        categories.put("type", assortmentService.getCountOfItemsByType("type"));
        model.addAttribute("countByType", categories);
        return "assortment-types";
    }


    @RequestMapping(value = "/{category1}/{category2}", method = RequestMethod.GET)
    public String show2Category(@PathVariable String category1, @PathVariable String category2, ModelMap modelMap){

        if(category1.equals("all")) category1="";
        if(category2.equals("all")) category2="";

        Map<String, Integer> categories=new HashMap<String, Integer>();
        categories.put("type", assortmentService.getCountOfItemsByType("type"));
        modelMap.addAttribute("countByType", categories);

        List<Item> items = assortmentService.getItemsByTwoTypes(category1, category2, "name");
        modelMap.addAttribute("items", items);

        return "assortment";
    }

    @RequestMapping(value = "/{category1}/{category2}", method = RequestMethod.GET, params = "sortMethod")
    public String showCategorySorted(@PathVariable String category1, @PathVariable String category2, @RequestParam String sortMethod, ModelMap modelMap){

        if(category1.equals("all")) category1="";
        if(category2.equals("all")) category2="";

        assortmentService.getCountOfItemsByType("type");
        Map<String, Integer> categories=new HashMap<String, Integer>();
        categories.put("type", assortmentService.getCountOfItemsByType("type"));
        modelMap.addAttribute("countByType", categories);
        List<Item> items=assortmentService.getItemsByTwoTypes(category1, category2, sortMethod);

        modelMap.addAttribute("items", items);

        return "assortment";
    }


}
