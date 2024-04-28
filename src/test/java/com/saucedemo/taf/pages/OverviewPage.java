package com.saucedemo.taf.pages;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class OverviewPage extends AbstractPage {

  private static final String CHECKOUT_OVERVIEW = "Checkout: Overview";
  private static final String ITEM_TOTAL = "Item total: ";
  private static final String TOTAL = "Total: ";
  private static final String TAX = "Tax: ";

  @FindBy(how = How.CSS, using = "#finish")
  private WebElement finishButton;
  @FindBy(how = How.CSS, using = "div[class='summary_subtotal_label']")
  private WebElement itemTotal;
  @FindBy(how = How.CSS, using = "div[class='summary_total_label']")
  private WebElement total;
  @FindBy(how = How.CSS, using = "div[class='summary_tax_label']")
  private WebElement taxLabel;

  @FindBy(how = How.CSS, using = "div[class='cart_item']")
  private List<WebElement> cartItemList;
  @FindBy(how = How.CSS, using = "div[class='inventory_item_price']")
  private List<WebElement> itemPriceList;

  public void checkForCheckoutOverviewPageLoaded() {
    helper.waitForElementToBeClickable(pageName);
    Assert.assertTrue(pageName.getText().contains(CHECKOUT_OVERVIEW));
  }

  public void clickFinishButton() {
    helper.clickElement(finishButton);
  }

  public void checkNumberOfProducts(int noOfProducts) {
    Assert.assertEquals(noOfProducts, cartItemList.size());
  }

  private double getItemsPriceSum() {
    ArrayList<Double> list = new ArrayList<>();
    for (int i = 0; i < itemPriceList.size(); i++) {
      String price = helper.removeDollarSignFromString(itemPriceList.get(i).getText());
      Double integerPrice = Double.parseDouble(price);
      list.add(integerPrice);
    }

    double sum = list.stream()
        .mapToDouble(a -> a)
        .sum();

    return  sum;
  }
  public void checkItemTotal() {
    if(getItemTotal()  == getItemsPriceSum()) {
      Assert.assertTrue(true);
    } else {
      Assert.assertTrue("Sum of items is not the same as Item total",false);
    }
  }

  private double getItemTotal() {
    String noDollar = helper.removeDollarSignFromString(itemTotal.getText());
    String noText = noDollar.replace(ITEM_TOTAL, "");
    double iTotal = Double.parseDouble(noText);
    return iTotal;
  }

  private double getTotalValue() {
    String totalTextLabel = helper.removeDollarSignFromString(total.getText());
    String removeTotal = totalTextLabel.replace(TOTAL, "");
    double totalValue = Double.parseDouble(removeTotal);
    return totalValue;
  }

  private double getTotalSum() {
    String taxLabelString = helper.removeDollarSignFromString(taxLabel.getText());
    String removeTax = taxLabelString.replace(TAX, "");
    double iTotalPlusTax = Double.parseDouble(removeTax) + getItemTotal();
    return iTotalPlusTax;
  }
  public void checkTotal() {
    if(getTotalValue() == getTotalSum()) {
      Assert.assertTrue(true);
    } else {
      Assert.assertTrue("Sum of Item total plus tax is the same as Total",false);
    }
  }
}
