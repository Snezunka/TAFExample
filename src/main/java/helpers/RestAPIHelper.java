package helpers;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static java.nio.charset.StandardCharsets.UTF_8;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class RestAPIHelper {

  public static Response get() {
    return getHttpClient().get();
  }

  private static RequestSpecification getHttpClient() {
    return given().spec(getRequestSpecification()).log().all();
  }

  private static RequestSpecification getRequestSpecification() {
    return new RequestSpecBuilder()
        .setBaseUri(ConfigProvider.getAPIUrl())
        .setContentType(ContentType.JSON)
        .setConfig(config().encoderConfig(encoderConfig().defaultContentCharset(UTF_8)))
        .build();
  }
}
