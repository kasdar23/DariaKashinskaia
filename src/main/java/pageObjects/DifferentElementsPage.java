package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ColorsAndMaterials;
import enums.NatureElements;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;

public class DifferentElementsPage {
    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement heardService;

    @FindBy(css = ".m-l8 .dropdown-menu [href = 'different-elements.html']")
    private SelenideElement differentElements;

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

    @Step("Go to Different Elements Page")
    public void goToDifferentElementsPage() {
        heardService.click();
        differentElements.click();
    }

    @Step("Check interface")
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
    public void checkRightSection() {
        rightSection.shouldBe(Condition.visible);
    }

    @Step("Select Nature Elements")
    public void selectNatureElement(NatureElements natureElement) {
        for (SelenideElement item : natureElements.exclude(Condition.attribute("checked"))) {
            if (item.parent().text().equalsIgnoreCase(natureElement.title)) {
                item.click();
            }
        }
    }

    @Step("Unselect Nature Elements")
    public void unselectNatureElement(NatureElements chekBoxTitle) {
        // TODO Take a look on IDEA warning
        for (SelenideElement item : natureElements.filter(Condition.attribute("checked"))) {
            if (item.parent().text().equalsIgnoreCase(chekBoxTitle.title)) {
                item.click();
            }
        }
    }

    @Step("Check Nature Elements log")
    public void checkLogElements(NatureElements titles, boolean expectedStatus) {
        for (SelenideElement item : logRows) {
            item.shouldBe(Condition.visible);
        }

        logRows.findBy(Condition.text(titles.title))
                .shouldHave(Condition.text("condition changed to " + expectedStatus));
    }

    @Step("Choose material")
    public void selectMaterials(ColorsAndMaterials materials) {
        // TODO material.find(Condition.text(materials.title)).click();
        material.find(Condition.text(materials.title)).click();
    }

    @Step("Choose color")
    public void selectColor(ColorsAndMaterials dropDownTitle) {
        // TODO dropDownItems.find(Condition.text(dropDownTitle.title)).click();
        dropDownItems.find(Condition.text(dropDownTitle.title)).click();
    }

    @Step("Check colors and materials log")
    public void checkLog(ColorsAndMaterials titles) {
        logRows.findBy(Condition.text(titles.title)).shouldHave(Condition.text("value changed to "));
    }

}

