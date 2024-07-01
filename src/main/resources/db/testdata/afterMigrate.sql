set foreign_key_checks = 0;

delete from empresa;

set foreign_key_checks = 1;

alter table empresa auto_increment = 1;


INSERT INTO empresa (razao_social,nome_fantasia,endereco,bairro,cidade,uf,cep,telefone,cnpj,marca_criador,inscricao_ibama,quantidade_digitos_numero_anel,layout_arvore_genealogica,layout_cracha)
VALUES ('CRIADOURO PICININI LTDA.', 'CRIADOURO PICININI', 'AV. CARDOSO SARAÍVA, 143', 'CENTRO', 'MATIAS BARBOSA', 'MG', '36120000', '(32) 3273-1346', '04704072000170', 'MLP', '74197', '3', '1', '1');