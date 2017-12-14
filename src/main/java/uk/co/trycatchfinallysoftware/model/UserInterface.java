package uk.co.trycatchfinallysoftware.model;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Page Object which provides heading, city vaues as well as interaction
 * with the day div "rows".
 *
 * @since 1.0-BETA2
 */
public class UserInterface {

    private final static String COLLAPSE_CSS_VALUE = "max-height: 0px;";
    private final static String EXPANDED_CSS_VALUE = "max-height: 2000px;";

    @FindBy(tagName = "h1")
    private WebElement headingElement;

    @FindBy(id = "city")
    private WebElement cityInputElement;

    @FindBy(css = "div[data-reactroot] > div")
    private List<WebElement> dayDivElements;

    private List<DayForecast> dayForecasts;

    public UserInterface() {
        // Blank
    }

    public String getHeadingText() {
        return headingElement.getText();
    }

    public int sizeOfDayElements() {
        return dayDivElements != null ? dayDivElements.size() : 0;
    }

    public String getCurrentCity() {
        return cityInputElement.getAttribute("value");
    }

    public void clearCurrentCity() {
        cityInputElement.clear();
    }

    public void clickOnDayWithIndex(int index) {
        if (hasDays() && index <= dayDivElements.size()) {
            getDayDivElementByIndex(index).click();
        }
    }

    public boolean hasDays() {
        return sizeOfDayElements() > 0;
    }

    public WebElement getDayDivElementByIndex(int index) {
        if (hasDays()) {
            return dayDivElements.get(index);
        }

        return null;
    }

    public boolean isDayDivExpanded() {
        boolean foundExpandedDayDiv = false;

        for (WebElement dayDivElement : dayDivElements) {
            // @todo Refactor to return the status of the div based on if/else-if type condition
            if (detailsDivExpanded(dayDivElement)) {
                foundExpandedDayDiv = true;
            }
        }

        return foundExpandedDayDiv;
    }

    private boolean detailsDivExpanded(WebElement dayDivElement) {
        String styleAttrValue = dayDivElement
                .findElement(By.className("details"))
                .getAttribute("style");

        return StringUtils.containsIgnoreCase(styleAttrValue, EXPANDED_CSS_VALUE);
    }

    @Override
    public String toString() {
        return "UserInterface{" +
                "headingText=" + getHeadingText() +
                ", currentCity=" + getCurrentCity() +
                ", numberOfDays=" + sizeOfDayElements() +
                ", isADayDivExpanded=" + isDayDivExpanded() +
                '}';
    }
}
