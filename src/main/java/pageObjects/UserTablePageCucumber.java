package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Titles;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class UserTablePageCucumber {
    public UserTablePageCucumber() {
        page(this);
    }

    @FindBy(css = "select")
    public ElementsCollection professions;

    @FindBy(css = "table a")
    public ElementsCollection userNames;

    @FindBy(css = "img")
    public ElementsCollection images;

    @FindBy(css = ".user-descr > span")
    public ElementsCollection imagesText;

    @FindBy(css = ".user-descr > input")
    public ElementsCollection vip;

    @FindBy(css = ".panel-body-list.logs > li")
    public ElementsCollection logs;

    @Step("Assert Browser title {expectedTitle.title}")
    @Then("(.+) page is opened")
    public void checkBrowserTitle(Titles expectedTitle) {
        assertEquals(getWebDriver().getTitle(), expectedTitle.title);
    }

    @Step("Check user types dropdowns are displayed")
    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkUserStatusDisplaed(int arg0) {
        for (SelenideElement item : professions) {
            item.shouldBe(Condition.visible);
        }
    }

    @Step("Check user names are displayed")
    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void checkNamesDisplayed(int arg0) {
        for (SelenideElement item : userNames) {
            item.shouldBe(Condition.visible);
        }
    }

    @Step("Check images are displayed")
    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void checkImagesDisplaed(int arg0) {
        for (SelenideElement item : images) {
            item.shouldBe(Condition.visible);
        }
    }

    @Step("Check images text are displayed")
    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkTextDisplaed(int arg0) {
        for (SelenideElement item : imagesText) {
            item.shouldBe(Condition.visible);
        }
    }

    @Step("Check vips are displayed")
    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkbVipsDisplaed(int arg0) {
        for (SelenideElement item : vip) {
            item.shouldBe(Condition.visible);
        }
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable users) {
        List<List<String>> data = users.raw();
        List<String> usersNames = new ArrayList();
        List<String> superHeroes = new ArrayList<>();
        for (List<String> item : data) {
            usersNames.add(item.get(1));
        }
        for (List<String> item : data) {
            superHeroes.add(item.get(2));
        }
        userNames.shouldHave(CollectionCondition.texts(usersNames));
        imagesText.shouldHave(CollectionCondition.texts(superHeroes));
    }

    @Step("Select vip {userName}")
    @When("^I select 'vip' checkbox for (.+)$")
    public void selectVip(String name) {
        int index = userNames.indexOf(userNames.find(Condition.text(name)));
        vip.get(index).click();
    }

    @Step("Check Log: Vip: condition changed to {status}")
    @Then("1 log row has \"Vip: condition changed to (.+)\" text in log section")
    public void checkLog(boolean status) {
        logs.get(0).shouldHave(Condition.text("Vip: condition changed to " + status));

    }

    private int index = 0;
    @When("^I click on dropdown in column Type for user (.+)$")
    public void selectDropdown(String name) {
        index = userNames.indexOf(userNames.find(Condition.text(name)));
        professions.get(index).click();
    }

    @Then("^droplist contains values$")
    public void checkProfessionItems(List<String> expectedText) {
        ElementsCollection professionItems = professions.get(index).findAll(By.cssSelector("option"));
        for (SelenideElement item:professionItems) {
            item.shouldBe(Condition.visible);
        }
        professionItems.shouldHave(CollectionCondition.texts(expectedText));
    }
}
