package pos;

public class InputValidator {
    public static int validateNumber(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return Integer.parseInt(input);
    }
}
