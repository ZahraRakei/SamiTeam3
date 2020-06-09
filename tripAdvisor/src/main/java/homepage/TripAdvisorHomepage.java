package homepage;

import commonAPI.WebAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static homepage.TripAdvisoryHomepageElements.*;


public class TripAdvisorHomepage extends WebAPI {
  //test case 1
  @FindBy(how = How.CSS, using = webElementHotelMenu)
  public WebElement hotelMenu;
  @FindBy(css = webElementSearchBox1)
  public WebElement searchBox1;
  @FindBy(css = webElementSearchBox1Alt)
  public WebElement searchBox1Alt;
  @FindBy(how = How.CSS, using = webElementSearchBox2)
  public WebElement searchBox2;
  @FindBy(how = How.CSS, using = webElementSearchingText)
  public WebElement searchingText;

  //test case 2
  @FindBy(how = How.XPATH,using = webElementSearchBoxTwo)
  public WebElement searchBoxTwo;
  @FindBy(xpath = webElementSearchSelectTextZero)
  public  WebElement selectText;

  //test case 3
  @FindBy(how = How.XPATH,using = webElementRestaurantMenu)
  public WebElement restaurantMenu;

  //test Case 4
  @FindBy(how = How.XPATH,using = webElementThingsToDo)
  public WebElement thingToDo;
  @FindBy(how = How.XPATH,using = webElementSelectTextTwo)
  public WebElement selectTextTwo;

  // test case 5
  @FindBy(how = How.XPATH,using = webElementInsurance)
  public WebElement insurance;
  @FindBy(how = How.XPATH,using = webElementSearchInsuranceMenu)
  public WebElement insuranceMenu;

  //test case 6
  @FindBy(how = How.XPATH,using = webElementMoreButton)
  public WebElement moreButton;
  @FindBy(how = How.XPATH,using = webElementSearchMoreMenu)
  public WebElement searchMoreMenu;

  //test case 7
  @FindBy(how = How.XPATH,using = webElementFlights)
  public WebElement flights;
  @FindBy(how = How.XPATH,using = webElementSearchFlightsMenu)
  public WebElement searchFlightsMenu;

  //test case 8
  @FindBy(how = How.XPATH,using = webElementAboutCOVID)
  public WebElement aboutCODIV;
  @FindBy(how = How.XPATH,using = webElementSearchInformation)
  public WebElement searchInformation;

  //test case 9
  @FindBy(how = How.XPATH,using = webElementTravelForums)
  public WebElement travelForums;
  @FindBy(how = How.XPATH,using = webElementTravelForumsMenu)
  public WebElement searchTravelFormsMenu;

  //test case 10
  @FindBy(how = How.XPATH,using = webElementWriteAReview)
  public WebElement writeAReview;
  @FindBy(how = How.XPATH,using = webElementSearchWriteAReviewMenu)
  public WebElement searchWriteAReviewMenu;


//test case 1
  public void doSearchingText() {
    hotelMenu.click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    if (searchBox1Alt.isDisplayed()){
      wait.until(ExpectedConditions.elementToBeClickable(searchBox1Alt));
      searchBox1Alt.sendKeys("South Africa Hotels");
      searchBox1Alt.sendKeys(Keys.ENTER);
    } else if (searchBox1.isDisplayed()){
      wait.until(ExpectedConditions.elementToBeClickable(searchBox1));
      searchBox1.click();
      wait.until(ExpectedConditions.elementToBeClickable(searchBox2));
      searchBox2.sendKeys("South Africa Hotels");
      searchBox2.sendKeys(Keys.ENTER);
    }
  }
  public void validateDoSearchingText() {
    String actualText = searchingText.getText();
    Assert.assertEquals(actualText, "South Africa Hotels");
  }

//test case 2
  public void doSearchElement() throws InterruptedException {
    searchBoxTwo.click();
    searchBoxTwo.sendKeys("aj");
    Thread.sleep(3000);
  }
  public void validateDoSearchSelectTextZero() {
    String actualText = selectText.getText();
    Assert.assertEquals(actualText, "ajmer ajmer district");

  }
  //test case 3
  public void doSearchTitle(){
    restaurantMenu.click();
  }
  public void validateDoSearchTitle(){
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle,webElementTitle);
  }

  //test case 4
  public void doSearchThingsToDo() {
    thingToDo.click();
  }
  public void validateDoThingsToDo() {
    String actualText = selectTextTwo.getText();
    Assert.assertEquals(actualText, "Bangkok");
  }

  //test case 5
  public void doSearchInsuranceTitle() {
    insurance.click();
  }
  public void validateDoSearchInsuranceMenu() {
    String actualText = insuranceMenu.getText();
    Assert.assertEquals(actualText, "A year of trips. Protected.");
  }

  //test case 6
  public void doSearchMoreButton() {
    moreButton.click();
  }
  public void validateDoSearchMoreMenu() {
    String actualText = searchMoreMenu.getText();
    Assert.assertEquals(actualText, "Find the best cruise for you");
  }

  //test case 7
  public void doSearchBar() {
    flights.click();
  }
  public void validateDoSearchFlightsMenu() {
    String actualText = searchFlightsMenu.getText();
    Assert.assertEquals(actualText, "Find the best flight from New York City");
  }

  //test case 8
  public void doSearchTopic() {
   aboutCODIV .click();
  }
  public void validateDoSearchInformation() {
    String actualText = searchInformation.getText();
    Assert.assertEquals(actualText, "What do I need to know about booking travel right now?");
  }

  //test case 9
  public void doSearchTravelTopic() {
    travelForums.click();
  }
  public void validateDoTravelForumsMenu() {
    String actualText = searchTravelFormsMenu.getText();
    Assert.assertEquals(actualText, "Share your experience with fellow travelers");
  }

  //test case 10
  public void doSearchReviewMenu() {
    writeAReview.click();
  }
  public void validateDoReviewMenuButton() {
    String actualText = searchWriteAReviewMenu.getText();
    Assert.assertEquals(actualText, "Review a place you've visited");
  }


}

