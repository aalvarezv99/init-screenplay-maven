package starter.task.nominacion;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.conf.RememberVariables;
import starter.ui.nominaciones.LocatorsNominaciones;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditarNominacionTask implements Task {
    private final String pedido;
    private final String producto;
    private final List<Map<String, String>> data;

    public static Performable whithEditarNominacion(String pedido, String producto, List<Map<String, String>> data) {
        return instrumented(EditarNominacionTask.class, pedido, producto, data);
    }

    public EditarNominacionTask(String pedido, String producto, List<Map<String, String>> data) {
        this.pedido = pedido;
        this.producto = producto;
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String typeUser = actor.recall(RememberVariables.typeUser.toString());
        actor.attemptsTo(
                WaitUntil.the(LocatorsNominaciones.enlaceNominacion.of(pedido), isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(LocatorsNominaciones.enlaceNominacion.of(pedido)),
                Click.on(LocatorsNominaciones.enlaceNominacion.of(pedido)),
                Check.whether(typeUser.equals("cliente"))
                        .andIfSo(
                                WaitUntil.the(LocatorsNominaciones.estadoNominacion, isVisible()).forNoMoreThan(10).seconds(),
                                Scroll.to(LocatorsNominaciones.estadoNominacion),
                                Ensure.that(LocatorsNominaciones.estadoNominacion).text().isEqualTo("PENDIENTE")
                        ),
                WaitUntil.the(LocatorsNominaciones.btnEditar, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(LocatorsNominaciones.btnEditar),
                Click.on(LocatorsNominaciones.btnEditar),
                WaitUntil.the(LocatorsNominaciones.selectProducto, isVisible()).forNoMoreThan(10).seconds(),
                // Scroll.to(LocatorsNominaciones.selectProducto),
                Click.on(LocatorsNominaciones.selectProducto)
        );
        boolean viewOptionSelect = Visibility.of(LocatorsNominaciones.optionSelect.of(producto)).viewedBy(actor).value();
        while (!viewOptionSelect) {
            actor.attemptsTo(DoubleClick.on(LocatorsNominaciones.selectProducto));
            viewOptionSelect = Visibility.of(LocatorsNominaciones.optionSelect.of(producto)).viewedBy(actor).value();
        }
        actor.attemptsTo(
                Click.on(LocatorsNominaciones.optionSelect.of(producto))
        );
        List<WebElementFacade> listElementos = LocatorsNominaciones.solicitadoInputs.resolveAllFor(actor);
        int contador = 0;
        for (Map<String, String> objectTablaFeature : data) {
            for (WebElementFacade input : listElementos) {
                if (contador < objectTablaFeature.size()) {
                    actor.attemptsTo(
                            Enter.theValue(objectTablaFeature.get("solicitado")).into(input)
                    );
                }
                contador++;
            }
        }
        actor.attemptsTo(
                WaitUntil.the(LocatorsNominaciones.btnGuardarEdicionNominacion, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(LocatorsNominaciones.btnGuardarEdicionNominacion),
                Click.on(LocatorsNominaciones.btnGuardarEdicionNominacion)
        );
        System.out.println("end test");
    }
}
