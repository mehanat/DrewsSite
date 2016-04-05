package com.springapp.mvc.classes;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class Basket implements Serializable{

    public class StackInfo implements Serializable{
        int amount;
        int stackPrice;

        public StackInfo() {
        }

        public StackInfo(int stackPrice, int amount) {
            this.stackPrice = stackPrice;
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getStackPrice() {
            return stackPrice;
        }

        public void setStackPrice(int stackPrice) {
            this.stackPrice = stackPrice;
        }
    }
    HashMap<Item, StackInfo> items=new HashMap<Item, StackInfo>();

    int totalCost;

    public Basket() {
    }

    public Basket(HashMap<Item, StackInfo> items) {
        this.items = items;
    }

    public HashMap<Item, StackInfo> getItems() {
        return items;
    }

    private void setItems(HashMap<Item, StackInfo> items) {
        this.items = items;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalCost(){
        int cost=0;
        for(Map.Entry<Item, StackInfo> item: items.entrySet()){
            cost+=item.getKey().getCost()*item.getValue().getAmount();
        }
        return cost;
    }


    public void addItem(Item item, int amount){
        Iterator iterator=getItems().entrySet().iterator();
        if (getItems().containsKey(item)) {
            while (iterator.hasNext()) {
                Map.Entry<Item, StackInfo> pair = (Map.Entry<Item, StackInfo>) iterator.next();
                if (pair.getKey().equals(item)) {
                    int itemsAmount=pair.getValue().amount+amount;
                    pair.setValue(new StackInfo(pair.getKey().getCost()*itemsAmount, itemsAmount));
                }
            }
        } else items.put(item, new StackInfo(item.getCost()*amount, amount));
    }
    public void deleteItem(Long itemId){
        Iterator iterator=getItems().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Item, StackInfo> pair = (Map.Entry<Item, StackInfo>) iterator.next();
            if (pair.getKey().getItemId()==itemId) {
                items.remove(pair.getKey());
                break;
            }
        }

    }
}
