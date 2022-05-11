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
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        while (tabs.size() != 1) {
            tabs = new ArrayList<String>(driver.getWindowHandles());
            System.out.println("descargando archivo " + tabs.size());
        }
        System.out.println("end test");
    }
}
