package tests;

import com.example.Config;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class CheckingInputFormTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    @Step("Настройка тестового окружения")
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Config.BASE_URL);
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    @Step("Тест ввода в главном меню")
    public void inputFormMainMenuTest() {
        InputPage inputPage = new InputPage(driver, wait);
        inputPage.inputFormMainMenu("maks123@mail.ru", "Maks4321");
    }

    @Test
    @Step("Тест ввода в личном кабинете")
    public void inputFormPersonalAccountTest() {
        InputPage inputPage = new InputPage(driver, wait);
        inputPage.inputFormPersonalAccount("maks123@mail.ru", "Maks4321");
    }

    @Test
    @Step("Тест ввода в форме регистрации")
    public void inputFormRegisterFormTest() {
        InputPage inputPage = new InputPage(driver, wait);
        inputPage.inputFormRegisterForm("maks123@mail.ru", "Maks4321");
    }

    @Test
    @Step("Тест ввода в форме восстановления пароля")
    public void inputFormRestorePasswordTest() {
        InputPage inputPage = new InputPage(driver, wait);
        inputPage.inputFormRestorePassword("maks123@mail.ru", "Maks4321");
    }

    @After
    @Step("Закрытие тестового окружения")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

