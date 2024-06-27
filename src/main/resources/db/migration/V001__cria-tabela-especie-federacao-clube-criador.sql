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

create table clube (
  id bigint not null auto_increment,
  codigo varchar(10) not null,
  nome varchar(60) not null,

  primary key (id)
)engine=InnoDB default charset=utf8;

create table criador (
  id bigint not null auto_increment,
  codigo varchar(10) not null,
  nome varchar(60) not null,

  primary key (id)
);

