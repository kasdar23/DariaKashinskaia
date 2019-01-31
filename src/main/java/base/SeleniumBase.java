package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Date;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {
    @BeforeSuite
    public void beforeSuit(){
        setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
    }
}
