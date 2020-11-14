package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class ContinueShopingPopupPage {
    public ShoppingCardPage pressCartCheckout(){
        $("#cart-popup-container .main-button").scrollIntoView(true).click();
        SharedContext.sleep(5);
        return Selenide.page(ShoppingCardPage.class);
    }
}
