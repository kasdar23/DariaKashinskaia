package enums;

import java.util.ArrayList;
import java.util.List;

public enum HeadSectionItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    public String expectedText;

    HeadSectionItems(String expectedText) {
        this.expectedText = expectedText;
    }

    static public List<String> getExpectedHeaderSection() {
        List<String> expectedHeaderSection = new ArrayList<>();
        for (HeadSectionItems text : HeadSectionItems.values()) {
            expectedHeaderSection.add(text.expectedText);

        }
        return expectedHeaderSection;
    }
}
