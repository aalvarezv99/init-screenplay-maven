package starter.ui.nominaciones;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LocatorsNominaciones {
    public static final Target inputFileNominacion = Target.the("Input file para cargar nominaciones").located(By.id("FilePathCtrl"));
    public static final Target btnSubitrDoc = Target.the("Botón que envia el documento").located(By.id("btnUploadLabAnalysisCtrl"));
    public static final Target msgCargue = Target.the("Elemento que muestra el cargue exitoso").locatedBy("//*[contains(text(), '{0}')]");
    public static final Target btnCargueMasivoNominaciones = Target.the("Elemento que dirige al planeador al cargue masivo de nominaciones").located(By.id("BtnBulkNomCtrl"));
    public static final Target selectSistema = Target.the("Elemento sistema de nominacion").locatedBy("//*[@aria-labelledby = 'select2-SystemSelectList-container']");
    public static final Target optionSistema = Target.the("Opcion de sistema de nominacion").locatedBy("//li[contains(text(), '{0}')]");

    public static final Target selectEstado = Target.the("Elemento estado de nominacion").locatedBy("//*[@aria-labelledby = 'select2-StatusList-container']");
    public static final Target optionEstado = Target.the("Opcion de estado de nominacion").locatedBy("//li[contains(text(), '{0}')]");
    public static final Target selectTipoBusqueda = Target.the("Elemento buscar de nominacion").locatedBy("//*[@aria-labelledby = 'select2-DateTypeSelectList-container']");
    public static final Target optionTipo = Target.the("Opcion buscar de nominacion").locatedBy("//li[contains(text(), '{0}')]");
    public static final Target btnBuscar = Target.the("Boton para buscar con los datos filtrados").located(By.id("SearchSubmitCtrl"));
    public static final Target checkSelectAll = Target.the("Check para seleccionar todos los registros").located(By.id("CheckAllCtrl"));
    public static final Target btnExportarExcel = Target.the("Boton que exporta a excel los registros obtenidos").locatedBy("//input[@value = 'Exportar a Excel']");

}
