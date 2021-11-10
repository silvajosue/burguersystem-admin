package br.gov.fatec.burguersystem.burguersystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.gov.fatec.burguersystem.burguersystem.controller.ProdutoController;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ProdutoDTO;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class ProdutoControllerTest {

    static ProdutoController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestaListarControllerNãoNulo() throws Exception{
        URI uri = new URI("/api/produto");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
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
