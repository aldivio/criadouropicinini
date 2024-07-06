package br.com.criadouropicinini.api.dtos.input;

import br.com.criadouropicinini.domain.models.Cliente;
import br.com.criadouropicinini.domain.models.Clube;
import br.com.criadouropicinini.domain.models.Sexo;
import br.com.criadouropicinini.domain.models.Situacao;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class PassaroInput {

    private EspecieIdInput especie;
    private FederacaoIdInput federacao;
    private ClubeIdInput  clube;
    private CriadorIdInput criador;
    private String numeroAnel;
    private String ano;
    private String tamanhoAnel;
    //private String anilha;
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
    private ClienteIdInput cliente;
    private BigDecimal numeroCtp;
    private Situacao situacao;
    private String observacao;

}
