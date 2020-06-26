package stepdefinitions;

import actions.UserAPIActions;
import context.ScenarioContext.Context;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePage;

public class GoogleSteps {


  private GooglePage googlePage = new GooglePage();
  private UserAPIActions userAPIActions = new UserAPIActions();

  @When("Open Google page")
  public void openGooglePage() {
    googlePage.openGooglePage();
  }

  @When("Search User in Google")
  public void searchUserInFacebook() {
    String user = userAPIActions.getUserFirstAndLastName();
    String searchText = user + " facebook account";
    googlePage.searchUserFacebookAccountInGoogle(searchText);
  }

  @Then("Check user facebook account is present in Google Search")
  public void checkUserFacebookAccountIsPresentInGoogleSearch() {
    googlePage.checkUserFacebookAccountIsPresentInGoogleSearch();
  }
}
