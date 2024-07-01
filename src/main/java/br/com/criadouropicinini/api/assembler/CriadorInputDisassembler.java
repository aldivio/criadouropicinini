package br.com.criadouropicinini.api.assembler;


import br.com.criadouropicinini.api.dtos.input.CriadorInput;
import br.com.criadouropicinini.domain.models.Criador;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriadorInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Criador toDomainObject(CriadorInput criadorInput) {
        return modelMapper.map(criadorInput,
                Criador.class);
    }

    public void copyToDomainObjtect(CriadorInput criadorInput, Criador criador) {
        modelMapper.map(criadorInput, criador);
    }
}

