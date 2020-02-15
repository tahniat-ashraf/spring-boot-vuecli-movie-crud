package com.bkash.se.controller;

import com.bkash.se.SpringBootVuejsApplication;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = SpringBootVuejsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class MovieControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void saysHello() {
        when()
                .get("/api/hello")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(is(equalTo(MovieController.HELLO_TEXT)));
    }

    @Test
    public void testFindByName() {

        Map<String, String> map = new HashMap<>();
        map.put("name", "Titanic");

        with().body(map)
                .when()
                .post("/api/findByName")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat();
    }


}
