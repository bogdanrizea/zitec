package com.saucedemo.taf.steps;

import com.saucedemo.taf.pages.CartPage;
import com.saucedemo.taf.pages.OverviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class OverviewSteps {

  @Autowired
  private OverviewPage overviewPage;

  @Then("the checkout overview page is loaded")
  public void checkOverviewPageIsLoaded() {
    overviewPage.checkForCheckoutOverviewPageLoaded();
  }

  @When("the client clicks Finish button")
  public void continueShopping() {
    overviewPage.clickFinishButton();
  }


  @Then("there are {int} products on the Overview page")
  public void checkNumberOfProductsInCart(int noOfProducts) {
    overviewPage.checkNumberOfProducts(noOfProducts);
  }

  @Then("the Item total is the sum of the products prices")
  public void checkItemTotal() {
    overviewPage.checkItemTotal();
  }

  @Then("the Total is the sum of Item Total plus Tax")
  public void checkTotal() {
    overviewPage.checkTotal();
  }
}
