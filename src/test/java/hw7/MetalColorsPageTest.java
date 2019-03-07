package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import jdi.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static entities.MetalsColorsData.DATA;
import static entities.MetalsColorsData.RESULT;
import static enums.DataUsers.PITER_CHAILOVSKII;
import static enums.HeadSectionItems.METALS_COLORS;
import static jdi.JDISite.*;

public class MetalColorsPageTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    // TODO Basically, this should not be here. You can create special class in order to store data,
    // TODO or use the similar way as User class.
    // TODO Anyway, take a look on Arrays class !

    @Test
    public void metalsColorsPageTest() {
        homePage.open();
        homePage.login(PITER_CHAILOVSKII);
        homePage.goTo(METALS_COLORS);
        // TODO This is completely prohibited to mix up action and verification steps !
        metalsColorsPage.fillMetalsColorsForm(DATA);
        metalsColorsPage.checkLog(RESULT);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

}
