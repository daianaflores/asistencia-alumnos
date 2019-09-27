https://start.spring.io/

mvn package && java -jar target/asistencia.alumnos-0.0.1-SNAPSHOT.jar

mvn clean install


# levantar la aplicación
mvn spring-boot:run


# CURL Ejemplos

## GET HelloWorld
curl http://localhost:8080

## GET Listado de Alumnos
curl http://localhost:8080/alumnos

## POST Alta nuevo Alumno
curl -X POST http://localhost:8080/alumnos -d '{"nombre":"NOMBRE3", "email":"EMAIL3", "dni":44555123, "matricula":1003}' -H "Content-Type: application/json"

## PUT Modificar un Alumno
curl -X PUT http://localhost:8080/alumnos -d '{"id":2, "nombre":"NOMBRE22", "email":"EMAIL22", "dni":44555123, "matricula":1002}' -H "Content-Type: application/json"

## DELETE Eliminar un Alumno
curl -X DELETE http://localhost:8080/alumnos/3
