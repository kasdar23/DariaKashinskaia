package jdi.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import entities.MetalsColorsData;

import java.util.List;

public class MetalsColorsForm extends Form<MetalsColorsData> {
    @FindBy(css = "p.radio")
    private HtmlRadioGroup numbers;

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

    @Override
    public void submit(MetalsColorsData data) {
        numbers.select(data.numbers.get(0).toString());
        numbers.select(data.numbers.get(1).toString());
        selectElement(data.elements);
        colors.select(data.color);
        metals.select(data.metal);
        selectVegetable(data.vegetables);
        submitButton.click();
    }


    // TODO In according to test script, you should not calculate anything.

    private void selectElement(List<String> elementsList) {
        for (String item : elementsList) {
            elements.select(item);
        }
    }

    // TODO What is the reason of this methods ??
    // !TODO

    private void selectVegetable(List<String> vegetablesList) {
        vegetables.select(vegetables.getSelected());
        for (String item : vegetablesList) {
            vegetables.select(item);
        }
    }

}
