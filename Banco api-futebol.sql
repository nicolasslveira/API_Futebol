use api_futebol;

CREATE TABLE time (
    id_time BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cidade VARCHAR(100),
    estado VARCHAR(100),
    pais VARCHAR(100),
    ano_fundacao INT,
    estadio VARCHAR(100),
    patrocinador VARCHAR(100),
    capacidade_estadio INT,
    treinador VARCHAR(100)
);

CREATE TABLE jogador (
    id_jogador BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    apelido VARCHAR(100),
    posicao VARCHAR(50),
    idade INT,
    nacionalidade VARCHAR(50),
    numero_camisa INT,
    id_time BIGINT,
    FOREIGN KEY (id_time) REFERENCES time(id_time)
);


