package enums;

public enum Vegetables {
    VEGETABLES ("Vegetables"),
    CUCUMBER ("Cucumber"),
    TOMATO ("Tomato"),
    ONION ("Onion")
    ;

    public String title;
    Vegetables(String title) {
        this.title = title;
    }
}
