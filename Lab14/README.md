# Agenda de contactos

Proyecto que integra las prácticas Lab12 y Lab13: permite registrar, consultar,
editar y eliminar contactos con Spring Boot, Thymeleaf, Spring Data JPA y MySQL.

## Requisitos

- Java 25
- Maven 3.9 o posterior
- MySQL en ejecución

## Preparar MySQL

Crea la base de datos antes de iniciar la aplicación:

```sql
CREATE DATABASE agenda;
```

La aplicación crea o actualiza la tabla de contactos al iniciar. Por defecto
intenta conectarse a `localhost:3306` con el usuario `root` y contraseña vacía.
Configura las variables de entorno si tus datos son distintos:

```powershell
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "tu_contraseña"
```

También puedes definir `DB_URL` para cambiar la dirección de conexión.

## Ejecutar

Desde la carpeta del proyecto:

```powershell
mvn spring-boot:run
```

Abre <http://localhost:8080>. Para ejecutar las pruebas:

```powershell
mvn test
```
