# NIVEL 1

## 📌 Enunciat del exercici
En este primer nivel, trabajaremos con algunas de las utilidades básicas de Java para gestionar archivos y directorios, así como para leer y escribir información en el sistema de archivos.

Te familiarizarás con operaciones muy comunes en el mundo del desarrollo: navegar por directorios , filtrar y ordenar contenido , guardar datos en archivos , y serializar objetos .

Este conjunto de ejercicios te permitirá poner en práctica:

- El uso de la clase File para acceder y gestionar archivos.
- El tratamiento de estructuras recursivas como los árboles de directorios.
- La manipulación de flujos de entrada/salida (I/O).
- La persistencia de objetos mediante serialización.

Al final de este nivel, habrás creado un pequeño conjunto de herramientas para trabajar con el sistema de archivos que podrás reutilizar o ampliar en proyectos futuros.

## ✨ Funcionalitats
- clase File
- Excepciones

## 🛠 Tecnologies
- **Llenguatge**: Java 25
- **IDE**: IntelliJ IDEA

## Excecution
### Ejercicio 1
#### Crea una clase que liste alfabéticamente el contenido de un directorio recibido por parámetro.
- He creado una clase llama DirectoryLister con un metodo alphabeticalDirectoryLister()
- He usado un montòn de llamadas nuevas:
- El tipo de objeto File, que puede leer archivos o directories
- .exists() .isDirectory() .getName() para llamar datos y/o verificar cosas
- La clase Main para llamar el metodo, pasando "." sale la estructura de la carpeta del proyecto 
- Tambièn he especificado si los elementos son FILE o DIR
### Ejercicio 2
#### Añade a la clase del ejercicio anterior, la funcionalidad de listar un árbol de directorios con el contenido de todos sus niveles (recursivamente) de forma que se impriman en pantalla en orden alfabético dentro de cada nivel, indicando además si es un directorio (D) o un archivo (F), y su última fecha de modificación
- Para que por cada carpeta haga un arbol he implementado, cada vez que se encuentre una carpeta, una llamada al mismo metodo usando .getAbsolutePath()
- tambièn he dato al metodo un secondo valor Integer nivel para poder dar un valor a las subcarpetas y poder craer espacios para visualmente darle un sentido al arbol, he usado el ("\t").repeat(nivel)
- tambièn he modificado el if para verificar que la carpeta estè vacia para que no salga como error cada vez que encuentre una directory vacia.
### Ejercicio 3
#### Modifica el ejercicio anterior. Ahora, en lugar de mostrar el resultado por la pantalla, guarda el resultado en un archivo TXT.
- He usado un try-with-resources para crear un FileWriter en un PrintWriter
- he pasado el PrintWriter writer al metodo y ahi en vez de usar un System.out.println() he usado un writer.println().
### Ejercicio 4
#### Añade la funcionalidad de leer cualquier archivo TXT y muestra su contenido por consola.
- He creado una nueva clase con un metodo readFile() que llama un BufferedReader y un FileReader pasando el path del file que quiere leer. 
- Desde el main he llamado el metodo y pasado el file path, el texto del .txt sale en consola.
### Ejercicio 5
#### Ahora el programa debe serializar un Objeto Java a un archivo .ser y después debe desserializarlo.
- He credo una nueva clase Serial y un PersonClass para poder crear un objeto
- En Serial dos metodos con ObjectOutputStrem y FileOutputStream para guardar el .ser y otro con InputObjectStream y FileInputStream para leerlo.
- al leer el .ser me da null, el objecto no ha sido guardado o leido.
- me faltaba un return en metodo de leida con el objeto. Ahora lo lee bien.