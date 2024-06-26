package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginUserPo extends WebBasePage {
   private String buttonText = "//android.widget.TextView[@text='Replaceable']";
   private String clickNotification = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']";
   private String fieldEmail = "//android.widget.EditText";
   private String clickButtonContinue = "//android.widget.Button";
   private String fielPassword = "//android.widget.EditText[@resource-id='com.booking:id/identity_text_input_edit_text']";
   private String buttonLoggin = "(//android.widget.Button[@resource-id='com.booking:id/identity_landing_social_button'])[1]";
   private String validateAlert = "//android.widget.TextView[@resource-id='com.booking:id/textinput_error']";
   private String validationBooking = "//android.view.ViewGroup[@resource-id='com.booking:id/facet_with_bui_booking_header_toolbar']/android.widget.LinearLayout[1]/android.widget.ImageView";
   private String buttonAccountTextGmail = "//android.widget.TextView[@resource-id='com.google.android.gms:id/account_name' and @text='Replaceable']";
   private String fieldEmailFacebook = "//android.webkit.WebView[@text='Log into Facebook | Facebook']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText";
   private String fieldPasswordFacebook = "//android.webkit.WebView[@text='Log into Facebook | Facebook']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.EditText";
   private String buttonLoginFacebook = "//android.widget.Button[@text='Log in']";
   private String validateAccountNotFoundFacebook = "//android.webkit.WebView[@text='Log into Facebook | Facebook']/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]";
   private String textIncorrectPassword = "//android.widget.TextView[@text='Incorrect password. ']";

   public void notificationAppAllow(String elm){
       clickElementList(buttonText, elm);
       element(clickNotification).click();
   }

    public void loginAppBoking(String login){
       clickElementList(buttonText,login);
    }

    public void formLoginApp(String email, String password){
       element(fieldEmail).sendKeys(email);
       waitUntilElementIsVisible(element(clickButtonContinue));
       element(clickButtonContinue).click();
       waitUntilElementIsVisible(element(fielPassword));
       element(fielPassword).sendKeys(password);
       element(buttonLoggin).click();
    }

    public boolean validateAlert(){
       return validateELmentLocator(validateAlert);
    }

    public boolean validationBooking(){
       return  validateELmentLocator(validationBooking);
    }

    public String getTextValidation(){
       return getTextElementLocator(validateAlert);
    }

    public void accountGmail(String email){
       clickElementList(buttonAccountTextGmail, email);
    }

    public void accountFacebook(String email, String password){
       waitUntilElementIsVisible(element(fieldEmailFacebook));
       element(fieldEmailFacebook).sendKeys(email);
       element(fieldPasswordFacebook).sendKeys(password);
       element(buttonLoginFacebook).click();
    }

    public boolean validateAlertNotFoundAccount(){
       return validateELmentLocator(validateAccountNotFoundFacebook);
    }

    public String getTextNotFoundAccountFacebook(){
       return getTextElementLocator(textIncorrectPassword);
    }
}
