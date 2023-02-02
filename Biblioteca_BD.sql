create database biblioteca;
use biblioteca;


CREATE TABLE livro (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255),
  autor VARCHAR(255),
  ano_publicacao VARCHAR(4)
);

CREATE TABLE leitor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255),
  idade INT,
  endereco VARCHAR(255),
  telefone VARCHAR(50)
);

CREATE TABLE funcionario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255),
  endereco VARCHAR(255),
  telefone VARCHAR(50)
);

CREATE TABLE emprestimo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_livro INT,
  id_leitor INT,
  id_funcionario INT,
  data_emprestimo VARCHAR(30),
  data_devolucao VARCHAR(40),
  FOREIGN KEY (id_livro) REFERENCES livro(id),
  FOREIGN KEY (id_leitor) REFERENCES leitor(id),
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);


CREATE TABLE login(
  usuario VARCHAR(50),
  senha VARCHAR(9),
  id_funcionario INT,
  ativo BOOLEAN,
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);

select * from funcionario;
select * from livro;
select * from leitor;
select * from emprestimo;
select * from login;


INSERT INTO funcionario(nome, endereco, telefone) VALUES
	('MATEUS', 'RUA...', '8767-8732'),
	('ARIMATÉIA', 'RUA...', '8865-8632');

INSERT INTO login(usuario, senha, id_funcionario, ativo) VALUES
	('ARI', '12345', '1', true),
	('MATEUS', '12345', '2', true);
