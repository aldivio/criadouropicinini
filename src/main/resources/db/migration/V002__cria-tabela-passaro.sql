create table passaro (
  id bigint not null auto_increment,
  especie_id bigint not null,
  federacao_id bigint not null,
  clube_id bigint not null,
  criador_id bigint not null,
  numero_anel varchar(06) not null,
  ano varchar(05) not null,
  tamanho_anel varchar(05) not null,
  anilha varchar(50) not null,
  nome varchar(20) not null,
  sexo varchar(10) not null,
  numero_sexagem int,
  data_nascimento date,
  data_aquisicao date,
  data_saida date,
  data_obito date,
  causa_obito varchar(60),
  passaro_pai_id bigint,
  passaro_mae_id bigint,
  cliente_id bigint,
  numero_ctp int,
  situacao varchar(15)default 'A VENDA',
  observacao varchar(255),

  primary key (id),
  INDEX nome_idx (nome ASC) VISIBLE,
  CONSTRAINT fk_passaropai_passaro
    FOREIGN KEY (passaro_pai_id)
    REFERENCES passaro (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_passaromae_passaro
    FOREIGN KEY (passaro_mae_id)
    REFERENCES passaro (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 constraint fk_passaro_especie foreign key (especie_id) references especie (id),
  constraint fk_passaro_federacao foreign key (federacao_id) references federacao (id),
  constraint fk_passaro_clube foreign key (clube_id) references clube (id),
  constraint fk_passaro_criador foreign key (criador_id) references criador (id)



)engine=InnoDB default charset=utf8;