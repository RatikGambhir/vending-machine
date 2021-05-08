package com.techelevator.items;

import java.math.BigDecimal;

public class Drink extends Vending {



    public Drink(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    public Drink(){
    }

    @Override
    public String displayMessage() {
        return "Glug Glug, Yum!";
    }
}



