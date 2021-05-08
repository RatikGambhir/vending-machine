package com.techelevator.items;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Vending {
    private String slot;
    private String name;
    private BigDecimal price;
    private int quantity = 5;


    public List<Vending> getVendingList() {
        return vendingList;
    }

    private List<Vending> vendingList;

    public Vending(String slot, String name, BigDecimal price) {
        this.slot = slot;
        this.name = name;
        this.price = price;

    }


    public Vending() {
    }

    @Override
    public String toString() {
        return slot + " | " + name + " | $" + price.setScale(2) + " | " + quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void remainingLeft() {
        quantity--;

    }


    public String displayMessage(){
        return "";
    }
}
