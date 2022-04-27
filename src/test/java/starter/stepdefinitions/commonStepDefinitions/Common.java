package starter.stepdefinitions.commonStepDefinitions;

import cucumber.api.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Common {

    @Cuando("^se asigna el (.*)")
    public void se_asigna_el(String name) {
        theActorCalled(name);
    }
}
