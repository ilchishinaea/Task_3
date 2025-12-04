package pageObjectModels;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Getter
public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //кнопка "Личный кабинет"
    private final By buttonPersonalAccount = By.xpath(".//*[text() = 'Личный Кабинет']");
    //кнопка "Конструктор"
    private final By buttonConstructor = By.xpath(".//*[text() = 'Конструктор']");
    //кнопка логотип
    private final By buttonLogo = By.className("AppHeader_header__logo__2D0X2");
    //кнопка "Булки"
    private final By buttonBuns = By.xpath(".//*[text() = 'Булки']");
    //кнопка "Соусы"
    private final By buttonSauces = By.xpath(".//*[text() = 'Соусы']");
    //кнопка "Начинки"
    private final By buttonFillings = By.xpath(".//*[text() = 'Начинки']");
    //кнопка "Войти в аккаунт"
    private final By buttonLoginToAcc = By.xpath(".//*[text() = 'Войти в аккаунт']");
    //кнопка "Оформить заказ"
    private final By buttonPlaceOrder = By.xpath(".//*[text() = 'Оформить заказ']");
    //кнопка "Флюоресцентная булка R2-D3"
    private final By someBun = By.xpath(".//*[text() = 'Флюоресцентная булка R2-D3']");
    //кнопка "Соус Spicy-X"
    private final By someSauce = By.xpath(".//*[text() = 'Соус Spicy-X']");
    //кнопка "Мясо бессмертных моллюсков Protostomia"
    private final By someFilling = By.xpath(".//*[text() = 'Мясо бессмертных моллюсков Protostomia']");


    //------------ действия ------------//

    @Step("Нажать на кнопку: {locator}")
    public void clickButtonStep(By locator){
        driver.findElement(locator).click();
    }

    @Step("Заполнить поле: {locator} значением: {value}")
    public void setInputStep(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    //------------ ожидания ------------//

    @Step("Ожидание видимости элемента: {locator}")
    public void waitForVisibleStep(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Ожидание кликабельности элемента: {locator}")
    public void waitForClickableStep(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
