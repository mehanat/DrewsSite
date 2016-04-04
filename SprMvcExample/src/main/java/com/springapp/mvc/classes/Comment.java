package com.springapp.mvc.classes;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Анатолий on 27.12.2015.
 */
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "itemId")
    private long itemId;
    @Column(name = "authorName")
    private String authorName;
    @Column(name = "date")
    private Date date;
    @Column(name = "text")
    private String text;

    public Comment() {
    }

    public Comment(String authorName, String text, long itemId) {
        this.authorName = authorName;
        this.text = text;
        this.itemId = itemId;
        this.date=new Date();
    }

    public long getItemId() {
        return itemId;
    }

    private void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
