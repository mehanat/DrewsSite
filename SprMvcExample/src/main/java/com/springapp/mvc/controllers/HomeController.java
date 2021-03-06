package com.springapp.mvc.controllers;

import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.service.InrerfaceService.AssortmentService;
import com.springapp.mvc.data.service.InrerfaceService.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	ItemService itemService;
	@Autowired
	AssortmentService assortmentService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("favourite", assortmentService.getFavourite());
		return "home";
	}

	@RequestMapping(value = "/getItem/{itemId}", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Item getItem(@PathVariable Long itemId){
		Item item=itemService.getItemById(itemId);
		return item;
	}

}