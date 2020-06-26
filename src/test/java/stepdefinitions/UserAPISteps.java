package stepdefinitions;

import actions.UserAPIActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import services.api.UserService;


public class UserAPISteps {

  private UserService userService = new UserService();
  private UserAPIActions userAPIActions = new UserAPIActions();

  @When("Create new user via User API")
  public void createNewUserViaUserAPI() {
    userService.getUser();
  }

  @And("First amd Last name are present in response")
  public void firstAmdLastNameArePresentInResponse() {
    userAPIActions.checkUserFirstNameIsPresentInResponse();
    userAPIActions.checkUserLastNameIsPresentInResponse();
  }


}
