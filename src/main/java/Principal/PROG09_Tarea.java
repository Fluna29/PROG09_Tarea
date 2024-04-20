package Principal;
import Funciones.Funciones;
/**
 *
 * @author fluna
 */
public class PROG09_Tarea {

    public static void main(String[] args) {
        try {
            
            Funciones.mostrarDirectoriosUsuario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
