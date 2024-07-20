package br.com.criadouropicinini.api.dtos.model;

import br.com.criadouropicinini.domain.models.Sexo;
import br.com.criadouropicinini.domain.models.Situacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class PassaroResumoModel {

    private Long id;
    private EspecieResumoModel especie;
    private FederacaoResumoModel federacao;
    private ClubeResumoModel clube;
    private CriadorResumoModel criador;
    private String numeroAnel;
    private String ano;
    private String tamanhoAnel;
    private String anilha;
    private String nome;
    private Sexo sexo;
    private int numeroSexagem;
    private OffsetDateTime dataNascimento;
    private OffsetDateTime dataAquisicao;
    private OffsetDateTime dataSaida;
    private OffsetDateTime dataObito;
    private String causaObito;
    private PassaroPaiResumoModel passaroPai;
    private PassaroMaeResumoModel passaroMae;
    private ClienteResumoModel cliente;

    private BigDecimal numeroCtp;
    private Situacao situacao;
    private String observacao;


}
