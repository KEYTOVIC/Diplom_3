package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DesignerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DesignerPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    private By buns = By.xpath("//span[contains(text(),'Булки')]");
    private By sauces = By.xpath("//span[contains(text(),'Соусы')]");
    private By fillings = By.xpath("//span[contains(text(),'Начинки')]");

    private By bunsHeader = By.xpath("//h2[text()='Булки']");
    private By saucesHeader = By.xpath("//h2[text()='Соусы']");
    private By fillingsHeader = By.xpath("//h2[text()='Начинки']");

    // Методы действий

    public void buttonBuns() {
        wait.until(ExpectedConditions.elementToBeClickable(sauces)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buns)).click();
    }

    public void buttonSaouces() {
        wait.until(ExpectedConditions.elementToBeClickable(sauces)).click();
    }

    public void buttonFillings() {
        wait.until(ExpectedConditions.elementToBeClickable(fillings)).click();
    }

    public boolean isBunsHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bunsHeader)).isDisplayed();
    }

    public boolean isSaucesHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(saucesHeader)).isDisplayed();
    }


    public boolean isFillingsHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsHeader)).isDisplayed();
    }

}


