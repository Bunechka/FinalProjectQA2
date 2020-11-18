import com.codeborne.selenide.Selenide;
import org.junit.Test;
import page.*;

import static com.codeborne.selenide.Selenide.sleep;

public class TestOne {
    @Test
    public void open() {
        HomePage homePage = Selenide.open("https://www.1a.lv", HomePage.class);

        SearchResultPage searchResultPage = homePage.searchProduct("dators");
        searchResultPage.pickProductByBrand("apple");

        ProductPage productPage = searchResultPage.pressAnyProduct();
        productPage.getProductName();
        productPage.getProductPrice();

        ContinueShopingPopupPage continueShopingPopupPage = productPage.addProductToCart();

        ShoppingCardPage shoppingCardPage = continueShopingPopupPage.pressCartCheckout();
        shoppingCardPage.getItemName();
        shoppingCardPage.getItemPrice();

        PurchaseOptionPage purchaseOptionPage = shoppingCardPage.clickDoPayment();
        purchaseOptionPage.useUnregisteredOption("test@selenide.com");

        sleep(10000);

    }
}
