package pos.domain;

public enum PayType {
    CREDIT(1),
    CASH(2);

    private int payType;

    PayType(int payType) {
        this.payType = payType;
    }

    public int getPayType() {
        return payType;
    }
}