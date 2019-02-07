package hw3;

import base.SeleniumBase;
import enums.BenefitText;
import enums.HeadSectionItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;


import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.HeadSectionItems.HOME;
import static enums.Links.HOME_PAGE_LINK;
import static enums.Links.JDI_LINK;
import static enums.Titles.HOME_PAGE_TITLE;
import static enums.Titles.SUB_HEADER;

public class HomePageObjectTest extends SeleniumBase {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver(); //Browser - Chrome
    }

    @AfterClass
    public void afterClass() {
        driver.close();
        System.out.println("done");
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void homePageTest() {
        //1. Open test site by URL
        homePage.open(HOME_PAGE_LINK);

        //2. Assert Browser title
        homePage.checkBrowserTitle(HOME_PAGE_TITLE);

        //3. Perform login
        //Assert User name in the left-top side of screen that user is loggined
        homePage.login(PITER_CHAILOVSKII);

        //4. Assert Browser title
        homePage.checkBrowserTitle(HOME_PAGE_TITLE);

        //5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        homePage.checkHeaderSection(HeadSectionItems.getExpectedHeaderSection());

        //6.Assert that there are 4 images on the Index Page
        // and they are displayed
        homePage.checkBenefitIcons(4);

        //7. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        homePage.checkTextUnderIcons(BenefitText.getExpectedText(), 4);

        //8. Assert a text of the main headers
        homePage.checkMainHeader();

        //9. Assert that there is the iframe in the center of page
        homePage.iframeDisplayed();

        //10. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe(driver);
        homePage.iframeLogoDisplaed();

        //11. Switch to original window back
        homePage.switchToParentFrame(driver);

        //12. Assert a text of the sub header
        homePage.checkSubHeadText(SUB_HEADER);

        //13. Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJdiLink(JDI_LINK);

        //14. Assert that there is Left Section
        homePage.leftSectionDisplaed();

        //15. Assert that there is Footer
        homePage.footerSectionDisplaed();
    }
}
