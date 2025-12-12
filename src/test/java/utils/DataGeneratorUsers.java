package utils;

import io.qameta.allure.Step;
import org.junit.jupiter.params.provider.Arguments;
import pageObjectModels.Login;
import pojoModels.User;
import java.util.UUID;
import java.util.stream.Stream;
import pageObjectModels.BasePage;

public class DataGeneratorUsers {

    //------------ действия ------------//

    @Step("Переход в конструктор")
    public static Stream<Arguments> goToConstructorData(){
        Login login = new Login();
        return Stream.of(
                Arguments.of(login.getButtonConstructor()),
                Arguments.of(login.getButtonLogo())
        );
    }

    @Step("Переход к разделу конструктора")
    public static Stream<Arguments> sectionConstructorData(){
        BasePage basePage = new BasePage();
        return Stream.of(
                Arguments.of(basePage.getButtonFillings()),
                Arguments.of(basePage.getButtonSauces())
        );
    }

    @Step("Инициализация валидного рандомного юзера c почтой, паролем и именем")
    public static User randomValidUserStep(){
        return new User(
                randomEmail(),
                randomPassword(),
                randomName()
        );
    }

    @Step("Инициализация рандомного юзера c почтой, невалидным паролем и именем")
    public static User randomUserWithInvalidPassStep(){
        return new User(
                randomEmail(),
                randomInvalidPassword(),
                randomName()
        );
    }

    @Step("Генерация рандомной почты")
    public static String randomEmail() {
        return "user_" + UUID.randomUUID().toString().substring(0, 8) + "@test.ru";
    }

    @Step("Генерация рандомного пароля")
    public static String randomPassword() {
        return "pass_" + UUID.randomUUID().toString().substring(0, 6);
    }

    @Step("Генерация рандомного имени")
    public static String randomName() {
        return "name_" + UUID.randomUUID().toString().substring(0, 6);
    }

    @Step("Генерация рандомного невалидного пароля")
    public static String randomInvalidPassword() {
        return UUID.randomUUID().toString().substring(0, 5);
    }
}
