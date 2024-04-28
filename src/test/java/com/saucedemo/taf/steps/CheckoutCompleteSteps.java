package com.saucedemo.taf.steps;

import com.saucedemo.taf.pages.CartPage;
import com.saucedemo.taf.pages.CheckoutCompletePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutCompleteSteps {

  @Autowired
  private CheckoutCompletePage checkoutCompletePage;

  @Then("the Checkout Complete page is displayed")
  public void checkCheckoutCompletePageIsLoaded() {
    checkoutCompletePage.checkForCheckoutCompletePageLoaded();
  }

  @Then("the shopping cart is now empty")
  public void checkNumberOfProductsInCart() {
    checkoutCompletePage.checkNumberOfProducts();
  }

}
