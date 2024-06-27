package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.input.EspecieInput;
import br.com.criadouropicinini.domain.models.Especie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EspecieInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    public Especie toDomainObject(EspecieInput especieInput){
        return modelMapper.map(especieInput, Especie.class);
    }
    public void copyToDomainObjtect(EspecieInput especieInput , Especie especie){
        modelMapper.map(especieInput, especie);
    }
}
