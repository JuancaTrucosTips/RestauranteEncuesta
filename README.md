# Servicio de Encuestas para Restaurante
Prueba Tecnica RobinFood

Utilizando el framework de **Spring Boot con Java 11** se realiza una **API Rest** para un restaurante que requiere un sistema que permita listar una encuesta a sus clientes para recibir el feedback de sus servicios; la encuesta debe de tener un listado de preguntas de tipo abiertas y selección múltiple con sus respectivas respuestas.

Se Implementan los test unitarios con **Junit 5**
(No implementar ningún tipo de seguridad)

# Solución (Servicios)
### Se debe exponer un servicio que permita listar una encuesta con sus respectivas preguntas. 
(GET localhost:8090/api/encuestas/{id})

### Se debe exponer un servicio que permita registrar la encuesta. 
(POST localhost:8090/api/solucionEncuestas) 

mas abajo dejo la colección de postman con su body para consumir el servicio y responder la encuesta.

## Servicios adicionales
### Crear Encuesta 
(POST localhost:8090/api/encuestas) 
mas abajo dejo la colección de postman con su body para consumir el servicio y crear la encuesta.

### Listar todas las encuestas
(GET localhost:8090/api/encuestas/)

# Instalación de la base de datos
Dentro del proyecto **en resourses** hay una carpeta llamada **sql** donde vas a encontrar el archivo **encuesta-restaurante.sql**, este contiene la creación de la base de datos, el usuario, los permisos para el usuario, las tablas y unos insert de datos iniciales.
[encuesta-restaurante.sql](https://github.com/JuancaTrucosTips/RestauranteEncuesta/blob/master/src/main/resources/sql/encuesta-restaurante.sql)

# Modelo Entidad Relacion
Dentro del proyecto **en resourses** hay una carpeta llamada **sql** donde vas a encontrar la **imagen del modelo llamada EntidadRelacionEncuesta.png**
[EntidadRelacionEncuesta](https://github.com/JuancaTrucosTips/RestauranteEncuesta/blob/master/src/main/resources/sql/EntidadRelacionEncuestas.png)

# Colección en POSTMAN
Dentro del proyecto **en resourses hay una carpeta llamada postman_collection** donde vas a encontrar el **archivo json** llamado **RestauranteEncuestas.postman_collection** para **importar en POSTMAN** y usar los servicios expuestos.
[EntidadRelacionEncuesta](https://github.com/JuancaTrucosTips/RestauranteEncuesta/tree/master/src/main/resources/postman_collection)

# Cobertura
94%

# Sonar
Se usa el plugin SonarLint para ayudar a mejorar el código.
