package starter.stepdefinitions.commonStepDefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Y;
import starter.conf.RememberVariables;
import starter.navigation.NavigateTo;
import starter.task.common.GetFuncionalidadTask;
import starter.task.login.LoginTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinitions {

    @Cuando("^se asigna el (.*)")
    public void se_asigna_el(String userType) {
        theActorCalled(userType);
        theActorInTheSpotlight().remember(RememberVariables.typeUser.toString(), userType);
    }

    @Y("^se digitan las credenciales del usuario (.*) y contrasena (.*) requeridos")
    public void seDigitanLasCredenciales(String user, String password) {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theCenitGoHomePage(),
                LoginTask.whithCredential(user, password)
        );
    }

    @Cuando("^el usuario ingresa al menu (.*) submenu (.*) item (.*)")
    public void elUsuarioIngresaAlMenu(String menu, String subMenu, String item) {
        theActorInTheSpotlight().attemptsTo(
                GetFuncionalidadTask.whithGetFuncionalidad(menu, subMenu, item)
        );

    }
}
