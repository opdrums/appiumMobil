package definitions;

import cucumber.api.java.en.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Steps;
import steps.loginUserStep;

import java.io.IOException;


public class loginUserDefinitions {
    private static String ambiente = "";

    @Steps
    loginUserStep loginUserStep;

    public loginUserDefinitions(){
        this.loginUserStep = new loginUserStep();
    }

    static AppiumDriver<MobileElement> driver;

    @Given("^user turn notification(.*)$")
    public void clickNotification(String elm){
        loginUserStep.clickButtonNotification(elm);
    }


    @Given("^user click button sign in (.*)$")
    public void selectOptionLogin(String login) {
        loginUserStep.clickButtonSingIn(login);
    }

    @When("^enter form (.*) and (.*)$")
    public void selectAccountUser(String email, String password){
        loginUserStep.formLogginUser(email, password);
    }

    @When("^select account gmail (.*)$")
    public void selectAccountGmail(String email){
        loginUserStep.clickAccountGmail(email.trim());
    }


    @Then("visuality a validation booking")
    public void validateBooking(){
        loginUserStep.validateViewBooking();
    }
}
