package tests;

import api.UserApi;
import baseTest.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjectModels.Login;
import pageObjectModels.Register;
import pojoModels.User;
import static utils.DataGeneratorUsers.randomValidUserStep;

public class LoginTest extends BaseTest {

    private final UserApi userApi = new UserApi();

    User user;

    Login login;
    Register register;

    @BeforeEach
    public void initModels(){
        Allure.step("Создать юзера через API", () -> {
            login = new Login(driver);
            register = new Register(driver);

            user = randomValidUserStep();
            userApi.createUserStep(user);
        });
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    public void loginByButtonLoginToAccSuccess(){
        login.goToLoginPageStep(basePage.getButtonLoginToAcc());
        login.loginFromEntryPageStep(user);
    }

    @Test
    @DisplayName("Вход по кнопке 'Личный кабинет' на главной")
    public void loginByButtonPersonalAccountSuccess(){
        login.goToLoginPageStep(basePage.getButtonPersonalAccount());
        login.loginFromEntryPageStep(user);
    }

    @Test
    @DisplayName("Вход по кнопке 'Зарегистрироваться'")
    public void loginByButtonRegisterSuccess(){
        basePage.clickButtonStep(basePage.getButtonPersonalAccount());
        login.clickButtonStep(login.getButtonRegister());
        login.goToLoginPageStep(register.getButtonLogin());
        login.loginFromEntryPageStep(user);
    }

    @Test
    @DisplayName("Вход по кнопке 'Восстановить пароль'")
    public void loginByButtonRecoverPassSuccess(){
        basePage.clickButtonStep(basePage.getButtonPersonalAccount());
        login.clickButtonStep(login.getButtonRecoverPass());
        login.goToLoginPageStep(register.getButtonLogin());
        login.loginFromEntryPageStep(user);
    }

    @AfterEach
    public void deleteUser(){
        userApi.deleteUserStep(user);
    }
}
