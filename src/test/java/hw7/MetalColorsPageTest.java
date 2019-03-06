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
import java.util.Arrays;
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
        // TODO Basically, this should not be here. You can create special class in order to store data,
        // TODO or use the similar way as User class.
        // TODO Anyway, take a look on Arrays class !
        List<String> vegetableList = new ArrayList<>();
        vegetableList.add(CUCUMBER.title);
        vegetableList.add(TOMATO.title);
        data = new MetalsColorsData("3", "8",
                Arrays.asList(WATER.title, FIRE.title),
                RED.title,
                SELEN.title,
                vegetableList);
    }

    @Test
    public void metalsColorsPageTest() {
        homePage.open();
        homePage.login(PITER_CHAILOVSKII);
        homePage.goTo(METALS_COLORS);
        // TODO This is completely prohibited to mix up action and verification steps !
        metalsColorsPage.fillMetalsColorsForm(data, RESULT);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

}
