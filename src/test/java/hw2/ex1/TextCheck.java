package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TextCheck extends SeleniumBase {

    // TODO In general it is doesn't matter but KEY(0-4 in this case) should be first {1, "benefit"}
    @DataProvider(parallel = true)
    public Object[][] expectedText() {
        return new Object[][]{
                {"To include good practices\n"
                        + "and ideas from successful\n" + "EPAM project", 0},
                {"To be flexible and\n" + "customizable", 1},
                {"To be multiplatform", 2},
                {"Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…", 3}
        };
    }

    @Test(dataProvider = "expectedText")
    public void textCheck(String text, int i) {
        //1. Open test site by URL
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //Browser - Chrome
        driver.manage().window().maximize();   //Window - maximized
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        List<WebElement> benefitText
                = driver.findElements(By.cssSelector("div.benefit > span"));
        assertEquals(benefitText.get(i).getText(), text);

        //3. Close Browser
        driver.close();

    }


}
