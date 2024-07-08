package br.com.criadouropicinini.api.dtos.input;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubeIdInput {


    @NotNull
    private Long id;
}
