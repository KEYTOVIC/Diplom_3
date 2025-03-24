package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public InputPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By buttonInputTop = By.xpath("//*[text()='Личный Кабинет']");
    private By emailField = By.xpath("//*[@name='name']");
    private By passwordField = By.xpath("//*[@type='password']");
    private By loginButton = By.xpath("//*[text()='Войти']");
    private By personalAccount = By.xpath("//*[text()='Личный Кабинет']");
    private By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    private By restorePasswordButton = By.xpath("//*[text()='Восстановить пароль']");

    public void inputFormMainMenu(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }

    public void inputFormPersonalAccount(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(personalAccount)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }
    public void inputFormRegisterForm(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(personalAccount)).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void inputFormRestorePassword(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(personalAccount)).click();
        wait.until(ExpectedConditions.elementToBeClickable(restorePasswordButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }



}
