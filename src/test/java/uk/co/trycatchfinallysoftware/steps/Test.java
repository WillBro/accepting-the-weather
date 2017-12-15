package uk.co.trycatchfinallysoftware.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import uk.co.trycatchfinallysoftware.SpringIntegrationTest;
import uk.co.trycatchfinallysoftware.model.DayForecast;
import uk.co.trycatchfinallysoftware.model.Detail;
import uk.co.trycatchfinallysoftware.model.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * A development class while wiring Page Objects with aspects of code
 * developed here likely to be refactored into WaitUtil/PageObjects or Helpers.
 */
public class Test extends SpringIntegrationTest {

    @Given("^I test the application$")
    public void pageObjectInitElementsToStringSystemOut() throws Throwable {
        navigateToWeatherApplication();

        UserInterface userInterfaceModel = new UserInterface();
        PageFactory.initElements(new AjaxElementLocatorFactory(
                getWebDriver(), 3
        ), userInterfaceModel);

        System.out.println(userInterfaceModel);

        FluentWait<WebDriver> wait = new FluentWait<>(getWebDriver())
                .pollingEvery(1, TimeUnit.SECONDS)
                .withTimeout(5, TimeUnit.SECONDS);

        // Confirming the Page model with
        // a Cheap and cheerful proof-of-concept
        for (int idxDayElements = 0; idxDayElements < userInterfaceModel.sizeOfDayElements(); idxDayElements++) {
            WebElement dayElement = userInterfaceModel.getDayDivElementByIndex(idxDayElements);

            dayElement.click();

            wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
                    dayElement,
                    By.className("detail")
            ));

            DayForecast dayForecast = new DayForecast();
            PageFactory.initElements(new AjaxElementLocatorFactory(
                    dayElement, 5
            ), dayForecast);

            if (idxDayElements == 0) {
                dayForecast.setToday();
            }

            System.out.print(dayForecast);

            dayForecast.setDetails(hoursListFromDay(dayElement));
        }
    }

    private List<Detail> hoursListFromDay(WebElement dayElement) {
        List<Detail> hoursForecastList = new ArrayList<>();
        for (WebElement hourWebElement : dayElement.findElements(By.className("detail"))) {
            Detail hourForecast = new Detail();
            PageFactory.initElements(new AjaxElementLocatorFactory(
                    hourWebElement,
                    10
            ), hourForecast);

            System.out.println(hourForecast);

            hoursForecastList.add(hourForecast);
        }

        return hoursForecastList;
    }
}
