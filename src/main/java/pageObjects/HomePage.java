package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    @FindBy(css = "[id='user-icon']")
    private WebElement profileButton;

    @FindBy(css = "[id='name']")
    private WebElement login;

    @FindBy(css = "[id='password']")
    private WebElement password;

    @FindBy(css = "[id='login-button']")
    private WebElement submit;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li > a")
    private List<WebElement> heardSection;

    @FindBy(css = "div.benefit-icon > span")
    private List<WebElement> benefitIcons;

    @FindBy(css = "div.benefit > span")
    private List<WebElement> benefitText;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "p.main-txt")
    private WebElement mainTitleText;

    @FindBy(css = "[id = 'iframe']")
    private WebElement iframe;

    @FindBy(css = "[id='epam_logo']")
    private WebElement iframeLogo;

    @FindBy(css = "h3.text-center > a")
    WebElement subHeard;

    @FindBy(css = "div.mCustomScrollBox")
    WebElement leftSection;

    @FindBy(css = "footer")
    WebElement footer;

    public void open(WebDriver driver, String link) {
        driver.manage().window().maximize();   //Window - maximized
        driver.navigate().to(link);
    }

    ;

    public void login(String name, String pass) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(pass);
        submit.click();
    }

    public void checkBrowserTitle(WebDriver driver, String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    public void checkUserName(String expectedUserName) {
        assertEquals(userName.getText(), expectedUserName);
    }

    public void checkHeardSectionDisplaed() {
        for (WebElement item : heardSection) {
            assertTrue(item.isDisplayed());
        }
    }

    public void checkHeardSectionText(int itemNumber, String expectedText) {
        assertEquals(heardSection.get(itemNumber).getText(), expectedText);
    }

    public void checkNumberBenefitIcons(int expectedNumber) {
        assertEquals(benefitIcons.size(), expectedNumber);
    }

    public void checkBenefitIconsDisplayed() {
        for (WebElement icon : benefitIcons) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkNumberTextUnderIcons(int expectedNumber) {
        assertEquals(benefitText.size(), expectedNumber);
    }

    public void checkTextUnderIcons(int itemNumber, String expectedText) {
        assertEquals(benefitText.get(itemNumber).getText(), expectedText);
    }

    public void checkMainHeader(String expectedTitleText, String expectedText) {
        assertEquals(mainTitle.getText(), expectedTitleText);
        assertEquals(mainTitleText.getText(), expectedText);
    }

    public void iframeDisplayed() {
        assertTrue(iframe.isDisplayed());
    }

    public void switchToIframe(WebDriver driver) {
        driver.switchTo().frame(iframe);
    }

    public void iframeLogoDisplaed() {
        assertTrue(iframeLogo.isDisplayed());
    }

    public void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public void checkSubHeadText(String expectedText) {
        assertEquals(subHeard.getText(), expectedText);
    }

    public void checkJdiLink(String expectedLink) {
        assertEquals(subHeard.getAttribute("href"), expectedLink);
    }

    public void leftSectionDisplaed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void footerSectionDisplaed() {
        assertTrue(footer.isDisplayed());
    }

    public void close(WebDriver driver) {
        driver.close();
    }
}



