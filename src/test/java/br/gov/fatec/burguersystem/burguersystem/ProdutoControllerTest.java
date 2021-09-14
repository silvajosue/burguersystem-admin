package br.gov.fatec.burguersystem.burguersystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import br.gov.fatec.burguersystem.burguersystem.controller.ProdutoController;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ProdutoDTO;

public class ProdutoControllerTest {

    static ProdutoController controller;

    @BeforeAll
    public static void inicializar(){
        controller = new ProdutoController();
    }

    @Test
    public void TestaListarControllerNãoNulo(){
        ResponseEntity<List<ProdutoDTO>> lista = controller.listarTodos();
        assertNotNull(lista.getBody());
    }

    // FIXME no momento apenas esse teste esta funcionando corretamente considerando que não tem nada implementado ainda.
    @Test
    public void TestaListarControllerNulo(){
        assertThrows(NullPointerException.class, () -> {
            controller.listarTodos();
        });
    }

    @Test
    public void TestaListarPosicaoUmController(){
        ResponseEntity<List<ProdutoDTO>> lista = controller.listarTodos();
        assertEquals(lista.getBody().get(0), "Coca Cola 2L");
    }
}
