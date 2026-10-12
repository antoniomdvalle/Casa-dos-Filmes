CREATE DATABASE IF NOT EXISTS casafilmes;

USE casafilmes;

CREATE TABLE IF NOT EXISTS Filme (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    sinopse VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    ano_lancamento INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Analise (
    id INT AUTO_INCREMENT PRIMARY KEY,
    filme_id INT,
    analise VARCHAR(255) NOT NULL,
    nota DOUBLE,
    CONSTRAINT fk_analise_filme
        FOREIGN KEY (filme_id)
        REFERENCES Filme(id)
        ON DELETE CASCADE
);

SELECT * FROM Filme;
SELECT * FROM Analise;