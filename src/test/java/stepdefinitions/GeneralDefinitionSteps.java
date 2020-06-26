package stepdefinitions;

import static context.ScenarioContext.Context.HTTP_RESPONSE;

import context.ScenarioContext;

import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class GeneralDefinitionSteps {

  @Then("Status code from response is (.*)")
  public void statusCodeFromInternalLambdaIs(int expectedStatusCode) {
    Response response = ScenarioContext.getContext(HTTP_RESPONSE);
    response.then().log().all();
    response.then().statusCode(expectedStatusCode);
  }

}
