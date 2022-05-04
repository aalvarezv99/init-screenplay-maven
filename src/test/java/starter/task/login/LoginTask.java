package starter.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.models.UserLogin;
import starter.ui.login.LoginForm;
import starter.utils.UserCredentials;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private final String typeUser;
    private final String userName;

    public LoginTask(String typeUser, String userName) {
        this.typeUser = typeUser;
        this.userName = userName;
    }

    public static Performable whithCredential(String typeUser, String userName) {
        return instrumented(LoginTask.class, typeUser, userName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserLogin userLogin = UserCredentials.getUser(typeUser, userName);
        actor.attemptsTo(
                WaitUntil.the(LoginForm.user, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userLogin.getUser()).into(LoginForm.user),
                Enter.theValue(userLogin.getPassword()).into(LoginForm.password),
                Click.on(LoginForm.btnLogin)
        );
        System.out.println("end to first test");
    }
}
