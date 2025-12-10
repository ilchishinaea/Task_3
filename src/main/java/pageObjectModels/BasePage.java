package pageObjectModels;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;

@Getter
@NoArgsConstructor
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
    //заголовок "Соберите бургер"
    private final By headerCollectBurger = By.xpath(".//*[text() = 'Соберите бургер']");
    //кнопка "Булки"
    private final By buttonBuns = By.xpath(".//div[count(*)=1 and span[text() = 'Булки']]");
    //кнопка "Соусы"
    private final By buttonSauces = By.xpath(".//div[count(*)=1 and span[text() = 'Соусы']]");
    //кнопка "Начинки"
    private final By buttonFillings = By.xpath(".//div[count(*)=1 and span[text() = 'Начинки']]");
    //кнопка "Войти в аккаунт"
    private final By buttonLoginToAcc = By.xpath(".//*[text() = 'Войти в аккаунт']");
    //кнопка "Оформить заказ"
    private final By buttonPlaceOrder = By.xpath(".//*[text() = 'Оформить заказ']");


    //------------ действия ------------//

    @Step("Нажать на кнопку: {locator}")
    public void clickButtonStep(By locator){
        driver.findElement(locator).click();
    }

    //вспомогательный метод для классов наследников
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

    @Step("Ожидание появления активного класса")
    public void waitDisplayActiveClass(By locator){
        wait.until(ExpectedConditions.attributeContains(
                locator,
                "class",
                "tab_tab_type_current__2BEPc"
        ));
    }

    @Step("Ожидание отсутсвтия активного класса")
    public void waitNotDisplayActiveClass(By locator){
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(
                locator,
                "class",
                "tab_tab_type_current__2BEPc"
        )));
    }
}