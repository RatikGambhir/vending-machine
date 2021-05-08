package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

import java.math.BigDecimal;

public class MoneyTest extends TestCase {

    public void testFeedMoneyTest_one_dollar_in_balance() {
        Money money = new Money();
        Money.setBalance(BigDecimal.ZERO);
        money.feedMoney("one_dollar");
        Assert.assertEquals(0, new BigDecimal(1.00).compareTo(money.getBalance()));
    }

    public void testFeedMoneyTest_two_dollar_in_balance() {
        Money money = new Money();
        Money.setBalance(BigDecimal.ZERO);
        money.feedMoney("two_dollar");
        Assert.assertEquals(0, new BigDecimal(2.00).compareTo(money.getBalance()));
    }

    public void testFeedMoneyTest_five_dollar_in_balance() {
        Money money = new Money();
        Money.setBalance(BigDecimal.ZERO);
        money.feedMoney("five_dollar");
        Assert.assertEquals(0, new BigDecimal(5.00).compareTo(money.getBalance()));
    }

    public void testFeedMoneyTest_ten_dollar_in_balance() {
        Money money = new Money();
        Money.setBalance(BigDecimal.ZERO);
        money.feedMoney("ten_dollar");
        Assert.assertEquals(0, new BigDecimal(10.00).compareTo(money.getBalance()));
    }

    public void testFeedMoneyTest_sum_of_all() {
        Money money = new Money();
        Money.setBalance(BigDecimal.ZERO);
        money.feedMoney("one_dollar");
        money.feedMoney("two_dollar");
        money.feedMoney("five_dollar");
        money.feedMoney("ten_dollar");
        Assert.assertEquals(0, new BigDecimal(18.00).compareTo(money.getBalance()));
    }



    public void testMakeChange() {
        Money money = new Money();
        Money.setBalance(BigDecimal.valueOf(100.00));
        money.makeChange(money.getBalance());
        Assert.assertEquals(0, new BigDecimal(0.00).compareTo(money.getBalance()));
    }

    public void testMakeChange_one_dollar_fourty_five_cents() {
        Money money = new Money();
        Money.setBalance(BigDecimal.valueOf(1.45));

        Assert.assertEquals("Change due: 5 Quarters 2 Dimes 0 Nickels", money.makingChange(money.getBalance()));
    }
}