package br.com.criadouropicinini.api.assembler;


import br.com.criadouropicinini.api.dtos.input.ClubeInput;
import br.com.criadouropicinini.domain.models.Clube;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClubeInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Clube toDomainObject(ClubeInput clubeInput) {
        return modelMapper.map(clubeInput, Clube.class);
    }

    public void copyToDomainObjtect(ClubeInput clubeInput, Clube clube) {
        modelMapper.map(clubeInput, clube);
    }
}

