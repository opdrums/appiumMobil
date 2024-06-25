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
    public void validateViewBooking(){
        if(loginUserPo.validationBooking()){
            Report.reports("PASS","Welcome to booking.com ", Report.takeSnapShot(DriverFactory.getDriver()));
        }else if (loginUserPo.validateAlert()){
            Report.reports("WARNING","mssg: " + loginUserPo.getTextValidation(), Report.takeSnapShot(DriverFactory.getDriver()));
        }
    }
}
