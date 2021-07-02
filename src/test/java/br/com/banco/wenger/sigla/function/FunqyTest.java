package br.com.banco.wenger.sigla.function;

import static org.hamcrest.Matchers.notNullValue;

import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class FunqyTest {


    @Test
    public void testConfigChain() {
        RestAssured.given().contentType("application/json")
                .header("ce-specversion", "1.0")
                .header("ce-id", UUID.randomUUID().toString())
                .header("ce-type", "hellofunc")
                .header("ce-source", "test")
                .body("\"Start::defaultChain\"")
                .post("/")
                .then().statusCode(200)
                .header("ce-id", notNullValue())
                .header("ce-type", "annotated")
                .header("ce-source", "nextchain")
                .body(Matchers.containsString("reqStart::defaultChain"));
    }




}
