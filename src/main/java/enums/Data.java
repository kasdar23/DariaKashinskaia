package enums;

public enum Data {
    RESULT ("Summary: 11\n" +
            "Elements: Water, Fire\n" +
            "Color: Red\n" +
            "Metal: Selen\n" +
            "Vegetables: Cucumber, Tomato");

    public String item;

    Data(String item) {
        this.item = item;
    }
}
