CREATE SEQUENCE conta_paga_id_seq start 1 increment 1;

CREATE TABLE conta_paga
(
    id BIGINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    valor_original NUMERIC(19,2) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE NOT NULL,
    data_cadastro timestamp with time zone NOT NULL,
    data_ultima_alteracao timestamp with time zone,
    CONSTRAINT conta_paga_pkey PRIMARY KEY (id)
);