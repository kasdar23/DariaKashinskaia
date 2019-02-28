package jdi.pages;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import enums.ColorsAndMaterials;
import enums.Data;
import enums.NatureElements;
import enums.Vegetables;

public class MetalsColorsPage extends WebPage {

    public MetalsColorsPage() {
    }

    @FindBy(css = "p.radio")
    private RadioButtons numbers;

    @FindBy(css = "[id ='calculate-button']")
    private Button calculate;

    @FindBy(css = "p.checkbox ")
    private RadioButtons elements;

    @JDropdown(
            root = "#colors",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret"
    )
    private Droplist colors;

    @JDropdown(
            root = "#salad-dropdown",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    public Droplist vegetables;


    @JDropdown(
            root = "#metals",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    private Droplist metals;

    @FindBy(css = "[id ='submit-button']")
    private Button submitButton;

    @FindBy (css = ".results")
    private Text result;

    public void selectAndCount(String oddNumber, String evenNumber) {
        numbers.select(oddNumber);
        numbers.select(evenNumber);
        calculate.click();
    }

    public void selectElement(NatureElements element) {
        elements.select(element.title);
    }

    public void selectColor(ColorsAndMaterials item) {
        colors.select(item.title);
    }

    public void selectMetal(ColorsAndMaterials item) {
        metals.select(item.title);
    }

    public void vegetableEmpty() {
        vegetables.select(vegetables.getSelected());
    }

    public void selectVegetable(Vegetables item) {
        vegetables.select(item.title);
    }

    public void submitForm() {
        submitButton.click();
    }

    public void checkResult(Data expectResult) {
        assert (result.getText().equals(expectResult.item));
    }
}
