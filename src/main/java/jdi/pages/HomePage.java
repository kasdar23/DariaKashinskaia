package jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.complex.Menu;
import enums.DataUsers;
import enums.HeadSectionItems;
import jdi.forms.LoginForm;


public class HomePage extends WebPage {

    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = "[id='user-name']")
    private Button userName;

    @FindBy(css = ".navbar-nav.m-l8")
    private Menu headerMenu;

    public void login(DataUsers user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void goTo(HeadSectionItems item) {
        headerMenu.select(item.expectedText);
    }

}
