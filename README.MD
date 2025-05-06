# Intérprete HTML en Java

Este proyecto es una aplicación de escritorio en Java que permite interpretar y analizar código HTML. La interfaz gráfica está construida con Swing y tiene las siguientes características principales:

## Características del Proyecto

### Visualización de HTML

- Utiliza un componente `JEditorPane` para mostrar contenido HTML básico con estilos en línea (como colores y tamaños de fuente).

### Análisis de Tokens

- El código incluye un analizador léxico (Lexer) que convierte el HTML en una lista de tokens.

### Detección de Errores

- Un analizador sintáctico (Parser) revisa los tokens generados y detecta errores en el HTML.

### Interfaz Dividida

- La ventana principal está dividida en tres secciones:
  - Un editor para mostrar el HTML.
    - Un panel para mostrar los tokens generados.
    - Un panel para mostrar los errores encontrados.

## Cómo Ejecutar el Proyecto

### Requisitos Previos

#### Java Development Kit (JDK)

- Asegúrate de tener instalado JDK 8 o superior.
- Verifica la instalación ejecutando:

    ```bash
    java -version
    ```

#### Compilador de Java

- Asegúrate de tener `javac` disponible para compilar el código.

### Pasos para Ejecutar

#### Clonar o Descargar el Proyecto

- Clona el repositorio o descarga los archivos en tu máquina local.

#### Compilar el Código

- Abre una terminal en la carpeta del proyecto y ejecuta:

    ```bash
    javac Main.java
    ```

#### Ejecutar la Aplicación

- Una vez compilado, ejecuta el programa con:

    ```bash
    java Main
    ```

#### Interacción con la Aplicación

- Al iniciar, la ventana mostrará un ejemplo de HTML con un encabezado y un párrafo.
- Los tokens generados y los errores (si los hay) se mostrarán en los paneles inferiores.

## Estructura del Proyecto

- **`Main.java`**: Contiene el punto de entrada del programa y la configuración de la interfaz gráfica.
- **`Lexer`**: Clase encargada de analizar el HTML y generar tokens.
- **`Parser`**: Clase encargada de analizar los tokens y detectar errores.

## Notas

- Si encuentras problemas al ejecutar, asegúrate de que todos los archivos necesarios (como `Lexer` y `Parser`) estén en el mismo directorio que `Main.java`.
- Si encuentras problemas al ejecutar, asegúrate de que todos los archivos necesarios (como `Lexer` y `Parser`) estén en el mismo directorio que `Main.java`.
