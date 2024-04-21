Descripción funcional
El objetivo de esta tarea es crear un programa que te permita hacer realizar diversas operaciones relacionadas con el sistema de archivos y con la creación y edición de un archivo de texto.

Cuando el programa se inicie mostrará un menú por la consola del sistema con las siguientes opciones:

1. Mostrar directorios de la carpeta de usuario

2. Crear un nuevo archivo de texto en la carpeta de usuario

3. Mostrar el contenido de un archivo de texto de la carpeta de usuario

4. Añadir una nueva línea de texto a un archivo de la carpeta de usuario

5. Eliminar un archivo de la carpeta de usuario

6. Salir

El usuario podrá seleccionar cualquier de las opciones anteriores introduciendo el número correspondiente a dicha opción. Tras acceder a esa opción y usar la funcionalidad de esa opción se volverá mostrar el menú permitiendo escoger una nueva opción. La única excepción es la opción Salir que directamente finalizará el programa.

A continuación se describe lo que debe hacer cada una de las opciones del menú:

1. Mostrar directorios de la carpeta de usuario
Cuando se seleccione esta opción se mostrará por la consola un listado con todos los directorios (solamente los directorios, no archivos) que hay en la carpeta de usuario. Se mostrará la información de cada directorio en una línea diferente, y la información a mostrar será el nombre de ese directorio, su fecha de última modificación y su tamaño en kilobytes.

2. Crear un nuevo archivo de texto en la carpeta de usuario
Cuando se seleccione esta opción se pedirá al usuario el nombre de un nuevo archivo de texto que se creará en la carpeta de de usuario. Si no existe un archivo con ese nombre lo creará con una única línea de texto con el nombre y apellidos del alumno. Si ya existe, simplemente mostrará un mensaje indicando que ya existe un archivo con ese nombre y no hará nada más.

3. Mostrar el contenido de un archivo de texto de la carpeta de usuario
Cuando se seleccione esta opción se pedirá al usuario el nombre de un archivo de texto que debe estar en la carpeta de de usuario. Si dicho archivo existe se mostrará el contenido del archivo por la consola mostrando cada línea del archivo en una línea diferente en la consola. Además, al final de todas las líneas se mostrará una línea adicional indicando cuantas lineas de texto tenía el fichero. Si no existe el archivo con el nombre indicado, simplemente se mostrará un mensaje indicándolo al usuario.

4. Añadir una nueva línea de texto a un archivo de la carpeta de usuario
Cuando se seleccione esta opción se pedirá al usuario el nombre de un archivo de texto que debe estar en la carpeta de de usuario. Si dicho archivo existe se pedirá al usuario que introduzca una nueva línea de texto por la consola y dicha línea se añadirá al final del archivo. Si no existe el archivo con el nombre indicado, simplemente se mostrará un mensaje indicándolo al usuario.

5. Eliminar un archivo de la carpeta de usuario
Cuando se seleccione esta opción se pedirá al usuario el nombre de un archivo de texto que debe estar en la carpeta de de usuario. Si dicho archivo existe se borrará y se mostrará un mensaje de confirmación al usuario por la consola. Si no existe el archivo con el nombre indicado, simplemente se mostrará un mensaje indicándolo al usuario.

6. Salir
Finalizará el programa.

Descripción técnica
Para obtener la carpeta del usuario se puede consultar el valor de la propiedad “user.home” y el método getProperty de la clase System.

Cada clase creada debe tener comentarios Javadoc en la cabecera de la clase y en la cabecera de los métodos de la misma.
