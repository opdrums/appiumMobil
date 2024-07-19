package definitions;
import cucumber.api.java.en.*;
import steps.buyBookingStep;
import utils.driver_factory.DriverFactory;

public class buyBookingDefinitions {
    buyBookingStep buyBookingStep;

    public buyBookingDefinitions(){
        this.buyBookingStep= new buyBookingStep();
    }

    @Given("^select (.*) as destination$")
    public void destinationBooking(String destination){
        buyBookingStep.selectDestination(destination);
    }

    @And("^select date (.*) and (.*)$")
    public void selectDateBookings(String dateOrigin, String dateDestination){
        buyBookingStep.dateBooking(dateOrigin,dateDestination);
    }

    @And("^select to count (.*) rooms and guest and children$")
    public void formSelectRoomAndGuest(int number){
        buyBookingStep.flueRoomAndGuests(number);
    }

    @Then("visuality properties")
    public void validateProperties(){
        buyBookingStep.takePhotoListProperties();
    }

}
