package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IMaterialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService implements IMaterialService {

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.
    @Override
    public List<MaterialDTO> listarTodos() {
        return null;
    }
}
