package uk.co.trycatchfinallysoftware.model;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Detail {

    @FindBy(css = "span[data-test^=maximum]")
    private WebElement maximum;

    @FindBy(css = "span[data-test^=minimum]")
    private WebElement minimum;

    @FindBy(css = "span[data-test^=rainfall]")
    private WebElement rainfallElement;

    @FindBy(css = "span[data-test^=pressure]")
    private WebElement pressureElement;

    public int getCleanMaximum() {
        return NumberUtils.createInteger(cleanCelcius(maximum.getText()));
    }

    public int getCleanMinimum() {
        return NumberUtils.createInteger(cleanCelcius(minimum.getText()));
    }

    public String cleanCelcius(String input) {
        return input.replace("\u00b0", "");
    }

    public int getCleanRainfall() {
        return Integer.parseInt(rainfallElement.getText().replace("mm", ""));
    }

    public int getCleanPressure() {
        return Integer.parseInt(pressureElement.getText().replace("mb", ""));
    }

    @Override
    public String toString() {
        return "Detail{" +
                "maximum=" + maximum.getText()+
                ", minimum=" + minimum.getText() +
                ", rainfall=" + rainfallElement.getText() +
                ", pressure=" + pressureElement.getText() +
                '}';
    }
}
