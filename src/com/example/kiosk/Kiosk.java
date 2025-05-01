package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    private final ShoppingCart shoppingCart;
    private final Display display;
    private final Scanner sc;

    public Kiosk(List<Menu> menus, ShoppingCart shoppingCart, Display display) {
        this.menus = menus;
        this.shoppingCart = shoppingCart;
        this.display = display;
        this.sc = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            try {
                // 카테고리 목록 출력 (0을 입력하면 종료)
                display.printCategories(menus, shoppingCart);

                int ordersIdx = (menus.size() + 1); //Orders의 인덱스 (동적 카테고리 추가 위해)
                int cancelIdx = (menus.size() + 2); //Cancel의 인덱스 (동적 카테고리 추가 위해)
                if (shoppingCart.hasItem()) {

                    display.printOrderMenu(ordersIdx, cancelIdx);

                }
                int inputSelectedCategory = sc.nextInt();
                if (inputSelectedCategory == 0) {

                    display.exitProgram();
                    return;
                }

                //선택한 카테고리의 메뉴 출력
                if (inputSelectedCategory == ordersIdx || inputSelectedCategory == cancelIdx) {
                    if (inputSelectedCategory == cancelIdx) {

                        display.printCancleMessage();
                        return;
                    }

                    display.printCartList(shoppingCart);

                    double totalPrice = 0;
                    for (MenuItem order : shoppingCart.getCartItems()) {
                        totalPrice += order.getPrice();
                    }

                    display.printTotalPriceOfCart(totalPrice);

                    int inputNum = sc.nextInt();
                    if (inputNum == 2) {
                        continue;
                    }

                    display.printPaySuccess(totalPrice);
                    display.exitProgram();
                    return;
                }

                display.printMenuItem(menus.get(inputSelectedCategory - 1));

                int inputSelectedItem = sc.nextInt();
                if (inputSelectedItem == 0) {
                    continue;
                }

                //선택한 메뉴 아이템 출력 (toString() 오버라이딩)
                MenuItem menuItem = getMenuItem(inputSelectedCategory, inputSelectedItem);
                display.printAddItemConfirmation(menuItem);

                int inputSavedNum = sc.nextInt();
                if (inputSavedNum == 2) {
                    display.restartMessage();
                    continue;
                }
                shoppingCart.addCartItem(menuItem);

                display.printAddSuccess(menuItem);
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                display.errorMessage();
                sc.nextLine();
            }
        }

    }

    private MenuItem getMenuItem(int inputSelectedCategory, int inputSelectedItem) {
        return menus.get(inputSelectedCategory - 1).getMenuItems().get(inputSelectedItem - 1);
    }
}