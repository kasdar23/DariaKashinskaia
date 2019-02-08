package pageObjects.hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import com.codeborne.selenide.impl.CollectionElementByCondition;
import enums.DataUsers;
import enums.Links;
import enums.Titles;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    private ElementsCollection heardServiceItems = $$("ul.dropdown-menu>li>a");
    @FindBy
    private SelenideElement leftService = $(".sidebar-menu .menu-title");
    @FindBy
    private ElementsCollection leftServiceItems = $$(".sidebar-menu .menu-title .sub>li>a");
    @FindBy
    private SelenideElement differentElements = $(".m-l8 .dropdown-menu [href = 'different-elements.html']");
    @FindBy
    private ElementsCollection checkBoxes = $$(".label-checkbox");
    @FindBy
    private ElementsCollection radios = $$(".label-radio");
    @FindBy
    private SelenideElement dropdown = $(".colors");
    @FindBy
    private ElementsCollection dropDownItems = $$("option");
    @FindBy
    private ElementsCollection buttons = $$(".main-content-hg .uui-button");
    @FindBy
    private SelenideElement rightSection = $(".right-fix-panel");
    @FindBy
    private SelenideElement leftSection = $(".sidebar-menu");
    @FindBy
    private ElementsCollection logRows = $$(".panel-body-list.logs > li");


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
        userName.shouldBe(Condition.exactText(user.userName));
    }

    public void checkHeaderServise(List<String> expectedText) {
        heardService.click();
        assertTrue(heardServiceItems.texts().containsAll(expectedText));
    }

    public void checkLeftServise(List<String> expectedText) {
        leftService.click();
        assertTrue(leftServiceItems.texts().containsAll(expectedText));
    }

    public void goToDifferentElementsPage() {
        heardService.click();
        differentElements.click();
    }

    public void checkInterfaceDifferentElementsPage() {
        checkBoxes.shouldHaveSize(4);
        for (SelenideElement item : checkBoxes) {
            item.shouldBe(Condition.visible);
        }
        radios.shouldHaveSize(4);
        for (SelenideElement item : radios) {
            item.shouldBe(Condition.visible);
        }
        dropdown.shouldBe(Condition.visible);
        buttons.shouldHaveSize(2);
        for (SelenideElement item : buttons) {
            item.shouldBe(Condition.visible);
        }
    }

    public void checkRightSection() {
        rightSection.shouldBe(Condition.visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(Condition.visible);
    }

    public void selectChekBox(Titles chekBoxTitle) {

        // TODO Take a look on IDEA warning
        for (SelenideElement item :
                checkBoxes) {
            if (item.text().equalsIgnoreCase(chekBoxTitle.title)) {
                item.click();
            }
        }

    }

    public void checkLogRowBox(Titles titles, boolean expectedStatus) {
        for (SelenideElement item :
                logRows) {
            item.shouldBe(Condition.visible);
        }
        if (expectedStatus) {
            logRows.findBy(Condition.text(titles.title)).shouldHave(Condition.text("condition changed to true"));
        } else {
            logRows.findBy(Condition.text(titles.title)).shouldHave(Condition.text("condition changed to false"));

        }

    }

    public void selectRadioButton(Titles radioButtonTitle) {
        // TODO Take a look on IDEA warning
        for (SelenideElement item :
                radios) {
            if (item.text().equalsIgnoreCase(radioButtonTitle.title)) {
                item.click();
            }
        }

    }

    public void checkLogRowValue(Titles titles){
        logRows.findBy(Condition.text(titles.title)).shouldHave(Condition.text("value changed to "));
    }

    public void selectColor(Titles dropDownTitle) {
        // TODO Take a look on IDEA warning
        for (SelenideElement item :
                dropDownItems) {
            if (item.text().equalsIgnoreCase(dropDownTitle.title)) {
                item.click();
            }
        }

    }

    public void unselectedCheckBox(Titles chekBoxTitle) {
        // TODO Take a look on IDEA warning
        for (SelenideElement item :
                checkBoxes) {
            if (item.text().equalsIgnoreCase(chekBoxTitle.title)) {
                item.click();
            }
        }

        for (SelenideElement item : logRows) {
            item.shouldBe(Condition.visible);
        }

        logRows.get(0).shouldHave(Condition.text(chekBoxTitle.title));
        logRows.get(0).shouldHave(Condition.text(chekBoxTitle.title + ": condition changed to false"));
    }


}


