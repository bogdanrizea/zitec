package com.saucedemo.taf.pages;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class CheckoutCompletePage extends AbstractPage {

  private static final String CHECKOUT_COMPLETE = "Checkout: Complete!";

  public void checkForCheckoutCompletePageLoaded() {
    helper.waitForElementToBeClickable(pageName);
    Assert.assertTrue(pageName.getText().contains(CHECKOUT_COMPLETE));
  }

  public void checkNumberOfProducts() {
    Assert.assertEquals(0, shoppingCartBadgeList.size());
  }
}
