package pageObjects;

public class loginUserPo extends WebBasePage{

    private String buttonSelectCountry = "com.gm.despegar:id/tv_country";
    private String listCountry = "//android.widget.TextView[@resource-id='com.gm.despegar:id/tv_country' and @text='Replaceable']";
    private String buttonSetUp = "com.gm.despegar:id/bt_next";
    private String buttonActiveNotification = "com.gm.despegar:id/bt_positive_action";
    private String buttonNotificationAllow = "com.android.permissioncontroller:id/permission_allow_button";
    private String buttonLoginGmail = "com.gm.despegar:id/button_loginhomefragment_googlelogin";
    private String buttonGmailEmail = "//android.widget.TextView[@resource-id='com.google.android.gms:id/account_name' and @text='Replaceable']";
    private String buttonContinueGmail = "//android.widget.Button[@resource-id='com.google.android.gms:id/continue_button']";
    private String clickButtonX = "com.google.android.gms:id/cancel";
    private String homePassengerName = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]";
    private String buttonAccount = "//android.widget.TextView[@resource-id='com.gm.despegar:id/label' and @text='Mi cuenta']";
    private String buttonLogout = "//android.widget.TextView[@resource-id='com.gm.despegar:id/text']";
    private String validateTextLogout = "//android.widget.TextView[@resource-id='com.gm.despegar:id/description']";
    private String buttonDeleteAcount = "//android.widget.TextView[@resource-id='com.gm.despegar:id/listItemText' and @text='Políticas de privacidad']";

    public void setupCountry(String country){
        clickElementId(buttonSelectCountry);
        clickElementList(listCountry, country);
        clickElementId(buttonSetUp);
        clickElementId(buttonActiveNotification);
        clickElementId(buttonNotificationAllow);
        clickElementId(clickButtonX);
    }

    public void buttonGmail(String email){
        clickElementId(buttonLoginGmail);
        clickElementList(buttonGmailEmail, email);
    }

    public boolean validateGmailSocial(){
        return validateElmentLocatorId(buttonLoginGmail);
    }

    public boolean validateEmailGmail(){
        return validateElmentLocator(buttonContinueGmail);
    }

    public void alertGmailContinue(){
        clickElementLocator(buttonContinueGmail);
    }

    public boolean validateHomeUser(){
        return validateElmentLocator(homePassengerName);
    }

    public void logoutUserApp(){
        clickElementLocator(buttonAccount);
    }

    public void clickButtonLogout(){
        moverScrollElementMobil(buttonDeleteAcount);
        clickElementLocator(buttonLogout);
    }

    public boolean validateLogoutSuccessfully(){
        return validateElmentLocator(validateTextLogout);
    }

    public String getTextSuccessfully(){
        return getTextElementLocator(validateTextLogout);
    }
}
