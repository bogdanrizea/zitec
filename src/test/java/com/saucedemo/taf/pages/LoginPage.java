package com.saucedemo.taf.pages;

import com.saucedemo.taf.helpers.Helper;
import com.saucedemo.taf.runners.Hook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage implements BasePage {

  private static final String USERNAME_ERROR_MESSAGE = "Epic sadface: Username is required";
  private static final String PASSWORD_ERROR_MESSAGE = "Epic sadface: Password is required";
  private static final String LOCKED_OUT_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
  @Autowired
  private Helper helper;

  @Autowired
  private Hook hook;

  @FindBy(how = How.ID, using = "user-name")
  private WebElement usernameInput;

  @FindBy(how = How.ID, using = "password")
  private WebElement passwordInput;

  @FindBy(how = How.ID, using = "login-button")
  private WebElement loginButton;

  @FindBy(how = How.CSS, using = "div[class='error-message-container error']")
  private WebElement errorMessageElement;

  public void clickLoginButton() {
    helper.clickElement(loginButton);
  }

  public void typeInUsernameInput(String string) {
    helper.waitForElementToBeClickable(usernameInput);
    usernameInput.sendKeys(string);
  }

  public void typeInPasswordInput(String string) {
    helper.waitForElementToBeClickable(passwordInput);
    passwordInput.sendKeys(string);
  }

  public void checkUserNameIsRequired() {
    helper.waitForElementToBeClickable(errorMessageElement);
    Assert.assertEquals(USERNAME_ERROR_MESSAGE, errorMessageElement.getText());
  }

  public void checkPasswordIsRequired() {
    helper.waitForElementToBeClickable(errorMessageElement);
    Assert.assertEquals(PASSWORD_ERROR_MESSAGE, errorMessageElement.getText());
  }

  public void checkUserIsLockedOut() {
    helper.waitForElementToBeClickable(errorMessageElement);
    Assert.assertEquals(LOCKED_OUT_ERROR_MESSAGE, errorMessageElement.getText());
  }
}
