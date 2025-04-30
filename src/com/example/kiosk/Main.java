package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();

        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menus.add(new Menu("Burger", burgers));

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Coke", 2.7, "시원한 콜라!"));
        drinks.add(new MenuItem("Sprite", 2.9, "시원한 사이다!"));
        menus.add(new Menu("Drinks", drinks));

        List<MenuItem> desserts = new ArrayList<>();
        desserts.add(new MenuItem("Cake", 10.9, "맛있는 케이크"));
        desserts.add(new MenuItem("Fruits", 8.9, "딸기, 바나나 등"));
        menus.add(new Menu("Desserts", desserts));

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}



