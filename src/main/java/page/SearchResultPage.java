package page;

import com.codeborne.selenide.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    public void pickProductByBrand(final String productBrand){

        $$("div.filter-title").find(Condition.matchesText("Zīmols")).parent().find("input").setValue(productBrand).pressEnter();
        System.out.println("find brand by name: " + productBrand);
        SharedContext.sleep(3);
        $$("div.filter-title").find(Condition.matchesText("Zīmols")).parent().find(".filter-link").scrollIntoView(true).click();
        System.out.println("click brand filter by name: " + productBrand);
        SharedContext.sleep(10);
    }

    public ProductPage pressAnyProduct(){

        //for some reasons 1a does not allow click on product,use javascript alternative, always choosing the first item
        $("div.new-product-item a").scrollIntoView(true).click(ClickOptions.usingJavaScript());

        SharedContext.sleep(10);
        return page(ProductPage.class);
    }
}
