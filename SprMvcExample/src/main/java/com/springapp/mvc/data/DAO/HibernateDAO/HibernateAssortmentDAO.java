package com.springapp.mvc.data.DAO.HibernateDAO;

import com.springapp.mvc.classes.Item;
import com.springapp.mvc.data.DAO.InterfaceDAO.AssortmentDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;
import java.util.List;

/**
 * Created by Анатолий on 11.11.2015.
 */
@Repository
public class HibernateAssortmentDAO implements AssortmentDAO {

    private SessionFactory sessionFactory;
    @Autowired
    private HibernateAssortmentDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<Item> getItemsByType(String type) {
        List query=currentSession().createSQLQuery("SELECT * FROM items WHERE type LIKE :type").addEntity(Item.class).setString("type", "%"+type+"%").list();
        return (List<Item>)query;
    }

    @Override
    public List<Item> getItemsByType(String type, String sortMethod) {
        List<Item> query=null;
        if (sortMethod.equals("name")) query=(List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE type LIKE :type ORDER BY name ASC").addEntity(Item.class).setString("type", "%"+type+"%").list();
        else if (sortMethod.equals("price-incr"))query=(List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE type LIKE :type ORDER BY cost ASC").addEntity(Item.class).setString("type", "%"+type+"%").list();
        else if (sortMethod.equals("price-decr")) query=(List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE type LIKE :type ORDER BY cost DESC").addEntity(Item.class).setString("type", "%"+type+"%").list();

        return query;
    }

    @Override
    public List<Item> getItemsByTwoTypes(String type1, String type2, String sortMethod) {
        List<Item> query=null;
        if (sortMethod.equals("name")) query=(List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE type LIKE :type1 AND type LIKE :type2 ORDER BY name ASC").addEntity(Item.class).setString("type1", "%" + type1 + "%").setString("type2", "%"+type2+"%").list();
        else if (sortMethod.equals("price-incr"))query=(List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE type LIKE :type1 AND type LIKE :type2 ORDER BY cost ASC").addEntity(Item.class).setString("type1", "%" + type1 + "%").setString("type2", "%"+type2+"%").list();
        else if (sortMethod.equals("price-decr")) query=(List<Item>)currentSession().createSQLQuery("SELECT * FROM items WHERE type LIKE :type1 AND type LIKE :type2 ORDER BY cost DESC").addEntity(Item.class).setString("type1", "%"+type1+"%").setString("type2", "%"+type2+"%").list();

        return query;
    }

    @Override
    public List getFavourite() {
        List query=currentSession().createSQLQuery("SELECT DISTINCT * FROM items WHERE items.itemId IN(SELECT buyings.Id FROM buyings)").addEntity(Item.class).list();
        return (List<Item>)query;
    }

    @Override
    public int getCountOfItemsByType(String type) {
        List query=currentSession().createSQLQuery("SELECT COUNT(*) FROM items WHERE type=:type").setString("type", type).list();
        return ((List<BigInteger>)query).get(0).intValue();
    }
}
