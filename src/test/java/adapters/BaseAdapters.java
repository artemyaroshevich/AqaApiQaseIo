package adapters;

import static io.restassured.RestAssured.given;

public class BaseAdapters {
    String baseUrl = "https://api.qase.io/";

    String post(String body, String uri, int statusCode) {

        return
                given()
                        .header("Content-Type", "application/json")
                        .header("Token", "e88e2085d8d7c3b3594d8e3c82d77989157aa7c3")
                        .body(body)
                .when()
                        .post(baseUrl + uri)
                .then()
                        .log().all()
                        .statusCode(statusCode)
                        .extract().body().asString();
    }

    String get(String uri, int statusCode) {
        return
                given()
                    .header("Content-Type","application/json")
                    .header("Token", "e88e2085d8d7c3b3594d8e3c82d77989157aa7c3")

                .when()
                        .get(baseUrl + uri)
                .then()
                        .log().all()
                        .statusCode(statusCode)
                        .extract().body().asString();
    }

    public void delete(String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "e88e2085d8d7c3b3594d8e3c82d77989157aa7c3").
                when().
                delete(baseUrl + uri).
                then().
                log().all().
                statusCode(200);
    }




}
