package courierTest;

import courier.CourierAssert;
import courier.CourierModel;
import courier.CourierRandomizer;
import courier.CourierSteps;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;

public class Fixture {
    protected final CourierRandomizer courierRandomizer = new CourierRandomizer();
    CourierSteps courierSteps;
    CourierModel courierModel;
    CourierAssert courierAssert;
    int courierId;

    @Before
    @Step("Создание тестовых данных курьера")
    public void setUp() {
        courierSteps = new CourierSteps();
        courierModel = courierRandomizer.createNewRandomCourier();
        courierAssert = new CourierAssert();
    }

    @After
    @Step("Удаление тестовых данных")
    public void deleteCourier() {
        if (courierId != 0) {
            courierSteps.deleteCourier(courierId);
        }
    }
}
