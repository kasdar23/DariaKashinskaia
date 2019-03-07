package jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import jdi.pages.HomePage;
import jdi.pages.MetalsColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    @Url("/index.html") @Title("Home Page")
    public static HomePage homePage;
    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;
}
