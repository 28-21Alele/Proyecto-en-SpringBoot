<p align="center">
  <img src="https://i.pinimg.com/originals/50/1a/66/501a665f295b9f6ccbe86e558e456605.gif" alt="Kenaro's Store Retro Banner" width="550">
</p>

# Kenaro's Store

Kenaro's Store es una aplicación web desarrollada con Spring Boot que simula una tienda digital de videojuegos. Permite visualizar un catálogo de productos, realizar búsquedas, filtrar por categorías, consultar detalles de cada videojuego y gestionar un carrito de compras mediante sesiones.

---

# Configuración del Proyecto

## Clonar repositorio

```bash
git clone https://github.com/USUARIO/kenaros-store.git
```

---

## Crear Base de Datos

```sql
CREATE DATABASE kenaros_store;
```

---

## Configurar application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/kenaros_store
spring.datasource.username=postgres
spring.datasource.password=TU_PASSWORD

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

## Ejecutar Aplicación

### Con Maven

```bash
mvn spring-boot:run
```

### O desde Visual Studio Code

Ejecutar:

```text
KenarosStoreApplication.java
```

---

# Acceso

Una vez iniciada la aplicación:

```text
http://localhost:8080
```
