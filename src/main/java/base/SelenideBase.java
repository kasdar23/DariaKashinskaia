package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBase {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}
