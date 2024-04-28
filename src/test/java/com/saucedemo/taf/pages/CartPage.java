package com.saucedemo.taf.pages;

import com.saucedemo.taf.helpers.Helper;
import com.saucedemo.taf.runners.Hook;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartPage extends AbstractPage {

  private static final String YOUR_CART = "Your Cart";

  @FindBy(how = How.CSS, using = "#continue-shopping")
  private WebElement continueShoppingButton;
  @FindBy(how = How.CSS, using = "div[class='cart_footer'] button[class='btn btn_action btn_medium checkout_button ']")
  private WebElement checkoutButton;
  @FindBy(how = How.CSS, using = "div[class='cart_item']")
  private List<WebElement> cartItemList;

  public void checkForCArtPageIsLoaded() {
    helper.waitForElementToBeClickable(pageName);
    Assert.assertTrue(pageName.getText().contains(YOUR_CART));
  }

  public void clickContinueShoppingButton() {
    helper.clickElement(continueShoppingButton);
  }

  public void clickCheckoutButton(){
    helper.clickElement(checkoutButton);
  }

  public void checkNumberOfProducts(int noOfProducts) {
    Assert.assertEquals(noOfProducts, cartItemList.size());
  }
}
