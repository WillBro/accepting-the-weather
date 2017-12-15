package uk.co.trycatchfinallysoftware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * WebDriver navigation to UserInterface, conveniences for selecting HTML elements
 * of test interest with data-test attribute.
 * @since 1.0
 */
@ContextConfiguration(classes = App.class)
public class SpringIntegrationTest {

    public static final String APPLICATION_URL = "https://weather-acceptance.herokuapp.com/";

    @Autowired
    private WebDriver webDriver;

    /**
     * @return Autowired WebDriver (currently ChromeDriver)
     */
    protected WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * GET using the WebDriver the hosted Heroku Weather App
     */
    protected void navigateToWeatherApplication() {
        webDriver.get(APPLICATION_URL);
    }

    /**
     * Convenience creating Selenium By locator to all data-test
     * HTML elements.
     *
     * @todo Refactor into Util
     * @return
     */
    public By getByAllDataTestAttrElements() {
        return By.cssSelector("[data-test]");
    }

    /**
     * Convenience creating Selenium By locator to HTML elements
     * with a specific data-test attribute value.
     *
     * @todo Refactor into main/Util
     * @param value
     * @return
     */
    public By getByTestAttr(String value) {
        return By.cssSelector("[data-test=" + value + "]");
    }

    /**
     * Is the WebDriver viewing the application under test?
     *
     * @return true if the current URL is exactly that
     * of the defined application URL
     */
    protected boolean currentUrlIsApplication() {
        return APPLICATION_URL.equalsIgnoreCase(webDriver.getCurrentUrl());
    }
}