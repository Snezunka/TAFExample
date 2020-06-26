package pages;

import base.DriverFactory;
import context.ScenarioContext;
import context.ScenarioContext.Context;
import helpers.ConfigProvider;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends DriverFactory {

  public GooglePage() {
    initElements(this);
  }

  @FindBy(name = "q")
  private WebElement searchBar;

  @FindBy(xpath = "//div[@class='g']//div[@class='r']//h3")
  private List<WebElement> searchResults;

  public void openGooglePage() {
    String url = ConfigProvider.getGoogleUrl();
    driver.get(url);
    driverWaiter.until(ExpectedConditions.visibilityOf(searchBar));
  }

  public void searchUserFacebookAccountInGoogle(String user) {
    searchBar.sendKeys(user);
    Actions action = new Actions(driver);
    action.sendKeys(Keys.ENTER).build().perform();
  }

  public void checkUserFacebookAccountIsPresentInGoogleSearch() {
    String user = ScenarioContext.getContext(Context.USER);
    String expectedResult =  user + " Profiles | Facebook";
    driverWaiter.until(ExpectedConditions.visibilityOfAllElements(searchResults));
    boolean isUserFbAccountPresent = searchResults.stream()
        .anyMatch(searchResult -> searchResult.getText().equals(expectedResult));
    Assertions.assertThat(isUserFbAccountPresent)
        .as("User Facebook account is not present in google search").isTrue();
  }
}
