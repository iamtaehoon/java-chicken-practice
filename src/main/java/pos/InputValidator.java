package pos;

import static pos.Constant.INTEGER_REGEX;

public class InputValidator {
    public static int validateNumber(String input) {
        if (!input.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return Integer.parseInt(input);
    }
}
