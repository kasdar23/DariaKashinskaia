package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

// TODO It is completely prohibited to store all elements in one certain PO class.
// TODO PO is LOGICAL page, you have to separate it in several classes.
// TODO This page is NOT home page !
public class DataPage {

    // TODO You have to use Selenide conditions instead of testNg assertions

    // TODO This is crucial to use annotation @FindBy.
    // TODO The name of the elements should be shorter.
    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement heardService;
    @FindBy(css = ".m-l8 .dropdown-menu [href = 'dates.html']")
    private SelenideElement buttonData;
    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logRows;
    @FindBy(css = ".ui-slider")
    private SelenideElement sliderTrack;
    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection slider;


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


    public void checkLog(Integer from, Integer to) {
        logRows.get(1).shouldHave(Condition.text(from.toString()));
        logRows.get(0).shouldHave(Condition.text(to.toString()));
    }

}

