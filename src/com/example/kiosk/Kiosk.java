package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    private final ShoppingCart shoppingCart;
    private final Scanner sc;

    public Kiosk(List<Menu> menus, ShoppingCart shoppingCart) {
        this.menus = menus;
        this.shoppingCart = shoppingCart;
        this.sc = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            try {
                //카테고리 목록 출력
                System.out.println("\n[ MAIN MENU ]");
                for (Menu menu : menus) {
                    menu.printCategories();
                }
                System.out.println("0. 종료      | 종료");

                //장바구니 확인 후 Order || Cancle
                int ordersIdx = (menus.size() + 1); //Orders의 인덱스 (동적 카테고리 추가 위해)
                int cancleIdx = (menus.size() + 2); //Cancel의 인덱스 (동적 카테고리 추가 위해)
                if(shoppingCart.hasItem()){
                    System.out.println("\n[ ORDER MENU ]");
                    System.out.println(ordersIdx + ". Orders       | 장바구니를 확인 후 주문합니다.");
                    System.out.println(cancleIdx + ". Cancel       | 진행중인 주문을 취소합니다.");
                }

                int inputSelectedCategory = sc.nextInt();
                if (inputSelectedCategory == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

                //선택한 카테고리의 메뉴 출력
                if(inputSelectedCategory == ordersIdx || inputSelectedCategory == cancleIdx){
                    if(inputSelectedCategory == cancleIdx){
                        System.out.println("진행중인 주문을 취소합니다.");
                        return;
                    }

                    shoppingCart.printCart();
                    int inputNum = sc.nextInt();
                    if (inputNum == 2) {
                        continue;
                    }
                    System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.", shoppingCart.getTotalPrice());
                    return;
                }

                menus.get(inputSelectedCategory - 1).printMenu();

                int inputSelectedItem = sc.nextInt();
                if (inputSelectedItem == 0) {
                    continue;
                }

                //선택한 메뉴 아이템 출력 (toString() 오버라이딩)
                MenuItem menuItem = getMenuItem(inputSelectedCategory, inputSelectedItem);
                System.out.println("선택한 메뉴 : " + menuItem);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1.확인\t\t2.취소");

                int inputSavedNum = sc.nextInt();
                if(inputSavedNum == 2) {
                    System.out.println("처음부터 다시 진행해주세요.");
                    continue;
                }

                shoppingCart.addCartItem(menuItem);
                System.out.println(menuItem.getName()+ "이(가) 장바구니에 추가되었습니다.");

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요");
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다. 메뉴를 다시 확인해주세요.");
                sc.nextLine();
            }
        }

    }


    //메뉴아이템 중복사용 위해
    private MenuItem getMenuItem(int inputSelectedCategory, int inputSelectedItem) {
        return menus.get(inputSelectedCategory - 1).getMenuItems().get(inputSelectedItem - 1);
    }
}