package com.springapp.mvc.data.service.InrerfaceService;

import com.springapp.mvc.classes.Comment;
import com.springapp.mvc.classes.Item;

import java.util.List;


public interface ItemService {
    void saveItem(Item item);
    void addItem(Item item);
    Item getItemById(long id);
    Item getItemByName(String name);
    List<Comment> getComments(long id);
    void addComment(Comment comment);
}
