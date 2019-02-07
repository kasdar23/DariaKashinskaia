package enums;

import java.util.ArrayList;
import java.util.List;

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

    static public List<String> getExpectedText() {
        List<String> expectedText = new ArrayList<>();

        for (BenefitText text : BenefitText.values()) {
            expectedText.add(text.expectedText);
        }
        return expectedText;
    }

}
