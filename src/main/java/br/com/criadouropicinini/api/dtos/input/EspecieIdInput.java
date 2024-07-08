package br.com.criadouropicinini.api.dtos.input;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspecieIdInput{
    @NotNull
    private Long id;
}
