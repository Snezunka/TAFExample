package actions;

import static context.ScenarioContext.Context.HTTP_RESPONSE;
import static context.ScenarioContext.Context.USER;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.ScenarioContext;
import dto.ResultsDTO;
import io.restassured.response.Response;
import java.io.IOException;
import org.assertj.core.api.Assertions;

public class UserAPIActions {

  public void checkUserFirstNameIsPresentInResponse() {
    String firstName = getUserFirstNameFromResponse();
    Assertions.assertThat(firstName)
        .as("First Name should not be null").isNotNull();
  }

  public void checkUserLastNameIsPresentInResponse() {

    String lastName = getUserLastNameFromResponse();
    Assertions.assertThat(lastName)
        .as("Last Name should not be null").isNotNull();
  }

  public String getUserFirstNameFromResponse() {
    ResultsDTO resultDto = parseResponse();
    return resultDto.getResults().get(0).getName().getFirst();
  }

  public String getUserLastNameFromResponse() {
    ResultsDTO resultDto = parseResponse();
    return resultDto.getResults().get(0).getName().getLast();
  }

  public String getUserFirstAndLastName() {
    String firstName = getUserFirstNameFromResponse();
    String lastName = getUserLastNameFromResponse();
    String user = firstName + " " + lastName;
    ScenarioContext.setContext(USER, user);
    return user;
  }

  private ResultsDTO parseResponse() {
    Response response = ScenarioContext.getContext(HTTP_RESPONSE);
    ObjectMapper mapper = new ObjectMapper();
    ResultsDTO result = null;
    String body = response.body().asString();
    try {
      result = mapper.readValue(body, ResultsDTO.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }
}
