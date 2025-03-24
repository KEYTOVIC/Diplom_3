package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PersonalAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By buttonInputTop = By.xpath("//*[text()='Личный Кабинет']");
    private By emailField = By.xpath("//*[@name='name']");
    private By passwordField = By.xpath("//*[@type='password']");
    private By loginButton = By.xpath("//*[text()='Войти']");
    private By profilePersonalAccount = By.xpath("//*[text()='Профиль']");
    private By designer = By.xpath("//*[text()='Конструктор']");
    private By textAssembleBurger = By.xpath("//*[text()='Соберите бургер']");
    private By logoBurger = By.xpath("//*[@class='AppHeader_header__logo__2D0X2']");
    private By logOutButton = By.xpath("//*[text()='Выход']");


    public void TransferPersonalAccount(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePersonalAccount));
    }

    public void  designerButtonWorking(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePersonalAccount));
        wait.until(ExpectedConditions.elementToBeClickable(designer)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(textAssembleBurger));

    }

    public void  logoButtonWorking(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePersonalAccount));
        wait.until(ExpectedConditions.elementToBeClickable(logoBurger)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(textAssembleBurger));

    }

    public void logOutPersonalAccount(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonInputTop)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePersonalAccount));
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));

    }

}
