package enums;

public enum Data {
    // TODO Great, you have a special class for filing form,
    // TODO but in spite of this fact, you created this one...
    // TODO It will be better to generate expected log's row from MetalsColorsData class.
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
