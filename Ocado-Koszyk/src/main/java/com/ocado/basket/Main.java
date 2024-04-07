package com.ocado.basket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        BasketSplitter testBasket = new BasketSplitter("/Users/dominik/Documents/Pwr/Semestr 6/Projekt Zespolowy/Repo/Ocado-Java/Ocado-Koszyk/Zadanie/config.json");
        List<String> testItemList1 = new ArrayList<>(Arrays.asList("Cocoa Butter", "Tart - Raisin And Pecan", "Table Cloth 54x72 White", "Flower - Daisies", "Fond - Chocolate", "Cookies - Englishbay Wht"));
        List<String> testItemList2 = new ArrayList<>(Arrays.asList("Fond - Chocolate", "Chocolate - Unsweetened", "Nut - Almond, Blanched, Whole", "Haggis", "Mushroom - Porcini Frozen", "Cake - Miini Cheesecake Cherry", "Sauce - Mint", "Longan", "Bag Clear 10 Lb", "Nantucket - Pomegranate Pear", "Puree - Strawberry", "Numi - Assorted Teas", "Apples - Spartan", "Garlic - Peeled", "Cabbage - Nappa", "Bagel - Whole White Sesame", "Tea - Apple Green Tea"));
        testBasket.split(testItemList1);
        testBasket.split(testItemList2);
    }
}
