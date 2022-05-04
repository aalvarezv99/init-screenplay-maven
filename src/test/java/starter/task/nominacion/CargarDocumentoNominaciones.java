package starter.task.nominacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.nominaciones.LocatorsNominaciones;

import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CargarDocumentoNominaciones implements Task {
    private final String rutaDoc;
    private final String mensajeEsperado;

    public CargarDocumentoNominaciones(String rutaDoc, String mensajeEsperado) {
        this.rutaDoc = rutaDoc;
        this.mensajeEsperado = mensajeEsperado;
    }

    public static Performable whithCargaElDocumentoDeNominacion(String rutaDoc, String mensajeEsperado) {
        return instrumented(CargarDocumentoNominaciones.class, rutaDoc, mensajeEsperado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Path doc = Paths.get(rutaDoc).toAbsolutePath();
        boolean getBtnCargueMasivo = Visibility.of(LocatorsNominaciones.btnCargueMasivoNominaciones).viewedBy(actor).value();
        actor.attemptsTo(
                Check.whether(getBtnCargueMasivo)
                        .andIfSo(
                                Click.on(LocatorsNominaciones.btnCargueMasivoNominaciones)
                        ),
                WaitUntil.the(LocatorsNominaciones.inputFileNominacion, isVisible()).forNoMoreThan(10).seconds(),
                Upload.theFile(doc).to(LocatorsNominaciones.inputFileNominacion),
                Click.on(LocatorsNominaciones.btnSubitrDoc),
                WaitUntil.the(LocatorsNominaciones.msgCargue.of(mensajeEsperado), isVisible()).forNoMoreThan(1200).seconds()
        );
        System.out.println("end to test");
    }
}
