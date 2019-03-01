package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import entities.MetalsColorsData;
import jdi.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

    public MetalsColorsData data;

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        List<String> elementsList = new ArrayList<>();
        List<String> vegetableList = new ArrayList<>();
        elementsList.add(WATER.title);
        elementsList.add(FIRE.title);
        vegetableList.add(CUCUMBER.title);
        vegetableList.add(TOMATO.title);
        data = new MetalsColorsData("3", "8",
                elementsList,
                RED.title,
                SELEN.title,
                vegetableList);
    }

    @Test
    public void metalsColorsPageTest() {
        homePage.open();
        homePage.login(PITER_CHAILOVSKII);
        homePage.goTo(METALS_COLORS);
        metalsColorsPage.fillMetalsColorsForm(data, RESULT);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

}
