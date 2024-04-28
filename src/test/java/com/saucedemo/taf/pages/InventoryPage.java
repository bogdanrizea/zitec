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
public class InventoryPage extends AbstractPage {

  @FindBy(how = How.CSS, using = "button[class='btn btn_primary btn_small btn_inventory ']")
  private WebElement addToCartButton;

  @FindBy(how = How.CSS, using = "button[class='btn btn_secondary btn_small btn_inventory ']")
  private List<WebElement> removeButton;

  public void waitForPageLoaded() {
    helper.waitForElementToBeClickable(shoppingCartIcon);
  }

  public void clickAddToCart() {
    helper.clickElement(addToCartButton);
  }

  public void checkCartCounterIs(int i) {
    if(i > 0) {
      helper.waitForElementToBeClickable(shoppingCartBadge);
      Assert.assertEquals(i, Integer.parseInt(shoppingCartBadge.getText()));
    } else {
      Assert.assertEquals(0, shoppingCartBadgeList.size());
    }

  }

  public void checkRemoveButtonIsDisplayed(int i) {
    Assert.assertEquals(i, removeButton.size());
  }

  public void clickRemoveButton(int howMany) {
    for(int i = howMany; i>0; i--) {
      helper.clickElement(removeButton.get(i-1));
    }
  }

  public void checkRemoveButtonAreNotDisplayed() {
    Assert.assertEquals(0, removeButton.size());
  }

  public void clickCartIcon() {
    helper.clickElement(shoppingCartIcon);
  }
}
