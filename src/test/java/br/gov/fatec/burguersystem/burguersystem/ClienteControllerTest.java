package br.gov.fatec.burguersystem.burguersystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.util.List;

import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.gov.fatec.burguersystem.burguersystem.controller.ClienteController;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ClienteDTO;
import br.gov.fatec.burguersystem.burguersystem.controller.EnderecoController;
import br.gov.fatec.burguersystem.burguersystem.model.dto.EnderecoDTO;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    static ClienteController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestaListarControllerNãoNulo() throws Exception{
        URI uri = new URI("/api/cliente");

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
		URI uri = new URI("/cliente/cadastrarCliente");
		
        //Vincula o material 1 com o produto 1
		ClienteDTO cliente = new ClienteDTO();
		cliente.setNome("João da Silva");
		cliente.setTelefone("(16)99999-8888");
		cliente.setCpf("118.982.620-80");

        //TODO criar uma maneira de conseguir cadastrar varios endereços para o mesmo cliente
		EnderecoDTO endereco = new EnderecoDTO();
        endereco.setCodCliente(cliente.getId());
        endereco.setLogradouro("Rua 5");
        endereco.setNumero(500);
        endereco.setBairro("Bairro 5");
        endereco.setCidade("São Paulo");
        endereco.setComplemento("Apartamento 5-5");
		
		Gson jsonC = new Gson();
		jsonC.toJson(cliente, ClienteDTO.class);

		mockMvc
				.perform(MockMvcRequestBuilders
						.post(uri)
						.content(jsonC.toJson(cliente, ClienteDTO.class))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.is(500));
		
                        
        Gson jsonE = new Gson();
        jsonE.toJson(endereco, EnderecoDTO.class);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(jsonE.toJson(endereco, EnderecoDTO.class))
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
