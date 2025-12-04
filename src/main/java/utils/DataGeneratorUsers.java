package utils;

import io.qameta.allure.Step;
import pojoModels.User;

import java.util.UUID;

public class DataGeneratorUsers {

    //------------ действия ------------//

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
