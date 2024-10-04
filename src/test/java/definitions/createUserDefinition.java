package definitions;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import steps.createUserStep;

public class createUserDefinition {
    @Steps
    createUserStep createUserStep;

    public createUserDefinition(){
        this.createUserStep = new createUserStep();
    }

    @Given("the user clicks the create Account button")
    public void clickButtonCreateAccount(){
        createUserStep.userClickButtOnCreateAccount();
    }

    @When("^fills in the registration form with (.*) and (.*)$")
    public  void fillFormRegister(String email, String password){
        createUserStep.registerUserSuccess(email, password);
    }

    @Then("the user should see success register")
    public void validateRegisterSuccessApp(){
        createUserStep.validateUserRegister();
    }
}
