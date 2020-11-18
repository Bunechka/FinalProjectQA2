package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SearchResultPage searchProduct(final String query){
        $(".main-search__input #q").setValue(query).pressEnter();
        System.out.println("enter search criteria: " + query);
        sleep(10000);
        //$(".page-title h1").waitUntil(Condition.visible, 5000).waitUntil(Condition.matchesText("Meklēšanas rezultāti frāzei \""+query+"\""), 500);
        return page(SearchResultPage.class);
    }
}
