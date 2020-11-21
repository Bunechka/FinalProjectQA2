package page;

import com.codeborne.selenide.Condition;
import model.UserFormInput;

import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class PurchaseOrderPage {

    public void chooseDeliveryOption () {
        $$(".menu li").find(Condition.matchesText("Preces saņemšana klientu centrā")).click();
    }
    public void choosePaymentOption () {
        $$(".menu li").find(Condition.matchesText("Apmaksa saņemot preci")).click();
    }

    public void chooseCustomerCenter () {
        $(byValue("3209")).click();
    }

    public void enterCustomerDetails (final UserFormInput name) {
        $("#address_first_name").setValue(name.getName());
        $("#address_last_name").setValue(name.getSurname());
        $("#address_phone_number").setValue(name.getPhone());

    }

    public void clickContinue(){
        $(".checkout-shipping-continue-button").scrollIntoView(true).click();
        sleep(1500);
    }
}
