package enums;

public enum BenefitText {
    BENEFIT_TEXT1("To include good practices\n"
            + "and ideas from successful\n" + "EPAM project"),
    BENEFIT_TEXT2("To be flexible and\n" + "customizable"),
    BENEFIT_TEXT3("To be multiplatform"),
    BENEFIT_TEXT4("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");

    public String expectedText;

    BenefitText(String expectedText) {
        this.expectedText = expectedText;
    }
}
