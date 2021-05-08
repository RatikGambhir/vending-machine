package com.techelevator.items;

import junit.framework.TestCase;
import org.junit.Assert;

public class ChipTest extends TestCase {

    public void testDisplayMessage() {
        Chip chip = new Chip();

        String expected = "Crunch Crunch, Yum!";

        String actual = chip.displayMessage();

        Assert.assertEquals(expected, actual);
    }

}