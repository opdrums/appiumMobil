package steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageObject.loginUserPo;
import utils.driver_factory.DriverFactory;
import utils.reporting.Report;

public class loginUserStep {

    private loginUserPo loginUserPo;

    public loginUserStep() {
        loginUserPo = new loginUserPo();
        loginUserPo.setDriver(DriverFactory.getDriver());
    }

    @Step
    public void clickButtonNotification(String elm){
        loginUserPo.notificationAppAllow(elm);
    }

    @Step
    public void clickButtonSingIn(String login){
        loginUserPo.loginAppBoking(login);
    }

    @Step
    public void clickAccountGmail(String email){
        loginUserPo.accountGmail(email);
    }

    @Step
    public void formLogginUser(String email, String password){
        loginUserPo.formLoginApp(email,password);
    }

    @Step
    public void formLogginUserFacebook(String email, String password){
        loginUserPo.accountFacebook(email, password);
    }



    @Step
    public void validateViewBooking() {
        if(loginUserPo.validationTextBooking()) {
            Report.reports("PASS", "Welcome to booking.com", Report.takeSnapShot(DriverFactory.getDriver()));
        }else if(loginUserPo.validateAlert()) {
            String errorMessage = "mssg: " + loginUserPo.getTextValidation();
            Report.reports("FAIL", errorMessage, Report.takeSnapShot(DriverFactory.getDriver()));
            Assert.fail(errorMessage);
        }else if (loginUserPo.validateAlertNotFoundAccount()) {
            String errorMessage = "mssg: " + loginUserPo.getTextNotFoundAccountFacebook();
            Report.reports("FAIL", errorMessage, Report.takeSnapShot(DriverFactory.getDriver()));
            Assert.fail(errorMessage);
        }
    }

}
