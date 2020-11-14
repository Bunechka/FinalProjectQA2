package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PurchaseOptionPage {
    public void useUnregisteredOption(final String email) {
        $("#new_user_guest input[name='user[email]']").setValue(email).pressEnter();
//        $(By.name("commit")).click();
        SharedContext.sleep(3);
    }
}
