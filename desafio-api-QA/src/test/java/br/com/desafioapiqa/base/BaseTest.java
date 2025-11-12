package br.com.desafioapiqa.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
    }
}
