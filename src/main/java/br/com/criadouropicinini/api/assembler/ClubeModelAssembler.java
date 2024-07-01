package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.model.ClubeModel;
import br.com.criadouropicinini.domain.models.Clube;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClubeModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public ClubeModel toModel(Clube clube) {
        return modelMapper.map(clube, ClubeModel.class);
    }

    public List<ClubeModel> toCollectionModel(List<Clube> clubes) {
        return clubes.stream()
                .map(clube -> toModel(clube))
                .collect(Collectors.toList());

    }
}
