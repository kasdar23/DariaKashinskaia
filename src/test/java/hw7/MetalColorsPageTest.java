package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import jdi.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static enums.ColorsAndMaterials.RED;
import static enums.ColorsAndMaterials.SELEN;
import static enums.Data.RESULT;
import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.HeadSectionItems.METALS_COLORS;
import static enums.NatureElements.FIRE;
import static enums.NatureElements.WATER;
import static enums.Vegetables.CUCUMBER;
import static enums.Vegetables.TOMATO;
import static jdi.JDISite.*;

public class MetalColorsPageTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void metalsColorsPageTest() {
        homePage.open();
        homePage.login(PITER_CHAILOVSKII);
        homePage.goTo(METALS_COLORS);
        metalsColorsPage.selectAndCount("3", "8");
        metalsColorsPage.selectElement(WATER);
        metalsColorsPage.selectElement(FIRE);
        metalsColorsPage.selectColor(RED);
        metalsColorsPage.selectMetal(SELEN);
        metalsColorsPage.vegetableEmpty();
        metalsColorsPage.selectVegetable(CUCUMBER);
        metalsColorsPage.selectVegetable(TOMATO);
        metalsColorsPage.submitForm();
        metalsColorsPage.checkResult(RESULT);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

}
