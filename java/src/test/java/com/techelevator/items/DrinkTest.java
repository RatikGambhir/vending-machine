package com.techelevator.items;

import junit.framework.TestCase;
import org.junit.Assert;

public class DrinkTest extends TestCase {

    public void testDisplayMessage() {
        Drink drink = new Drink();

        String expected = "Glug Glug, Yum!";

        String actual = drink.displayMessage();

        Assert.assertEquals(expected, actual);
    }
}