package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ContinueShopingPopupPage {
    public ShoppingCardPage pressCartCheckout(){
        $("#cart-popup-container .main-button").scrollIntoView(true).click();
        sleep(5000);
        return Selenide.page(ShoppingCardPage.class);
    }
}
