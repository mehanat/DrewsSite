package com.springapp.mvc.data.DAO.InterfaceDAO;

import com.springapp.mvc.classes.Comment;
import com.springapp.mvc.classes.Item;

import java.util.List;

/**
 * Created by Анатолий on 10.11.2015.
 */
public interface ItemDAO {
    void saveItem(Item item);
    Item addItem(Item item);
    Item getItemById(long id);
    Item getItemByName(String name);
    List<Item> getAll();
    List<Comment> getComments(long id);
    void addComment(Comment comment);
}
