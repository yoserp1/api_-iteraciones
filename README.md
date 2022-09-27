# api_iteraciones
Se debe exponer un API que reciba un numero de iteraciones Q y un número del 1 al 5 que representara el id de la pila de datos a trabajar (script de DB entregados) y entregue el array de respuesta

# Spring Boot "iteraciones" proyecto de prueba

## Como correrlo

* Clonar este repositorio
* Asegúrese de estar usando JDK 1.8 y Maven 3.x
* Puede compilar el proyecto y ejecutar las pruebas ejecutando ```mvn clean package```
* Para mas comodidad ejecutar desde un IDE ejemplo: Eclipse

## Configurar BD

Modificar los parametros de conexion en:
* api_iteraciones/src/main/resources/application.properties
* Ejemplo del archivo:
```shell
spring.datasource.url=jdbc:mysql://localhost:3306/bartender
spring.datasource.username=mi_usuario
spring.datasource.password=mi_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
spring.jpa.generate-ddl=true
```
## Como probar

* Utilizar un cliente para peticiones HTTP ejemplo: Postman
* En la siguiente url hacer la peticion: ```http://localhost:8080/bar?pila=1&iteraccion=3```
* Donde pila es el id del registro en la tabla arrays y iteraccion es la cantidad de iteraciones que realizara el programa.
* La respuesta que deberia venir de la api seria la siguiente:
```
{
    "output": "8,6,4,2,5,7"
}
```
