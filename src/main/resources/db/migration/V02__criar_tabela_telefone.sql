CREATE TABLE telefone (
  codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
  ddd VARCHAR(2) NOT NULL,
  numero VARCHAR(9) NOT NULL,
  codigo_funcionario BIGINT,
  FOREIGN KEY (codigo_funcionario) REFERENCES funcionario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;