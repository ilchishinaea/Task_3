package tests;

import api.UserApi;
import baseTest.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjectModels.Login;
import pageObjectModels.Profile;
import pojoModels.User;

import static utils.DataGeneratorUsers.randomValidUserStep;

public class ProfileTest extends BaseTest {

    private final UserApi userApi = new UserApi();

    User user;

    Login login;
    Profile profile;

    @BeforeEach
    public void initModels(){
        Allure.step("Создать юзера через API и авторизоваться", () -> {
            login = new Login(driver);
            profile = new Profile(driver);

            user = randomValidUserStep();
            userApi.createUserStep(user);
            login.goToLoginPageStep(basePage.getButtonPersonalAccount());
            login.loginFromEntryPageStep(user);
        });
    }

    @Test
    @DisplayName("Выход по кнопке 'Выйти' в ЛК")
    public void loginByButtonLoginToAccSuccess(){
        basePage.clickButtonStep(basePage.getButtonPersonalAccount());
        profile.waitForVisibleStep(profile.getHeaderProfile());
        profile.clickButtonStep(profile.getButtonExit());
        login.waitForVisibleStep(login.getHeaderEntrance());
    }

    @AfterEach
    public void deleteUser(){
        userApi.deleteUserStep(user);
    }
}
