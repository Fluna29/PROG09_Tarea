package Funciones;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;

/**
 * En esta clase van a ir todas las funciones a utilizar en nuestra clase PROG09_Tarea
 * @author Francisco Luna Raya
 */
public class Funciones {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final String KEY = "user.home";
    private static final String DIRECTORY_PATH = System.getProperty(KEY);

    /**
     * Cuando se seleccione esta opción se mostrará por la consola un listado con todos los directorios (solamente los directorios, no archivos) que hay en la carpeta de usuario. 
     * Se mostrará la información de cada directorio en una línea diferente,
     * y la información a mostrar será el nombre de ese directorio, 
     * su fecha de última modificación y su tamaño en kilobytes.
     * @throws IOException
     */
    public static void mostrarDirectoriosUsuario () throws IOException{

        Path directory = Paths.get(DIRECTORY_PATH);

        StringBuilder listaDirectorios = new StringBuilder();

        DirectoryStream<Path> items = null;
        try{
            items = Files.newDirectoryStream(directory);
            for (Path file : items){
                if (Files.isDirectory(file)) {
                    BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
                    listaDirectorios.append("Nombre Directorio: " + file).append(", Ultima Modificación: " + attr.lastModifiedTime()).append(", Tamaño (KB): " + attr.size()/ 1024).append("\n");
                    
                }
            }

            System.out.println(listaDirectorios.toString());
        
        }finally{
            if (items != null) {
                items.close();
            }
        }
    }

    /**
     * Cuando se seleccione esta opción se pedirá al usuario el nombre de un nuevo archivo de texto que se creará en la carpeta de de usuario. 
     * Si no existe un archivo con ese nombre lo creará con una única línea de texto con el nombre y apellidos del alumno. 
     * Si ya existe, simplemente mostrará un mensaje indicando que ya existe un archivo con ese nombre y no hará nada más.
     * @param nombreArchivo
     * @throws IOException
     */
    public static void crearArchivoUsuario (String nombreArchivo) throws IOException{

        nombreArchivo += ".txt";

        Path nuevoArchivo = Paths.get(DIRECTORY_PATH, nombreArchivo);
        if (!Files.exists(nuevoArchivo)) {
            try{
                Files.createFile(nuevoArchivo);
                Files.write(nuevoArchivo, "Francisco Luna Raya".getBytes());
                System.out.println("\nArchivo creado correctamente");
            }catch(IOException e){
                System.out.println("\nError al escribir en el archivo" + e.getMessage());
            }
        } else{
            System.out.println("\nNo se ha podido crear el archivo, porque ya existe un archivo con ese nombre");
        }
    }

    /**
     * Cuando se seleccione esta opción se pedirá al usuario el nombre de un archivo de texto que debe estar en la carpeta de de usuario. 
     * Si dicho archivo existe se mostrará el contenido del archivo por la consola mostrando cada línea del archivo en una línea diferente en la consola. 
     * Además, al final de todas las líneas se mostrará una línea adicional indicando cuantas lineas de texto tenía el fichero. 
     * Si no existe el archivo con el nombre indicado, simplemente se mostrará un mensaje indicándolo al usuario.
     * @param nombreArchivo
     */
    public static void mostrarContenidoArchivo (String nombreArchivo){

        Path archivo = Paths.get(DIRECTORY_PATH, nombreArchivo);

        if (Files.exists(archivo) && Files.isRegularFile(archivo)){
            try {

                List<String> lineas = Files.readAllLines(archivo);
                System.out.println("\nContenido del archivo: ");

                for (String linea : lineas){
                    System.out.println(linea);
                }

                System.out.println("\nNúmero de líneas del archivo: " + lineas.size());
            } catch (IOException e) {
                System.out.println("\nError al leer el archivo: " + e.getMessage());
            }
        }else{
            System.out.println("\nEl archivo no existe");
        }
    }

    /**
     * Cuando se seleccione esta opción se pedirá al usuario el nombre de un archivo de texto que debe estar en la carpeta de de usuario. 
     * Si dicho archivo existe se pedirá al usuario que introduzca una nueva línea de texto por la consola y dicha línea se añadirá al final del archivo. 
     * Si no existe el archivo con el nombre indicado, simplemente se mostrará un mensaje indicándolo al usuario.
     * @param nombreArchivo
     */
    public static void anyadirLinea (String nombreArchivo){

        
        Path archivo = Paths.get(DIRECTORY_PATH, nombreArchivo);

        if(Files.exists(archivo) && Files.isRegularFile(archivo)){
            try {
                System.out.println("\nIntroduce la línea de texto a añadir en el archivo de texto: ");
                String texto = scanner.nextLine();

                Files.write(archivo, (texto + System.lineSeparator()).getBytes(), java.nio.file.StandardOpenOption.APPEND);
                System.out.println("\nSe ha escrito en el archivo correctamente");
            } catch (IOException e) {
                System.out.println("\nError al escribir en el archivo: " + e.getMessage());
            }
        }else{
            System.out.println("\nEl archivo no existe");
        }
    }

    /**
     * Cuando se seleccione esta opción se pedirá al usuario el nombre de un archivo de texto que debe estar en la carpeta de de usuario. 
     * Si dicho archivo existe se borrará y se mostrará un mensaje de confirmación al usuario por la consola. 
     * Si no existe el archivo con el nombre indicado, simplemente se mostrará un mensaje indicándolo al usuario.
     * @param nombreArchivo
     */
    public static void eliminarArchivo(String nombreArchivo) {

        Path archivo = Paths.get(DIRECTORY_PATH, nombreArchivo);

        if (Files.exists(archivo) && Files.isRegularFile(archivo)) {

            System.out.println("\n¿Desea borrar el archivo con nombre '" + nombreArchivo + "' (s/n)?");
            String respuetaBorrado = scanner.nextLine();
            scanner.nextLine();

            if (respuetaBorrado.equalsIgnoreCase("s")) {
                    try {
                        Files.delete(archivo);
                        System.out.println("\nEl archivo con nombre: '" + nombreArchivo + "' ha sido eliminado correctamente.");
                    } catch (IOException e) {
                        System.out.println("\nError al eliminar el archivo: " + e.getMessage());
                    }
            }else{
                System.out.println("\nHa decidido no borrar el archivo");
            }
        } else {
            System.out.println("\nEl archivo con nombre'" + nombreArchivo + "' no existe.");
        }     
    }
}
