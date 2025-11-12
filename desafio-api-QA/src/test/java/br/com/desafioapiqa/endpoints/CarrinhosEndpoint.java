package br.com.desafioapiqa.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CarrinhosEndpoint {
    private static final String PATH = "/carrinhos";

    public static Response listarCarrinhos() {
        return given().when().get(PATH);
    }

    public static Response criarCarrinho(String idProduto, int quantidade) {
        String body = String.format("{"produtos":[{"idProduto":"%s","quantidade":%d}]}", idProduto, quantidade);

        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(PATH);
    }
}
