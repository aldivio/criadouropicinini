create table empresa (
  id bigint not null auto_increment,
  razao_social varchar(60) not null,
  nome_fantasia varchar(30) not null,
  endereco varchar(50) not null,
  bairro varchar(30) not null,
  cidade varchar(30) not null,
  uf varchar(02) not null,
  cep varchar(08) not null,
  telefone varchar(30) not null,
  cnpj varchar(14) not null,
  marca_criador varchar(10) not null,
  inscricao_ibama varchar(20) not null,
  quantidade_digitos_numero_anel int not null default 3,
  layout_arvore_genealogica int not null default 1,
  layout_cracha int not null default 1,

  primary key (id)
)engine=InnoDB default charset=utf8;





create table especie (
  id bigint not null auto_increment,
  nome varchar(20) not null,
  nome_cientifico varchar(60) not null,

  primary key (id)
)engine=InnoDB default charset=utf8;

alter table especie
add constraint uk_especie unique (nome);





create table federacao (
  id bigint not null auto_increment,
  codigo varchar(10) not null,
  nome varchar(60) not null,

  primary key (id)
)engine=InnoDB default charset=utf8;

alter table federacao
add constraint uk_federacao unique (codigo);




create table clube (
  id bigint not null auto_increment,
  codigo varchar(10) not null,
  nome varchar(60) not null,

  primary key (id)
)engine=InnoDB default charset=utf8;

alter table clube
add constraint uk_clube unique (codigo);





create table criador (
  id bigint not null auto_increment,
  codigo varchar(10) not null,
  nome varchar(60) not null,

  primary key (id)
);

alter table criador
add constraint uk_criador unique (codigo);





create table cliente (
  id bigint not null auto_increment,
  nome varchar(60) not null,
  endereco varchar(50),
  bairro varchar(30),
  cidade varchar(30),
  uf varchar(2),
  cep varchar(08),
  telefone varchar(50),
  email varchar(255),
  nome_contato varchar(30),
  cpf_cnpj varchar(14),
  observacao varchar(255),

  primary key (id)
)engine=InnoDB default charset=utf8;





