package pageObjects;

import enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.Titles.MAIN_HEADER_TEXT;
import static enums.Titles.MAIN_HEADER_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    public WebDriver driver;

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

    // TODO This locator can be improved
    @FindBy(css = ".m-l8 > li > a")
    private List<WebElement> headerSection;

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

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(Links links) {
        driver.manage().window().maximize();
        driver.navigate().to(links.link);
    }

    public void login(DataUsers user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
        assertEquals(userName.getText(), user.userName);
    }

    public void checkBrowserTitle(Titles expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle.title);
    }


    public void checkHeaderSection(List<String> expectedHeadSectionItems) {
        for (WebElement item : headerSection) {
            assertTrue(item.isDisplayed());
        }

        for (int i = 0; i < headerSection.size(); i++) {
            assertEquals(headerSection.get(i).getText(), expectedHeadSectionItems.get(i));
        }
    }

    public void checkBenefitIcons(int expectedNumber) {
        assertEquals(benefitIcons.size(), expectedNumber);
        for (WebElement icon : benefitIcons) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkTextUnderIcons(List<String> expectedText, int expectedNumber) {
        assertEquals(benefitText.size(), expectedNumber);
        for (int i = 0; i < benefitText.size(); i++) {
            assertEquals(benefitText.get(i).getText(), expectedText.get(i));
        }
    }


    public void checkMainHeader() {
        assertEquals(mainTitle.getText(), MAIN_HEADER_TITLE.title);
        assertEquals(mainTitleText.getText(), MAIN_HEADER_TEXT.title);
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

    public void checkSubHeadText(Titles expectedTitle) {
        assertEquals(subHeard.getText(), expectedTitle.title);
    }

    public void checkJdiLink(Links expectedLink) {
        assertEquals(subHeard.getAttribute("href"), expectedLink.link);
    }

    public void leftSectionDisplaed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void footerSectionDisplaed() {
        assertTrue(footer.isDisplayed());
    }


}



