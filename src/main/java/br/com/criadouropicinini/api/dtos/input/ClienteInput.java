package br.com.criadouropicinini.api.dtos.input;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInput {


    @NotBlank
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
