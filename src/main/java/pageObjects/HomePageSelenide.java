package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DataUsers;
import enums.Links;
import enums.Titles;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

// TODO It is completely prohibited to store all elements in one certain PO class.
// TODO PO is LOGICAL page, you have to separate it in several classes.
// TODO This page is NOT home page !
public class HomePageSelenide {

    // TODO You have to use Selenide conditions instead of testNg assertions

    // TODO This is crucial to use annotation @FindBy.
    // TODO The name of the elements should be shorter.

    @FindBy(css = "[id='user-icon']")
    private SelenideElement profileButton;

    @FindBy(css = "[id='name']")
    private SelenideElement login;

    @FindBy(css = "[id='password']")
    private SelenideElement password;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submit;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement heardService;

    @FindBy(css = "ul.dropdown-menu>li>a")
    private ElementsCollection heardServiceItems;

    @FindBy(css = ".sidebar-menu .menu-title")
    private SelenideElement leftService;

    @FindBy(css = ".sidebar-menu .menu-title .sub>li>a")
    private ElementsCollection leftServiceItems;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @Step("Open test site by URL")
    public void openPage(Links links) {
        open(links.link);
    }

    @Step("Assert Browser title")
    public void checkBrowserTitle(Titles expectedTitle) {
        assertEquals(getWebDriver().getTitle(), expectedTitle.title);
    }

    @Step("Login")
    public void login(DataUsers user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
        userName.shouldBe(Condition.exactText(user.userName));
    }

    @Step("Check Header")
    public void checkHeaderServise(List<String> expectedText) {
        heardService.click();
        heardServiceItems.shouldHave(CollectionCondition.texts(expectedText));
    }

    @Step("Check Left Section")
    public void checkLeftSection() {
        leftSection.shouldBe(Condition.visible);
    }

    @Step("Check Left Section Items")
    public void checkLeftServise(List<String> expectedText) {
        leftService.click();
        leftServiceItems.excludeWith(Condition.empty).shouldHave(CollectionCondition.texts(expectedText));
    }

    @Step("Go to Dates Page")
    public void goToDatesPage() {
        heardService.click();
        heardServiceItems.findBy(Condition.text("DATES")).click();
    }

}


