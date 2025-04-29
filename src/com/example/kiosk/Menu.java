package com.example.kiosk;

import java.util.List;

public class Menu {
    //속성
    private final String categoryName;
    private final List<MenuItem> menuItems;

    //생성자
    public Menu(String categoryName, List<MenuItem> menuItems) {
        this.categoryName = categoryName;
        this.menuItems = menuItems;
    }

    //기능
    //게터
    public String getCategories() {
        return categoryName;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    //카테고리 선택 하는 메서드 버거, 디저트, 드링크
    public void printMenu() {
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getName() + " : " + menuItem.getPrice() + " " + menuItem.getDescription());
        }
    }
}
