package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static enums.Links.HOME_PAGE_LINK;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects")
public class CucumberPageRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open(HOME_PAGE_LINK.link);
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }
}