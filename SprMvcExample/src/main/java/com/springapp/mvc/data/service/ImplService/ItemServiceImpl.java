package com.springapp.mvc.data.service.ImplService;

import com.springapp.mvc.classes.Comment;
import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.DAO.InterfaceDAO.ItemDAO;
import com.springapp.mvc.data.service.InrerfaceService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Анатолий on 10.11.2015.
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO hibernateItemDAO;


    public void saveItem(Item item) {

    }


    public Item addItem(Item item) {
        return hibernateItemDAO.addItem(item);
    }


    @Transactional
    public Item getItemById(long id) {
        return hibernateItemDAO.getItemById(id);
    }

    @Override
    public Item getItemByName(String name) {
        return hibernateItemDAO.getItemByName(name);
    }

    @Override
    public List<Item> getAll() {
        return hibernateItemDAO.getAll();
    }

    @Override
    public List<Comment> getComments(long id) {
        return hibernateItemDAO.getComments(id);
    }

    @Override
    public void addComment(Comment comment) {
        hibernateItemDAO.addComment(comment);
    }
}
