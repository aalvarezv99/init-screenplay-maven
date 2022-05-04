package starter.stepdefinitions.nominacion;

import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import starter.task.nominacion.CargarDocumentoNominaciones;
import starter.task.nominacion.ExportarNominacionTask;
import starter.task.nominacion.FiltrarNominacionTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NominacionStepDefinitios {

    @Y("carga el documento de nominacion (.*) con el mensaje esperado (.*)")
    public void cargaElDocumentoDeNominaciones(String rutaDoc, String mensajeEsperado) {
        theActorInTheSpotlight().attemptsTo(
                CargarDocumentoNominaciones.whithCargaElDocumentoDeNominacion(rutaDoc, mensajeEsperado)
        );
    }

    @Y("se selecciona (.*) y (.*) para filtrar (.*)")
    public void seSeleccionanLosFiltrosParaFiltrar(String sistema, String estado, String tipoBusqueda) {
        theActorInTheSpotlight().attemptsTo(
                FiltrarNominacionTask.whithFiltroNominacion(sistema, estado, tipoBusqueda)
        );
    }

    @Entonces("se da click al check para seleccionar todo y se exporta")
    public void SeDaClickAlCheckParaExportar() {
        theActorInTheSpotlight().attemptsTo(
                ExportarNominacionTask.whithExportarNominacion()
        );
    }
}
