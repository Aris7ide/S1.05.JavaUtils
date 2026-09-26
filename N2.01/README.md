# Ejercicio 1

## 📌 Enunciat del exercici
Ejecuta el ejercicio 3 del nivel anterior parametrizando todos los métodos en un archivo de configuración.

Puedes utilizar un archivo Java Properties, o bien la librería Apache Commons Configuration si lo prefieres.

Del ejercicio anterior, parametriza lo siguiente:

Directorio a leer.
Nombre y directorio del archivo TXT resultante.

## ✨ Funcionalitats
- Apache Commons

## 🛠 Tecnologies
- **Llenguatge**: Java 25
- **IDE**: IntelliJ IDEA

## Excecution
- he copiado el ejercicio del Nivel 1 hasta el ejercicio 3 para empezar.
- Empiezo a añadir la dependency al pom
- Creo el .properties con una sola linea app.data.file=N2.01/directory_structure.txt
- Creo la clase ConfigLoader encargada de gestionar todos los servicios de escritura y lectura del .properties usando Apache Commons
- Le he dado un String con el path del .properties 
- Y dos atributos, builder y config para que comuniquen entre el .properties y el disco duro /RAM
- He creado un bloque estatico que verifique que el .properties exista, y si no existe lo crea.
- Y en ese mismo bloque estatico que lea los parameters en congig.properties y los guarde en el objeto config.
- #### El builder llama los metodos necesarios para leer el file config.properties y los guarda en config
- he creado los dos metodos getProperty() y setProperty() para poder leer y escribir el config.properties
- 