package tests;

import api.UserApi;
import baseTest.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import pageObjectModels.Login;
import pojoModels.User;

public class BasePageTest extends BaseTest {

    private final UserApi userApi = new UserApi();

    User user;

    Login login;

    @BeforeEach
    public void initModels(){
            login = new Login(driver);
    }

    @ParameterizedTest
    @DisplayName("Переход из личного кабинета в конструктор по клику на кнопку: {locatorButton}")
    @MethodSource("utils.DataGeneratorUsers#goToConstructorData")
    public void openConstructorFromPersAccAndNoAuthClickButton(By locatorButton){
        login.goToLoginPageStep(basePage.getButtonPersonalAccount());
        login.clickButtonStep(locatorButton);
        basePage.waitForVisibleStep(basePage.getHeaderCollectBurger());
    }

    @ParameterizedTest
    @DisplayName("Переход к разделу: {locatorConstructorSection}")
    @MethodSource("utils.DataGeneratorUsers#sectionConstructorData")
    public void goToConstructorSection(By locatorConstructorSection){
        basePage.waitNotDisplayActiveClass(locatorConstructorSection);
        basePage.clickButtonStep(locatorConstructorSection);
        basePage.waitDisplayActiveClass(locatorConstructorSection);
    }

    @Test
    @DisplayName("Переход к разделу: Булки")
    public void goToConstructorSectionBuns(){
        By locatorButtonBuns = basePage.getButtonBuns();
        basePage.clickButtonStep(basePage.getButtonFillings());
        basePage.waitNotDisplayActiveClass(locatorButtonBuns);
        basePage.waitForClickableStep(locatorButtonBuns);
        basePage.clickButtonStep(locatorButtonBuns);
        basePage.waitDisplayActiveClass(locatorButtonBuns);
    }

    @AfterEach
    public void deleteUser(){
        userApi.deleteUserStep(user);
    }

}
