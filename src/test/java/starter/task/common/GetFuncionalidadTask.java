package starter.task.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import starter.ui.common.LocatorsMenu;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GetFuncionalidadTask implements Task {
    private final String menu;
    private final String subMenu;
    private final String item;

    public GetFuncionalidadTask(String menu, String subMenu, String item) {
        this.menu = menu;
        this.subMenu = subMenu;
        this.item = item;
    }

    public static Performable whithGetFuncionalidad(String menu, String subMenu, String item) {
        return instrumented(GetFuncionalidadTask.class, menu, subMenu, item);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LocatorsMenu.menu.of(menu), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LocatorsMenu.menu.of(menu)),
                WaitUntil.the(LocatorsMenu.subMenu.of(subMenu), isVisible()).forNoMoreThan(10).seconds(),
                MoveMouse.to(LocatorsMenu.subMenu.of(subMenu)),
                Hit.the(Keys.ENTER).into(LocatorsMenu.item.of(item))
        );
        System.out.println("end test");
    }
}
