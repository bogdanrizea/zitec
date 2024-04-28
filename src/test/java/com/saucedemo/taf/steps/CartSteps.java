package com.saucedemo.taf.steps;

import com.saucedemo.taf.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class CartSteps {

  @Autowired
  private CartPage cartPage;

  @Then("the Cart page is loaded")
  public void checkInventoryPageIsLoaded() {
    cartPage.checkForCArtPageIsLoaded();
  }

  @When("the client Continues Shopping")
  public void continueShopping() {
    cartPage.clickContinueShoppingButton();
  }

  @When("the client goes to Checkout")
  public void goToCheckout() {
    cartPage.clickCheckoutButton();
  }

  @Then("there are {int} products on the Your Cart page")
  public void checkNumberOfProductsInCart(int noOfProducts) {
    cartPage.checkNumberOfProducts(noOfProducts);
  }

}
