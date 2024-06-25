package definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;
import utils.driver_factory.DriverFactory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import utils.reporting.Report;

public class Hooks {
    Scenario scenario;
    static AppiumDriver<MobileElement> driver;

    @Before
    public void config(Scenario scenario) throws IOException {
        //configutacion de las variables del archivo configuration Properties
        String name = Utils.readProperty("configurations", "PLATFORM_NAME");
        String version = Utils.readProperty("configurations", "PLATFORM_VERSION");
        String idPhone = Utils.readProperty("configurations", "DEVICE_NAME");
        String rute = Utils.readProperty("configurations", "RUTA_LOCAL");
        String apk = Utils.readProperty("configurations","APK");

        //configuracion de las capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, name);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, idPhone);
        capabilities.setCapability(MobileCapabilityType.APP, apk);
        capabilities.setCapability("appium:appWaitForLaunch", false);

        // Iniciar sesión en Appium Server
        URL url = new URL(rute);
        driver = new AndroidDriver<>(url, capabilities);

        // Configurar el driver en DriverFactory
        DriverFactory.setDriver(driver);

        //iniciar el reporte
        this.scenario = scenario;
        Report.startReport(scenario.getName());

    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void quitDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            Report.reportarCasoFallido(("MODULO: "+System.getProperty("tags")+" --> ESCENARIO: "+scenario.getName()).replace("null","Pibox"));
            if (DriverFactory.getDriver() == null) {
                Report.reports("FAIL", "Se finaliza el flujo automatizado debido al error generado!");
            } else {
                DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                Report.reports("FAIL", "Se finaliza el flujo automatizado debido al error generado!", Report.takeSnapShot(DriverFactory.getDriver()));
            }
        } else {
            Report.reports("PASS", "Se finaliza el flujo automatizado correctamente!");
        }
        Report.finishReport();

        DriverFactory.quitDriver();
    }

}
