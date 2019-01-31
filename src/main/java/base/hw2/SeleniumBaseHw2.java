package base.hw2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Date;

import static java.lang.System.setProperty;

public abstract class SeleniumBaseHw2 {
    @BeforeSuite
    public void beforeSuit(){
        setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
    }
    @AfterSuite
    public void afterSuit(){
        Date date = new Date();
        System.out.println(date.toString());
    }
}
