package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.model.PassaroResumoModel;
import br.com.criadouropicinini.domain.models.Passaro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassaroResumoModelAssembler {
    @Autowired
    private ModelMapper modelMapper;



    public PassaroResumoModel toModel(Passaro passaro) {
        return modelMapper.map(passaro, PassaroResumoModel.class);
    }

    public List<PassaroResumoModel> toCollectionModel(List<Passaro> passaros) {
        return passaros.stream()
                .map(passaro -> toModel(passaro))
                .collect(Collectors.toList());

    }
}
