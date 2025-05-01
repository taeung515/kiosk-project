package com.example.kiosk;

import java.util.List;

public class Menu {
    private final int idx;
    private final String categoryName;
    private final List<MenuItem> menuItems;

    public Menu(int idx, String categoryName, List<MenuItem> menuItems) {
        this.idx = idx;
        this.categoryName = categoryName;
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void getCategory() {
        System.out.println(idx + ". " + categoryName);
    }

    public String getCategoryName() {
        return categoryName;
    }
}
