package com.springapp.mvc.data.DAO.InterfaceDAO;

import com.springapp.mvc.classes.Item;

import java.util.List;

/**
 * Created by Анатолий on 11.11.2015.
 */
public interface AssortmentDAO {
    List getItemsByType(String type);
    List getItemsByType(String type, String sortMethod);
    List getItemsByTwoTypes(String type1, String type2, String sortMethod);
    List getFavourite();
    int getCountOfItemsByType(String type);
}
