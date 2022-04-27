package starter.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginForm {
    public static final Target user = Target.the("Input para digitar el usuario").located(By.id("UserCtrl"));
    public static final Target password = Target.the("Input para digitar la contraseña").located(By.id("PwdCtrl"));
    public static final Target btnLogin = Target.the("Input para digitar la contraseña").locatedBy("//input[@type = 'submit' and @name = 'btnLogin' and @value = 'Acceso']");
}
