package com.techelevator;

import com.techelevator.items.Item;
import com.techelevator.items.Vending;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Money {

    private static BigDecimal balance = new BigDecimal("0.00");

    public static void setBalance(BigDecimal balance) {
        Money.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void feedMoney(String args) {
        if (args.equals("one_dollar")) {
            balance = balance.add(BigDecimal.valueOf(1.00));
        } else if (args.equals("two_dollar")) {
            balance = balance.add(BigDecimal.valueOf(2.00));
        } else if (args.equals("five_dollar")) {
            balance = balance.add(BigDecimal.valueOf(5.00));
        } else if (args.equals("ten_dollar")) {
            balance = balance.add(BigDecimal.valueOf(10.00));
        }

    }




    public void makeChange(BigDecimal change) {
        double balanceForCoins = ((balance.doubleValue())*100);
        int quarters = (int) (balanceForCoins/25);
        balanceForCoins -= (quarters*25);
        int dimes = (int) (balanceForCoins/10);
        balanceForCoins -= (dimes*10);
        int nickels = (int) (balanceForCoins/5);
        System.out.println("Change due: " + quarters + " Quarters " + dimes + " Dimes " + nickels + " Nickels");
        balance = balance.subtract(balance);
    }

    public String makingChange(BigDecimal change){
        double balanceForCoins = ((balance.doubleValue())*100);
        int quarters = (int) (balanceForCoins/25);
        balanceForCoins -= (quarters*25);
        int dimes = (int) (balanceForCoins/10);
        balanceForCoins -= (dimes*10);
        int nickels = (int) (balanceForCoins/5);
        System.out.println("Change due: " + quarters + " Quarters " + dimes + " Dimes " + nickels + " Nickels");
        balance = balance.subtract(balance);
        return "Change due: " + quarters + " Quarters " + dimes + " Dimes " + nickels + " Nickels";
    }
}

