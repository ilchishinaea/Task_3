package pageObjectModels;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojoModels.User;

@Getter
@NoArgsConstructor
public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    //заголовок "Вход"
    private final By headerEntrance = By.xpath(".//*[text() = 'Вход']");
    //инпут "Email"
    private final By inputEmail = By.xpath(".//fieldset[1]/div/div/input");
    //инпут "Пароль"
    private final By inputPassword = By.xpath(".//fieldset[2]/div/div/input");
    //кнопка "Войти"
    private final By buttonLogin = By.xpath(".//*[text() = 'Войти']");
    //кнопка "Зарегистрироваться"
    private final By buttonRegister = By.xpath(".//*[text() = 'Зарегистрироваться']");
    //кнопка "Восстановить пароль"
    private final By buttonRecoverPass = By.xpath(".//*[text() = 'Восстановить пароль']");


    //------------ действия ------------//

    @Step("Авторизация юзера: {user} ")
    public void loginFromEntryPageStep(User user){
        waitForVisibleStep(getHeaderEntrance());
        setInputStep(getInputEmail(), user.getEmail());
        setInputStep(getInputPassword(), user.getPassword());
        clickButtonStep(getButtonLogin());
        waitForClickableStep(getButtonPlaceOrder());
    }

    @Step("Переход к странице авторизации")
    public void goToLoginPageStep(By locator){
        clickButtonStep(locator);
        waitForVisibleStep(getHeaderEntrance());
    }
}
