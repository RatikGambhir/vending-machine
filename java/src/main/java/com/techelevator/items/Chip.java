package com.techelevator.items;

import java.math.BigDecimal;

public class Chip extends Vending {



    public Chip(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    public Chip(){
    }

    @Override
    public String displayMessage(){
        return "Crunch Crunch, Yum!";
    }
}



