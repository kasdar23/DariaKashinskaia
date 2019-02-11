package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Titles;
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

    public void goToDifferentElementsPage() {
        heardService.click();
        differentElements.click();
    }

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

    public void checkRightSection() {
        rightSection.shouldBe(Condition.visible);
    }

    public void selectNatureElement(Titles natureElement) {
        for (SelenideElement item : natureElements.exclude(Condition.attribute("checked"))) {
            if (item.parent().text().equalsIgnoreCase(natureElement.title)) {
                item.click();
            }
        }
    }

    public void checkLogElements(Titles titles, boolean expectedStatus) {
        for (SelenideElement item : logRows) {
            item.shouldBe(Condition.visible);
        }

        logRows.findBy(Condition.text(titles.title))
                .shouldHave(Condition.text("condition changed to " + expectedStatus));
    }

    public void selectMaterials(Titles materials) {
        // TODO material.find(Condition.text(materials.title)).click();
        for (SelenideElement item : material) {
            if (item.text().equalsIgnoreCase(materials.title)) {
                item.click();
            }
        }
    }

    public void checkLog(Titles titles) {
        logRows.findBy(Condition.text(titles.title)).shouldHave(Condition.text("value changed to "));
    }

    public void selectColor(Titles dropDownTitle) {
        // TODO dropDownItems.find(Condition.text(dropDownTitle.title)).click();
        for (SelenideElement item : dropDownItems) {
            if (item.text().equalsIgnoreCase(dropDownTitle.title)) {
                item.click();
            }
        }

    }

    public void unselectNatureElement(Titles chekBoxTitle) {
        // TODO Take a look on IDEA warning
        for (SelenideElement item : natureElements.filter(Condition.attribute("checked"))) {
            if (item.parent().text().equalsIgnoreCase(chekBoxTitle.title)) {
                item.click();
            }
        }
    }
}

