package br.com.criadouropicinini.api.dtos.model;

import br.com.criadouropicinini.domain.models.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class PassaroModel {

    private Long id;
    private EspecieModel especie;
    private FederacaoModel federacao;
    private ClubeModel clube;
    private CriadorModel criador;
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
    //passaro_pai_id bigint,
    //passaro_mae_id bigint,
    private ClienteModel cliente;

    private BigDecimal numeroCtp;
    private Situacao situacao;

    private String observacao;

}
