package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {
    public static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase("yandex")) {
            System.setProperty("webdriver.chrome.driver", "path/to/yandexdriver");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Users/User/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
            return new ChromeDriver(options);
        } else {
            return new ChromeDriver();
        }
    }
}