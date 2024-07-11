package br.com.criadouropicinini.domain.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "especie")
public class Especie {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_cientifico")
    private String nomeCientifico;

    public Especie(Long id) {
        this.id = id;
    }
}