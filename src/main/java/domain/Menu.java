package domain;

public enum Menu {
    FRIED(1, "후라이드", Category.CHICKEN, 16_000),
    SEASONED(2, "양념치킨", Category.CHICKEN, 16_000),
    HALF(3, "반반치킨", Category.CHICKEN, 16_000),
    GRILLED(4, "통구이", Category.CHICKEN, 16_000),
    SOY_SAUCE(5, "간장치킨", Category.CHICKEN, 17_000),
    BONELESS(6, "순살치킨", Category.CHICKEN, 17_000),
    COKE(21, "콜라", Category.BEVERAGE, 1_000),
    SPRITE(22, "사이다", Category.BEVERAGE, 1_000);

    private int number;
    private String name;
    private Category category;
    private int price;

    Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
