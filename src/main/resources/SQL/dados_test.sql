INSERT INTO material (id, active, creation_date, descricao, update_date)
    VALUES (1, 1, '2021-04-12 08:46:18', 'Plástico', null);

INSERT INTO coletor (id, active, creation_date, nome, total_realizado, total_solicitacoes, update_date)
    VALUES (1, 1, '2021-04-12 18:47:33', 'João', 0, 0, null);

INSERT INTO estacao (id, active, bairro, cep, complemento, creation_date, descricao, endereco, estado, municipio, numero, pais, update_date)
    VALUES (1, 1, 'Centro', '14400000', '0', '2021-04-12 18:49:31', 'tambor para reciclável', 'rua de XV janeiro', 'SP', 'Franca', '222', 'BR', null);

INSERT INTO postocoleta (id, active, creation_date, latitude, longitude, observacao, status_instalacao, update_date, coletor_id, estacao_id, material_id)
    VALUES (1, 1, '2021-04-12 18:51:39', null, null, '---', 1, null, 1, 1, 1);

