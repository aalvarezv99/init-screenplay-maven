package starter.ui.common;

import net.serenitybdd.screenplay.targets.Target;

public class LocatorsMenu {
    public static final Target menu = Target.the("Locator para el menú").locatedBy("//input[contains(@value, '{0}')]");
    public static final Target subMenu = Target.the("Locator para el sub menú").locatedBy("//a[@class = 'drop']//child::span[starts-with(text(), '{0}')]");
    public static final Target item = Target.the("Locator para el item a escoger").locatedBy("//*[@id='OrdersDivCtrl']//child::div[@class = 'col_4']//following-sibling::a[contains(text(), '{0}')]");
}
