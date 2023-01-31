create database biblioteca;
use biblioteca;


CREATE TABLE livro (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255),
  autor VARCHAR(255),
  ano_publicacao INT
);

CREATE TABLE leitor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255),
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
  data_emprestimo DATE,
  data_devolucao DATE,
  FOREIGN KEY (id_livro) REFERENCES livro(id),
  FOREIGN KEY (id_leitor) REFERENCES leitor(id),
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);

select * from livro;
select * from leitor;
select * from emprestimo;
