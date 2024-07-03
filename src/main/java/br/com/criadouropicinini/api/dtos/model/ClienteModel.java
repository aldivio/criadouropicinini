package br.com.criadouropicinini.api.dtos.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteModel {

    private long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String email;
    private String nomeContato;
    private String cpfCnpj;
    private String observacao;

}
