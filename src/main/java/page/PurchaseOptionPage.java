package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PurchaseOptionPage {
    public PurchaseOrderPage useUnregisteredOption(final String email) {
        $("#new_user_guest input[name='user[email]']").setValue(email).pressEnter();
//        $(By.name("commit")).click();
        sleep(5000);
        return Selenide.page(PurchaseOrderPage.class);
    }
}
