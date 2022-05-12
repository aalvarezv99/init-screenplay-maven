package starter.ui.nominaciones;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LocatorsNominaciones {
    public static final Target inputFileNominacion = Target.the("Input file para cargar nominaciones").located(By.id("FilePathCtrl"));
    public static final Target btnSubitrDoc = Target.the("Botón que envia el documento").located(By.id("btnUploadLabAnalysisCtrl"));
    public static final Target msgCargue = Target.the("Elemento que muestra el cargue exitoso").locatedBy("//*[contains(text(), '{0}')]");
    public static final Target btnCargueMasivoNominaciones = Target.the("Elemento que dirige al planeador al cargue masivo de nominaciones").located(By.id("BtnBulkNomCtrl"));
    public static final Target selectSistema = Target.the("Elemento sistema de nominacion").locatedBy("//*[@aria-labelledby = 'select2-SystemSelectList-container']");
    public static final Target selectEstado = Target.the("Elemento estado de nominacion").locatedBy("//*[@aria-labelledby = 'select2-StatusList-container']");
    public static final Target optionSelect = Target.the("Opcion de estado de nominacion").locatedBy("//li[contains(text(), '{0}')]");
    public static final Target selectTipoBusqueda = Target.the("Elemento buscar de nominacion").locatedBy("//*[@aria-labelledby = 'select2-DateTypeSelectList-container']");
    public static final Target btnBuscar = Target.the("Boton para buscar con los datos filtrados").located(By.id("SearchSubmitCtrl"));
    public static final Target checkSelectAll = Target.the("Check para seleccionar todos los registros").located(By.id("CheckAllCtrl"));
    public static final Target btnExportarExcel = Target.the("Boton que exporta a excel los registros obtenidos").locatedBy("//input[@value = 'Exportar a Excel']");
    public static final Target enlaceNominacion = Target.the("check nominacion listada").locatedBy("//a[text() = '{0}']");
    public static final Target selectEstadoNominacion = Target.the("select que muestra los estados de nominacion").located(By.id("select2-StatusApproveListCtrl-container"));
    public static final Target btnGuardarCambioNominacion = Target.the("boton para guardar el estado de las nominaciones seleccionadas").located(By.id("btnSubmitCtrl"));
    public static final Target btnHistorialUpdateNominacion = Target.the("boton para ver el historial de actualizacion de nominaciones").located(By.id("inputBtnHistoryCtrl"));
    public static final Target estadoActual = Target.the("Localizador del estado actual de la nominacion").locatedBy("//*[contains(text(), 'Current')]/ancestor::tr/child::td[contains(text(), '{0}')]");
    public static final Target btnEditar = Target.the("boton para editar nominacion").located(By.id("BtnEditCtrl"));
    public static final Target selectProducto = Target.the("Elemento select para seleccionar el producto cuando se edita la nominacion").located(By.id("select2-ProductCtrl-container"));
    public static final Target solicitadoInputs = Target.the("todos los inputs para el solicitado de la tabla salida de envios").locatedBy("//tr[starts-with(@id, 'delRowCtrl') and not(contains(@style, 'none'))]//child::input[@id = 'DeliveryVolumeCtrl' and starts-with(@name, 'volume')]");
    public static final Target btnGuardarEdicionNominacion = Target.the("boton para guardar los cambios de edicion de la nominacion").locatedBy("//*[@id = 'BtnSubmitCtrl' and not(contains(@disabled, 'disabled'))]");
    public static final Target estadoNominacion = Target.the("Estado actual de la nominacion a editar").locatedBy("//th[starts-with(text(), 'Est')]//following-sibling::td");
}
