package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<MenuItem> cartItems;
    private double totalPrice;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addCartItem(MenuItem menuItem) {
        cartItems.add(menuItem);
    }

    public boolean hasItem() {
        return !cartItems.isEmpty();
    }

    public void printCart(){
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        for (MenuItem selectedMenuItem : cartItems) {
            System.out.println(selectedMenuItem);
        }
        System.out.println("[ Total ]");

        for (MenuItem order : cartItems) {
            totalPrice += order.getPrice();
        }
        System.out.printf("W %.1f", totalPrice);

        System.out.println("\n1. 주문     2. 메뉴판");
    }
}
