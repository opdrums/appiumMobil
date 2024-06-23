package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginUserPo extends WebBasePage {
   private String buttonSingIn = "//android.widget.TextView[@resource-id='com.google.android.apps.youtube.music:id/sign_in_button']";
   private String selectFielUser = "//android.widget.TextView[@resource-id='com.google.android.apps.youtube.music:id/name' and @text='Replaceable']";
   private String clickNotification = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']";
   private String clickSong = "//android.widget.GridView/android.view.ViewGroup[1]/android.view.ViewGroup";
   private String validateTitleSong = "//android.widget.GridView/android.view.ViewGroup[7]/android.view.ViewGroup/android.widget.ImageView";

   public void clickButtonLogin(){
        waitUntilElementIsVisible(element(buttonSingIn));
        element(buttonSingIn).click();
    }

    public void selectLoginUser(String user){
        clickElementList(selectFielUser, user);
        element(clickNotification).click();
        element(clickSong).click();
    }

    public boolean validateHomeSong(){
       return validateELmentLocator(validateTitleSong);
    }
}
