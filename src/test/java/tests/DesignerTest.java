package tests;

import com.example.Config;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DesignerPage;

public class DesignerTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    @DisplayName("Настройка тестового окружения")
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Config.BASE_URL);
        wait = new WebDriverWait(driver, 3);
    }


    @Test
    @DisplayName("Проверка на работоспособность Tab Булки")
    public void bunsVisableTest() {
        DesignerPage designerPage = new DesignerPage(driver, wait);
        designerPage.buttonBuns();
        designerPage.isBunsHeaderVisible();
    }

    @Test
    @DisplayName("Проверка на работоспособность Tab Соусы")
    public void saucesVisableTest() {
        DesignerPage designerPage = new DesignerPage(driver, wait);
        designerPage.buttonSaouces();
        designerPage.isSaucesHeaderVisible();
    }

    @Test
    @DisplayName("Проверка на работоспособность Tab Начинки")
    public void fillingsVisableTest() {
        DesignerPage designerPage = new DesignerPage(driver, wait);
        designerPage.buttonFillings();
        designerPage.isFillingsHeaderVisible();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

