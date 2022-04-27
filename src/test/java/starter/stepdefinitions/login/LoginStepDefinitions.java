package starter.stepdefinitions.login;

import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import starter.navigation.NavigateTo;
import starter.task.login.LoginTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    @Y("^digita su usuario (.*) y contrasena (.*)")
    public void ingresa_su_usuario_y_contrasena(String usuario, String contrasena) {

        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theCenitGoHomePage(),
                LoginTask.whithCredential(usuario, contrasena)
        );

    }

    @Entonces("este es un paso de prueba")
    public void este_es_un_paso_de_prueba() {
        System.out.println("paso de prueba");
    }
}
