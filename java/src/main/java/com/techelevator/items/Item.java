package com.techelevator.items;


import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Item {
    public List<Vending> readFile() {


        List<Vending> vendingList = new ArrayList<>();

        String path = "C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t9\\java\\vendingmachine.csv";
        String line = "";

        File filePath = new File(path);

        try (Scanner fileInput = new Scanner(filePath)) {
            while (fileInput.hasNextLine()) {
                line = fileInput.nextLine();
                String[] values = line.split("\\|");
                if(values[3].equals("Candy")) {
                    Candy candy = new Candy(values[0], values[1], BigDecimal.valueOf(Double.parseDouble(values[2])));
                    vendingList.add(candy);
                } else if (values[3].equals("Chip")) {
                    Chip chip = new Chip(values[0], values[1], BigDecimal.valueOf(Double.parseDouble(values[2])));
                    vendingList.add(chip);
                } else if (values[3].equals("Drink")) {
                    Drink drink = new Drink(values[0], values[1], BigDecimal.valueOf(Double.parseDouble(values[2])));
                    vendingList.add(drink);
                } else if (values[3].equals("Gum")) {
                    Gum gum = new Gum(values[0], values[1], BigDecimal.valueOf(Double.parseDouble(values[2])));
                    vendingList.add(gum);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return vendingList;
    }





}
