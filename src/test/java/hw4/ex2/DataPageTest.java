package hw4.ex2;

import base.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.hw4.ex2.HomePageSelenide;

import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.Links.HOME_PAGE_LINK;
import static enums.Titles.HOME_PAGE_TITLE;

public class DataPageTest extends SelenideBase {
    private HomePageSelenide homePageSelenide;

    @BeforeMethod
    public void beforeMethod() {
        homePageSelenide = new HomePageSelenide();
    }

    @Test
    public void homePageTest() throws InterruptedException {
        //1. Open test site by URL
        homePageSelenide.openPage(HOME_PAGE_LINK);

        //2. Assert Browser title
        homePageSelenide.checkBrowserTitle(HOME_PAGE_TITLE);

        //3. Perform login
        //Assert User name in the right-top side of screen that user is loggined
        homePageSelenide.login(PITER_CHAILOVSKII);

        //4. Open through the header menu Service -> Dates Page
        homePageSelenide.goToDatesPage();

        //5. Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most rigth position
        homePageSelenide.moveSliders(0, 100);

        //6. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRowsLog(0,100);

        //7. Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most left position.
        homePageSelenide.moveSliders(0, 0);

        //8. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRowsLog(0,0);

        //9. Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        // right slider - the most rigth position.
        homePageSelenide.moveSliders(100, 100);

        //10. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRowsLog(100,100);

        //11. Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        //right slider - the most rigth position.
        homePageSelenide.moveSliders(30, 70);

        //12. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRowsLog(30,70);
    }
}
