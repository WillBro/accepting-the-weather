package uk.co.trycatchfinallysoftware.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class DayForecast {

    private static final String TRANSFORM_STYLE = "transform: rotate(\\d+)deg);";

    @FindBy(css = "span[data-test^=date]")
    private WebElement dateElement;

    @FindBy(css = "span[data-test^=day]")
    private WebElement dayElement;

    @FindBy(css = "svg[data-test^=description]")
    private WebElement descriptionElement;

    private List<WebElement> hourElements;

    @FindBy(css = "span[data-test^=maximum]")
    private WebElement maximumTempElement;

    @FindBy(css = "span[data-test^=minimum]")
    private WebElement minimumTempElement;

    @FindBy(css = "span[data-test^=speed]")
    private WebElement windSpeedElement;

    @FindBy(css = "span[data-test^=direction]")
    private WebElement windDirectionElement;

    @FindBy(css = "span[data-test^=rainfall]")
    private WebElement rainfallElement;

    @FindBy(css = "span[data-test^=pressure]")
    private WebElement pressureElement;

    public DayForecast(WebElement parentElement) {
        PageFactory.initElements(new AjaxElementLocatorFactory(parentElement, 3), this);
    }

    public String getDateText() {
        return dateElement.getText();
    }

    @Override
    public String toString() {
        return "DayForecast{" +
                "dateElement=" + getDateText() +
                ", day=" + dayElement.getText() +
                ", description=" + descriptionElement.getAttribute("aria-label") +
                ", maximum=" + maximumTempElement.getText() +
                ", minimum=" + minimumTempElement.getText() +
                ", speed=" + windSpeedElement.getText() +
                ", rainfall=" + rainfallElement.getText() +
                ", pressure=" + pressureElement.getText() +
                '}';
    }
}
