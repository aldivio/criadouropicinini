package br.com.criadouropicinini.api.dtos.input;

import br.com.criadouropicinini.domain.models.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class PassaroInput {

    @NotNull
    @Valid
    private EspecieIdInput especie;
    @NotNull
    @Valid
    private FederacaoIdInput federacao;
    @NotNull
    @Valid
    private ClubeIdInput  clube;
    @NotNull
    @Valid
    private CriadorIdInput criador;
    @NotBlank
    private String numeroAnel;
    @NotBlank
    private String ano;
    @NotBlank
    private String tamanhoAnel;
    @NotBlank
    private String nome;
    private Sexo sexo;
    private int numeroSexagem;
    private OffsetDateTime dataNascimento;
    private OffsetDateTime dataAquisicao;
    private OffsetDateTime dataSaida;
    private OffsetDateTime dataObito;
    private String causaObito;
    private PassaroPaiInput passaroPai ;
    private PassaroMaeInput passaroMae;
    private ClienteIdInput cliente;
    private BigDecimal numeroCtp;
    private Situacao situacao;
    private String observacao;

}
