package com.springapp.mvc.data.service.ImplService;

import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.DAO.InterfaceDAO.AssortmentDAO;
import com.springapp.mvc.data.service.InrerfaceService.AssortmentService;
import com.springapp.mvc.data.service.InrerfaceService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Анатолий on 11.11.2015.
 */
@Service
@Transactional
public class AssortmentServiceImpl implements AssortmentService {
    @Autowired
    AssortmentDAO assortmentDAO;

    @Transactional
    public List<Item> getItemsByType(String type) {
        return assortmentDAO.getItemsByType(type);
    }

    @Override
    public List getItemsByType(String type, String sortMethod) {
        return assortmentDAO.getItemsByType(type, sortMethod);
    }

    @Override
    public List getItemsByTwoTypes(String type1, String type2, String sortMethod) {
        return assortmentDAO.getItemsByTwoTypes(type1, type2, sortMethod);
    }

    @Transactional
    public List getFavourite() {
        return assortmentDAO.getFavourite();
    }

    @Transactional
    public int getCountOfItemsByType(String type) {
        return assortmentDAO.getCountOfItemsByType(type);
    }
}
