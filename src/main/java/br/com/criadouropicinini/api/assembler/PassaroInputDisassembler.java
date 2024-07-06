package br.com.criadouropicinini.api.assembler;


import br.com.criadouropicinini.api.dtos.input.PassaroInput;
import br.com.criadouropicinini.domain.models.Passaro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassaroInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Passaro toDomainObject(PassaroInput passaroInput) {
        return modelMapper.map(passaroInput, Passaro.class);
    }

    public void copyToDomainObjtect(PassaroInput passaroInput, Passaro passaro) {
        modelMapper.map(passaroInput, passaro);
    }
}

