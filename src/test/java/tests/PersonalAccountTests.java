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
import pages.PersonalAccountPage;

public class PersonalAccountTests {
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
    @DisplayName("Тест перехода в личный кабинет")
    public void TransferPersonalAccountTest() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver, wait);
        performTransferPersonalAccount(personalAccountPage);
    }

    @DisplayName("Переход в личный кабинет")
    private void performTransferPersonalAccount(PersonalAccountPage personalAccountPage) {
        personalAccountPage.TransferPersonalAccount("maks123@mail.ru", "Maks4321");
    }

    @Test
    @DisplayName("Тест работы кнопки конструктора")
    public void designerButtonWorkingTest() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver, wait);
        performDesignerButtonWorking(personalAccountPage);
    }

    @DisplayName("Проверка работы кнопки конструктора")
    private void performDesignerButtonWorking(PersonalAccountPage personalAccountPage) {
        personalAccountPage.designerButtonWorking("maks123@mail.ru", "Maks4321");
    }

    @Test
    @DisplayName("Тест работы кнопки логотипа")
    public void logoButtonWorkingTest() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver, wait);
        performLogoButtonWorking(personalAccountPage);
    }

    @DisplayName("Проверка работы кнопки логотипа")
    private void performLogoButtonWorking(PersonalAccountPage personalAccountPage) {
        personalAccountPage.logoButtonWorking("maks123@mail.ru", "Maks4321");
    }

    @Test
    @DisplayName("Тест выхода из личного кабинета")
    public void logOutPersonalAccountTest() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver, wait);
        performLogOutPersonalAccount(personalAccountPage);
    }

    @DisplayName("Выход из личного кабинета")
    private void performLogOutPersonalAccount(PersonalAccountPage personalAccountPage) {
        personalAccountPage.logOutPersonalAccount("maks123@mail.ru", "Maks4321");
    }

    @After
    @DisplayName("Закрытие тестового окружения")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

