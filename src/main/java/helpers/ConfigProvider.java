package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {

  static String getAPIUrl() {
    Properties properties = getProperties();
    return properties.getProperty("api.url");
  }

  public static String getGoogleUrl() {
    Properties properties = getProperties();
    return properties.getProperty("google.url");
  }

  public static String getFacebookUrl() {
    Properties properties = getProperties();
    return properties.getProperty("facebook.url");
  }

  public static String getBrowserName() {
    Properties properties = getProperties();
    return properties.getProperty("browser.name");
  }

  private static Properties getProperties() {
    Properties properties = new Properties();
    String filePath = System.getProperty("user.dir") + "/src/main/resources/inputData.properties";
    try(InputStream inputStream = new FileInputStream(filePath)) {
      properties.load(inputStream);
    } catch (IOException io) {
      throw new IllegalArgumentException("Incorrect properties file path " + filePath);
    }
    return properties;
  }
}
