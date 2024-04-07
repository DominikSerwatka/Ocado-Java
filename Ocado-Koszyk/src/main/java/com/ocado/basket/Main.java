package com.ocado.basket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        BasketSplitter testBasket = new BasketSplitter("/Users/dominik/Documents/Pwr/Semestr 6/Projekt Zespolowy/Repo/Ocado-Java/Ocado-Koszyk/Zadanie/config.json");
        System.out.println(testBasket.getDeliveryOptions());
    }
}
