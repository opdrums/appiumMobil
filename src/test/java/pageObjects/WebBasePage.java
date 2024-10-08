package pageObjects;


import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.pages.PageObject;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver_factory.DriverFactory;
import utils.reporting.Report;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class WebBasePage extends PageObject {

    private static final int WAIT_TIMEOUT = 10;
    private String loadedBar = "//*[@class='MuiCircularProgress-svg' or @class='loading-ripple' or contains(@class,'MuiCircularProgress') or contains(@class,'ui active transition visible') ]";
    private static final int POLLING = 100;

    // metodo que retorna web element de tipo xpath y reemplaza un string
    public WebElement getElementXpathReplecable(String xpath, String element) {
        return element(By.xpath(xpath.replace("Replaceable", element)));
    }

    //metodo  que retorna  web element de tipo xpath
    public WebElement getElementXpath(String xpath) {
        return element(By.xpath(xpath));
    }

    public  WebElement getElementId(String id){
        return  element(By.id(id));
    }


    //bloque de codigo de tipo booleano que contiene si elemento es visible
    protected boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //metodo para hacer una espera implicita y espera que se ha visible si no manda un excepcion
    public void waitUntilElementIsVisible(WebElement element) {
        try {
            await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
        } catch (ConditionTimeoutException e) {
            Report.reports("FAIL",String.format("No found element: %s: ", element), Report.takeSnapShot(DriverFactory.getDriver())) ;
            throw new ConditionTimeoutException(String.format("No found element \nElement: %s: ", element));
        }
    }

    //metodo para hacer una espera implicita y genera una exepcion si no es visible
    public void waitUntilElementIsVisibleNonThrow(WebElement element, int WAIT_TIMEOUT) {
        try {
            await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
        } catch (ConditionTimeoutException e) {
        }
    }

    //metodo para hacer una espera que cargue la pagina
    public void waitUntilLoadPage() {
        try {
            new WebDriverWait(getDriver(), WAIT_TIMEOUT, POLLING).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loadedBar)));
        } catch (Exception e) {
        }
    }

    //metodo para hacer una espera explicita
    public void waitTime(int segundos){
        try {
            Thread.sleep(segundos*1000);
        }catch (InterruptedException ignored){

        }
    }

    //metodo para dar un back
    public void returnLastPage() {
        getDriver().navigate().back();
    }

    //metodo para refrescar una pagina
    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    //metodo para dar un click a un elemento de una lista
    public void clickElementList(String locator, String elm){
        WebElement element = getElementXpathReplecable(locator,elm.trim());
        waitUntilElementIsVisible(element);
        element.click();
    }

    //metodo para dar click a elemento xpath
    public void clickElementLocator(String locator){
        WebElement element = getElementXpath(locator);
        waitUntilElementIsVisible(element);
        element.click();
    }

    //metodo para dar click a elemento xpath
    public void clickElementId(String locator){
        WebElement element = getElementId(locator);
        waitUntilElementIsVisible(element);
        element.click();
    }

    //metodo para envia un texto de una lista
    public void sendTextLocator (String locator, String TextField){
        WebElement element = getElementXpath(locator);
        waitUntilElementIsVisible(element);
        element.sendKeys(TextField);
    }

    //metodo para validar un elemento de una lista
    public boolean validateELmentMain(String locator,String elm){
        WebElement element = getElementXpathReplecable(locator, elm);
        waitUntilElementIsVisibleNonThrow(element, 10);
        return isVisible(element);
    }

    //metodo para validar un elemento
    public boolean validateElmentLocator(String locator){
        WebElement element = getElementXpath(locator);
        waitUntilElementIsVisibleNonThrow(element,10);
        return isVisible(element);
    }

    public boolean validateElmentLocatorId(String locator){
        WebElement element = getElementId(locator);
        waitUntilElementIsVisibleNonThrow(element,10);
        return isVisible(element);
    }

    //metodo para obtener el texto de un elemento de una lista
    public String getTextElementMain(String locator, String elm){
        WebElement element = getElementXpathReplecable(locator, elm);
        waitUntilElementIsVisible(element);
        return element.getText();
    }

    //metodo para obtener el texto de un elemento
    public String getTextElementLocator(String locator){
        WebElement element = getElementXpath(locator);
        waitUntilElementIsVisible(element);
        return element.getText();
    }

    //metodo para dar click una alerta de texto
    public String getTextAlert() {
        try{
            return getDriver().switchTo().alert().getText();
        }catch (Exception e){
            return "Alert not found";
        }
    }

    //metodo para dar click una alerta de buton
    public void clickAcceptAlert() {
        try{
            getDriver().switchTo().alert().accept();
        }catch (Exception e){
        }
    }

    //metodo para hacer un scroll a un elemento web
    public void moverScrollAUnElemento(String locator) {
        try {
            WebElement element = getElementXpath(locator);
            waitUntilElementIsVisible(element);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            waitTime(1);
        }catch (Exception e){
        }
    }

    //metodo para mover el cursos a un elemento web
    public void moverCursorElemento(String locator) {
        WebElement element = getElementXpath(locator);
        waitUntilElementIsVisible(element);
        withAction().moveToElement(element).build().perform();
    }

    //metodo para mover el cursos a un elemento en mobil
    public void moverScrollElementMobil(String locator) {
        try {
            // Esperar hasta que el elemento esté visible
            WebElement element = getElementXpath(locator);
            waitUntilElementIsVisible(element);

            // Obtener las dimensiones de la pantalla
            Dimension screenSize = getDriver().manage().window().getSize();
            int startX = screenSize.width / 2; // Punto medio en el eje X
            int startY = (int) (screenSize.height * 0.8); // Comenzar en el 80% de la altura
            int endY = (int) (screenSize.height * 0.2); // Terminar en el 20% de la altura

            // Realizar el desplazamiento
            new TouchAction<>(DriverFactory.getDriver())
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();

            // Esperar un momento para permitir la visualización
            waitTime(1);
        } catch (Exception e) {
            e.printStackTrace(); // Agregar manejo de excepciones adecuado
        }
    }
}

