package starter.runner.cortoPlazo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/cortoPlazo/nominaciones.feature",
        glue = "starter",
        tags = "@consultaNominacion"
)

public class Nominaciones {

}