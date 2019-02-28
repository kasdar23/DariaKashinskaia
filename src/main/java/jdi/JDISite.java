package jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import jdi.pages.HomePage;
import jdi.pages.MetalsColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    @Url("/index.html")
    public static HomePage homePage;
    @Url("/metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;
}
