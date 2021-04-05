INSERT INTO funcionario (nome, cpf,salario) VALUES ('Iago', '86730543540', '120.00');
INSERT INTO funcionario (nome, cpf,salario) VALUES ('Pedro', '55565893569', '120.00');
INSERT INTO funcionario (nome, cpf,salario) VALUES ('Cauê', '38767897100', '120.00');
INSERT INTO funcionario (nome, cpf, salario) VALUES ('Breno', '78673781620', '120.00');
INSERT INTO funcionario (nome, cpf, salario) VALUES ('Thiago', '72788740417', '120.00');

INSERT INTO telefone (ddd, numero, codigo_funcionario) VALUES ('41', '999570146', (SELECT codigo FROM funcionario WHERE cpf = '86730543540' LIMIT 1));
INSERT INTO telefone (ddd, numero, codigo_funcionario) VALUES ('82', '39945903', (SELECT codigo FROM funcionario WHERE cpf = '55565893569'LIMIT 1));
INSERT INTO telefone (ddd, numero, codigo_funcionario) VALUES ('86', '35006330', (SELECT codigo FROM funcionario WHERE cpf = '38767897100' LIMIT 1));
INSERT INTO telefone (ddd, numero, codigo_funcionario) VALUES ('21', '997538804', (SELECT codigo FROM funcionario WHERE cpf = '78673781620' LIMIT 1));
INSERT INTO telefone (ddd, numero, codigo_funcionario) VALUES ('95', '38416516', (SELECT codigo FROM funcionario WHERE cpf = '72788740417' LIMIT 1));

INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, codigo_funcionario) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT codigo FROM funcionario WHERE cpf = '86730543540'));
INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, codigo_funcionario) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT codigo FROM funcionario WHERE cpf = '55565893569'));
INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, codigo_funcionario) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT codigo FROM funcionario WHERE cpf = '38767897100'));
INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, codigo_funcionario) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT codigo FROM funcionario WHERE cpf = '78673781620'));
INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, codigo_funcionario) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT codigo FROM funcionario WHERE cpf = '72788740417'));
