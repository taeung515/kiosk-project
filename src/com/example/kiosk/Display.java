package com.example.kiosk;

import java.util.List;

public class Display {
    public void printCategories(List<Menu> menus, ShoppingCart cart){
        System.out.println("\n[ MAIN MENU ]");
        for (Menu menu : menus) {
            menu.getCategory();
        }
        System.out.println("0. 종료      | 종료");
    }
    public void printOrderMenu(int ordersIdx, int cancelIdx) {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println(ordersIdx + ". Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println(cancelIdx + ". Cancel       | 진행중인 주문을 취소합니다.");
    }
    public void printMenuItem(Menu menu) {
        System.out.println("\n[ " + menu.getCategoryName().toUpperCase() + " MENU ] ");
        for (MenuItem menuItem : menu.getMenuItems()) {
            System.out.println(menuItem); //MenuItem toString()오버라이딩
        }
        System.out.println("0. 뒤로가기");
    }
    public void printCartList(ShoppingCart cart) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        for (MenuItem selectedMenuItem : cart.getCartItems()) {
            System.out.println(selectedMenuItem);
        }
    }
    public void printTotalPriceOfCart(double totalPrice) {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f", totalPrice);
        System.out.println("\n1. 주문     2. 메뉴판");
    }
    public void printPaySuccess(double totalPrice){
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.", totalPrice);
    }
    public void printAddItemConfirmation(MenuItem menuItem) {
        System.out.println("선택한 메뉴 : " + menuItem);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인\t\t2.취소");
    }
    public void printAddSuccess(MenuItem menuItem) {
        System.out.println(menuItem.getName()+ "이(가) 장바구니에 추가되었습니다.");
    }
    public void printCancleMessage() {
        System.out.println("진행중인 주문을 취소합니다.");
    }
    public void exitProgram() {
        System.out.println("프로그램을 종료합니다.");
    }
    public void restartMessage() {
        System.out.println("처음부터 다시 진행해주세요.");
    }
    public void errorMessage() {
        System.out.println("잘못된 입력입니다. 다시 확인해주세요.");
    }
}
