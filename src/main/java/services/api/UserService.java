package services.api;

import static context.ScenarioContext.Context.HTTP_RESPONSE;

import context.ScenarioContext;
import helpers.RestAPIHelper;
import io.restassured.response.Response;

public class UserService {
  public Response getUser() {
    Response response = RestAPIHelper.get();
    ScenarioContext.setContext(HTTP_RESPONSE, response);
    return response;
  }
}
