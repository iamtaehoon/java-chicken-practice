package view;

import domain.Menu;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputFunction() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputOrderCnt() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static Menu inputMenuType() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        int inputType = scanner.nextInt();
        Menu menu = Arrays.stream(Menu.values()).filter(menuGroup ->
                menuGroup.getNumber() == inputType).findAny().orElse(null);
        if (menu == null) {
            throw new IllegalArgumentException("해당 번호의 메뉴는 존재하지 않습니다.");
        }
        return menu;
    }

}