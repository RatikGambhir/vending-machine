package com.techelevator;

import com.techelevator.items.Item;
import com.techelevator.Money;
import com.techelevator.items.Vending;
import com.techelevator.view.Menu;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String ONE_DOLLAR_OPTION = "$1.00 Bill";
    private static final String TWO_DOLLAR_OPTION = "$2.00 Bill";
    private static final String FIVE_DOLLAR_OPTION = "$5.00 Bill";
    private static final String TEN_DOLLAR_OPTION = "$10.00 Bill";


    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String[] MONEY_MENU_OPTIONS = {ONE_DOLLAR_OPTION, TWO_DOLLAR_OPTION, FIVE_DOLLAR_OPTION, TEN_DOLLAR_OPTION};


    private Menu menu;
    List<Vending> vendingList;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        Item item = new Item();
        vendingList = item.readFile();
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                for (Vending vend : vendingList) {
                    System.out.println(vend);
                }
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                purchaseRun();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                exit();
            }
        }
    }

    public void purchaseRun() {
        Money money = new Money();
        while (true) {
            System.out.println("Current Money Provided: $" + money.getBalance());
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                moneyMenu();
            } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                productMenu();
            } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                finishTransaction();
                run();
            }
        }
    }

    public void moneyMenu() {
        Money money = new Money();
        while (true) {

            String choice = (String) menu.getChoiceFromOptions(MONEY_MENU_OPTIONS);

            if (choice.equals(ONE_DOLLAR_OPTION)) {
                money.feedMoney("one_dollar");
                feedMoneyLog(BigDecimal.valueOf(1.00));
                break;
            } else if (choice.equals(TWO_DOLLAR_OPTION)) {
                money.feedMoney("two_dollar");
                feedMoneyLog(BigDecimal.valueOf(2.00));
                break;
            } else if (choice.equals(FIVE_DOLLAR_OPTION)) {
                money.feedMoney("five_dollar");
                feedMoneyLog(BigDecimal.valueOf(5.00));
                break;
            } else if (choice.equals(TEN_DOLLAR_OPTION)) {
                money.feedMoney("ten_dollar");
                feedMoneyLog(BigDecimal.valueOf(10.00));
                break;
            }
        }
    }

    public void productMenu() {
        Money remBalance = new Money();
        BigDecimal balance = remBalance.getBalance();
        for (Vending vend : vendingList) {
            System.out.println(vend);
        }
        File newFile = new File("Log.txt");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean found = false;
        Vending itemToSell = null;


        System.out.println("Enter Slot number for product: ");
        Scanner scanner = new Scanner(System.in);
        String newStr = scanner.nextLine();


        for (int i = 0; i < vendingList.size(); i++) {

            if (vendingList.get(i).getSlot().equalsIgnoreCase(newStr)) {

                itemToSell = vendingList.get(i);
                found = true;
                break;
            }
        }
        if (itemToSell == null){
            System.out.println("INVALID CODE");
            purchaseRun();
        }
        if(itemToSell.getQuantity() > 0) {
            found = true;
        } else {
            System.out.println("Sorry, Item Sold Out!");
            purchaseRun();
        }

        if(itemToSell.getPrice().compareTo(remBalance.getBalance()) > 0){
            System.out.println("Please add more Money!");
            purchaseRun();
        } else {
            found = true;
            Money.setBalance(remBalance.getBalance().subtract(itemToSell.getPrice()));
        }



        if (found) {
            //System.out.println("FOUND IT");
            System.out.println("Item Dispensed: " + itemToSell.getName() + " | " + "Price: $" + itemToSell.getPrice() + " | Balance Remaining: $" + remBalance.getBalance());
            System.out.println(itemToSell.displayMessage() + "\n");
            itemToSell.remainingLeft();
            try(PrintWriter newPrint = new PrintWriter(new FileOutputStream("Log.txt", true))) {
                DateTimeFormatter currentDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
                LocalDateTime now = LocalDateTime.now();
                String formatDate = now.format(currentDateTime);
                newPrint.println(formatDate + " " + itemToSell.getName() + " " + itemToSell.getSlot() + " $" + itemToSell.getPrice() + " $" + remBalance.getBalance());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



        } else {
            System.out.println("NO ITEM FOUND");

        }


    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();


    }

    public void exit() {
        System.exit(1);
    }

    public void finishTransaction(){
        Money money = new Money();
        try(PrintWriter newPrint = new PrintWriter(new FileOutputStream("Log.txt", true))) {
            DateTimeFormatter currentDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
            LocalDateTime now = LocalDateTime.now();
            String formatDate = now.format(currentDateTime);
            newPrint.println(formatDate + " GIVE CHANGE: $" + money.getBalance() + " $0.00");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        money.makeChange(money.getBalance());
    }

    public void feedMoneyLog(BigDecimal bills){
        Money money = new Money();
        try (PrintWriter newPrint = new PrintWriter(new FileOutputStream("Log.txt", true))){
            DateTimeFormatter currentDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formatDate = now.format(currentDateTime);
            BigDecimal newAmount = money.getBalance().add(bills);
            newPrint.println( formatDate + " " + "FEED MONEY: $" + money.getBalance() + " $" + newAmount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}