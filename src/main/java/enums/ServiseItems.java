package enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiseItems {
    SERVISE_ITEMS_1("Support"),
    SERVISE_ITEMS_2("Dates"),
    SERVISE_ITEMS_3("Complex Table"),
    SERVISE_ITEMS_4("Simple Table"),
    SERVISE_ITEMS_5("User Table"),
    SERVISE_ITEMS_6("Table with pages"),
    SERVISE_ITEMS_7("Different elements"),
    SERVISE_ITEMS_8("Performance");

    public String expectedText;

    ServiseItems(String expectedText) {
        this.expectedText = expectedText;
    }

    public static List<String> getServiseItemsUp() {
        List<String> expectedItemsText = new ArrayList<>();
        for (ServiseItems item :
                ServiseItems.values()) {
            expectedItemsText.add(item.expectedText.toUpperCase());
        }
        return expectedItemsText;
    }
    public static List<String> getServiseItems() {
        List<String> expectedItemsText = new ArrayList<>();
        for (ServiseItems item :
                ServiseItems.values()) {
            expectedItemsText.add(item.expectedText);
        }
        return expectedItemsText;
    }

}
