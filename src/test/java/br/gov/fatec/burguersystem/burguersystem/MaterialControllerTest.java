package br.gov.fatec.burguersystem.burguersystem;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;

import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MaterialControllerTest {

	@Autowired
	private MockMvc mockMvc;

    @Test
    public void TestaListarControllerNãoNulo() throws Exception{
    		URI uri = new URI("/api/material");
    		
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
		URI uri = new URI("/material/cadastrarMaterial");
		
		MaterialDTO material = new MaterialDTO();
		material.setNome("Pão de Hamburguer");
		material.setPreco(new Double(10.5));
		material.setQuantidade(new Double(5));
		material.setUnidadeMedida("UN");
		
		Gson json = new Gson();
		json.toJson(material, MaterialDTO.class);

		mockMvc
				.perform(MockMvcRequestBuilders
						.post(uri)
						.content(json.toJson(material, MaterialDTO.class))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.is(500));
    }

}
//
//    @Test
//    public void TestaListarPosicaoUmController(){
//        ResponseEntity<List<MaterialDTO>> lista = controller.listarTodos();
//        assertEquals(lista.getBody().get(0), "Pão de Hamburger");
//    }

