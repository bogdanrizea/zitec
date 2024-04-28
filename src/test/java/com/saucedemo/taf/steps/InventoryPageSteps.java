package com.saucedemo.taf.steps;

import com.saucedemo.taf.pages.InventoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryPageSteps {

  @Autowired
  private InventoryPage inventoryPage;

  @Then("the Inventory Page should be loaded")
  public void checkInventoryPageIsLoaded() {
    inventoryPage.waitForPageLoaded();
  }

  @When("the client adds a product to cart")
  public void clickAddToCartButton() {
    inventoryPage.clickAddToCart();
  }

  @When("the client Removes {int} products")
  public void clockRemoveButton(int i) {
    inventoryPage.clickRemoveButton(i);
  }

  @Then("the cart icon shows {int} products")
  public void checkCartIcon(int i) {
    inventoryPage.checkCartCounterIs(i);
  }

  @Then("the Add to cart button changes to Remove for {int} products")
  public void checkRemoveButtonIsDisplayed(int i) {
    inventoryPage.checkRemoveButtonIsDisplayed(i);
  }

  @Then("there are no Remove buttons")
  public void checkRemoveButtonAreNotDisplayed() {
    inventoryPage.checkRemoveButtonAreNotDisplayed();
  }

  @When("the client clicks the cart icon")
  public void goToCart(){
    inventoryPage.clickCartIcon();
  }
}

