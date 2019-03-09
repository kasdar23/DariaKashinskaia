package hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import dataProvider.metalsColorsDataSet;
import entities.MetalsColorsData;
import jdi.JDISite;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.Reader;

import static entities.MetalsColorsData.DATA;
import static entities.MetalsColorsData.RESULT;
import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.HeadSectionItems.METALS_COLORS;
import static jdi.JDISite.homePage;
import static jdi.JDISite.metalsColorsPage;

public class MetalColorsPageTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test(dataProvider
            = "expectedData", dataProviderClass = metalsColorsDataSet.class)
    public void metalsColorsPageTest(MetalsColorsData dataSet) {
        homePage.open();
        homePage.login(PITER_CHAILOVSKII);
        homePage.goTo(METALS_COLORS);
        metalsColorsPage.fillMetalsColorsForm(dataSet);
        metalsColorsPage.checkLog(dataSet.generateLog());
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverFactory.close();
    }

}
