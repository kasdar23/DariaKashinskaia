package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import enums.DataUsers;
import enums.Links;
import enums.Titles;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
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
    SelenideElement profileButton = $("[id='user-icon']");
    SelenideElement login = $("[id='name']");
    SelenideElement password = $("[id='password']");
    SelenideElement submit = $("[id='login-button']");
    SelenideElement userName = $("[id='user-name']");
    SelenideElement buttonHeardService = $(".m-l8 .dropdown-toggle");
    List<SelenideElement> heardServiceItems = $$("ul.dropdown-menu>li>a");
    SelenideElement leftService = $(".sidebar-menu .menu-title");
    List<SelenideElement> leftServiceItems = $$(".sidebar-menu .menu-title .sub>li>a");
    SelenideElement buttonDifferentElements = $(".m-l8 .dropdown-menu [href = 'different-elements.html']");
    SelenideElement buttonData = $(".m-l8 .dropdown-menu [href = 'dates.html']");
    List<SelenideElement> checkBoxesDifferentElements = $$(".label-checkbox");
    List<SelenideElement> radiosDifferentElements = $$(".label-radio");
    SelenideElement dropdownDifferentElements = $(".colors");
    List<SelenideElement> dropDownDifferentElements = $$("option");
    List<SelenideElement> buttonsPageDifferentElements = $$(".main-content-hg .uui-button");
    SelenideElement rightSection = $(".right-fix-panel");
    SelenideElement leftSection = $(".sidebar-menu");
    List<SelenideElement> logRows = $$(".panel-body-list.logs > li");
    SelenideElement sliderTrack = $(".ui-slider");
    List<SelenideElement> slider = $$(".ui-slider-handle");


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
        assertEquals(userName.getText(), user.userName);
    }

    public void checkHeaderServise(List<String> expectedText) {
        buttonHeardService.click();
        List<String> heardServiceText = new ArrayList<>();
        for (SelenideElement item :
                heardServiceItems) {
            heardServiceText.add(item.getText().toUpperCase());
        }

        assertTrue(heardServiceText.containsAll(expectedText));
    }

    public void checkLeftServise(List<String> expectedText) {
        leftService.click();
        List<String> leftServiceText = new ArrayList<>();
        for (SelenideElement item :
                leftServiceItems) {
            leftServiceText.add(item.getText().toUpperCase());
        }

        assertTrue(leftServiceText.containsAll(expectedText));
    }

    public void goToDifferentElementsPage() {
        buttonHeardService.click();
        buttonDifferentElements.click();
    }

    public void goToDatesPage() {
        buttonHeardService.click();
        buttonData.click();
    }

    public void checkInterfaceDifferentElementsPage() {
        assertEquals(checkBoxesDifferentElements.size(), 4);
        for (SelenideElement item : checkBoxesDifferentElements) {
            assertTrue(item.isDisplayed());
        }
        assertEquals(radiosDifferentElements.size(), 4);
        for (SelenideElement item : radiosDifferentElements) {
            assertTrue(item.isDisplayed());
        }
        assertTrue(dropdownDifferentElements.isDisplayed());
        assertEquals(buttonsPageDifferentElements.size(), 2);
        for (SelenideElement item : buttonsPageDifferentElements) {
            assertTrue(item.isDisplayed());
        }
    }

    public void checkRightSection() {
        assertTrue(rightSection.isDisplayed());
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void selectChekBox(Titles chekBoxTitle) {

        // TODO Take a look on IDEA warning
        for (int i = 0; i < checkBoxesDifferentElements.size(); i++) {
            if (checkBoxesDifferentElements.get(i).getText().equalsIgnoreCase(chekBoxTitle.title)) {
                checkBoxesDifferentElements.get(i).click();
            }
        }

        for (SelenideElement item :
                logRows) {
            assertTrue(item.isDisplayed());
        }

        assertTrue(logRows.get(0).getText().contains(chekBoxTitle.title));
        assertTrue(logRows.get(0).getText().contains(chekBoxTitle.title + ": condition changed to true"));
    }

    public void selectRadioButton(Titles radioButtonTitle) {
        // TODO Take a look on IDEA warning
        for (int i = 0; i < radiosDifferentElements.size(); i++) {
            if (radiosDifferentElements.get(i).getText().equalsIgnoreCase(radioButtonTitle.title)) {
                radiosDifferentElements.get(i).click();
            }
        }
        assertTrue(logRows.get(0).getText().contains("value changed to " + radioButtonTitle.title));
    }

    public void selectDropDown(Titles dropDownTitle) {
        // TODO Take a look on IDEA warning
        for (int i = 0; i < dropDownDifferentElements.size(); i++) {
            if (dropDownDifferentElements.get(i).getText().equalsIgnoreCase(dropDownTitle.title)) {
                dropdownDifferentElements.click();
                dropDownDifferentElements.get(i).click();
            }
        }
        assertTrue(logRows.get(0).getText().contains("value changed to " + dropDownTitle.title));
    }

    public void unselectedCheckBox(Titles chekBoxTitle) {
        // TODO Take a look on IDEA warning
        for (int i = 0; i < checkBoxesDifferentElements.size(); i++) {
            if (checkBoxesDifferentElements.get(i).getText().equalsIgnoreCase(chekBoxTitle.title)) {
                checkBoxesDifferentElements.get(i).click();
            }
        }

        for (SelenideElement item : logRows) {
            assertTrue(item.isDisplayed());
        }

        assertTrue(logRows.get(0).getText().contains(chekBoxTitle.title));
        assertTrue(logRows.get(0).getText().contains(chekBoxTitle.title + ": condition changed to false"));
    }

    // TODO It is not really good idea to mix PO Action and verification !
    public void moveLeftSlider(Integer fromValue, Integer toValue) {

        Integer sliderTrackLength = sliderTrack.getSize().getWidth();
        Integer sliderTrackX = sliderTrack.getLocation().getX();
        Integer sliderWidth = slider.get(1).getSize().getWidth() / 2;
        // TODO Quite long variable name
        Integer leftSliderStartLocationPixel = slider.get(0).getLocation().getX() + sliderWidth;
        Integer rightSliderStartLocationPixel = slider.get(1).getLocation().getX() + sliderWidth;

        Integer offsetLeftSlider = convertPercentToPixel(fromValue, sliderTrackLength) + sliderTrackX - leftSliderStartLocationPixel;
        new Actions(getWebDriver()).dragAndDropBy(slider.get(0), offsetLeftSlider, 0).build().perform();

        assertTrue(logRows.get(0).getText().contains(fromValue.toString()));

        Integer offsetRightSlider = convertPercentToPixel(toValue, sliderTrackLength) + sliderTrackX - rightSliderStartLocationPixel;
        new Actions(getWebDriver()).dragAndDropBy(slider.get(1), offsetRightSlider, 0).build().perform();
        assertTrue(logRows.get(0).getText().contains(toValue.toString()));
    }

    public Integer convertPercentToPixel(Integer percentValue, Integer sliderLength) {
        // TODO Take a look on IDEA warning
        // TODO (int) 100 != (float) 100.0 Your test failed because of this accuracy flaw.
        Integer pixelValue = (int) Math.ceil(percentValue * sliderLength / 100.0);
        return pixelValue;
    }


}

