package starter.task.nominacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import starter.ui.nominaciones.LocatorsNominaciones;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CambiarEstadoTask implements Task {
    private final String numPedido;
    private final String cambiarEstado;

    public static Performable whithCambiarEstado(String numPedido, String cambiarEstado) {
        return instrumented(CambiarEstadoTask.class, numPedido, cambiarEstado);
    }

    public CambiarEstadoTask(String numPedido, String cambiarEstado) {
        this.numPedido = numPedido;
        this.cambiarEstado = cambiarEstado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LocatorsNominaciones.enlaceNominacion.of(numPedido), isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(LocatorsNominaciones.enlaceNominacion.of(numPedido)),
                Click.on(LocatorsNominaciones.enlaceNominacion.of(numPedido)),
                Scroll.to(LocatorsNominaciones.selectEstadoNominacion),
                Click.on(LocatorsNominaciones.selectEstadoNominacion),
                WaitUntil.the(LocatorsNominaciones.optionSelect.of(cambiarEstado), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsNominaciones.optionSelect.of(cambiarEstado)),
                Click.on(LocatorsNominaciones.btnGuardarCambioNominacion),
                WaitUntil.the(LocatorsNominaciones.btnHistorialUpdateNominacion, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsNominaciones.btnHistorialUpdateNominacion)
        );
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        actor.attemptsTo(
                WaitUntil.the(LocatorsNominaciones.estadoActual.of(cambiarEstado), isVisible()).forNoMoreThan(10).seconds()
        );
        System.out.println("end test");
    }
}
