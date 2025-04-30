package com.example.kiosk;

public class MenuItem {

    private final int idx;
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(int idx, String name, double price, String description) {
        this.idx = idx;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return idx + ". " + name + "    | W " + price + " |  " + description;
    }
}
