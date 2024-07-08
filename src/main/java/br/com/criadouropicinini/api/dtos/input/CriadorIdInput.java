package br.com.criadouropicinini.api.dtos.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriadorIdInput {
    @NotNull
    private Long id;

}
