package Principal;
import Funciones.Funciones;

import java.io.IOException;
import java.util.Scanner;
/**
 * En esta clase vamos a ejecutar la clase main, importando la clase Funciones que es donde
 * tenemos todas las funciones de nuestra tarea.
 * @author Francisco Luna Raya
 */
public class PROG09_Tarea {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    
        int eleccion;

        do{
            menu();
            System.out.println("\nIntroduzca un número acorde al menú (1-6)");
            eleccion = scanner.nextInt();
            if (0< eleccion && eleccion < 7){
                switch (eleccion) {
                    case 1:
                        mostrarDirectoriosUsuario();
                        scanner.nextLine();
                        break;
                    case 2:
                        nuevoArchivo();
                        scanner.nextLine();
                        break;
                    case 3:
                        mostrarContenidoArchivo();
                        scanner.nextLine();
                        break;
                    case 4:
                        anyadirLinea();
                        scanner.nextLine();
                        break;
                    case 5:
                        eliminarArchivo();
                        scanner.nextLine();
                        break;
                    case 6:
                        System.out.println("\nHasta la próxima");
                        break;
                    default:
                        System.out.println("\nERROR");
                        break;
                }  
            }
        }while (eleccion != 6);
    }

    /**
     * Esta función devuelve el texto del menú visual
     */
    private static void menu(){
        System.out.println("\n====MENÚ PRINCIPAL====");
        System.out.println(" 1. Mostrar directorios de la carpeta de usuario");
        System.out.println(" 2. Crear un nuevo archivo de texto en la carpeta de usuario");
        System.out.println(" 3. Mostrar el contenido de un archivo de texto de la carpeta de usuario");
        System.out.println(" 4. Añadir una nueva línea de texto a un archivo de la carpeta de usuario");
        System.out.println(" 5. Eliminar un archivo de la carpeta de usuario");
        System.out.println(" 6. Salir");
    }


    /**
     * En esta función llamamos a la lógica de la función en la clase Funciones,
     * pero lo único que hacemos aquí es controlar el error.
     */
    private static void mostrarDirectoriosUsuario (){
        try {
            Funciones.mostrarDirectoriosUsuario();
        } catch (IOException e) {
            System.out.println("\nNo se pueden mostrar los directorios " + e.getMessage());
        }
    }

    /**
     * En esta función llamamos a la lógica de la función en la clase Funciones,
     * aquí se pide al usuario que introduzca el nombre del archivo que quiera crear
     * y mediante el uso de un try-catch se contrla la excepción.
     */
    private static void nuevoArchivo (){
        
        System.out.println("\nIntroduzca el nombre del archivo a crear: ");
        String nombreArchivo = scanner.nextLine();
        while (nombreArchivo.isEmpty()) {
            nombreArchivo = scanner.nextLine().trim(); // trim() para eliminar espacios en blanco
            if (nombreArchivo.isEmpty()) {
                System.out.println("Por favor, ingrese un valor válido.");
            }
        }
        try {
            Funciones.crearArchivoUsuario(nombreArchivo);
        } catch (IOException e) {
            System.out.println("\nError al escribir en el archivo" + e.getMessage());
        }
    }

    /**
     * En esta función llamamos a la lógica de la función en la clase Funciones,
     * aquí se pide al usuario que introduzca el nombre del archivo del que quiera ver
     * el contenido.
     */
    private static void mostrarContenidoArchivo (){

        System.out.println("\nIntroduzca el nombre del archivo para mostrar su contenido: ");
        String nombreArchivo = scanner.nextLine();
        while (nombreArchivo.isEmpty()) {
            nombreArchivo = scanner.nextLine().trim(); // trim() para eliminar espacios en blanco
            if (nombreArchivo.isEmpty()) {
                System.out.println("Por favor, ingrese un valor válido.");
            }
        }
        Funciones.mostrarContenidoArchivo(nombreArchivo);
    }

    /**
     * En esta función llamamos a la lógica de la función en la clase Funciones,
     * aquí se pide al usuario que introduzca el nombre del archivo en el que quiera añadir una línea.
     * Tras esto, la propia función de la clase Funciones, le pide que introduzca el texto de la línea.
     */
    private static void anyadirLinea (){
        
        System.out.println("\nIntroduzca el nombre del archivo para añadir una línea: ");
        String nombreArchivo = scanner.nextLine();
        while (nombreArchivo.isEmpty()) {
            nombreArchivo = scanner.nextLine().trim(); // trim() para eliminar espacios en blanco
            if (nombreArchivo.isEmpty()) {
                System.out.println("Por favor, ingrese un valor válido.");
            }
        }
        Funciones.anyadirLinea(nombreArchivo);
    }

    /**
     * En esta función llamamos a la lógica de la función en la clase Funciones,
     * aquí se pide al usuario que introduzca el nombre del archivo a eliminar.
     * Tras esto, la propia función de la clase Funciones, le pide que una confirmación antes de eliminarlo.
     */
    private static void eliminarArchivo(){
        System.out.println("\nIntroduzca el nombre del archivo a eliminar: ");
        String nombreArchivo = scanner.nextLine();
        while (nombreArchivo.isEmpty()) {
            nombreArchivo = scanner.nextLine().trim(); // trim() para eliminar espacios en blanco
            if (nombreArchivo.isEmpty()) {
                System.out.println("Por favor, ingrese un valor válido.");
            }
        }
        Funciones.eliminarArchivo(nombreArchivo);
    }
}
