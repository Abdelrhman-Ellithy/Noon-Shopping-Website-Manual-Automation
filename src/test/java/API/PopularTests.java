package API;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
public class PopularTests {
    @Test
    public void moviesSortedByRating(){
        Response response =given().baseUri("http://movieland.runasp.net/").
                when().get("api/Movies/popular")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThanOrEqualTo(1000L))
                .contentType("application/json;").extract().response();
        List<Float>popularity=response.jsonPath().getList("results.popularity", Float.class);
        List<Float>sorted=popularity.stream().sorted((a, b) -> Float.compare(b, a))
                .collect(Collectors.toList());
        System.out.println(sorted);
        System.out.println(popularity);
        Assert.assertEquals(popularity,sorted,"not sorted by popularity");
    }
}
