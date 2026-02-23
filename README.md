# Udemy project

Proyecto de ejemplo que implementa una **arquitectura hexagonal** (ports & adapters) con **Spring Boot**, **Maven** y buenas prácticas de dominio.

## 📁 Estructura

```
src/
  main/
    java/com/hexagonal_arquitecture/hexagonal_arquitecture/
      application/usescases/…     # Casos de uso / lógica de aplicación
      domain/…                     # Entidades, modelos, puertos
      infrastructure/…             # Adaptadores, controladores, seguridad
  resources/
    application.properties
test/…                             # Pruebas unitarias/integración
```

El paquete base es `com.hexagonal_arquitecture.hexagonal_arquitecture`.

## ⚙️ Requisitos

- Java 17 (o superior)
- Maven 3.6+
- JDK configurado (`JAVA_HOME`)
- (Opcional) Docker si quieres correr la base de datos

## 🚀 Cómo ejecutar

```bash
# compilar y ejecutar tests
./mvnw clean verify

# iniciar la aplicación
./mvnw spring-boot:run

# o construir jar y ejecutar
./mvnw clean package
java -jar target/hexagonal-arquitecture-0.0.1-SNAPSHOT.jar
```

Por defecto escucha en `http://localhost:8080`.

## 🧪 Pruebas

Las pruebas se ejecutan con:

```bash
./mvnw test
```

El módulo `test` contiene clases como `HexagonalArquitectureApplicationTests`.

## 📦 Dependencias principales

- Spring Boot Starter Web
- Spring Data JPA (presumiblemente)
- Spring Security (token JWT en `security/`)
- Lombok
- H2 o base de datos configurada en `application.properties`

(Fíjate en el pom.xml para ver el listado completo.)

## 🛠️ Arquitectura

- **Domain**: modelos, excepciones, puertos (`in` y `on`).
- **Application**: casos de uso orquestados por servicios.
- **Infrastructure**: adapters para persistencia, controladores REST, DTOs, mappers, seguridad.

Esta separación habilita un diseño independiente de frameworks y facilita pruebas unitarias.

## 📘 Endpoints (ejemplos)

Controladores disponibles:

- `/categories` – gestión de categorías
- `/courses` – cursos
- `/lessons` – lecciones
- `/users`, `/auth` – seguridad y usuarios

Revisa cada `Controller` en `infrastructure/controllers` para rutas y métodos detallados.

## 🔐 Seguridad

Implementa JWT con filtros y servicios en `infrastructure/security/`. Modifica `application.properties` para declarar llaves/secretos.

## 💡 Contribuciones

1. Fork del repositorio
2. Nueva rama `feature/…`
3. Tests y documentación
4. Pull request explicando cambios
