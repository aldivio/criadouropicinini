package br.com.criadouropicinini.api.assembler;


import br.com.criadouropicinini.api.dtos.input.PassaroResumidoInput;
import br.com.criadouropicinini.domain.models.Passaro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassaroResumidoInputDisassembler {

    @Autowired
    private  ModelMapper modelMapper;

    public Passaro toDomainObject(PassaroResumidoInput passaroResumidoInput) {
        return modelMapper.map(passaroResumidoInput, Passaro.class);
    }

    public  void copyToDomainObjtect(PassaroResumidoInput passaroResumidoInput, Passaro passaro) {
        modelMapper.map(passaroResumidoInput, passaro);
    }
}

