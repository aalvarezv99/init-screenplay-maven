package starter.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.login.LoginForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private final String user;
    private final String password;

    public LoginTask(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Performable whithCredential(String user, String password) {
        return instrumented(LoginTask.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginForm.user, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(LoginForm.user),
                Enter.theValue(password).into(LoginForm.password),
                Click.on(LoginForm.btnLogin)
        );
        System.out.println("end to first test");
    }
}
