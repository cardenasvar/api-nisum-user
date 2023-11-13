# api-nisum-user

Aplicación API RESTful de creación de usuarios.
* Springboot
* Java 8
* Gradle
* JWT
* H2
* JPA
* Swagger

***

## Instalación y ejecución de la aplicación

Descargar la aplicación:
* git clone https://github.com/cardenasvar/api-nisum-user.git o
* descargar en zip y descomprimir.

Acceder a la carpeta del proyecto y ejecutar el comando:
* **gradlew bootRun**

![image](https://github.com/cardenasvar/api-nisum-user/assets/10708727/43b6c550-8e2e-46b7-adb2-e4252ce47dc6)
La aplicación arrancará e indicará el puerto de ejecución.

## Pruebas

Ya sea desde postman o soapUI montar las siguientes llamadas al api:

* /authenticate (Obtener token):
  * POST.
  * Datos de entrada: userName - password
  * Datos de salida: token
  * ![image](https://github.com/cardenasvar/api-nisum-user/assets/10708727/02293e53-221e-4f32-83d9-57e23ec9873c)

* /create (Crear usuario)
  * POST.
  * Authorization Token Bearer.
  * Datos de entrada: name - email - password - phones
  * ![image](https://github.com/cardenasvar/api-nisum-user/assets/10708727/b1b35eea-5710-41ee-b613-1d4be6098b7c)

  * Datos de salida: id - created - modified - lastLogin - token - active - respuestaBackoffice
  * ![image](https://github.com/cardenasvar/api-nisum-user/assets/10708727/292e0908-c2d4-4633-8d66-eb7f8ef1d0d2)

*Se incluye collection de postman dentro de la carpeta resources del proyecto.*
