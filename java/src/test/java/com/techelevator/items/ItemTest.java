package com.techelevator.items;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void readFile() {
        Item item = new Item();
        List<Vending> actual = item.readFile();
        for(Vending name : actual) {

        }

    }
}