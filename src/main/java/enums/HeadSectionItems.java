package enums;

public enum HeadSectionItems {
    HOME(0, "HOME"),
    CONTACT_FORM(1, "CONTACT FORM"),
    SERVICE(2, "SERVICE"),
    METALS_COLORS(3, "METALS & COLORS");

    public int count;
    public String expectedText;

    HeadSectionItems(int count, String expectedText) {
        this.count = count;
        this.expectedText = expectedText;
    }
}
