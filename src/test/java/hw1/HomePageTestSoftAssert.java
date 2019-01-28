package hw1;
//Kashinskaia 28_01_2019
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTestSoftAssert {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void homePageTestSoftAssert(){

        //1. Open test site by URL
        WebDriver driver = new ChromeDriver(); //Browser - Chrome
        driver.manage().window().maximize();   //Window - maximized
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement userName =
                driver.findElement(By.cssSelector("[id='user-name']"));
        softAssert.assertEquals(userName.getAttribute("innerText"), "PITER CHAILOVSKII");

        //5. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        List<WebElement> heardSection
                = driver.findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li > a"));

        for (WebElement item: heardSection) {
           softAssert.assertTrue(item.isDisplayed());
        }

        //"HOME"
        softAssert.assertEquals(heardSection.get(0).getAttribute("innerText"), "HOME");

        //"CONTACT FORM"
        softAssert.assertEquals(heardSection.get(1).getAttribute("innerText"), "CONTACT FORM");

        //"SERVICE"
        softAssert.assertEquals(heardSection.get(2).getAttribute("innerText"), "SERVICE");

        //"METALS & COLORS"
        softAssert.assertEquals(heardSection.get(3).getAttribute("innerText"), "METALS & COLORS");

        //7.Assert that there are 4 images on the Index Page
        // and they are displayed
        List<WebElement> benefitIcons
                = driver.findElements(By.cssSelector("div.benefit-icon > span"));
        softAssert.assertEquals(benefitIcons.size(),4);
        for (WebElement icon: benefitIcons) {
            softAssert.assertTrue(icon.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        List<WebElement> benefitText
                = driver.findElements(By.cssSelector("div.benefit > span"));
        softAssert.assertEquals(benefitText.get(0).getText(), "To include good practices\n"
                + "and ideas from successful\n" + "EPAM project");
        softAssert.assertEquals(benefitText.get(1).getText(), "To be flexible and\n"+"customizable");
        softAssert.assertEquals(benefitText.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(benefitText.get(3).getText(), "Already have good base\n"
                +"(about 20 internal and\n"
                +"some external projects),\n"
                +"wish to get more…");

        //9. Assert a text of the main headers
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        softAssert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainText = driver.findElement(By.cssSelector("p.main-txt"));
        softAssert.assertEquals(mainText.getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA"
                        +" ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS"+
                        " AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("[id = 'iframe']"));
        softAssert.assertTrue(iframe.isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iframe);
        WebElement iframeLogo = driver.findElement(By.cssSelector("[id='epam_logo']"));
        softAssert.assertTrue(iframeLogo.isDisplayed());

        //12. Switch to original window back
        driver.switchTo().parentFrame();

        //13. Assert a text of the sub header
        WebElement subHeard = driver.findElement(By.cssSelector("h3.text-center > a"));
        softAssert.assertEquals(subHeard.getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(subHeard.getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector("div.mCustomScrollBox"));
        softAssert.assertTrue(leftSection.isDisplayed());

        //16. Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        softAssert.assertTrue(footer.isDisplayed());

        //17. Close Browser
        driver.close();
        softAssert.assertAll();

    }
}
