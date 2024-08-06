package br.com.criadouropicinini.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "passaro")
public class Passaro{

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;

    @OneToOne
    @JoinColumn(name = "federacao_id", nullable = false)
    private Federacao federacao;

    @OneToOne
    @JoinColumn(name = "clube_id", nullable = false)
    private Clube clube;

    @OneToOne
    @JoinColumn(name = "criador_id", nullable = false)
    private Criador criador;

    @Column(name = "numero_anel")
    private String numeroAnel;

    @Column(name = "ano")
    private String ano;

    @Column(name = "tamanho_anel")
    private String tamanhoAnel;

    @Column(name = "anilha")
    private String anilha;
    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo = Sexo.INDEFINIDO;

    @Column(name = "numero_sexagem")
    private int numeroSexagem;

    @Column(name = "data_nascimento", nullable = false)
    private OffsetDateTime dataNascimento;

    @Column(name = "data_aquisicao", nullable = false)
    private OffsetDateTime dataAquisicao;

    @Column(name = "data_saida", nullable = false)
    private OffsetDateTime dataSaida;

    @Column(name = "data_obito", nullable = false)
    private OffsetDateTime dataObito;

    @Column(name = "causa_obito", nullable = false)
    private String causaObito;

    @ManyToOne
    @JoinColumn(name = "passaro_pai_id")
    private Passaro passaroPai ;
    @ManyToOne
    @JoinColumn(name = "passaro_mae_id")
    private Passaro passaroMae;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente  cliente;

    @Column(name = "numero_ctp")
    private BigDecimal numeroCtp;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private Situacao situacao = Situacao.A_VENDA;

    @Column(name = "observacao")
    private String observacao;


}
