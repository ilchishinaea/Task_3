package utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class AssertionsHelper {

    //------------ действия ------------//

    @Step("Статус-код в ответе 200")
    public void checkStatusCode200Step(Response response){
        response.then()
                .assertThat().statusCode(SC_OK);
    }

    @Step("Статус-код в ответе 202")
    public void checkStatusCode202Step(Response response){
        response.then()
                .assertThat().statusCode(SC_ACCEPTED);
    }

    @Step("Поле success в ответе = true")
    public void checkSuccessTrueStep(Response response){
        response.then()
                .assertThat()
                .body("success", equalTo(true));
    }
}
