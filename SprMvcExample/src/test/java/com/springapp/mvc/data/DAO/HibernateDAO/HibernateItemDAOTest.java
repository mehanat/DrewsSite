package com.springapp.mvc.data.DAO.HibernateDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Анатолий on 04.04.2016.
 */

@ContextConfiguration({
        "classpath:spring-app.xml",
        "classpath:spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:myshop.sql", config = @SqlConfig(encoding = "UTF-8"))
public class HibernateItemDAOTest {

    @Test
    public void testSaveItem() throws Exception {

    }

    @Test
    public void testAddItem() throws Exception {

    }

    @Test
    public void testGetItemById() throws Exception {

    }

    @Test
    public void testGetItemByName() throws Exception {

    }

    @Test
    public void testGetComments() throws Exception {

    }

    @Test
    public void testAddComment() throws Exception {

    }
}