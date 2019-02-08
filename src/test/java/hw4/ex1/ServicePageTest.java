package hw4.ex1;

import base.SelenideBase;
import enums.ServiseItems;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.Links.HOME_PAGE_LINK;
import static enums.Titles.*;

public class ServicePageTest extends SelenideBase {

    private HomePageSelenide homePageSelenide;

    @BeforeMethod
    public void beforeMethod() {
        homePageSelenide = new HomePageSelenide();
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
        homePageSelenide.checkHeaderServise(ServiseItems.getServiseItems());

        //5. Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.checkLeftServise(ServiseItems.getServiseItems());

        //6. Open through the header menu Service -> Different Elements Page
        homePageSelenide.goToDifferentElementsPage();

        //7. Check interface on Different elements page, it contains all needed elements
        homePageSelenide.checkInterfaceDifferentElementsPage();

        //8. Assert that there is Right Section
        homePageSelenide.checkRightSection();

        //9. Assert that there is Left Section
        homePageSelenide.checkLeftSection();

        //10. Select checkboxes
        // Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        homePageSelenide.selectChekBox(CHECK_BOX_WATER);
        homePageSelenide.selectChekBox(CHECK_BOX_WIND);

        //11. Select radio
        //Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton
        homePageSelenide.selectRadioButton(RADIO_BUTTON_SELEN);

        //12. Select in dropdown
        //Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        homePageSelenide.selectDropDown(DROP_DOWN_YELLOW);

        //13.Unselect and assert checkboxes
        //Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        homePageSelenide.unselectedCheckBox(CHECK_BOX_WATER);
        homePageSelenide.unselectedCheckBox(CHECK_BOX_WIND);
    }

}