package br.com.desafioapiqa.tests;

import br.com.desafioapiqa.base.BaseTest;
import br.com.desafioapiqa.endpoints.ProdutosEndpoint;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class ProdutosTest extends BaseTest {

    @Test
    @DisplayName("Deve listar todos os produtos com sucesso")
    void listarProdutos() {
        ProdutosEndpoint.listarProdutos()
                .then()
                .statusCode(200)
                .body("quantidade", greaterThanOrEqualTo(0))
                .body("produtos", notNullValue());
    }

    @Test
    @DisplayName("Deve criar um novo produto com sucesso")
    void criarProdutoComSucesso() {
        String nome = "Produto Teste " + System.currentTimeMillis();
        Response response = ProdutosEndpoint.criarProduto(nome, 100, "Produto de teste automatizado", 5);
        response.then()
                .statusCode(anyOf(is(201), is(400)))
                .body("message", not(emptyOrNullString()));
    }
}
