package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjectModels.Login;
import pageObjectModels.Register;
import pojoModels.User;
import api.UserApi;
import static utils.DataGeneratorUsers.*;

public class RegisterTest extends BaseTest {

    private final UserApi userApi = new UserApi();

    User user;

    Login login;
    Register register;

    @BeforeEach
    public void initModels(){
        login = new Login(driver);
        register = new Register(driver);

        basePage.clickButtonStep(basePage.getButtonPersonalAccount());
        login.waitForVisibleStep(login.getHeaderEntrance());
        login.clickButtonStep(login.getButtonRegister());
        register.waitForVisibleStep(register.getHeaderRegister());
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registerValidUserSuccess(){
        user = randomValidUserStep();

        register.setInputStep(register.getInputName(), user.getName());
        register.setInputStep(register.getInputEmail(), user.getEmail());
        register.setInputStep(register.getInputPassword(), user.getPassword());

        register.clickButtonStep(register.getButtonRegister());

        login.waitForVisibleStep(login.getHeaderEntrance());
    }

    @Test
    @DisplayName("Неуспешная регистрация - ошибка для некорректного пароля")
    public void registerUserWithInvalidPassFail(){
        user = randomUserWithInvalidPassStep();

        register.setInputStep(register.getInputName(), user.getName());
        register.setInputStep(register.getInputEmail(), user.getEmail());
        register.setInputStep(register.getInputPassword(), user.getPassword());

        register.clickButtonStep(register.getButtonRegister());

        register.waitForVisibleStep(register.getErrorText());
    }

    @AfterEach
    public void deleteUser(){
        userApi.deleteUserStep(user);
    }
}
