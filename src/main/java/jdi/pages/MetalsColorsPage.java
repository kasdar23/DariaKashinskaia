package jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Text;
import entities.MetalsColorsData;
import enums.Data;
import jdi.forms.MetalsColorsForm;

public class MetalsColorsPage extends WebPage {

    // TODO Is this constructor really essential ?
    public MetalsColorsPage() {
    }

    MetalsColorsForm metalsColorsForm;

    @FindBy (css = ".results")
    private Text result;

    public void fillMetalsColorsForm(MetalsColorsData data,
                                     Data expectResult)
    {
        metalsColorsForm.fill(data);
        // TODO Really ? Where did you find this approach ??
        // TODO You should use JDI/TestNg assertions...
        assert (result.getText().equals(expectResult.item));
    }
}
