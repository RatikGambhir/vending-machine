package com.techelevator.items;

import junit.framework.TestCase;
import org.junit.Assert;

public class CandyTest extends TestCase {

    public void testDisplayMessage() {
        Candy candy = new Candy();

        String expected = "Munch Munch, Yum!";

        String actual = candy.displayMessage();

        Assert.assertEquals(expected, actual);
    }

}