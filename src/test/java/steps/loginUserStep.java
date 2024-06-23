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
    public void clickButtonSingIn(){
        loginUserPo.clickButtonLogin();
    }

    @Step
    public void selectAccount(String user){
        loginUserPo.selectLoginUser(user);
    }

    @Step
    public void validateViewMusicApp(){
        if(!loginUserPo.validateHomeSong()){
            Report.reports("FAIL","not found song", Report.takeSnapShot(DriverFactory.getDriver()));
            Assert.fail("opp bug");
        }
        Report.reports("PASS","song good", Report.takeSnapShot(DriverFactory.getDriver()));
    }
}
