DROP DATABASE IF EXISTS oficios_db;
CREATE DATABASE oficios_db;
USE oficios_db;

-- Tabla: USUARIO
CREATE TABLE usuario (
  id_user INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password_hash VARCHAR(32) NOT NULL,
  fecha_ingreso DATE NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE (username)
);

-- Tabla: OFICIOS
CREATE TABLE oficios (
  id_oficio INT NOT NULL AUTO_INCREMENT,
  persona VARCHAR(50) NOT NULL,
  area VARCHAR(30) NOT NULL,         
  asunto VARCHAR(255) NOT NULL,
  fecha VARCHAR(8) NOT NULL, 
  hash_documento VARCHAR(32) NOT NULL,
  PRIMARY KEY (id_oficio)
);