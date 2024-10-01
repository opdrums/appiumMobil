package steps;
import net.thucydides.core.annotations.Step;
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
}
