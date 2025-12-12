package pageObjectModels;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojoModels.User;

@Getter
@NoArgsConstructor
public class Register extends BasePage {

    public Register(WebDriver driver) {
        super(driver);
    }

    //заголовок "Регистрация"
    private final By headerRegister = By.xpath(".//*[text() = 'Регистрация']");
    //инпут "Имя"
    private final By inputName = By.xpath(".//fieldset[1]/div/div/input");
    //инпут "Email"
    private final By inputEmail = By.xpath(".//fieldset[2]/div/div/input");
    //инпут "Пароль"
    private final By inputPassword = By.xpath(".//fieldset[3]/div/div/input");
    //кнопка "Войти"
    private final By buttonLogin = By.xpath(".//*[text() = 'Войти']");
    //кнопка "Зарегистрироваться"
    private final By buttonRegister = By.xpath(".//*[text() = 'Зарегистрироваться']");
    //ошибка "Некорректный пароль"
    private final By errorText = By.xpath(".//*[text() = 'Некорректный пароль']");


    //------------ действия ------------//

    @Step("Заполнить поля для регистрации данными и нажать на 'Зарегистрироваться': {user} ")
    public void setInputForRegisterAndClickButtonRegisterStep(User user){
        setInputStep(getInputName(), user.getName());
        setInputStep(getInputEmail(), user.getEmail());
        setInputStep(getInputPassword(), user.getPassword());
        clickButtonStep(getButtonRegister());
    }
}
