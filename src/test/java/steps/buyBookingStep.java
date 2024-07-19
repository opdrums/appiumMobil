package steps;
import pageObjects.buyBooking;
import utils.driver_factory.DriverFactory;
import utils.reporting.Report;

public class buyBookingStep {
    private buyBooking buyBoking;

    public buyBookingStep(){
        buyBoking = new buyBooking();
        buyBoking.setDriver(DriverFactory.getDriver());
    }

    public void selectDestination(String destination){
        buyBoking.formDestination(destination);
    }

    public void  dateBooking(String dateOrigin, String dateDestination){
        buyBoking.selectDateBooking(dateOrigin, dateDestination);
    }

    public void flueRoomAndGuests(int number){
        buyBoking.selectRoomsANdGuets(number);
    }

    public  void takePhotoListProperties(){
       if (!buyBoking.validateLIstOrderPorperties()){
           Report.reports("FAIL", "list not found", Report.takeSnapShot(DriverFactory.getDriver()));
       }
        Report.reports("PASS", "list found", Report.takeSnapShot(DriverFactory.getDriver()));
    }
}

