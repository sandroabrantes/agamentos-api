DELETE FROM conta_paga;

ALTER SEQUENCE conta_paga_id_seq RESTART WITH 1;




INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'ENERGIA ELÉTRICA', 200.56, '2022-01-11' , '2022-01-16', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'CELULAR', 65.22, '2022-01-14' , '2022-01-18', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'FACULDADE DE ENGENHARIA', 2000.74, '2022-01-17' , '2022-01-22', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'CURSO DE INGLÊS', 200.00, '2022-01-10' , '2022-01-13', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'ESCOLA DE TÁCIO', 420.25, '2022-01-12' , '2022-01-15', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'ESCOLA DE THALES', 350.50, '2022-01-15' , '2022-01-16', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'CARTÃO DE CRÉDITO VISA', 1300.33, '2022-01-17' , '2022-01-19', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'AULA DE VIOLÃO', 150.00, '2022-01-18' , '2022-01-18', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'CURSO DE AWS', 2240.97, '2022-01-13' , '2022-01-21', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'TREINAMENTO ESPECIALISTA REACT', 1497.00, '2022-01-16' , '2022-01-18', now(), now());


INSERT INTO conta_paga (id, nome, valor_original, data_vencimento, data_pagamento, data_cadastro, data_ultima_alteracao)
VALUES (nextval('conta_paga_id_seq'), 'NETFLIX', 40.48, '2022-01-17' , '2022-01-18', now(), now());
