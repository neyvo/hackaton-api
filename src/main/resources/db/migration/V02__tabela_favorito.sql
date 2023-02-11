
CREATE TABLE favorito (
    id serial,
    usuario_id int,
    titulo varchar(255),
    endereco text,
    latitude varchar(150),
    longitude varchar(150),
    CONSTRAINT pk_favorito PRIMARY KEY (id)
);


