package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.input.FederacaoInput;
import br.com.criadouropicinini.domain.models.Federacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FederacaoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Federacao toDomainObject(FederacaoInput federacaoInput) {
        return modelMapper.map(federacaoInput, Federacao.class);
    }

    public void copyToDomainObjtect(FederacaoInput federacaoInput, Federacao federacao) {
        modelMapper.map(federacaoInput, federacao);
    }
}
