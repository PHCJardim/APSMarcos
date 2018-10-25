create database aps4sem
use aps4sem
CREATE TABLE ranking (
    id PRIMARY KEY SERIAL,
    nome varchar(50),
    tempo float,
    qtd_erros int
)