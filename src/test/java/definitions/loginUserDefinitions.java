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

    @Given("user click button sign in")
    public void openApk() {
        loginUserStep.clickButtonSingIn();
    }

    @When("^select to account (.*)$")
    public void selectAccountUser(String user){
        loginUserStep.selectAccount(user);
    }

    @Then("visuality view song music")
    public void validateHomeMusic(){
        loginUserStep.validateViewMusicApp();

    }
}
