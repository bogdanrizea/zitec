package com.saucedemo.taf.pages;

import com.saucedemo.taf.helpers.Helper;
import com.saucedemo.taf.runners.Hook;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPage implements BasePage {

  @Autowired
  protected Helper helper;
  @Autowired
  protected Hook hook;

  @FindBy(how = How.CSS, using = "span[class='title']")
  protected WebElement pageName;
  @FindBy(how = How.CSS, using = "span[class='shopping_cart_badge']")
  protected WebElement shoppingCartBadge;
  @FindBy(how = How.CSS, using = "span[class='shopping_cart_badge']")
  protected List<WebElement> shoppingCartBadgeList;
  @FindBy(how = How.CSS, using = "#shopping_cart_container")
  protected WebElement shoppingCartIcon;
}
