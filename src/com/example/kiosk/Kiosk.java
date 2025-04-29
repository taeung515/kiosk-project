package com.example.kiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //메인부에서 사용할 메서드 public
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenuItems();
            int inputNum = scanner.nextInt();
            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            printSelectedMenuItem(inputNum);
        }
    }

    //메뉴들을 출력하는 메서드
    private void printMenuItems() {
        System.out.println("\n[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            System.out.printf("%d. %-12s | W %.1f | %s%n", i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println("0. 종료\t\t\t| 종료");
        System.out.print("선택(번호를 입력하세요.) ");
    }

    //선택한 메뉴를 보여주는 메서드
    private void printSelectedMenuItem(int inputNum) {
        if (1 <= inputNum && inputNum <= menuItems.size()) {
            MenuItem selected = menuItems.get(inputNum - 1);
            System.out.println("\n=== 선택하신 메뉴 ===");
            System.out.println("메뉴명 : " + selected.getName());
            System.out.printf("가격   : W %.1f%n", selected.getPrice());
            System.out.println("설명   : " + selected.getDescription());
        } else {
            System.out.println("잘못된 번호입니다. 메뉴 확인 바랍니다.");
        }
    }

}
