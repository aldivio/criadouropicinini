package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.model.PassaroResumoModel;
import br.com.criadouropicinini.api.dtos.model.PassaroSexagemModel;
import br.com.criadouropicinini.domain.models.Passaro;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassaroSexagemModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public PassaroSexagemModel toModel(Passaro passaro) {
        return modelMapper.map(passaro, PassaroSexagemModel.class);
    }

    public List<PassaroSexagemModel> toCollectionModel(List<Passaro> passaros) {
        return passaros.stream()
                .map(passaro -> toModel(passaro))
                .collect(Collectors.toList());

    }

}
