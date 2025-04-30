package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n[ MAIN MENU ]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getCategories());
                }
                System.out.println("0. 종료      | 종료");

                int inputSelectedCategory = sc.nextInt();
                if (inputSelectedCategory == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

                menus.get(inputSelectedCategory - 1).printMenu();
                System.out.println("0. 뒤로가기");

                int inputSelectedItem = sc.nextInt();
                if (inputSelectedItem == 0) {
                    continue;
                }

                System.out.print("선택한 메뉴 : ");
                System.out.println(menus.get(inputSelectedCategory - 1).getMenuItems().get(inputSelectedItem - 1).toString());

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요");
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다. 메뉴를 다시 확인해주세요.");
                sc.nextLine();
            }
        }

    }
}