package br.gov.fatec.burguersystem.burguersystem;

import br.gov.fatec.burguersystem.burguersystem.controller.MaterialController;
import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

public class MaterialControllerTest {

    MaterialController controller;

    @Before
    public void inicializar(){
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
        assertEquals(lista.getBody().get(0), "Funciona");
    }
}
