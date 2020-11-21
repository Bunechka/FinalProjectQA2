package Steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import model.CartData;
import model.UserFormInput;
import page.*;

import static org.junit.Assert.assertEquals;

public class TestOneStepDefs {
    private final CartData cartData = new CartData();

    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    ContinueShopingPopupPage continueShopingPopupPage;
    ShoppingCardPage shoppingCardPage;
    PurchaseOrderPage purchaseOrderPage;

    @Given("open browser with address {word}")
    public void open(String url) {
        homePage = Selenide.open(url, HomePage.class);
    }

    @Then("^search for product (.*)$")
    public void search_for_product(String product) {
        searchResultPage = homePage.searchProduct(product);
    }

    @Then("^filter products by brand (.*)$")
    public void filter_products_by_brand(String brand) {
        searchResultPage.pickProductByBrand(brand);
    }

    @Then("choose any first filtered product")
    public void choose_any_first_filtered_product() {

        productPage = searchResultPage.pressAnyProduct();
    }

    @Then("put the chosen product into basket")
    public void put_the_chosen_product_into_basket() {
        cartData.setProductName(productPage.getProductName());
        cartData.setProductPrice(productPage.getProductPrice());

        continueShopingPopupPage = productPage.addProductToCart();
    }

    @Then("proceed to the checkout as unregistered user")
    public void proceed_to_the_checkout_as_unregistered_user() {


        shoppingCardPage = continueShopingPopupPage.pressCartCheckout();

        assertEquals(cartData.getProductName(), shoppingCardPage.getItemName());
        assertEquals(cartData.getProductPrice(), shoppingCardPage.getItemPrice());
        System.out.println("Shopping cart item price is " + cartData.getProductPrice());
        System.out.println("Chosen product price was " + shoppingCardPage.getItemPrice());

        PurchaseOptionPage purchaseOptionPage = shoppingCardPage.clickDoPayment();
        purchaseOrderPage = purchaseOptionPage.useUnregisteredOption("test@selenide.com");
    }

    @Then("choose pick up option in the office")
    public void choose_pick_up_option_in_the_office() {

        purchaseOrderPage.chooseDeliveryOption();
        purchaseOrderPage.chooseCustomerCenter();
    }

    @Then("fill in the userform with name={word}, surname={word} and phone={word}")
    public void fill_in_the_userform(String name, String surname, String phone) {
        purchaseOrderPage.enterCustomerDetails(new UserFormInput(name, surname, phone));
        purchaseOrderPage.clickContinue();
        purchaseOrderPage.clickContinue();
        purchaseOrderPage.choosePaymentOption();
    }

}
