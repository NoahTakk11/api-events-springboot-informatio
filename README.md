# API de Turnos - README

Bienvenido/a al proyecto final de "Trabajo Práctico Integrador", una API REST diseñada para administrar turnos para eventos u ocasiones especiales de cualquier empresa u organización. Este documento le proporcionará una visión general del proyecto y cómo interactuar con la API.

## Descripción del proyecto

La API de Turnos permite a las empresas y organizaciones registrarse en el sistema y crear eventos o motivos para los cuales las personas pueden sacar turnos. Además, las personas pueden solicitar turnos para los eventos sin la necesidad de autenticación. El sistema asegura la integridad de los datos y la coherencia de la información registrada.

## Características principales

- Gestión de Empresas: Permite agregar, modificar y eliminar empresas u organizaciones del sistema. Cada empresa tiene una clave alfanumérica única para realizar operaciones sensibles.

- Gestión de Eventos: Las organizaciones pueden crear eventos, ya sean únicos u ocasionales, con información relevante, y los usuarios pueden solicitar turnos para asistir a los mismos.

- Gestión de Personas: Las personas pueden solicitar turnos para eventos sin necesidad de registro. Se generará una clave para que los usuarios puedan modificar sus datos o darse de baja en el futuro.

- Controladores y Validaciones: Se han implementado controladores específicos para cada entidad (Empresa, Evento, Turno y Persona). Además, los datos recibidos se validan adecuadamente, y se proporcionan mensajes de error claros cuando es necesario.

- Manejo centralizado de errores: Se ha utilizado un controller advice para manejar los errores de manera centralizada y proporcionar respuestas coherentes en caso de situaciones inesperadas.

- Documentación con Swagger: La API está documentada con Swagger, lo que facilita su comprensión y uso por parte de los desarrolladores.

- Uso de interfaces: Se han utilizado interfaces de manera correcta para no depender de implementaciones específicas, lo que permite una mayor flexibilidad y escalabilidad del código.

## Endpoints disponibles

A continuación, se enumeran los principales endpoints disponibles en la API:

- **Empresas**:
  - `POST /empresas`: Registrar una nueva empresa u organización en el sistema.
  - `PUT /empresas/{cuit}`: Modificar los datos de una empresa existente. Se requiere la clave de la empresa para realizar esta operación.
  - `DELETE /empresas/{cuit}`: Eliminar una empresa del sistema. Se requiere la clave de la empresa para realizar esta operación.
  - `GET /empresas/{cuit}`: Obtener los datos de una empresa activa según su CUIT.
  - `GET /empresas`: Obtener la lista de todas las empresas registradas activas.

- **Eventos**:
  - `POST /eventos`: Crear un nuevo evento para una empresa u organización.
  - `PUT /eventos/{eventoId}`: Modificar un evento activo. Se requiere la clave de la organización para realizar esta operación.
  - `DELETE /eventos/{eventoId}`: Eliminar un evento existente. Se requiere la clave de la organización para realizar esta operación.
  - `GET /eventos/{organizacionId}`: Obtener todos los eventos de una organización dada.
  - `GET /eventos/{organizacionId}/{evento}`: Obtener todos los turnos activos de un evento específico para una organización dada.

- **Personas**:
  - `POST /personas`: Solicitar un turno para un evento sin necesidad de registro.
  - `PUT /personas/{clave}`: Modificar los datos de una persona. Se requiere la clave generada al solicitar el turno.
  - `DELETE /personas/{clave}`: Darse de baja y eliminar los datos de una persona del sistema. Se requiere la clave generada al solicitar el turno.
  - `GET /personas/{dni}`: Obtener los datos de una persona activa según su DNI.

## Uso de Swagger

Para interactuar con la API, puede acceder a la documentación generada por Swagger. Simplemente, inicie la aplicación y diríjase a la siguiente dirección en su navegador web: `http://direccion_de_la_api/swagger-ui.html`. Desde allí, podrá explorar los diferentes endpoints y realizar peticiones para probar la funcionalidad de la API.

## Requisitos de instalación y ejecución

Antes de utilizar la API, asegúrese de tener instalado lo siguiente:

- Java (versión XX o superior)
- Maven (versión XX o superior)

Una vez que haya instalado los requisitos, clone el repositorio y ejecute el siguiente comando en la raíz del proyecto para compilar y ejecutar la API:

```bash
mvn spring-boot:run
