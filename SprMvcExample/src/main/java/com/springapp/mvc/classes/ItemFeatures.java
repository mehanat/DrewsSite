package com.springapp.mvc.classes;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
@Entity
@Table(name = "features")
public class ItemFeatures {
    @Id
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter(value="item", name = "property"))
    private long itemId;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="itemId")
    private Item item;
    @Column(name = "weight")
    private int weight;
    @Column(name = "protein")
    private int protein;
    @Column(name = "carbohydrates")
    private int carbohydrates;
    @Column(name = "energy_value")
    private int energy_value;
    @Column(name = "calories")
    private int calories;

    public ItemFeatures() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getItemId() {
        return itemId;
    }

    private void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getEnergy_value() {
        return energy_value;
    }

    public void setEnergy_value(int energy_value) {
        this.energy_value = energy_value;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
