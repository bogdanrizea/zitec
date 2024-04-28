package com.saucedemo.taf.steps;

import com.saucedemo.taf.helpers.UserNames;
import com.saucedemo.taf.pages.LoginPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageSteps {

  @Autowired
  private LoginPage loginPage;

  @ParameterType("STANDARD_USER|LOCKED_OUT_USER|PROBLEM_USER|PERFORMANCE_GLITCH_USER|ERROR_USER|VISUAL_USER")
  public String userName(String userName) {
    return switch (userName) {
      case "STANDARD_USER" -> UserNames.STANDARD_USER.userName;
      case "LOCKED_OUT_USER" -> UserNames.LOCKED_OUT_USER.userName;
      case "PROBLEM_USER" -> UserNames.PROBLEM_USER.userName;
      case "PERFORMANCE_GLITCH_USER" -> UserNames.PERFORMANCE_GLITCH_USER.userName;
      case "ERROR_USER" -> UserNames.ERROR_USER.userName;
      case "VISUAL_USER" -> UserNames.VISUAL_USER.userName;
      default -> "";
    };
  }

  @Given("the client inputs {userName} credentials")
  public void inputCredentials(String userName) {
    loginPage.typeInUsernameInput(userName);
    loginPage.typeInPasswordInput("secret_sauce");
  }

  @Given("the client does not input a username")
  public void doNotInputUsername() {
    loginPage.typeInPasswordInput("secret_sauce");
  }

  @Given("the client does not input a password")
  public void doNotInputPassword() {
    loginPage.typeInUsernameInput("standard_user");
  }

  @When("clicks on the Login button")
  public void clickLoginButton() {
    loginPage.clickLoginButton();
  }

  @Then("an Username required error message should be displayed")
  public void checkUserNameIsRequired() {
    loginPage.checkUserNameIsRequired();
  }

  @Then("a Password required error message should be displayed")
  public void checkPasswordIsRequired() {
    loginPage.checkPasswordIsRequired();
  }

  @Then("an User locked out error message should be displayed")
  public void checkUserIsLockedOut() {
    loginPage.checkUserIsLockedOut();
  }

}

