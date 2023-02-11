
CREATE TABLE usuario (
    id serial,
    nome varchar(50),
    login varchar(50),
    senha varchar(50),
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);


