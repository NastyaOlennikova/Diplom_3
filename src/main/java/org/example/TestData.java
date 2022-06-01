package org.example;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestData {

    public void loginAndDeleteTestUser(String email, String password) {
        List<String> emailPass = new ArrayList<>();
        emailPass.add(email);
        emailPass.add(password);
        Credentials credentials = new Credentials(emailPass.get(0), emailPass.get(1));
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(credentials)
                        .when()
                        .post("https://stellarburgers.nomoreparties.site/api/auth/login");
        response.then().assertThat().statusCode(200).and().body("success", equalTo(true));
        String refreshToken = response.path("refreshToken");
        String accessToken = response.path("accessToken");

        given()
                .header("Content-type", "application/json")
                .auth().oauth2(accessToken.substring(7))
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then().assertThat().statusCode(202);
    }
}
