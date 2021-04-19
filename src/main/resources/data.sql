insert into cliente(nome, cpf, telefone, email, data_de_nascimento) values('Silas Nazare', '123', '98981', 'silas@nazare.com', '1988-9-16');
insert into cliente(nome, cpf, telefone, email, data_de_nascimento) values('Rita Teixeira', '456', '98982', 'rita@teixeira.com', '1996-5-3');
insert into cliente(nome, cpf, telefone, email, data_de_nascimento) values('Italo Santos', '789', '98983', 'italo@santos.com', '1995-6-18');
insert into cliente(nome, cpf, telefone, email, data_de_nascimento) values('Gandalf Teixeira', '101', '98984', 'gandalf@teixeira.com', '2016-5-4');
insert into cliente(nome, cpf, telefone, email, data_de_nascimento) values('Sansa Chagas', '112', '98985', 'sansa@chagas.com', '2020-9-18');

insert into imovel(tipo_de_imovel, endereco, quantidade_de_dormitorios, quantidade_de_banheiros, quantidade_de_suites, metragem, valor_sugerido, observacoes) values('apartamento', 'Calhau', 3, 2, 1, 200, 1290.98, '...');
insert into imovel(tipo_de_imovel, endereco, quantidade_de_dormitorios, quantidade_de_banheiros, quantidade_de_suites, metragem, valor_sugerido, observacoes) values('casa', 'Cohama', 4, 3, 1, 300, 1849.50, '...');
insert into imovel(tipo_de_imovel, endereco, quantidade_de_dormitorios, quantidade_de_banheiros, quantidade_de_suites, metragem, valor_sugerido, observacoes) values('escritório', 'Resnascença', 0, 1, 0, 100, 2098.24, '...');

insert into locacao(imovel_id, cliente_id, ativo, inicio_do_contrato, fim_do_contrato, dia_do_vencimento, percentual_da_multa, valor_do_aluguel, observacoes) values(1, 1, true, '2021-1-10', '2022-1-9', 10, 0.33, 1290.98, '...');

insert into aluguel(locacao_id, data_do_pagamento, valor_pago, observacoes) values(1, '2021-4-18', 1290.98, '...');