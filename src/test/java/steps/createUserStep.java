package steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageObjects.createUserPo;
import utils.driver_factory.DriverFactory;
import utils.reporting.Report;

public class createUserStep {
    createUserPo createUserPo;

    public createUserStep(){
        createUserPo = new createUserPo();
        createUserPo.setDriver(DriverFactory.getDriver());
    }

    @Step
    public void userClickButtOnCreateAccount(){
        createUserPo.clickButtonCreateAcount();
    }

    @Step
    public void registerUserSuccess(String email, String password){
        createUserPo.formRegisterUser(email, password);
    }

    @Step
    public void validateUserRegister(){
        if(!createUserPo.validateSUccesRegister()){
            Report.reports("FAIL", "bug Register user", Report.takeSnapShot(DriverFactory.getDriver()));
            Assert.fail("bug Register user");
        }
        Report.reports("PASS", createUserPo.getTextSuccessRegister(), Report.takeSnapShot(DriverFactory.getDriver()));
    }
}
