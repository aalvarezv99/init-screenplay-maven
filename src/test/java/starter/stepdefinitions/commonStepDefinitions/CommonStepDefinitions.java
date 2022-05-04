package starter.stepdefinitions.commonStepDefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Y;
import starter.navigation.NavigateTo;
import starter.task.common.GetFuncionalidadTask;
import starter.task.login.LoginTask;
import starter.utils.UserCredentials;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinitions {
    String typeUser = "";

    @Cuando("^se asigna el (.*)")
    public void se_asigna_el(String userType) {
        typeUser = userType;
        theActorCalled(userType);
    }

    @Y("se crean localmente los usuarios del sistema")
    public void seCreanLocalmenteLosUsuarios() {
        UserCredentials.insertUsers();
    }

    @Y("^se digitan las credenciales del usuario requerido (.*)")
    public void seDigitanLasCredenciales(String userName) {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theCenitGoHomePage(),
                LoginTask.whithCredential(typeUser, userName)
        );
    }

    @Cuando("^el usuario ingresa al menu (.*) submenu (.*) item (.*)")
    public void elUsuarioIngresaAlMenu(String menu, String subMenu, String item) {
        theActorInTheSpotlight().attemptsTo(
                GetFuncionalidadTask.whithGetFuncionalidad(menu, subMenu, item)
        );

    }
}
