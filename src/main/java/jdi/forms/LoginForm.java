package jdi.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import enums.DataUsers;

public class LoginForm extends Form<DataUsers> {

    @FindBy(css = "[id='name']")
    private TextField login;

    @FindBy(css = "[id='password']")
    private TextField password;

    @FindBy (css = "[id='login-button']")
    private Button submitButton;
}
