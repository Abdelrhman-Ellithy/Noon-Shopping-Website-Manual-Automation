package API;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class DetailsTests {
    @Test
    public void invalidID(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("/api/Movies/Details/50")
                .then()
                .assertThat()
                .statusCode(404)
                .contentType("application/json; charset=utf-8")
                .time(lessThanOrEqualTo(1000L));
    }
    @Test
    public void invalidParamter(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("/api/Movies/Details/1022789?said=talaat")
                .then()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .time(lessThanOrEqualTo(1000L))
                .statusCode(400);
    }
    @Test
    public void validID(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("/api/Movies/Details/1022789")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json;")
                .body("originalTitle", equalTo("Inside Out 2"))
                .time(lessThanOrEqualTo(1000L));
    }
}
