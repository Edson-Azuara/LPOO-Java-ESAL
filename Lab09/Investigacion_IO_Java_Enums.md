# Investigación: enumeraciones y entrada/salida en Java

## `FileWriter(archivo)` y `FileWriter(archivo, true)`

`FileWriter(archivo)` abre el archivo para escribir desde el inicio. Si ya existe, su contenido anterior se trunca (se borra); si no existe, se crea. En cambio, `FileWriter(archivo, true)` habilita el modo *append*: conserva el contenido y escribe al final.

En `PersistenciaGremio.agregarEntradaBitacora`, cada entrada abre un `FileWriter` nuevo. Por eso, si se reemplazara `new FileWriter(archivo, true)` por `new FileWriter(archivo)`, cada llamada borraría las entradas escritas por llamadas anteriores. Al terminar las tres llamadas de `Main`, la bitácora conservaría únicamente la última entrada: `Thorin venció a Dragón de Hielo`. También se perderían las entradas anteriores que hubiera en el archivo antes de ejecutar el programa.

## Verificar que el archivo exista antes de leerlo

Comprobar la existencia permite tratar el caso de un archivo ausente de forma controlada; por ejemplo, mostrar un mensaje o devolver una colección vacía, como hace `cargarRoster()`. Si se intenta construir un `FileReader` para una ruta que no existe, Java lanza `FileNotFoundException`, una subclase de `IOException`.

La comprobación no reemplaza el manejo de excepciones: el archivo puede cambiar o dejar de estar accesible entre la comprobación y la apertura, y pueden ocurrir otros errores de E/S. Por eso, la operación de lectura también debe manejar o propagar `IOException`.

## Ventaja de `BufferedReader` y `BufferedWriter`

`FileReader` lee caracteres desde un archivo. `BufferedReader` envuelve un `Reader` —por ejemplo, un `FileReader`— y guarda temporalmente caracteres en memoria. En lugar de solicitar cada carácter individualmente al sistema de archivos, puede leer bloques más grandes y servir varias lecturas desde ese bloque, reduciendo operaciones de E/S. Además, ofrece `readLine()` para leer texto línea por línea.

De forma análoga, `BufferedWriter` envuelve un `Writer` y acumula temporalmente los caracteres escritos para enviarlos en bloques; esto puede reducir las operaciones de escritura. También permite escribir líneas de forma conveniente con `newLine()`. Al cerrar el escritor, se vacía el contenido pendiente y se libera el recurso. Es recomendable usar *try-with-resources* para garantizar el cierre incluso si ocurre una excepción.

Ejemplo del patrón usado en el proyecto:

```java
try (BufferedReader reader =
         new BufferedReader(new FileReader(archivo))) {
    String linea;
    while ((linea = reader.readLine()) != null) {
        System.out.println(linea);
    }
}
```

## ¿Qué es un `enum` y para qué sirve?

Un `enum` (enumeración) es un tipo que representa un conjunto fijo de constantes con nombre. Es útil cuando una variable solo debe aceptar uno de varios valores conocidos, por ejemplo, direcciones, estados o categorías. Frente a usar cadenas o números arbitrarios, ayuda a evitar valores inválidos y permite que el compilador detecte errores de tipo.

```java
public enum TipoEvento {
    ATAQUE,
    CURACION,
    DERROTA
}

TipoEvento evento = TipoEvento.ATAQUE;
```

En este proyecto podría servir, por ejemplo, para clasificar entradas de la bitácora con categorías conocidas, en vez de depender de texto libre. Java permite que un `enum` también tenga campos, métodos y un constructor privado o de paquete; sus constantes se pueden recorrer con `values()`.

## Clases de Java relacionadas con lectura y escritura

Las clases de `java.io` pueden agruparse según trabajen con caracteres o bytes, y según agreguen almacenamiento temporal (*buffer*) u otras funciones:

| Clase | Uso principal |
|---|---|
| `FileReader` / `FileWriter` | Leer y escribir caracteres en archivos de texto. |
| `BufferedReader` / `BufferedWriter` | Añadir búfer a lectores y escritores de caracteres; `BufferedReader` también ofrece `readLine()`. |
| `FileInputStream` / `FileOutputStream` | Leer y escribir bytes en archivos; apropiados para datos binarios, como imágenes. |
| `BufferedInputStream` / `BufferedOutputStream` | Añadir búfer a flujos de bytes para reducir operaciones de E/S. |
| `InputStreamReader` / `OutputStreamWriter` | Conectar flujos de bytes con lectores y escritores de caracteres; permiten especificar la codificación de caracteres. |
| `PrintWriter` | Escribir texto con métodos de impresión y formato convenientes; puede envolver un `Writer`. |
| `LineNumberReader` | Variante de `BufferedReader` que lleva el número de línea leído. |
| `PushbackReader` | Lector que permite devolver caracteres al flujo para volver a leerlos. |
| `StringReader` / `StringWriter` | Leer caracteres desde una cadena o acumular escritura de caracteres en memoria. |
| `CharArrayReader` / `CharArrayWriter` | Leer desde un arreglo de caracteres o escribir caracteres en uno mantenido internamente. |
| `Files` (`java.nio.file`) | Utilidades estáticas para rutas y archivos; incluye `newBufferedReader` y `newBufferedWriter`. |
| `Scanner` (`java.util`) | Leer y dividir texto en tokens, por ejemplo, valores separados por espacios o delimitadores. |
| `RandomAccessFile` | Leer y escribir en un archivo permitiendo cambiar la posición de lectura/escritura. |

Las clases no son intercambiables en todos los casos: `Reader` y `Writer` procesan texto (caracteres), mientras que `InputStream` y `OutputStream` procesan bytes. Para texto moderno donde importa la codificación, `Files.newBufferedReader` y `Files.newBufferedWriter` permiten indicar explícitamente un `Charset`.

## Referencias

- Oracle, documentación de `java.io`: [Package java.io](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/io/package-summary.html)
- Oracle, tutorial de enumeraciones: [Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
- Oracle, documentación de `java.nio.file.Files`: [Class Files](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/nio/file/Files.html)
