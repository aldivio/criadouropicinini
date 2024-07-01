package br.com.criadouropicinini.api.dtos.input;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriadorInput {
    @NotBlank
    private String codigo;

    @NotBlank
    private String nome;
}
