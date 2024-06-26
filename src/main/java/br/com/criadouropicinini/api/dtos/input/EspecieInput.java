package br.com.criadouropicinini.api.dtos.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspecieInput {

    @NotBlank
    private String nome;
    @NotBlank
    private String nomeCientifico;
}
