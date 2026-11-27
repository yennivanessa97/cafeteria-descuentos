# Cafetería - Aplicación de descuentos

Proyecto integrador (EA4) de Programación Orientada a Objetos II.
Aplicación Java con interfaz Swing que calcula el descuento de un pedido
y verifica la conexión a una base de datos SQLite mediante JDBC.

## Estructura

- `modelo`: Producto (abstracta), Bebida, Comida, Tamanio, Pedido y ReglaDescuento.
- `datos`: ConexionBD (prueba de conexión JDBC).
- `ui`: VentanaDescuentos y MainUI.

## Requisitos

- Java 21
- Maven

## Cómo ejecutar

1. Clonar el repositorio.
2. Abrirlo en IntelliJ IDEA y cargar el proyecto Maven.
3. Ejecutar la clase `MainUI`.

## Regla de descuento

Si el total supera 10, se aplica un 15 % de descuento. Está escrita como una
lambda sobre la interfaz funcional `ReglaDescuento`.

## Ramas

- `main`: versión estable.
- `dev`: integración.
- `feature/*`: una rama por cada parte del proyecto.
