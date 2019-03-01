package jdi.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import entities.MetalsColorsData;

import java.util.List;

public class MetalsColorsForm extends Form<MetalsColorsData> {
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

    public void fill(MetalsColorsData data)
    {
        selectAndCount(data.oddNumber, data.evenNumber);
        selectElement(data.elements);
        selectColor(data.color);
        selectMetal(data.metal);
        selectVegetable(data.vegetables);
        submitForm();
    }

    private void selectAndCount(String oddNumber, String evenNumber) {
        numbers.select(oddNumber);
        numbers.select(evenNumber);
        calculate.click();
    }

    private void selectElement(List<String> elementsList) {
        for (String item :
                elementsList) {
            elements.select(item);
        }

    }

    private void selectColor(String item) {
        colors.select(item);
    }

    private void selectMetal(String item) {
        metals.select(item);
    }

    private void selectVegetable(List<String> vegetablesList) {
        vegetables.select(vegetables.getSelected());
        for (String item: vegetablesList) {
            vegetables.select(item);
        }
    }

    private void submitForm() {
        submitButton.click();
    }
}
