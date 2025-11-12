package br.com.desafioapiqa.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProdutosEndpoint {
    private static final String PATH = "/produtos";

    public static Response listarProdutos() {
        return given().when().get(PATH);
    }

    public static Response criarProduto(String nome, int preco, String descricao, int quantidade) {
        String body = String.format("{"nome":"%s","preco":%d,"descricao":"%s","quantidade":%d}",
                nome, preco, descricao, quantidade);

        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(PATH);
    }
}
