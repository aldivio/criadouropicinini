package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.model.FederacaoModel;
import br.com.criadouropicinini.domain.models.Federacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FederacaoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public FederacaoModel toModel(Federacao federacao) {
        return modelMapper.map(federacao, FederacaoModel.class);
    }

    public List<FederacaoModel> toCollectionModel(List<Federacao> federacoes) {
        return federacoes.stream()
                .map(federacao -> toModel(federacao))
                .collect(Collectors.toList());

    }
}
