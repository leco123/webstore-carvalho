-- MOEDAS
CREATE TABLE public.moeda (
                              moedaid int8 NOT NULL,
                              nome varchar(255) NOT NULL,
                              sigla varchar(6) NOT NULL,
                              simbolo varchar(5) NOT NULL,
                              CONSTRAINT moeda_pkey PRIMARY KEY (moedaid),
                              CONSTRAINT uk_moeda_sigla UNIQUE (sigla),
                              CONSTRAINT uk_simbolo UNIQUE (simbolo));
CREATE INDEX moeda_nome ON public.moeda USING btree (nome);

-- PAÍSES
CREATE TABLE public.pais (
                             paisid int8 NOT NULL,
                             codigopais int4 NOT NULL,
                             continente varchar(255) NOT NULL,
                             nome varchar(80) NOT NULL,
                             sigla varchar(5) NOT NULL,
                             moedaid int8 NOT NULL,
                             CONSTRAINT pais_pkey PRIMARY KEY (paisid),
                             CONSTRAINT uk_pais_sigla UNIQUE (sigla),
                             CONSTRAINT uk_paiscodigo_pais UNIQUE (codigopais),
                             CONSTRAINT fk_pais_moeda FOREIGN KEY (moedaid) REFERENCES public.moeda(moedaid));
CREATE INDEX pais_nome ON public.pais USING btree (nome);

-- ESTADOS/PROVÍNCIAS
CREATE TABLE public.estado (
                               estadoid int8 NOT NULL,
                               ibge int4 NOT NULL,
                               nome varchar(255) NOT NULL,
                               sigla varchar(3) NOT NULL,
                               paisid int8 NOT NULL,
                               regiaoEstado varchar(20) NOT NULL,
                               CONSTRAINT estado_pkey PRIMARY KEY (estadoid),
                               CONSTRAINT uk_estado_ibge UNIQUE (ibge),
                               CONSTRAINT uk_estado_sigla UNIQUE (sigla),
                               CONSTRAINT fk_estado_pais FOREIGN KEY (paisid) REFERENCES public.pais(paisid)
);
CREATE INDEX estado_nome ON public.estado USING btree (nome);

--CIDADES
CREATE TABLE public.cidade (
                               cidadeid int8 NOT NULL,
                               nome varchar(255) NOT NULL,
                               estadoid int8 NOT NULL,
                               paisid int8 NOT NULL,
                               CONSTRAINT cidade_pkey PRIMARY KEY (cidadeid),
                               CONSTRAINT fk_cidade_estado FOREIGN KEY (estadoid) REFERENCES public.estado(estadoid),
                               CONSTRAINT fk_cidade_pais FOREIGN KEY (paisid) REFERENCES public.pais(paisid));
CREATE INDEX cidade_nome ON public.cidade USING btree (nome);

--BAIRROS
CREATE TABLE public.bairro (
                               bairroid int8 NOT NULL,
                               nome varchar(255) NOT NULL,
                               cidadeid int8 NOT NULL,
                               estadoid int8 NOT NULL,
                               paisid int8 NOT NULL,
                               CONSTRAINT bairro_pkey PRIMARY KEY (bairroid),
                               CONSTRAINT fk_bairro_cidade FOREIGN KEY (cidadeid) REFERENCES public.cidade(cidadeid),
                               CONSTRAINT fk_bairro_estado FOREIGN KEY (estadoid) REFERENCES public.estado(estadoid),
                               CONSTRAINT fk_bairro_pais FOREIGN KEY (paisid) REFERENCES public.pais(paisid)
);
CREATE INDEX bairro_nome ON public.bairro USING btree (nome);

CREATE TABLE public.endereco (
                                 enderecoid int8 NOT NULL,
                                 cep int8 NOT NULL,
                                 latitude varchar(255) NULL,
                                 longitude varchar(255) NULL,
                                 nome varchar(255) NOT NULL,
                                 numero varchar(255) NULL,
                                 bairroid int8 NOT NULL,
                                 cidadeid int8 NOT NULL,
                                 estadoid int8 NOT NULL,
                                 paisid int8 NOT NULL,
                                 CONSTRAINT endereco_pkey PRIMARY KEY (enderecoid),
                                 CONSTRAINT fk_endereco_bairro FOREIGN KEY (bairroid) REFERENCES public.bairro(bairroid),
                                 CONSTRAINT fk_endereco_cidade FOREIGN KEY (cidadeid) REFERENCES public.cidade(cidadeid),
                                 CONSTRAINT fk_endereco_estado FOREIGN KEY (estadoid) REFERENCES public.estado(estadoid),
                                 CONSTRAINT fk_endereco_pais FOREIGN KEY (paisid) REFERENCES public.pais(paisid)
);
CREATE INDEX endereco_nome ON public.endereco USING btree (nome);

--UNIDADES/ESTABELECIMENTO
CREATE TABLE public.unidade (
                                unidadeid int8 NOT NULL,
                                ativo bool NOT NULL,
                                email varchar(80) NOT NULL,
                                nome varchar(255) NOT NULL,
                                principal bool NOT NULL,
                                tipoendereco varchar(255) NOT NULL,
                                enderecoid int8 NOT NULL,
                                CONSTRAINT uk_unidade_principal UNIQUE (principal),
                                CONSTRAINT unidade_pkey PRIMARY KEY (unidadeid),
                                CONSTRAINT fk_unidade_endereco FOREIGN KEY (enderecoid) REFERENCES public.endereco(enderecoid)
);
CREATE INDEX unid_nome ON public.unidade USING btree (nome);

--CATEGORIA DOS PRODUTOS
CREATE TABLE public.categoriaproduto (
                                         categoriaprodutoid int8 NOT NULL,
                                         ativo bool NOT NULL,
                                         datahoracadastro timestamp NOT NULL,
                                         nome varchar(80) NOT NULL,
                                         CONSTRAINT categoriaproduto_pkey PRIMARY KEY (categoriaprodutoid)
);
CREATE INDEX categoriaproduto_nome ON public.categoriaproduto USING btree (nome);

--PRODUTOS
CREATE TABLE public.produto (
                                produtoid int8 NOT NULL,
                                ativo bool NOT NULL,
                                datacadastro timestamp NULL,
                                descricao text NOT NULL,
                                nome varchar(255) NOT NULL,
                                preco numeric(19, 2) NOT NULL,
                                versao int4 NOT NULL,
                                CONSTRAINT produto_pkey PRIMARY KEY (produtoid)
);
CREATE INDEX produto_nome ON public.produto USING btree (nome);

--RELACIONAMENTO ENTRE UNIDADE E CATEGORIAS DOS PRODUTOS
CREATE TABLE public.relunidadecategoriaproduto (
                                                   unidadeid int8 NOT NULL,
                                                   categoriaprodutoid int8 NOT NULL,
                                                   CONSTRAINT fk_rel_categoriaproduto_unidade FOREIGN KEY (categoriaprodutoid) REFERENCES public.unidade(unidadeid),
                                                   CONSTRAINT fk_rel_unidade_categoriaproduto FOREIGN KEY (unidadeid) REFERENCES public.categoriaproduto(categoriaprodutoid)
);

--RELACIONAMENTO ENTRE CATEGORIA E PRODUTOS
CREATE TABLE public.relcategoriaproduto (
                                            categoriaprodutoid int8 NOT NULL,
                                            produtoid int8 NOT NULL,
                                            CONSTRAINT fk_rel_categoria_produto FOREIGN KEY (categoriaprodutoid) REFERENCES public.produto(produtoid),
                                            CONSTRAINT fk_rel_categoriaproduto_produto FOREIGN KEY (produtoid) REFERENCES public.categoriaproduto(categoriaprodutoid)
);


--SEQUÊNCIAS
CREATE SEQUENCE public.seq_bairro_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_categoria_produto_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;


CREATE SEQUENCE public.seq_cidade_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_endereco_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_estado_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_moeda_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_pais_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_produto_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_unidade_api
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;