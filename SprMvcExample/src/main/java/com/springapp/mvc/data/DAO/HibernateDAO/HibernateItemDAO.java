package com.springapp.mvc.data.DAO.HibernateDAO;

import com.springapp.mvc.classes.Comment;
import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.DAO.InterfaceDAO.ItemDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;


/**
 * Created by Анатолий on 10.11.2015.
 */
@Repository
public class HibernateItemDAO implements ItemDAO {
    private SessionFactory sessionFactory;
    @Autowired
    public HibernateItemDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveItem(Item item) {
       currentSession().update(item);
    }

    @Override
    public Item addItem(Item item) {
        return (Item) currentSession().save(item);
    }

    @Override
    public Item getItemById(long id) {
        return (Item) currentSession().get(Item.class, id);
    }

    @Override
    public Item getItemByName(String name) {
        return (Item) DataAccessUtils.singleResult(currentSession().getNamedQuery(Item.GET_BY_NAME).setString("name", name).list());
        //return ((List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE name=:name").addEntity(Item.class).setString("name", name).list()).get(0);
    }

    @Override
    public List<Item> getAll() {
        return (List<Item>) currentSession().getNamedQuery(Item.GET_ALL).list();
    }

    @Override
    public List<Comment> getComments(long id) {
        return (List<Comment>) currentSession().getNamedQuery(Item.GET_COMMENTS).setLong("itemId", id).list();
        //return ((List<Comment>)currentSession().createSQLQuery("SELECT * FROM comments WHERE itemId=:id").addEntity(Comment.class).setLong("id", id).list());
    }

    @Override
    public void addComment(Comment comment) {
        currentSession().save(comment);
    }
}
