import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Requests {

    String Uri = "http://jsonplaceholder.typicode.com";

    public void requestGet(String Element, String postId, int statusCode, String path, String operand) {
        given()
                .baseUri(Uri+Element)
                .basePath("/" + postId + "/")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(statusCode)
                .body(path, equalTo(operand));

    }

    public void negativeRequestGet(String Element, String postId, int statusCode) {
        given()
                .baseUri(Uri+Element)
                .basePath("/" + postId + "/")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(statusCode);
    }

    public void requestPost(String Element, String requestBody, int statusCode) {
        given()
                .baseUri(Uri+Element)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post()
                .then()
                .statusCode(statusCode);
    }
}
