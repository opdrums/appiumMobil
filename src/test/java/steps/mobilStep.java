package steps;

import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.annotations.Step;
import pageObject.mobilPo;
import utils.Utils;
import utils.driver_factory.DriverFactory;

public class mobilStep {

    private mobilPo mobilPo;

    public mobilStep() {
        mobilPo = new mobilPo();
        mobilPo.setDriver(DriverFactory.getDriver());
    }

    @Step
    public void openToMobil(String ambiente) {
        try {
            // Abrir la URL correspondiente según el ambiente
            //mobilPo.getDriver().get(Utils.readProperty("configurations", "mobil_" + ambiente));
        } catch (Exception e) {
            // Manejar cualquier excepción aquí, por ejemplo, registrar o lanzar una nueva excepción
            e.printStackTrace();
        }
    }
}
