CREATE DATABASE db_filmes;

USE db_filmes;

CREATE TABLE tb_filme(
codigo INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(200),
diretor VARCHAR(200),
ator_principal VARCHAR(200),
genero VARCHAR(200)
);



INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Silent Hill', 'Christopher Gans',
'Sean Bean', 'terror');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Blade Runner 2049', 'Denis Villeneuve',
'Ryan Gosling', 'Ação');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Old Guard', 'Gina Prince',
'Charlize Theron', 'Aventura');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Enola Holmes', 'Harry Bradbeer',
'Millie Bobby Brown', 'Aventura');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Matrix', 'Lilly Wachowski',
'Keanu Reeves', 'Ficção Científica');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('A Noive Cadaver', 'Tim Burton',
'Johnny Depp', 'Musical');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('O Conto da Princesa Kaguya', 'Isao Takahata',
'Aki Asakura', 'Anime');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Lanterna Verde', 'Martin Campbell',
'Ryan Reynolds', 'Super-Heróis');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Alive', 'Cho li',
'Yoo Ah-in', 'Suspense');
INSERT INTO tb_filme (titulo, diretor, ator_principal, genero) VALUES ('Orgulho e Preconceito', 'Joe Wright',
'Keira Knightley', 'Drama');

UPDATE tb_filme SET titulo ='Capitão América: O Primeiro Vingador' WHERE codigo = 1;
UPDATE tb_filme SET diretor ='Joe Johnston' WHERE codigo = 1;
UPDATE tb_filme SET ator_principal ='Chris Evans' WHERE codigo = 1;
UPDATE tb_filme SET genero ='Super-Heróis' WHERE codigo = 1;

SELECT * FROM tb_filme;