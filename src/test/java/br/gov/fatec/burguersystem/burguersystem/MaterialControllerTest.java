package br.gov.fatec.burguersystem.burguersystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import br.gov.fatec.burguersystem.burguersystem.controller.MaterialController;
import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;

public class MaterialControllerTest {

    static MaterialController controller;

    @BeforeAll
    public static void inicializar(){
        controller = new MaterialController();
    }

    @Test
    public void TestaListarControllerNãoNulo(){
        ResponseEntity<List<MaterialDTO>> lista = controller.listarTodos();
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
        ResponseEntity<List<MaterialDTO>> lista = controller.listarTodos();
        assertEquals(lista.getBody().get(0), "Pão de Hamburger");
    }
}
