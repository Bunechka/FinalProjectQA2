package page;

import com.codeborne.selenide.ClickOptions;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public String getProductName(){
        return $("div.detailed-product-block h1").text();
    }

    public String getProductPrice(){
        return $("div.product-price-details span.price span").text();
    }

    public ContinueShopingPopupPage addProductToCart(){
        $("#add_to_cart_btn").scrollIntoView(true).click(ClickOptions.usingJavaScript());
        sleep(5000);

        return page(ContinueShopingPopupPage.class);
    }
}
