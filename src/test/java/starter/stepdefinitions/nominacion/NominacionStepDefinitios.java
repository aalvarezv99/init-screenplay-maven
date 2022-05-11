package starter.stepdefinitions.nominacion;

import cucumber.api.DataTable;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import starter.task.nominacion.*;

import java.util.List;
import java.util.Map;

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

    @Y("selecciona el (.*) cambia el estado a (.*) y lo guarda")
    public void seleccionLaNominacionParaCambiarElEstado(String numPedido, String cambiarEstado) {
        theActorInTheSpotlight().attemptsTo(
                CambiarEstadoTask.whithCambiarEstado(numPedido, cambiarEstado)
        );
    }

    @Entonces("selecciona el (.*) para editar el (.*) y las cantidades")
    public void seleccionaElPedidoParaEditarElProductoCantidad(String pedido, String producto, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(
                EditarNominacionTask.whithEditarNominacion(pedido, producto, data)
        );
    }
}
