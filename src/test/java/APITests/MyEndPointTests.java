package APITests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class MyEndPointTests {

    @Test
    public void getAllUsersRequest(){
         given()
                .baseUri("https://66e5adf25cc7f9b6273e0f96.mockapi.io/")
        .when()
                .get("Ellithium/api/users")
        .then().assertThat().statusCode(200);
    }
}
