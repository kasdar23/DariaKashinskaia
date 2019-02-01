package enums;

public enum BenefitText {
    BENEFIT_TEXT1(0, "To include good practices\n"
            + "and ideas from successful\n" + "EPAM project"),
    BENEFIT_TEXT2(1, "To be flexible and\n" + "customizable"),
    BENEFIT_TEXT3(2, "To be multiplatform"),
    BENEFIT_TEXT4(3, "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");

    public int count;
    public String text;

    BenefitText(int count, String text) {
        this.count = count;
        this.text = text;
    }
}
