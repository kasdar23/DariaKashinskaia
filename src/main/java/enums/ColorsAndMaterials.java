package enums;

public enum ColorsAndMaterials {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String title;

    ColorsAndMaterials (String title) {
        this.title = title;
    }
}
