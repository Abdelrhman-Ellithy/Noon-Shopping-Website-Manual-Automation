package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class SearchTest {
    @Test
    public void onlyRelativeNameReturned(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("api/Movies/search?query=Jack")
                .then().assertThat().statusCode(200)
                .contentType("application/json")
                .time(lessThanOrEqualTo(1000L))
                .body("results.title", hasItem("Jack"));

    }
    @Test
    public void acceptsArabicWords(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("api/Movies/search?query=رشدي")
                .then().assertThat().statusCode(200)
                .contentType("application/json")
                .time(lessThanOrEqualTo(1000L))
                .body("results.title",hasSize(2));
    }
    @Test
    public void searchWithWrongSpelling(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("api/Movies/search?query=bad bys")
                .then().assertThat().statusCode(200)
                .contentType("application/json")
                .time(lessThanOrEqualTo(1000L))
                .body("results.title",hasItem("bad boys"));
    }
    @Test
    public void searchWithEmptyQuery(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("api/Movies/search?query=")
                .then()
                .assertThat().time(lessThanOrEqualTo(1000L))
                .statusCode(400)
                .contentType("application/problem+json; charset=utf-8");
    }
    @Test
    public void sqlInjection(){
        given().baseUri("http://movieland.runasp.net/").
                when().get("api/Movies/search?query=select * from movies")
                .then()
                .assertThat().time(lessThanOrEqualTo(1000L))
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
}
