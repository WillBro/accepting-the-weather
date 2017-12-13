package uk.co.trycatchfinallysoftware;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean(name = "chromeDriver")
    public ChromeDriver getChromeDriver() throws InstantiationException, IllegalAccessException {
        ChromeDriverManager.getInstance().setup();

        Class<? extends WebDriver> driverClass = ChromeDriver.class;
        ChromeDriverManager.getInstance().setup();

        return (ChromeDriver) driverClass.newInstance();
    }
}
