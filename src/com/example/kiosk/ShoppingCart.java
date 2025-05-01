package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<MenuItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public List<MenuItem> getCartItems() {
        return cartItems;
    }

    public void addCartItem(MenuItem menuItem) {
        cartItems.add(menuItem);
    }

    public boolean hasItem() {
        return !cartItems.isEmpty();
    }
}
