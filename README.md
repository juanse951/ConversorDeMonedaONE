# Menú de Conversiones de Divisas

Este proyecto en Java permite al usuario realizar conversiones entre diferentes divisas mediante un menú interactivo. Las tasas de cambio son obtenidas a través de una API, y las conversiones se registran con marca de tiempo en un archivo de historial.

## Estructura del Proyecto

El programa consta de tres clases principales:

1. **MenuConversiones**: Muestra un menú para seleccionar el tipo de conversión de divisas y gestiona las entradas del usuario.
2. **ConsultaTasaAPI**: Realiza las consultas a la API de tasas de cambio, realiza la conversión y maneja la persistencia de los registros en un archivo.
3. **TasasDeCambio**: Representa el modelo de datos de las tasas de cambio, utilizando un `record` de Java para almacenar el código de base y las tasas de conversión en un `Map`.

## Requisitos Previos

- Java 11 o superior.
- Biblioteca `Gson` para manipular JSON. Puedes descargarla desde [Gson en GitHub](https://github.com/google/gson) o agregarla a tu proyecto.

## Instrucciones de Uso

1. **Ejecuta el programa**: Compila y ejecuta `MenuConversiones.java`.
2. **Selecciona la conversión**: Elige una opción del menú (1-10) para convertir entre diferentes divisas.
3. **Introduce el valor a convertir**: El programa solicitará el monto que deseas convertir.
4. **Salida y registro**: Se mostrará el resultado de la conversión en pantalla y se registrará en el archivo `historial.txt` con la marca de tiempo.

### Opciones de Conversión Disponibles

1. Dólar (USD) a Peso Argentino (ARS)
2. Peso Argentino (ARS) a Dólar (USD)
3. Peso Colombiano (COP) a Dólar (USD)
4. Dólar (USD) a Peso Colombiano (COP)
5. Real Brasileño (BRL) a Dólar (USD)
6. Dólar (USD) a Real Brasileño (BRL)
7. Yuan Chino (CNY) a Dólar (USD)
8. Dólar (USD) a Yuan Chino (CNY)
9. Euro (EUR) a Dólar (USD)
10. Dólar (USD) a Euro (EUR)
11. Salir

### Ejemplo de Ejecución

```plaintext
Menú de conversiones:
1. Dólar => Peso Argentino
2. Peso Argentino => Dólar
...
Seleccione una opción válida:

Al seleccionar una opción y proporcionar un valor, el programa muestra la conversión en pantalla y guarda un registro en historial.txt.

Manejo de Errores
El programa incluye manejo de excepciones para evitar interrupciones en la ejecución:

InputMismatchException: Se captura cuando el usuario ingresa un valor no numérico.
IOException: Se captura al escribir en el archivo historial.txt.
Excepción general (Exception): Se captura cualquier otro error no previsto y lo registra en el historial.
Ejemplo de Registro en historial.txt

La cantidad: 100.00 USD Equivale a: 8500.00 ARS
Registro: 2024-11-07 15:30:22

Notas
El programa utiliza una API de tasas de cambio para obtener las tasas en tiempo real. La clave de la API debe configurarse en la variable apiKeyCodificada de la clase ConsultaTasaAPI.
Asegúrate de tener conexión a internet para que el programa funcione correctamente.
La API utilizada tiene limitaciones de uso. Consulta la documentación de la API para más detalles.
Autor
Desarrollado como una práctica de Java para implementar un menú interactivo y el consumo de APIs para conversiones de divisas.
