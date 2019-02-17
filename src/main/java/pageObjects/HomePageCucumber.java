package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.DataUsers;
import enums.Links;
import enums.Titles;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageCucumber {

    public HomePageCucumber() {
        page(this);
    }

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

    @FindBy(css = "div.benefit-icon > span")
    private ElementsCollection pictures;

    @FindBy(css = "div.benefit > span")
    private ElementsCollection picturesTexts;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainTitleText;

    @Step("Open test site {links.link}")
    @When("I'm on (.+)")
    public void openPage(Links links) {
        open(links.link);
    }

    @Step("Assert Browser title {expectedTitle.title}")
    @Then("The browser title is (.+)")
    public void checkBrowserTitle(Titles expectedTitle) {
        assertEquals(getWebDriver().getTitle(), expectedTitle.title);
    }

    @Step("Login: login {user.login}; password {user.password}; user {user.userName}")
    @And("I login as user (.+)")
    public void login(DataUsers user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
        userName.shouldBe(Condition.exactText(user.userName));
    }

    @Step("Check interface")
    @Then("4 - pictures, 4 texts under them, 2 texts above are displayed")
    public void checkInterface() {
        for (SelenideElement item :
                pictures) {
            item.shouldBe(Condition.visible);
        }
        for (SelenideElement item :
                picturesTexts) {
            item.shouldBe(Condition.visible);
        }
        mainTitle.shouldBe(Condition.visible);
        mainTitleText.shouldBe(Condition.visible);
    }

    @Step("Check Header")
    @Then("I click on Service subcategory in the header and check that drop down contains")
    public void checkHeaderServise(List<String> expectedText) {
        heardService.click();
        heardServiceItems.shouldHave(CollectionCondition.texts(expectedText));
    }

    @Step("Check Left Section Items")
    @Then("I click on Service subcategory in the left section and check that drop down contains")
    public void checkLeftServise(List<String> expectedText) {
        leftSection.shouldBe(Condition.visible);
        leftService.click();
        leftServiceItems.excludeWith(Condition.empty).shouldHave(CollectionCondition.texts(expectedText));
    }

    @Step("Check Left Section Visible")
    @Then("Left section is displayed")
    public void checkLeftSection() {
        leftSection.shouldBe(Condition.visible);
    }

    @Step("Go to Different Elements Page")
    @When("I open through the header menu Service -> Different Elements Page")
    public void goToDifferentElementsPage() {
        heardService.click();
        heardServiceItems.findBy(Condition.text("DIFFERENT ELEMENTS")).click();
    }

    @Step("Go to Dates Page")
    public void goToDatesPage() {
        heardService.click();
        heardServiceItems.findBy(Condition.text("DATES")).click();
    }

    @Step("click on Service button in Header")
    @When("I click on Service button in Header")
    public void clickService() {
        heardService.click();
    }

    @Step("Go to User Table Page")
    @And("I click on User Table button in Service dropdown")
    public void goToUserTablePage() {
        heardServiceItems.findBy(Condition.text("USER TABLE")).click();
    }

}


