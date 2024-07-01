package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.model.CriadorModel;
import br.com.criadouropicinini.domain.models.Criador;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CriadorModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public CriadorModel toModel(Criador criador) {
        return modelMapper.map(criador,
                CriadorModel.class);
    }

    public List<CriadorModel> toCollectionModel(List<Criador> criadouros) {
        return criadouros.stream()
                .map(criador -> toModel(criador))
                .collect(Collectors.toList());

    }
}
