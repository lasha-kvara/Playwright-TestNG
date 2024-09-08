package ApiMethods;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Api {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api"; // Replace with your API base URI
    }

    public String ListUsers_Get() {
        Response response = RestAssured.given()
                .when()
                .get("/users?page=1") // Endpoint
                .then()
                .statusCode(200)     // Verify if statusCode is 200
                .extract().response(); // Extract the response

        return response.getBody().asString();
    }

    public String SingleUser_Get(int userId) {
        Response response = RestAssured.given()
                .when()
                .get("/users/" + userId) // Endpoint
                .then()
                .statusCode(200)     // Verify if statusCode is 200
                .extract().response(); // Extract the response

        return response.getBody().asString();
    }

    public String CreateUser_Post(String name, String job) {
        String requestBody = "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"job\": \"" + job + "\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users") // Endpoint
                .then()
                .statusCode(201)
                .extract().response(); // Extract the response

        return response.getBody().asString();
    }

    public String CreateUserWithInvalidBody_Post() {

        // The API request doesn't have any validations and the only way to not get 200 status code is
        // to send request with invalid body

        String requestBody = "InvalidBody";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users") // Endpoint
                .then()
                .statusCode(400)
                .extract().response(); // Extract the response

        return response.getBody().asString();
    }

    @Test
    public String DeleteUser_Delete() {
        Response response =RestAssured.given()
                .when()
                .delete("/users/1") // Endpoint
                .then()
                .statusCode(204)
                .extract().response(); // Extract the response

        return response.getBody().asString();
    }
}
