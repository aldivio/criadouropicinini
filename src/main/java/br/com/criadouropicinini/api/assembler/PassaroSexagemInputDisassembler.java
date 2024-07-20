package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.input.PassaroSexagemInput;
import br.com.criadouropicinini.domain.models.Passaro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassaroSexagemInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Passaro toDomainObject(PassaroSexagemInput passaroSexagemInput) {
        return modelMapper.map(passaroSexagemInput, Passaro.class);
    }

    public void copyToDomainObjtect(PassaroSexagemInput passaroSexagemInput, Passaro passaro) {
        modelMapper.map(passaroSexagemInput, passaro);
    }

}
