package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class buyBooking extends WebBasePage {

    private String  clickButtonDestination = "//android.widget.Button[@content-desc='Enter your destination']";
    private String fillSearchDestination = "//android.widget.EditText";
    private  String listDestination = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]";
    private String fieldDate = "//android.view.View[@content-desc='Replaceable']";
    private String buttonSelectDate = "//android.widget.Button[@resource-id='com.booking:id/facet_date_picker_confirm']";
    private String selectExtraDates = "//android.widget.TextView[@resource-id='com.booking:id/text' and @text='Exact dates']";
    private String settingLocation = "//android.widget.TextView[@text='Around current location']";
    private String whileUsingLocation = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']";
    private  String buttonSelectRoom = "//android.widget.Button[@content-desc='1 room, 2 adults, 0 children']";
    private String clickFieldRoom = "(//android.widget.Button[@content-desc='Increase'])[1]";
    private String clickFieldAdults = "(//android.widget.Button[@content-desc='Increase'])[2]";
    private String clickFieldChildren = "(//android.widget.Button[@content-desc='Increase'])[3]";
    private String checkTravelWhitPet= "//android.widget.Switch[@resource-id='com.booking:id/group_config_travelling_with_pets']";
    private String buttonChildren = "//android.view.View[@resource-id='com.booking:id/bui_input_container_background']";
    private String selectAgeChildren ="//android.widget.EditText[@resource-id='android:id/numberpicker_input']";
    private String clickButtonOk = "//android.widget.Button[@resource-id='android:id/button1']";
    private String buttonApply = "//android.widget.Button[@resource-id='com.booking:id/group_config_apply_button']";
    private String buttonSearch = "//android.view.View[@content-desc='Accommodation search box']/android.view.View/android.widget.Button";
    private String validateOrdenListProperties = "//android.view.View[@resource-id='sr_list']";

    public void formDestination(String destination){
        clickELementLocator(clickButtonDestination);
        sendTextLocator(fillSearchDestination, destination);
        waitTime(5);
        clickElementList(listDestination, destination);
    }

    public void selectDateBooking(String dateOrigin, String dateDestination){
        clickELementLocator(selectExtraDates);
        clickElementList(fieldDate, dateOrigin);
        clickElementList(fieldDate, dateDestination);
        clickELementLocator(buttonSelectDate);
    }

    public void setSettingLocationUser(){
        clickELementLocator(settingLocation);
        clickELementLocator(whileUsingLocation);
    }

    public void selectRoomsANdGuets(int number){
        clickELementLocator(buttonSelectRoom);

        for(int i= 0; i< number; i++){
            clickELementLocator(clickFieldRoom);
        }

        clickELementLocator(clickFieldAdults);
        clickELementLocator(checkTravelWhitPet);
        clickELementLocator(buttonApply);
        clickELementLocator(buttonSearch);
    }

    public boolean validateLIstOrderPorperties(){
        return validateELmentLocator(validateOrdenListProperties);
    }
}
