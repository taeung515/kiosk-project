package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //카테고리별 메뉴를 담는 컬렉션
        List<Menu> menus = new ArrayList<>();

        //메뉴를 생성한 후 카테고리별로 저장
        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menus.add(new Menu(1, "Burger", burgers));

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem(1, "Coke", 2.7, "시원한 콜라!"));
        drinks.add(new MenuItem(2, "Sprite", 2.9, "시원한 사이다!"));
        menus.add(new Menu(2, "Drinks", drinks));

        List<MenuItem> desserts = new ArrayList<>();
        desserts.add(new MenuItem(1, "Cake", 10.9, "맛있는 케이크"));
        desserts.add(new MenuItem(2, "Fruits", 8.9, "딸기, 바나나 등"));
        menus.add(new Menu(3, "Desserts", desserts));

        Display display = new Display();
        ShoppingCart cart = new ShoppingCart();
        //Kiosk (menus, cart, display) 시작
        Kiosk kiosk = new Kiosk(menus, cart, display);
        kiosk.start();
    }
}



