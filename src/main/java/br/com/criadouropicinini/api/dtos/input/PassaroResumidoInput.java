package br.com.criadouropicinini.api.dtos.input;

import br.com.criadouropicinini.domain.models.Sexo;
import br.com.criadouropicinini.domain.models.Situacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;


@Getter
@Setter
public class PassaroResumidoInput {


    private String nome;
  //  private Sexo sexo;
  //  private int numeroSexagem;
    private OffsetDateTime dataNascimento;
    private OffsetDateTime dataAquisicao;
    private OffsetDateTime dataSaida;
    private OffsetDateTime dataObito;
    private String causaObito;
    private PassaroPaiInput passaroPai ;
    private PassaroMaeInput passaroMae;
    private BigDecimal numeroCtp;
    private Situacao situacao;
    private String observacao;

}
