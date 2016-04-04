package com.springapp.mvc.data.DAO.HibernateDAO;

import com.springapp.mvc.classes.Comment;
import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.DAO.InterfaceDAO.ItemDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    public void addItem(Item item) {
        currentSession().save(item);
    }


    public Item getItemById(long id) {
        return (Item) currentSession().get(Item.class, id);
    }

    @Override
    public Item getItemByName(String name) {
        return ((List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE name=:name").addEntity(Item.class).setString("name", name).list()).get(0);
    }

    @Override
    public List<Comment> getComments(long id) {
        return ((List<Comment>)currentSession().createSQLQuery("SELECT * FROM comments WHERE itemId=:id").addEntity(Comment.class).setLong("id", id).list());
    }

    @Override
    public void addComment(Comment comment) {
        currentSession().save(comment);
    }
}
