--TABELA DE MOEDAS
INSERT INTO public.moeda (moedaid, nome, sigla, simbolo) VALUES(1, 'Real', 'Real', 'R$');

--TABELA DE PAÍSES
INSERT INTO public.pais (paisid, codigopais, continente, nome, sigla, moedaid) VALUES(1, 55, 'AMERICANO', 'Brasil', 'BR', 1);

--TABELA DE ESTADOS/PROVINCIAS
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(1, 11, 'Rondônia', 'RO', 1, 'NORTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(2, 12, 'Acre', 'AC', 1, 'NORTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(3, 13, 'Amazonas', 'AM', 1, 'NORTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(4, 14, 'Roraima', 'RR', 1, 'NORTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(5, 15, 'Pará', 'PA', 1, 'NORTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(6, 16, 'Amapá', 'AP', 1, 'NORTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(7, 17, 'Tocantins', 'TO', 1, 'NORTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(8, 21, 'Maranhão', 'MA', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(9, 22, 'Piauí', 'PI', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(10, 23, 'Ceará', 'CE', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(11, 24, 'Rio Grande do Norte', 'RN', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(12, 25, 'Paraíba', 'PB', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(13, 26, 'Pernambuco', 'PE', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(14, 27, 'Alagoas', 'AL', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(15, 28, 'Sergipe', 'SE', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(16, 29, 'Bahia', 'BA', 1, 'NORDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(17, 31, 'Minas Gerais', 'MG', 1, 'SUDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(18, 32, 'Espírito Santo', 'ES', 1, 'SUDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(19, 33, 'Rio de Janeiro', 'RJ', 1, 'SUDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(20, 35, 'São Paulo', 'SP', 1, 'SUDESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(21, 41, 'Paraná', 'PR', 1, 'SUL');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(22, 42, 'Santa Catarina', 'SC', 1, 'SUL');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(23, 43, 'Rio Grande do Sul', 'RS', 1, 'SUL');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(24, 50, 'Mato Grosso do Sul', 'MS', 1, 'CENTROOESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(25, 51, 'Mato Grosso', 'MT', 1, 'CENTROOESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(26, 52, 'Goiás', 'GO', 1, 'CENTROOESTE');
INSERT INTO public.estado (estadoid, ibge, nome, sigla, paisid, regiaoestado) VALUES(27, 53, 'Distrito Federal', 'DF', 1, 'CENTROOESTE');

--TABELA DE CIDADES
INSERT INTO public.cidade (cidadeid, nome, estadoid, paisid) VALUES(1, 'Pato Branco', 21, 1);
INSERT INTO public.cidade (cidadeid, nome, estadoid, paisid) VALUES(2, 'Clevelândia', 21, 1);
INSERT INTO public.cidade (cidadeid, nome, estadoid, paisid) VALUES(3, 'Mariópolis', 21, 1);
INSERT INTO public.cidade (cidadeid, nome, estadoid, paisid) VALUES(4, 'Coronel Vivida', 21, 1);

--TABELA DE BAIRROS
INSERT INTO public.bairro (bairroid, nome, cidadeid, estadoid, paisid) VALUES(1, 'Centro', 1, 21, 1);
INSERT INTO public.bairro (bairroid, nome, cidadeid, estadoid, paisid) VALUES(2, 'Centro', 2, 21, 1);
INSERT INTO public.bairro (bairroid, nome, cidadeid, estadoid, paisid) VALUES(3, 'Centro', 3, 21, 1);
INSERT INTO public.bairro (bairroid, nome, cidadeid, estadoid, paisid) VALUES(4, 'Centro', 4, 21, 1);

--TABELA DE ENDEREÇOS
INSERT INTO public.endereco (enderecoid, cep, latitude, longitude, nome, numero, bairroid, cidadeid, estadoid, paisid) VALUES(1, 85530220, NULL, NULL, 'Tapejara', '320', 1, 1, 21, 1);
INSERT INTO public.endereco (enderecoid, cep, latitude, longitude, nome, numero, bairroid, cidadeid, estadoid, paisid) VALUES(2, 85530000, NULL, NULL, 'Major Diogo Ribeiro', '540', 1, 1, 21, 1);
INSERT INTO public.endereco (enderecoid, cep, latitude, longitude, nome, numero, bairroid, cidadeid, estadoid, paisid) VALUES(3, 85455255, NULL, NULL, 'Nome da rua 1', '659', 1, 1, 21, 1);
INSERT INTO public.endereco (enderecoid, cep, latitude, longitude, nome, numero, bairroid, cidadeid, estadoid, paisid) VALUES(4, 58545554, NULL, NULL, 'Nome da rua 2', '984', 1, 1, 21, 1);

-- UNIDADES DE TESTE
INSERT INTO public.unidade (unidadeid, ativo, email, nome, principal, tipoendereco, enderecoid) VALUES(1, true, 'email.unidade@unidade.com', 'Nome da Unidade/Estabelecimento', true, 'EMPRESARIAL', 1);
INSERT INTO public.unidade (unidadeid, ativo, email, nome, principal, tipoendereco, enderecoid) VALUES(2, true, 'email.unidade2@unidade.2com', 'Outra Unidade de Teste', false, 'EMPRESARIAL', 2);

-- CATEGORIAS DE PRODUTOS
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(1, true, '2021-10-04 17:54:41.000', 'Saúde e Beleza');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(2, true, '2021-10-04 17:54:41', 'Casa, Cosinha e Decoração');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(3, true, '2021-10-04 17:54:41.000', 'Roupas Femininas');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(4, true, '2021-10-04 17:54:41', 'Roupas Masculinas');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(5, true, '2021-10-04 17:54:41.000', 'Acessórios de Moda');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(6, true, '2021-10-04 17:54:41', 'Bebês e Crianças');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(7, true, '2021-10-04 17:54:41.000', 'Brinquedos e Hobbies');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(8, true, '2021-10-04 17:54:41', 'Bolsas');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(9, true, '2021-10-04 17:54:41.000', 'Calçados');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(10, true, '2021-10-04 17:54:41', 'Animais de Estimação');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(11, true, '2021-10-04 17:54:41.000', 'Livros e Revistas');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(12, true, '2021-10-04 17:54:41', 'Celulares e Acessórios');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(13, true, '2021-10-04 17:54:41.000', 'Joias e Relógios');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(14, true, '2021-10-04 17:54:41.000', 'Informática');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(15, true, '2021-10-04 17:54:41.000', 'Esporte e Lazer');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(16, true, '2021-10-04 17:54:41.000', 'Acessórios para Veículos');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(17, true, '2021-10-04 17:54:41.000', 'Eletros e Portáteis');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(18, true, '2021-10-04 17:54:41.000', 'Papelaria');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(19, true, '2021-10-04 17:54:41.000', 'Alimentos e Bebidas');
INSERT INTO public.categoriaproduto (categoriaprodutoid, ativo, datahoracadastro, nome) VALUES(20, true, '2021-10-04 17:54:41.000', 'Áudios Eletrônicos e Câmeras');

--RELACIONAMENTO UNIDADE DA CATEGORIA
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 1);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 2);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 3);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 4);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 5);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 6);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 7);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 8);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 9);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 10);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 11);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 12);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 13);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 14);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 15);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 16);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 17);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 18);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 19);
INSERT INTO public.relunidadecategoriaproduto (unidadeid, categoriaprodutoid) VALUES(1, 20);

--PRODUTOS DE TESTE
INSERT INTO public.produto (produtoid, ativo, datacadastro, descricao, nome, preco, versao) VALUES(1, true, '2021-10-04 17:54:41.000', 'Caixinha de som portátil charge mini bluetooth. Mini caixinha de som portátil. Acompanha caixa protetora. Resistente a respingos de água. Apertar o botão M (Mode) para alternar entre as funções disponíveis: Bluetooth, Radio FM e Pendrive/Cartão SD.', 'Teste Pendrive Cartão', 105.99, 0);
INSERT INTO public.produto (produtoid, ativo, datacadastro, descricao, nome, preco, versao) VALUES(2, true, '2021-10-04 17:54:41.000', 'Luminária de LED Colorido Musical com Bluetooth Wireless 12W Bivolt com Controle Lâmpada E27 Branca', 'Luminária de LED Colorido Musical com Bluetooth Wireless 12W Bivolt com Controle Lâmpada E27 Branca', 26.99, 0);
INSERT INTO public.produto (produtoid, ativo, datacadastro, descricao, nome, preco, versao) VALUES(3, true, '2021-10-04 17:54:41.000', 'Conversor Smart Tv Uhd 4k Transforma Sua Tv Em Smart Tv e Internet Android 10.1 hdmi - Mxq Media Player com processador quad core de altiss&iacute;mo desempenho e baixo consumo de energia, ideal para reprodu&ccedil;&atilde;o de cont&eacute;udo multimidia e sistema de Tv via web como exemplo a entre outras milhares de possibilidade que somente a plataforma Android pode trazer.', 'Tv Box Smart 4k Pro 5g 16gb/ 256gb Wifi Android 10.1 Tv Box Smart MXQ PRO 5G 4K', 127.53, 0);


--CATEGORIAS DE CADA PRODUTO
INSERT INTO public.relcategoriaproduto (categoriaprodutoid, produtoid) VALUES(20, 1);
INSERT INTO public.relcategoriaproduto (categoriaprodutoid, produtoid) VALUES(20, 2);
INSERT INTO public.relcategoriaproduto (categoriaprodutoid, produtoid) VALUES(20, 3);
