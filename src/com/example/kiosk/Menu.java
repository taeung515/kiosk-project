package com.example.kiosk;

import java.util.List;

public class Menu {
    private final String categoryName;
    private final List<MenuItem> menuItems;

    public Menu(String categoryName, List<MenuItem> menuItems) {
        this.categoryName = categoryName;
        this.menuItems = menuItems;
    }

    public String getCategories() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void printMenu() {
        System.out.println("\n[ " + categoryName.toUpperCase() + " MENU ] ");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get(i)); //MenuItem toString()오버라이딩
        }
    }
}
