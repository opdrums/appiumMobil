package steps;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageObjects.loginUserPo;
import utils.driver_factory.DriverFactory;
import utils.reporting.Report;

public class loginUserStep {
    loginUserPo loginUserPo;

    public loginUserStep(){
        loginUserPo = new loginUserPo();
        loginUserPo.setDriver(DriverFactory.getDriver());
    }

    @Step
    public void setupCountryTravel(String country){
        loginUserPo.setupCountry(country);
    }

    @Step
    public void chooseAccountEmail(String email){
        loginUserPo.waitTime(1);
        if(loginUserPo.validateGmailSocial()){
            Report.reports("PASS", "selec email form", Report.takeSnapShot(DriverFactory.getDriver()));
            loginUserPo.buttonGmail(email);
        }else if (loginUserPo.validateEmailGmail()) {
            Report.reports("PASS", "continue as email" + email,Report.takeSnapShot(DriverFactory.getDriver()));
            loginUserPo.alertGmailContinue();
        }
    }

    @Step
    public void validateNameHomeScreen(){
        if(!loginUserPo.validateHomeUser()){
            Report.reports("FAIL", "user not found", Report.takeSnapShot(DriverFactory.getDriver()));
            Assert.fail("user not found in the app");
        }
        Report.reports("PASS", "user found app", Report.takeSnapShot(DriverFactory.getDriver()));
    }

    @Step
    public void logoutUserInApp(){
        loginUserPo.logoutUserApp();
    }

    @Step
    public void userLogoutSuccess(){
        loginUserPo.clickButtonLogout();
        if(!loginUserPo.validateLogoutSuccessfully()){
            Report.reports("FAIL", "logout not success", Report.takeSnapShot(DriverFactory.getDriver()));
            Assert.fail("logout not success");
        }
        Report.reports("PASS", "logout not success: " + loginUserPo.getTextSuccessfully(), Report.takeSnapShot(DriverFactory.getDriver()));
    }
}
