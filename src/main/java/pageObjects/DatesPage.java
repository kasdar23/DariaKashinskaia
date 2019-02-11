package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {
    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement heardService;

    // TODO It is not make sense to create fields for each menu items...
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

    public void moveSliders(int fromValue, int toValue) {
        double sliderTrackLength = sliderTrack.getSize().getWidth();
        setSliderPosition(fromValue, sliderTrackLength, slider.get(0));
        setSliderPosition(toValue, sliderTrackLength, slider.get(1));
    }

    private void setSliderPosition(int fromValue, double sliderTrackLength, SelenideElement element) {
        new Actions(getWebDriver()).moveToElement(sliderTrack)
                .clickAndHold(element)
                .moveToElement(sliderTrack, (int) (fromValue * sliderTrackLength / 100.0 + 1), 0)
                .release().build().perform();
    }

    public void checkLog(Integer from, Integer to) {
        logRows.get(1).shouldHave(Condition.text(from.toString()));
        logRows.get(0).shouldHave(Condition.text(to.toString()));
    }

}

