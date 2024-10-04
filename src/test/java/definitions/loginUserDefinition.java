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

    @Given("^the user has set up their country in (.*)$")
    public void setUpCountryApp(String country){
        loginUserStep.setupCountryTravel(country);
    }

    @Given("^the user selects a Gmail account(.*)$")
    public void chooseAnAccountGmail(String email){
        loginUserStep.chooseAccountEmail(email);
    }

    @Then("the user should see the home passenger screen")
    public void homeScreenValidateUser(){
        loginUserStep.validateNameHomeScreen();
    }

    @When("the user clicks en el boton account")
    public void logoutUserInAppTravel(){
        loginUserStep.logoutUserInApp();
    }

    @Then("the user clicks the logout button and should be logged out successfully")
    public void logoutUserApp(){
        loginUserStep.userLogoutSuccess();
    }
}