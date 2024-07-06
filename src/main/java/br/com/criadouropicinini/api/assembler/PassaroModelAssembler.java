
package br.com.criadouropicinini.api.assembler;

import br.com.criadouropicinini.api.dtos.model.PassaroModel;
import br.com.criadouropicinini.domain.models.Passaro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassaroModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public PassaroModel toModel(Passaro passaro) {
        return modelMapper.map(passaro, PassaroModel.class);
    }

    public List<PassaroModel> toCollectionModel(List<Passaro> passaros) {
        return passaros.stream()
                .map(passaro -> toModel(passaro))
                .collect(Collectors.toList());
    }
}
