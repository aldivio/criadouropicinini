package br.com.criadouropicinini.api.dtos.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FederacaoIdInput {


    @NotNull
    private Long id;
}
