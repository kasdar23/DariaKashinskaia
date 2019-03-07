package jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Text;
import entities.MetalsColorsData;
import jdi.forms.MetalsColorsForm;
import org.testng.Assert;

public class MetalsColorsPage extends WebPage {

    MetalsColorsForm metalsColorsForm;

    @FindBy(css = ".results")
    private Text result;

    public void fillMetalsColorsForm(MetalsColorsData data) {
       metalsColorsForm.submit(data);
    }

    public void checkLog(String expectResult) {
        Assert.assertEquals(result.getText(), expectResult);
    }

}
