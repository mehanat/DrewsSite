package com.springapp.mvc.controllers;

import com.springapp.mvc.classes.Basket;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by Анатолий on 19.11.2015.
 */
@Controller
@Scope("session")
public class MenuBarController extends ViewPreparerSupport {
    @Override
    public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) {
        if(!tilesContext.getSessionScope().containsKey("basket")){
            tilesContext.getSessionScope().put("basket", new Basket());
        }
    }
}
