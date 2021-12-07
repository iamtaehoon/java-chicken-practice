package domain;

public class MainFunctionCode {
    private int code;

    public MainFunctionCode(String inputValue) {
        if (!inputValue.matches("[1-3]")) {
            throw new IllegalArgumentException("해당 기능은 지원하지 않습니다.");
        }
        this.code = Integer.parseInt(inputValue);
    }
}
