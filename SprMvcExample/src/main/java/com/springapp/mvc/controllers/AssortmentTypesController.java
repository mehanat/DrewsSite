package com.springapp.mvc.controllers;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Scope("session")
public class AssortmentTypesController extends ViewPreparerSupport{
    @Override
    public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) {
        Map<String, Integer> categories=(Map<String, Integer>) tilesContext.getRequestScope().get("countByType");

        tilesContext.getRequestScope().put("countByType", categories);
    }
}
