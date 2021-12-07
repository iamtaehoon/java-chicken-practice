package domain;

public enum MainFunctionCode {
    REGISTER(1,"주문등록"),
    PAY(2,"결제하기"),
    END(3, "프로그램 종료"),;

    private int code;
    private String message;

    MainFunctionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
