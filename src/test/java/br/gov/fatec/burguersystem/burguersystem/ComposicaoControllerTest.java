package br.gov.fatec.burguersystem.burguersystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.util.List;

import com.google.gson.Gson;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.gov.fatec.burguersystem.burguersystem.controller.ComposicaoController;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ComposicaoDTO;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class ComposicaoControllerTest {

    static ComposicaoController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestaListarControllerNãoNulo() throws Exception{
        URI uri = new URI("/api/composicao");

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
    public void TestaListarControllerNulo() throws Exception {
		URI uri = new URI("/composicao/cadastrarComposicao");
		
        //Vincula o material 1 com o produto 1
		ComposicaoDTO composicao = new ComposicaoDTO();
//		composicao.setCodProduto(1L);
//		composicao.setCodMaterial(1L);
		composicao.setQuantidade(0.06);
		composicao.setUnidadeMedida("KG");
		
		Gson json = new Gson();
		json.toJson(composicao, ComposicaoDTO.class);

		mockMvc
				.perform(MockMvcRequestBuilders
						.post(uri)
						.content(json.toJson(composicao, ComposicaoDTO.class))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.is(500));
    }
    //@Test
    //    public void TestaListarPosicaoUmController(){
    //        ResponseEntity<List<ComposicaoDTO>> lista = controller.listarTodos();
    //        assertEquals(lista.getBody().get(0), "Hamburguer de Carne");
    //    }
}
