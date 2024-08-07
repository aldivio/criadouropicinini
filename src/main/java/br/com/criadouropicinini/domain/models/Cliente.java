package br.com.criadouropicinini.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "cep")
    private String cep;
    @Column(name = "email")
    private String email;
    @Column(name = "nome_contato")
    private String nomeContato;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    @Column(name = "observacao")
    private String observacao;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Passaro> passaros = new ArrayList<>();

    public Cliente(Long id) {
        this.id= id;
    }
}
