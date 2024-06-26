package pageObject;


import net.thucydides.core.pages.PageObject;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;
import utils.driver_factory.DriverFactory;
import utils.reporting.Report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class WebBasePage extends PageObject {

    private static String pathDownloads ="";
    private static final int WAIT_TIMEOUT = 10;
    private String loadedBar = "//*[@class='MuiCircularProgress-svg' or @class='loading-ripple' or contains(@class,'MuiCircularProgress') or contains(@class,'ui active transition visible') ]";
    private static final int POLLING = 100;

    //bloque de codigo de tipo booleano que contiene si elemento es visible
    protected boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickElementList(String locator, String elm){
        WebElement element = getElement(locator,elm.trim());
        waitUntilElementIsVisible(element);
        element.click();
    }

    public boolean validateELmentMain(String locator,String elm){
        WebElement element = getElement(locator, elm);
        waitUntilElementIsVisibleNonThrow(element, 10);
        return isVisible(element);
    }

    public boolean validateELmentLocator(String locator){
        WebElement element = getElement2(locator);
        waitUntilElementIsVisibleNonThrow(element,10);
        return isVisible(element);
    }

    public String getTextElementMain(String locator, String elm){
        WebElement element = getElement(locator, elm);
        waitUntilElementIsVisible(element);
        return element.getText();
    }

    public String getTextElementLocator(String locator){
       WebElement element = getElement2(locator);
        waitUntilElementIsVisible(element);
        return element.getText();
    }

    public void waitUntilElementIsVisible(WebElement element) {
        try {
            await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
        } catch (ConditionTimeoutException e) {
           Report.reports("FAIL",String.format("No se encuentra el elemento: %s: ", element), Report.takeSnapShot(DriverFactory.getDriver())) ;
            throw new ConditionTimeoutException(String.format("No se encuentra el elemento \nElemento: %s: ", element));
        }
    }

    public void waitUntilElementIsVisibleNonThrow(WebElement element, int WAIT_TIMEOUT) {
        try {
            await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
        } catch (ConditionTimeoutException e) {
        }
    }

    public void waitUntilLoadPage() {
        try {
            new WebDriverWait(getDriver(), WAIT_TIMEOUT, POLLING).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loadedBar)));
        } catch (Exception e) {
        }
    }

    public void moverScrollAUnElemento(WebElement element) {
        try {
            waitUntilElementIsVisibleNonThrow(element, 1);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            waitTime(1);
            waitUntilElementIsVisible(element);
        }catch (Exception e){
        }
    }

    public void moverCursorAElemento(WebElement element) {
        waitFor(element).isVisible();
        withAction().moveToElement(element).build().perform();
    }

    public WebElement getElement(String xpath, String element) {
        return element(By.xpath(xpath.replace("Replaceable", element)));
    }

    public WebElement getElement2(String xpath) {
        return element(By.xpath(xpath));
    }

    public void waitTime(int segundos){
        try {
            Thread.sleep(segundos*1000);
        }catch (InterruptedException ignored){

        }
    }

    public String getTextAlert() {
        try{
            return getDriver().switchTo().alert().getText();
        }catch (Exception e){
            return "Alerta no presente";
        }
    }

    public void returnLastPage() {
        getDriver().navigate().back();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }


    public void clickAcceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public String downloadFile(WebElement webelement) throws IOException {
        switch (Utils.readProperty("configurations", "S.O.").toLowerCase()){
            case "linux":
                pathDownloads ="/home/" + System.getProperty("user.name") + "/Downloads/";
                break;
            case "windows":
                pathDownloads ="C:/Users/" + System.getProperty("user.name") + "/Downloads/";
        }
        File carpeta = new File(pathDownloads );
        List<String> listado=new ArrayList<>();
        try {
            listado = Arrays.asList(carpeta.list());
        }catch (Exception e){
        }
        String nombre="";
        webelement.click();
        int time=0;
        while (!(nombre.contains(".xlsx") || nombre.contains(".csv"))&& time<30){
            waitTime(5);
            List<String> listadoNuevo = Arrays.asList(carpeta.list());
            for (String element : listadoNuevo) {
                if (!listado.contains(element)) {
                    nombre=element;
                }
            }
            time=time+1;
        }
        return nombre;
    }


}

