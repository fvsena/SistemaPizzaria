CREATE DATABASE OdinPizzaria
GO
USE OdinPizzaria
GO
CREATE TABLE Cargo
	(
		Codigo INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
		Descricao VARCHAR(30) NOT NULL
	)

CREATE TABLE Usuario
	(
		Codigo INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
		Nome VARCHAR(100) NOT NULL,
		Login VARCHAR(30) NOT NULL UNIQUE,
		Senha VARCHAR(30) NOT NULL,
		Ativo BIT NOT NULL DEFAULT 0,
		CodigoCargo INT NOT NULL,
		CaminhoImagem VARCHAR(MAX)
		
		CONSTRAINT FK_Usuario_Cargo FOREIGN KEY (CodigoCargo) REFERENCES Cargo(Codigo)
	)

INSERT INTO Cargo VALUES ('Atendente'),('Gerente')
INSERT INTO Usuario VALUES ('Felipe Venancio de Sena','felipe.sena','admin',1,2,NULL),('Chirley Nunes Pereira Santos','chirley.santos','admin',1,2,NULL)

CREATE TABLE Produto
	(
		Codigo INT IDENTITY NOT NULL PRIMARY KEY,
		Nome VARCHAR(100) NOT NULL,
		Ingredientes VARCHAR(255),
		Valor NUMERIC(5,2) NOT NULL
	)

INSERT INTO Produto VALUES('Pizza de mussarela','Massa, molho, mussarela',25.9),('Pizza de calabresa','Massa, molho, calabresa, cebola',26.9),('Pizza de atum','Massa, molho, atum, cebola',32.9)

SELECT * FROM Produto;

SELECT * FROM Pedido

SELECT * FROM SYS.OBJECTS WITH (NOLOCK) WHERE TYPE_DESC = 'USER_TABLE'

CREATE TABLE Pedido
	(
		IdPedido INT IDENTITY NOT NULL PRIMARY KEY,
		Telefone VARCHAR(11),
		Nome VARCHAR(100),
		Endereco VARCHAR(255),
		Produto VARCHAR(100),
		Quantidade INT,
		TaxaEntrega NUMERIC(5,2),
		Total NUMERIC(5,2)
	)