package definitions;

import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.remote.DesiredCapabilities;
import steps.mobilStep;
import utils.Utils;

import java.io.IOException;
import java.net.URL;


public class openApkDefinitions {
    private static String ambiente = "";

    @Steps
    mobilStep mobilStep;

    public openApkDefinitions(){
        this.mobilStep = new mobilStep();
    }

    static AppiumDriver<MobileElement> driver;

    @Given("^open apk(.*)$")
    public void openApk(String ambiente) throws IOException {

    }

}
