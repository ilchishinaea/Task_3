package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojoModels.User;
import pojoModels.UserResponse;
import utils.AssertionsHelper;

import static config.RequestSpec.requestSpec;
import static io.restassured.RestAssured.given;

public class UserApi {

    private final AssertionsHelper assertionsHelper = new AssertionsHelper();

    //------------ эндпоинты ------------//

    private static final String REGISTER_USER = "api/auth/register";
    private static final String LOGIN_USER = "api/auth/login";
    private static final String DATA_USER = "api/auth/user";


    //------------ действия ------------//

    @Step("Создание пользователя: {user}")
    public void createUserStep(User user){
        Response response = given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(REGISTER_USER);
        assertionsHelper.checkStatusCode200Step(response);
        assertionsHelper.checkSuccessTrueStep(response);
    }

    @Step("Удаление пользователя, если существует: {user}")
    public String deleteUserStep(User user) {
        if (user == null) {
            return "Объект не инициализирован";
        }

        UserResponse userResponse = given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(LOGIN_USER).as(UserResponse.class);

        if (userResponse.getAccessToken() != null) {
            Response response =
                    given()
                            .spec(requestSpec)
                            .header("Authorization", userResponse.getAccessToken())
                            .when()
                            .delete(DATA_USER);
            assertionsHelper.checkStatusCode202Step(response);
            return "Юзер удален";
        } else {
            return "Юзер не был создан";
        }
    }
}
