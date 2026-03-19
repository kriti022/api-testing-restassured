package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    @Test
    public void getUsersTest() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createUserTest() {
        String requestBody = "{\"name\":\"kriti\",\"job\":\"qa\"}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("https://reqres.in/api/users");

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
