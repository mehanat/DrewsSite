package com.springapp.mvc.classes;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Анатолий on 10.11.2015.
 */
@Entity
@Table(name = "items")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="itemId")
    private long itemId;
    @OneToOne(cascade=CascadeType.ALL, mappedBy="item")
    private ItemFeatures itemFeatures;
    @Column(name = "cost")
    private int cost;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "imagePath")
    private String imagePath;


    public long getItemId() {
        return itemId;
    }

    private void setItemId(long id) {
        this.itemId = id;
    }

    public ItemFeatures getItemFeatures() {
        return itemFeatures;
    }

    public void setItemFeatures(ItemFeatures itemFeatures) {
        this.itemFeatures = itemFeatures;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return itemId == item.itemId;

    }

    @Override
    public int hashCode() {
        return (int) (itemId ^ (itemId >>> 32));
    }
}
