package pageObjects;

public class createUserPo extends WebBasePage{
    private String buttonCreateAccount = "com.gm.despegar:id/button_loginhomefragment_registerwithoutpurchase";
    private String fieldEmail = "//android.widget.EditText[@resource-id='com.gm.despegar:id/edittext_viewemail_email']";
    private String fieldPassword = "//android.widget.EditText[@resource-id='com.gm.despegar:id/edittext_viewpassword_password']";
    private String buttonCreate = "com.gm.despegar:id/button_registerfragment_create";
    private String succesRegister = "//android.widget.TextView[@resource-id='com.gm.despegar:id/textview_successemailfragment_description']";

    public void clickButtonCreateAcount(){
        clickElementId(buttonCreateAccount);
    }

    public void formRegisterUser(String email, String password){
        sendTextLocator(fieldEmail, email);
        sendTextLocator(fieldPassword, password);
        clickElementId(buttonCreate);
    }

    public Boolean validateSUccesRegister(){
        return validateElmentLocator(succesRegister);
    }

    public String getTextSuccessRegister(){
        return getTextElementLocator(succesRegister);
    }
}
