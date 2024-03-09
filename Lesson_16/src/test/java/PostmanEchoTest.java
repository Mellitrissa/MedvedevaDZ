import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .extract()
                .response();

        response.then().assertThat().statusCode(200);

        response.then().assertThat().body("args.foo1", equalTo("bar1"));
        response.then().assertThat().body("args.foo2", equalTo("bar2"));
        response.then().assertThat().body("headers.'x-forwarded-proto'", equalTo("https"));
        response.then().assertThat().body("headers.'x-forwarded-port'", equalTo("443"));
        response.then().assertThat().body("headers.host", equalTo("postman-echo.com"));
        response.then().assertThat().body("headers.'x-amzn-trace-id'", not(emptyOrNullString()));
        response.then().assertThat().body("headers.'user-agent'", containsString("Apache-HttpClient/4.5.3 (Java/11.0.21)"));
        response.then().assertThat().body("headers.accept", equalTo("*/*"));
        response.then().assertThat().body("headers.'accept-encoding'", equalTo("gzip,deflate"));
        response.then().assertThat().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
    @Test
    public void testPostRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        String requestBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";

        Response response =
                given().log().body()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .post("/post");
        response.then().assertThat().statusCode(200);

        String responseBody = response.getBody().asString();

        Assert.assertTrue(responseBody.contains("\"foo1\": \"bar1\""), "Field 'foo1' value is incorrect");
        Assert.assertTrue(responseBody.contains("\"foo2\": \"bar2\""), "Field 'foo2' value is incorrect");
    }
    @Test
    public void testPutRequest(){
        RestAssured.baseURI = "https://postman-echo.com";
        String requestBody = "{\"foo1\": \"This is expected to be sent back as part of response body.\"}";

        Response response =
                given().log().body()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .put("/put");
        response.then().assertThat().statusCode(200);
        String responseBody = response.getBody().asString();

        Assert.assertTrue(responseBody.contains("\"foo1\": \"This is expected to be sent back as part of response body.\""), "Field 'foo1' value is incorrect");
    }
    @Test
    public void testPatchRequest(){
        RestAssured.baseURI = "https://postman-echo.com";
        String requestBody = "{\"foo1\": \"This is expected to be sent back as part of response body.\"}";

        Response response =
                given().log().body()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .patch("/patch");
        response.then().assertThat().statusCode(200);
        String responseBody = response.getBody().asString();

        Assert.assertTrue(responseBody.contains("\"foo1\": \"This is expected to be sent back as part of response body.\""), "Field 'foo1' value is incorrect");
    }
    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        String requestBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";

        Response response =
                given().log().body()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .delete("/delete");
        response.then().log().body().assertThat().statusCode(200);
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"foo1\": \"bar1\""), "Field 'foo1' value is incorrect");
        Assert.assertTrue(responseBody.contains("\"foo2\": \"bar2\""), "Field 'foo2' value is incorrect");
    }
}

