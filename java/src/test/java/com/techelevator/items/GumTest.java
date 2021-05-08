package com.techelevator.items;

import junit.framework.TestCase;
import org.junit.Assert;

public class GumTest extends TestCase {

    public void testDisplayMessage() {
        Gum gum = new Gum();

        String expected = "Chew Chew, Yum!";

        String actual = gum.displayMessage();

        Assert.assertEquals(expected, actual);
    }

}