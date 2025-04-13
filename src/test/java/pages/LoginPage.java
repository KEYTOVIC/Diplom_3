package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Локаторы Регистрации
    private By personalAccount = By.xpath("//*[text()='Личный Кабинет']");
    private By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    private By nameField = By.name("name");
    private By emailField = By.xpath("//input[@type='text' and @name='name']/following::input[1]");
    private By passwordField = By.xpath("//*[@type='password']");
    private By notCorrectPassword = By.xpath("//*[@class='input__error text_type_main-default']");

    public void clickPersonalAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccount)).click();
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void fillRegisterForm(String name, String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void notCorrectfillRegisterForm(String name, String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(notCorrectPassword));
    }

    // Метод для получения токена из localStorage
    public String getBearerToken() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return localStorage.getItem('accessToken');");
    }
}


