package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<MenuItem>();

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem menuItem = menuItems.get(i);
                System.out.printf("%d. %-12s | W %.1f | %s%n", i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
            }
            System.out.println("0. 종료\t\t\t| 종료");
            System.out.print("선택(번호를 입력하세요.) ");

            int inputNum = scanner.nextInt();

            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (1 <= inputNum && inputNum <= menuItems.size()) {
                MenuItem selected = menuItems.get(inputNum - 1);
                System.out.println("\n=== 선택하신 메뉴 ===");
                System.out.println("메뉴명 : " + selected.getName());
                System.out.printf("가격   : W %.1f%n", selected.getPrice());
                System.out.println("설명   : " + selected.getDescription());
            } else {
                System.out.println("잘못된 번호입니다. 메뉴 확인 바랍니다.");
            }
            //메뉴 추가되어도 반복문 수정 없게 하기 위하여 switch > if변경

        }

    }
}