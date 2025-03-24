package tests;

import com.example.Config;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import static io.restassured.RestAssured.given;

public class RegistrationFormTest {

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
    @Step("Тест успешной регистрации")
    public void successfulRegistrationFormTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        performSuccessfulRegistration(loginPage);
    }

    @Step("Заполнение формы успешной регистрации")
    private void performSuccessfulRegistration(LoginPage loginPage) {
        loginPage.clickPersonalAccount();
        loginPage.clickRegisterButton();
        loginPage.fillRegisterForm("Maksim", "maks123@mail.ru", "Maks4321");
    }

    @Test
    @Step("Тест неудачной регистрации")
    public void failedRegistrationFormTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        performFailedRegistration(loginPage);
    }

    @Step("Заполнение формы с некорректными данными")
    private void performFailedRegistration(LoginPage loginPage) {
        loginPage.clickPersonalAccount();
        loginPage.clickRegisterButton();
        loginPage.notCorrectfillRegisterForm("Maksm", "mak.123@mail.ru", "Maks4");
    }

    @After
    @Step("Закрытие тестового окружения и удаление пользователя")
    public void tearDown() {
        if (driver != null) {
            LoginPage loginPage = new LoginPage(driver, wait);
            String token = loginPage.getBearerToken();
            if (token != null && !token.isEmpty()) {
                deleteUser(token);
            }
            driver.quit();
        }
    }

    @Step("Удаление пользователя через API")
    public void deleteUser(String token) {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api/auth/user";
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete()
                .then()
                .extract().response();

        System.out.println("Удаление пользователя: " + response.getStatusCode() + " " + response.getBody().asString());
    }
}

