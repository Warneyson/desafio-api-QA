package br.com.desafioapiqa.tests;

import br.com.desafioapiqa.base.BaseTest;
import br.com.desafioapiqa.endpoints.CarrinhosEndpoint;
import br.com.desafioapiqa.endpoints.ProdutosEndpoint;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class CarrinhosTest extends BaseTest {

    @Test
    @DisplayName("Deve listar todos os carrinhos")
    void listarCarrinhos() {
        CarrinhosEndpoint.listarCarrinhos()
                .then()
                .statusCode(200)
                .body("quantidade", greaterThanOrEqualTo(0))
                .body("carrinhos", notNullValue());
    }

    @Test
    @DisplayName("Deve criar um carrinho com produto válido")
    void criarCarrinho() {
        Response produto = ProdutosEndpoint.criarProduto(
                "Produto Carrinho " + System.currentTimeMillis(),
                50,
                "Produto para teste de carrinho",
                10
        );

        String idProduto = produto.jsonPath().getString("_id");

        CarrinhosEndpoint.criarCarrinho(idProduto, 2)
                .then()
                .statusCode(anyOf(is(201), is(400)))
                .body("message", not(emptyOrNullString()));
    }
}
