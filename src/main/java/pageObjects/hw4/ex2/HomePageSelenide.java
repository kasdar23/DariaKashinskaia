package pageObjects.hw4.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DataUsers;
import enums.Links;
import enums.Titles;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO It is completely prohibited to store all elements in one certain PO class.
// TODO PO is LOGICAL page, you have to separate it in several classes.
// TODO This page is NOT home page !
public class HomePageSelenide {

    // TODO You have to use Selenide conditions instead of testNg assertions

    // TODO This is crucial to use annotation @FindBy.
    // TODO The name of the elements should be shorter.
    @FindBy
    private SelenideElement profileButton = $("[id='user-icon']");
    @FindBy
    private SelenideElement login = $("[id='name']");
    @FindBy
    private SelenideElement password = $("[id='password']");
    @FindBy
    private SelenideElement submit = $("[id='login-button']");
    @FindBy
    private SelenideElement userName = $("[id='user-name']");
    @FindBy
    private SelenideElement heardService = $(".m-l8 .dropdown-toggle");
    @FindBy
    private SelenideElement buttonData = $(".m-l8 .dropdown-menu [href = 'dates.html']");
    @FindBy
    private ElementsCollection logRows = $$(".panel-body-list.logs > li");
    @FindBy
    private SelenideElement sliderTrack = $(".ui-slider");
    @FindBy
    private ElementsCollection slider = $$(".ui-slider-handle");


    public void openPage(Links links) {
        open(links.link);
    }

    public void checkBrowserTitle(Titles expectedTitle) {
        assertEquals(getWebDriver().getTitle(), expectedTitle.title);
    }

    public void login(DataUsers user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
        userName.shouldBe(Condition.text(user.userName));
    }

    public void goToDatesPage() {
        heardService.click();
        buttonData.click();
    }


    // TODO It is not really good idea to mix PO Action and verification !
    public void moveSliders(int fromValue, int toValue) {

        double sliderTrackLength = sliderTrack.getSize().getWidth();
        // TODO Quite long variable name

        new Actions(getWebDriver()).moveToElement(sliderTrack)
                .clickAndHold(slider.get(0))
                .moveToElement(sliderTrack, (int) (fromValue * sliderTrackLength / 100.0 + 1), 0)
                .release().build().perform();

        new Actions(getWebDriver()).moveToElement(sliderTrack)
                .clickAndHold(slider.get(1))
                .moveToElement(sliderTrack, (int) (toValue * sliderTrackLength / 100.0 + 1), 0)
                .release().build().perform();
    }


    // TODO Take a look on IDEA warning
    // TODO (int) 100 != (float) 100.0 Your test failed because of this accuracy flaw.


    public void checkRowsLog(Integer from, Integer to) {
        logRows.get(1).shouldHave(Condition.text(from.toString()));
        logRows.get(0).shouldHave(Condition.text(to.toString()));
    }

}

