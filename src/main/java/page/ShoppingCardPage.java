package page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCardPage {
    public String getItemName(){
        return $(".detailed-cart-item .detailed-cart-item__name").text().trim();
    }
    public String getItemPrice(){
        return $(".detailed-cart-item .detailed-cart-item__price").text().trim();
    }

    public PurchaseOptionPage clickDoPayment(){
        $(By.name("commit")).click();
        SharedContext.sleep(5);
        return Selenide.page(PurchaseOptionPage.class);
    }
}
