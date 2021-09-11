package br.gov.fatec.burguersystem.burguersystem;

import br.gov.fatec.burguersystem.burguersystem.controller.MaterialController;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;

import java.util.List;

public class MaterialControllerTest {

    @Test
    public void TestaListarControllerNãoNulo(){
        MaterialController controller = new MaterialController();
        ResponseEntity<List<String>> lista = controller.listarTodos();
        assertNotNull(lista.getBody());
    }

    @Test
    public void TestaListarPosicaoUmController(){
        MaterialController controller = new MaterialController();
        ResponseEntity<List<String>> lista = controller.listarTodos();
        assertEquals(lista.getBody().get(0), "Funciona");
    }
}
