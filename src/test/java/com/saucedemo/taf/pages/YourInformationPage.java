package com.saucedemo.taf.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class YourInformationPage extends AbstractPage {

  private static final String YOUR_INFORMATION = "Checkout: Your Information";
  private static final String FIRST_NAME_ERROR = "Error: First Name is required";
  private static final String FIRST_NAME = "Harry";
  private static final String LAST_NAME_ERROR = "Error: Last Name is required";
  private static final String LAST_NAME = "Potter";
  private static final String ZIP_CODE_ERROR = "Error: Postal Code is required";
  private static final String ZIP_CODE = "9ER";

  @FindBy(how = How.CSS, using = "#first-name")
  private WebElement firstNameInput;
  @FindBy(how = How.CSS, using = "#last-name")
  private WebElement lastNameInput;
  @FindBy(how = How.CSS, using = "#postal-code")
  private WebElement zipCodeInput;
  @FindBy(how = How.CSS, using = "#continue")
  private WebElement continueButton;
  @FindBy(how = How.CSS, using = "div[class='error-message-container error']")
  private WebElement errorMessage;

  public void checkForYourInformationPageIsLoaded() {
    helper.waitForElementToBeClickable(pageName);
    Assert.assertTrue(pageName.getText().contains(YOUR_INFORMATION));
  }

  public void clickContinueButton() {
    helper.clickElement(continueButton);
  }

  public void checkFirstNameError(){
    checkErrorMessage(FIRST_NAME_ERROR);
  }

  public void checkLastNameError(){
    checkErrorMessage(LAST_NAME_ERROR);
  }

  public void checkZipCodeError(){
    checkErrorMessage(ZIP_CODE_ERROR);
  }

 private void checkErrorMessage(String expected) {
   helper.waitForElementToBeClickable(errorMessage);
   Assert.assertEquals(expected, errorMessage.getText());
 }

  public void inputName() {
    firstNameInput.sendKeys(FIRST_NAME);
  }

  public void inputLastName() {
    lastNameInput.sendKeys(LAST_NAME);
  }

  public void inputZipCode() {
    zipCodeInput.sendKeys(ZIP_CODE);
  }
}
