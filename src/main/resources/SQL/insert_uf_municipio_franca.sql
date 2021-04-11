DELETE FROM municipio;
DELETE FROM uf;
INSERT INTO uf (cod_uf, habilitado, nome_uf) VALUES (35, 1,'São Paulo');
INSERT INTO municipio (cod_mun, habilitado, nome_municipio, uf_cod_uf) VALUES (3516200, 1, 'Franca', 35);