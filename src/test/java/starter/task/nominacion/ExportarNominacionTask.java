package starter.task.nominacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.nominaciones.LocatorsNominaciones;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ExportarNominacionTask implements Task {

    public static Performable whithExportarNominacion() {
        return instrumented(ExportarNominacionTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LocatorsNominaciones.checkSelectAll, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsNominaciones.checkSelectAll),
                Scroll.to(LocatorsNominaciones.btnExportarExcel),
                Click.on(LocatorsNominaciones.btnExportarExcel)
        );
        System.out.println("end test");
    }
}
