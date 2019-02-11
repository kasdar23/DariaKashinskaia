package hw4.ex1;

import base.SelenideBase;
import enums.ServiseItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.DifferentElementsPage;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.Links.HOME_PAGE_LINK;
import static enums.Titles.*;

public class DifferentElementsPageTest extends SelenideBase {

    private DifferentElementsPage differentElementsPage;
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        // TODO This should be stored as constant or as a enum...
        open("https://epam.github.io/JDI/index.html");
    }


    @BeforeMethod
    public void beforeMethod() {
        differentElementsPage = page(DifferentElementsPage.class);
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void servicePageTest() {

        // 1. Open test site by URL
        homePageSelenide.openPage(HOME_PAGE_LINK);

        //2. Assert Browser title
        homePageSelenide.checkBrowserTitle(HOME_PAGE_TITLE);

        //3. Perform login
        //   Assert User name in the right-top side of screen that user is loggined
        homePageSelenide.login(PITER_CHAILOVSKII);

        //4. Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.checkHeaderServise(ServiseItems.getServiseItemsUp());

        //5. Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.checkLeftServise(ServiseItems.getServiseItems());

        //6. Open through the header menu Service -> Different Elements Page
        differentElementsPage.goToDifferentElementsPage();

        //7. Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkInterface();

        //8. Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //9. Assert that there is Left Section
        homePageSelenide.checkLeftSection();

        //10. Select checkboxes 
        differentElementsPage.selectNatureElement(CHECK_BOX_WATER);
        differentElementsPage.selectNatureElement(CHECK_BOX_WIND);

        //11. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogElements(CHECK_BOX_WATER, true);
        differentElementsPage.checkLogElements(CHECK_BOX_WIND, true);

        //12. Select radio
        differentElementsPage.selectMaterials(RADIO_BUTTON_SELEN);

        //13. Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton
        differentElementsPage.checkLog(RADIO_BUTTON_SELEN);

        //14. Select in dropdown
        differentElementsPage.selectColor(DROP_DOWN_YELLOW);

        //15. Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        differentElementsPage.checkLog(DROP_DOWN_YELLOW);

        //16.Unselect and assert checkboxes 
        differentElementsPage.unselectNatureElement(CHECK_BOX_WATER);
        differentElementsPage.unselectNatureElement(CHECK_BOX_WIND);

        //17. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogElements(CHECK_BOX_WATER, false);
        differentElementsPage.checkLogElements(CHECK_BOX_WIND, false);
    }

}
