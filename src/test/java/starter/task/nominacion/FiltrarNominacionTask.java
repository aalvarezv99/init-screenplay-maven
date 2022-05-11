package starter.task.nominacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.nominaciones.LocatorsNominaciones;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FiltrarNominacionTask implements Task {
    private final String sistema;
    private final String estado;
    private final String tipoBusqueda;

    public FiltrarNominacionTask(String sistema, String estado, String tipoBusqueda) {
        this.sistema = sistema;
        this.estado = estado;
        this.tipoBusqueda = tipoBusqueda;
    }

    public static Performable whithFiltroNominacion(String sistema, String estado, String tipoBusqueda) {
        return instrumented(FiltrarNominacionTask.class, sistema, estado, tipoBusqueda);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LocatorsNominaciones.selectSistema, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsNominaciones.selectSistema),
                WaitUntil.the(LocatorsNominaciones.optionSelect.of(sistema), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsNominaciones.optionSelect.of(sistema)),
                Click.on(LocatorsNominaciones.selectEstado),
                WaitUntil.the(LocatorsNominaciones.optionSelect.of(estado), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsNominaciones.optionSelect.of(estado)),
                Click.on(LocatorsNominaciones.selectTipoBusqueda),
                WaitUntil.the(LocatorsNominaciones.optionSelect.of(tipoBusqueda), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsNominaciones.optionSelect.of(tipoBusqueda)),
                Click.on(LocatorsNominaciones.btnBuscar)
        );
        System.out.println("end test");
    }
}
