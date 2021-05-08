package com.techelevator.items;

import java.math.BigDecimal;

public class Gum extends Vending{



    public Gum(String slot, String name, BigDecimal price){
        super(slot, name, price);
    }

    public Gum(){
    }

    @Override
    public String displayMessage() {
        return "Chew Chew, Yum!";
    }
}
