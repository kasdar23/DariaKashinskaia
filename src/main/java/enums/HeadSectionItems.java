package enums;

public enum HeadSectionItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    public String expectedText;

    HeadSectionItems(String expectedText) {
        this.expectedText = expectedText;
    }
}
