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