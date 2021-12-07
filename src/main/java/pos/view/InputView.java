package pos.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputFunctionCode() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputOrderCnt() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputMenuType() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputPayType() {
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return scanner.nextLine();
    }
}