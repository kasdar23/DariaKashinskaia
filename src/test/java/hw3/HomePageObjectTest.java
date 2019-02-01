package hw3;

import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.HomePage;


import static enums.BenefitText.*;
import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.HeadSectionItems.*;
import static enums.Links.HOME_PAGE_LINK;
import static enums.Links.JDI_LINK;
import static enums.MainHeader.MAIN_HEADER;
import static enums.PageTitles.HOME_PAGE;
import static enums.SubHeader.SUB_HEADER;

// TODO In general everything OK, but you smashed Data to really small pieces
// TODO Maybe it will be easier if you merge several of it into one Enum

public class HomePageObjectTest extends SeleniumBase {
    // TODO Take a look on hw2 nad testNg hooks.
    // TODO This should bi in one of the @before methods
    private WebDriver driver = new ChromeDriver();
    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    // TODO Basically, you should pass Enum into the method instead of String
    // TODO This help us to avoid unexpected usage of our methods by others users
    @Test
    public void homePageTest() {
        //1. Open test site by URL
        // TODO Take a look on HomePage(WebDriver driver) {...} constructor
        // TODO it can be used in order to pass WD instance to PO once.
        homePage.open(driver, HOME_PAGE_LINK.link);

        //2. Assert Browser title
        homePage.checkBrowserTitle(driver, HOME_PAGE.pageTitle);

        //3. Perform login
        // TODO Why don't you pass the whole user into this method ?
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName(PITER_CHAILOVSKII.userName);

        //5. Assert Browser title
        homePage.checkBrowserTitle(driver, HOME_PAGE.pageTitle);

        //6. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        homePage.checkHeardSectionDisplaed();

        // TODO This should be encapsulate into PO, trying to use cycle.
        //"HOME"
        homePage.checkHeardSectionText(HOME.count, HOME.expectedText);

        //"CONTACT FORM"
        homePage.checkHeardSectionText(CONTACT_FORM.count, CONTACT_FORM.expectedText);

        //"SERVICE"
        homePage.checkHeardSectionText(SERVICE.count, SERVICE.expectedText);

        //"METALS & COLORS"
        homePage.checkHeardSectionText(METALS_COLORS.count, METALS_COLORS.expectedText);
        // !TODO

        //7.Assert that there are 4 images on the Index Page
        // and they are displayed
        homePage.checkNumberBenefitIcons(4);
        homePage.checkBenefitIconsDisplayed();


        //8. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        // TODO You should encapsulate this into PO
        // TODO This will be better with cycle
        homePage.checkNumberTextUnderIcons(4);
        homePage.checkTextUnderIcons(BENEFIT_TEXT1.count, BENEFIT_TEXT1.text);
        homePage.checkTextUnderIcons(BENEFIT_TEXT2.count, BENEFIT_TEXT2.text);
        homePage.checkTextUnderIcons(BENEFIT_TEXT3.count, BENEFIT_TEXT3.text);
        homePage.checkTextUnderIcons(BENEFIT_TEXT4.count, BENEFIT_TEXT4.text);

        //9. Assert a text of the main headers
        homePage.checkMainHeader(MAIN_HEADER.mainTitle, MAIN_HEADER.mainTitleText);

        //10. Assert that there is the iframe in the center of page
        homePage.iframeDisplayed();

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe(driver);
        homePage.iframeLogoDisplaed();

        //12. Switch to original window back
        homePage.switchToParentFrame(driver);

        //13. Assert a text of the sub header
        homePage.checkSubHeadText(SUB_HEADER.subHeaderText);

        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJdiLink(JDI_LINK.link);

        //15. Assert that there is Left Section
        homePage.leftSectionDisplaed();

        //16. Assert that there is Footer
        homePage.footerSectionDisplaed();

        // TODO Take a look on HW2 ex 2
        //17. Close Browser
        homePage.close(driver);

    }
}
