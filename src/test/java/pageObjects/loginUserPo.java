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

}
