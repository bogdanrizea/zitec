package com.saucedemo.taf.steps;

import com.saucedemo.taf.pages.CartPage;
import com.saucedemo.taf.pages.YourInformationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class YourInformationSteps {

  @Autowired
  private YourInformationPage yourInformationPage;

  @Then("the Your Information Page should be displayed")
  public void checkInventoryPageIsLoaded() {
    yourInformationPage.checkForYourInformationPageIsLoaded();
  }

  @When("the client clicks Continue button")
  public void continueShopping() {
    yourInformationPage.clickContinueButton();
  }

  @When("the client inputs a name")
  public void inputName() {
    yourInformationPage.inputName();
  }

  @When("the client inputs a last name")
  public void inputLastName() {
    yourInformationPage.inputLastName();
  }

  @When("the client inputs a zip code")
  public void inputZipCode() {
    yourInformationPage.inputZipCode();
  }

  @Then("a missing first name error message is displayed")
  public void checkFirstNameError() {
    yourInformationPage.checkFirstNameError();
  }

  @Then("a missing last name error message is displayed")
  public void checkLastNameError() {
    yourInformationPage.checkLastNameError();
  }

  @Then("a missing zip code error message is displayed")
  public void checkZipCodeError() {
    yourInformationPage.checkZipCodeError();
  }

}
