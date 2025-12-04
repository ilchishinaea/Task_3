package pageObjectModels;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    //заголовок "Вход"
    private final By headerEntrance = By.xpath(".//*[text() = 'Вход']");
    //инпут "Email"
    private final By inputEmail = By.xpath(".//*[text() = 'Email']");
    //инпут "Пароль"
    private final By inputPassword = By.xpath(".//*[text() = 'Пароль']");
    //кнопка "Войти"
    private final By buttonLogin = By.xpath(".//*[text() = 'Войти']");
    //кнопка "Зарегистрироваться"
    private final By buttonRegister = By.xpath(".//*[text() = 'Зарегистрироваться']");

}
