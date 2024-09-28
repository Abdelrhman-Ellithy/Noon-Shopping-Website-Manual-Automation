package APITests;
import Ellithium.Utilities.JsonHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
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
