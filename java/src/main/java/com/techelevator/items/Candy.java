package com.techelevator.items;

import java.math.BigDecimal;

public class Candy extends Vending{



    public Candy(String slot,String name, BigDecimal price){
        super(slot, name, price);
    }

    public Candy(){
    }

    @Override
    public String displayMessage() {
        return "Munch Munch, Yum!";
    }
}

