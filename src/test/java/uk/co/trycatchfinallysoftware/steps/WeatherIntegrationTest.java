package uk.co.trycatchfinallysoftware.steps;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uk.co.trycatchfinallysoftware.SpringIntegrationTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WeatherIntegrationTest extends SpringIntegrationTest {

    @Given("^that I have accessed the Weather Application$")
    public void that_i_have_accessed_the_weather_application() throws Throwable {
        navigateToWeatherApplication();
    }

    @When("^When I go to the Weather Application$")
    public void browser_navigates_to_application() throws Throwable {
        navigateToWeatherApplication();
    }

    @And("^We have requested the correct application URL$")
    public void application_url_is_browser_url() {
        Assert.assertTrue("This might not be the application URL",
                currentUrlIsApplication()
        );
    }

    @Then("^I should see weather for the city (.+)$")
    public void expected_city_is_displayed(String city) throws Throwable {
        String actualCity = getWebDriver()
                .findElement(getByTestAttr("city"))
                .getAttribute("value");

        assertThat("Displayed city is not correct",
                actualCity,
                is(city)
        );
    }

    @And("^(\\d+) days should be displayed$")
    public void expects_days_to_be_displayed(int days) {
        List<WebElement> dayDivElementList = getWebDriver().findElements(
                By.cssSelector("div[data-reactroot] > div")
        );

        assertThat("5 days of forecast was not displayed", dayDivElementList.size(), is(4));

        dayDivElementList.forEach(element -> {
            System.out.println(element.findElement(By.cssSelector("span.name")).getText());
        });
    }
}
