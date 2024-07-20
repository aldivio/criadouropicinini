package br.com.criadouropicinini.api.dtos.model;

import br.com.criadouropicinini.domain.models.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassaroSexagemModel {

    private Sexo sexo;

    private int numeroSexagem;


}
