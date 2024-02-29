package order;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import static constant.SamokatYandexApi.*;
import static constant.endpoints.Endpoints.*;
import static io.restassured.RestAssured.given;

public class OrderSteps {
    public static RequestSpecification requestSpec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(URL);
    }

    @Step("Создание заказа")
    public ValidatableResponse createNewOrder(OrderModel orderModel) {
        return requestSpec()
                .body(orderModel)
                .when()
                .post(ORDERS_POST_CREATE)
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse getOrderList() {
        return requestSpec()
                .when()
                .get(ORDERS_GET_LIST)
                .then();
    }

    @Step("Отмена заказа")
    public ValidatableResponse cancelOrder(int track) {
        return requestSpec()
                .body(track)
                .when()
                .put(ORDERS_PUT_CANCEL)
                .then();
    }

}