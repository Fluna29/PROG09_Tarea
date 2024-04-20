package Funciones;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * En esta clase van a ir todas las funciones a utilizar en nuestra clase PROG09_Tarea
 * @author Francisco Luna Raya
 */
public class Funciones {
    
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

        //TODO Escribir fecha ultima modificacion + tamaño en KiloBytes

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

    public static void crearArchivoUsuario (String nombreArchivo) throws IOException{

        Path directory = Paths.get(DIRECTORY_PATH);

        DirectoryStream<Path> items = null;
        try{
            Files.newDirectoryStream(directory);
            for(Path file : items){
                if (true) {
                    
                }
            }
        }finally{

        }
    }
}
