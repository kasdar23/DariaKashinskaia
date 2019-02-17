package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.ColorsAndMaterials;
import enums.NatureElements;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPageCucumber {

    public DifferentElementsPageCucumber(){
        page(this);
    }

    @FindBy(css = ".label-checkbox > input")
    private ElementsCollection natureElements;

    @FindBy(css = ".label-radio")
    private ElementsCollection material;

    @FindBy(css = ".colors")
    private SelenideElement color;

    @FindBy(css = "option")
    private ElementsCollection dropDownItems;

    @FindBy(css = ".main-content-hg .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logRows;

    @Step("Check interface")
    @Then("4 checkboxes, 4 radios, 1 dropdown, 2 buttons are displayed")
    public void checkInterface() {
        natureElements.shouldHaveSize(4);
        for (SelenideElement item : natureElements) {
            item.shouldBe(Condition.visible);
        }
        material.shouldHaveSize(4);
        for (SelenideElement item : material) {
            item.shouldBe(Condition.visible);
        }
        color.shouldBe(Condition.visible);
        buttons.shouldHaveSize(2);
        for (SelenideElement item : buttons) {
            item.shouldBe(Condition.visible);
        }
    }

    @Step("Check Right Section")
    @And ("Right section is displayed")
    public void checkRightSection() {
        rightSection.shouldBe(Condition.visible);
    }

    @Step("Select {natureElement.title}")
    @When("I select element (.+)")
    public void selectNatureElement(NatureElements natureElement) {
        for (SelenideElement item : natureElements.exclude(Condition.attribute("checked"))) {
            if (item.parent().text().equalsIgnoreCase(natureElement.title)) {
                item.click();
            }
        }
    }

    @Step("Unselect {chekBoxTitle.title}")
    @When("I unselect element (.+)")
    public void unselectNatureElement(NatureElements chekBoxTitle) {
        // TODO Take a look on IDEA warning
        for (SelenideElement item : natureElements.filter(Condition.attribute("checked"))) {
            if (item.parent().text().equalsIgnoreCase(chekBoxTitle.title)) {
                item.click();
            }
        }
    }

    @Step("Check log: element - {titles.title}, status - {expectedStatus}")
    @Then("Logs for element (.+) is displayed and status is (.+)")
    public void checkLogElements(NatureElements titles, boolean expectedStatus) {
        for (SelenideElement item : logRows) {
            item.shouldBe(Condition.visible);
        }

        logRows.findBy(Condition.text(titles.title))
                .shouldHave(Condition.text("condition changed to " + expectedStatus));
    }

    @Step("Choose {materials}")
    @When("I select material (.+)")
    public void selectMaterials(ColorsAndMaterials materials) {
        // TODO material.find(Condition.text(materials.title)).click();
        material.find(Condition.text(materials.title)).click();
    }

    @Step("Choose {dropDownTitle}")
    @When("I select color (.+)")
    public void selectColor(ColorsAndMaterials dropDownTitle) {
        // TODO dropDownItems.find(Condition.text(dropDownTitle.title)).click();
        dropDownItems.find(Condition.text(dropDownTitle.title)).click();
    }

    @Step("Check log for {titles.title}")
    @Then("Log for (.+) is displayed")
    public void checkLog(ColorsAndMaterials titles) {
        logRows.findBy(Condition.text(titles.title)).shouldHave(Condition.text("value changed to "));
    }

}

