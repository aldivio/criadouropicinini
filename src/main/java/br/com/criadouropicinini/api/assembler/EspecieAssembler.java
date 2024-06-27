package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.model.EspecieModel;
import br.com.criadouropicinini.domain.models.Especie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EspecieAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EspecieModel toModel(Especie especie) {
        return modelMapper.map(especie, EspecieModel.class);
    }

    public List<EspecieModel> toCollectionModel(List<Especie> especies) {
        return especies.stream()
                .map(especie -> toModel(especie))
                .collect(Collectors.toList());

    }
}
