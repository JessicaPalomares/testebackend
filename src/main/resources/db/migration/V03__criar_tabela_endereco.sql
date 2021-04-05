CREATE TABLE endereco (
  codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
  logradouro VARCHAR(255),
  numero INT,
  complemento VARCHAR(255),
  bairro VARCHAR(255),
  cidade VARCHAR(255),
  estado VARCHAR(2),
  codigo_funcionario BIGINT,
  FOREIGN KEY (codigo_funcionario) REFERENCES funcionario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;