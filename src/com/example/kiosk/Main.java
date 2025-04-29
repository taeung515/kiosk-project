package com.example.kiosk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuItem burger1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem burger2 = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem burger3 = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem burger4 = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        MenuItem[] burgers = {burger1, burger2, burger3, burger4};

        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < burgers.length; i++) {
                System.out.printf("%d. %-12s\t| W %.1f | %s%n", i + 1, burgers[i].getName(), burgers[i].getPrice(), burgers[i].getDescription());
            }
            System.out.println("0. 종료\t\t\t| 종료");
            System.out.print("선택(번호를 입력하세요.) ");

            int inputNum = scanner.nextInt();

            switch (inputNum) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                    MenuItem selected = burgers[inputNum - 1];
                    System.out.println("\n=== 선택하신 메뉴 ===");
                    System.out.println("메뉴명 : " + selected.getName());
                    System.out.printf("가격   : W %.1f%n", selected.getPrice());
                    System.out.println("설명   : " + selected.getDescription());
                    break;

                default:
                    System.out.println("잘못된 번호입니다. 메뉴 확인 바랍니다.");
            }

        }

    }
}