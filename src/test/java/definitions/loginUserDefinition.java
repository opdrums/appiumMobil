package definitions;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import steps.loginUserStep;

public class loginUserDefinition {

    @Steps
    loginUserStep loginUserStep;

    public loginUserDefinition() {
        this.loginUserStep = new loginUserStep();
    }

    @Given("^user septup country in (.*)$")
    public void setUpCountryApp(String country){
        loginUserStep.setupCountryTravel(country);
    }

    @Given("^select an account in gmail (.*)$")
    public void chooseAnAccountGmail(String email){
        loginUserStep.chooseAccountEmail(email);
    }
}