-- Crear base de datos
CREATE DATABASE IF NOT EXISTS restaurante_2 DEFAULT CHARACTER SET = 'utf8' DEFAULT COLLATE 'utf8_general_ci';

-- Crear usuario y darle permisos para la base de datos creada
CREATE USER 'restuser'@'localhost' IDENTIFIED BY '12345';

-- Asignar permisos al usuario
GRANT ALL ON restaurante_2.* TO restuser@localhost;

-- Tablas
CREATE TABLE restaurante_2.Cliente (
  id INTEGER NOT NULL AUTO_INCREMENT,
  nombre TEXT NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE restaurante_2.Encuesta(
    id INTEGER NOT NULL AUTO_INCREMENT,
    descripcion TEXT NULL,
    CONSTRAINT pk_encuesta PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE restaurante_2.TipoPregunta(
    id INTEGER NOT NULL AUTO_INCREMENT,
    descripcion TEXT NOT NULL,
    CONSTRAINT pk_tipo_pregunta PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE restaurante_2.Pregunta(
    id INTEGER NOT NULL AUTO_INCREMENT,
    enunciado TEXT NOT NULL,
    idTipo INTEGER NOT NULL,
    idEncuesta INTEGER NOT NULL,
    CONSTRAINT pk_pregunta PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE restaurante_2.Pregunta ADD CONSTRAINT pregunta_idencuesta_foreign FOREIGN KEY(idEncuesta) REFERENCES restaurante_2.Encuesta(id);
ALTER TABLE restaurante_2.Pregunta ADD CONSTRAINT pregunta_tipo_foreign FOREIGN KEY(idTipo) REFERENCES restaurante_2.TipoPregunta(id);

CREATE TABLE restaurante_2.OpcionRespuesta(
    id INTEGER NOT NULL AUTO_INCREMENT,
    texto TEXT NULL,
    idPregunta INTEGER NOT NULL,
    CONSTRAINT pk_opcion_respuesta PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE restaurante_2.OpcionRespuesta ADD CONSTRAINT opcionrespuesta_idpregunta_foreign FOREIGN KEY(idPregunta) REFERENCES restaurante_2.Pregunta(id);

CREATE TABLE restaurante_2.Respuesta (
  id int NOT NULL AUTO_INCREMENT,
  idCliente int NOT NULL,
  idEncuesta int NOT NULL,
  idPregunta int NOT NULL,
  idOpcionRespuesta int DEFAULT NULL,
  respuestaAbierta text,
  CONSTRAINT pk_respuesta PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE restaurante_2.Respuesta ADD CONSTRAINT respuesta_idcliente_foreign FOREIGN KEY(idCliente) REFERENCES restaurante_2.Cliente(id);

ALTER TABLE restaurante_2.Respuesta ADD CONSTRAINT respuesta_idencuesta_foreign FOREIGN KEY(idEncuesta) REFERENCES restaurante_2.Encuesta(id);

ALTER TABLE restaurante_2.Respuesta ADD CONSTRAINT respuesta_idpregunta_foreign FOREIGN KEY(idPregunta) REFERENCES restaurante_2.Pregunta(id);

ALTER TABLE restaurante_2.Respuesta ADD CONSTRAINT respuesta_idopcionrespuesta_foreign FOREIGN KEY(idOpcionRespuesta) REFERENCES restaurante_2.OpcionRespuesta(id);

-- DATOS INICIALES
INSERT INTO restaurante_2.Cliente (nombre) VALUES('Juan');
INSERT INTO restaurante_2.Cliente (nombre) VALUES('Petronila');
INSERT INTO restaurante_2.Cliente (nombre) VALUES('Carlos');

INSERT INTO restaurante_2.TipoPregunta (descripcion) VALUES('Opción Multiple');
INSERT INTO restaurante_2.TipoPregunta (descripcion) VALUES('Abierta');
COMMIT;