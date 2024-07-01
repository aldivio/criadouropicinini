package br.com.criadouropicinini.api.dtos.input;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubeInput {
    @NotBlank
    private String codigo;

    @NotBlank
    private String nome;
}
