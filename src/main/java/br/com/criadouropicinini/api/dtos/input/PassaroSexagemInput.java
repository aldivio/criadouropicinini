package br.com.criadouropicinini.api.dtos.input;

import br.com.criadouropicinini.domain.models.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassaroSexagemInput {

    private Sexo sexo;

    private int numeroSexagem;


}
