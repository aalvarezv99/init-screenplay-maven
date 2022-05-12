package starter.conf;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import cucumber.api.java.Before;

public class SetTheStage {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

}
