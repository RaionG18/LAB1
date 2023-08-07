// ============================================================================
// LAB 1 - POO
// Emilio Gordillo
// Carne 18062
// ============================================================================

// ============================================================================
// LIBRERIAS
// ============================================================================
import java.util.Scanner;

// ============================================================================
// LOOP PRINCIPAL
// ============================================================================
public class Main {

    public static void main(String[] args) {
        // Crear las dos atracciones
        Atraccion atraccion1 = new Atraccion("Montaña rusa 1", 1.5);
        Atraccion atraccion2 = new Atraccion("Montaña rusa 2", 1.6);

        Scanner scanner = new Scanner(System.in);

        // Recolectar información del usuario
        System.out.println("Ingrese su estatura en metros:");
        double estatura = scanner.nextDouble();
        System.out.println("¿Tiene problemas cardiacos? (ingrese 'true' para sí, 'false' para no):");
        boolean problemasCardiacos = scanner.nextBoolean();
        System.out.println("¿Tiene problemas de espalda? (ingrese 'true' para sí, 'false' para no):");
        boolean problemasEspalda = scanner.nextBoolean();

        // Crear el objeto Usuario
        Usuario usuario = new Usuario(estatura, problemasCardiacos, problemasEspalda);

        // Verificar si el usuario puede ingresar a las atracciones
        verificar(usuario, atraccion1);
        verificar(usuario, atraccion2);
    }

    // ============================================================================
    // FUNCIONES ESTATICAS
    // ============================================================================
    public static void verificar(Usuario usuario, Atraccion atraccion) {
        if (puedeIngresar(usuario, atraccion)) {
            System.out.println("Usted puede ingresar a la atracción: " + atraccion.getNombre());
        } else {
            System.out.println("Lo siento, no puede ingresar a la atracción: " + atraccion.getNombre());
        }
    }

    public static boolean puedeIngresar(Usuario usuario, Atraccion atraccion) {
        if (usuario.getEstatura() < atraccion.getEstaturaMinima()) {
            return false;
        }
        if (usuario.tieneProblemasCardiacos() || usuario.tieneProblemasDeEspalda()) {
            return false;
        }
        return true;
    }
}

// ============================================================================
// CLASES
// ============================================================================
class Usuario {
    private double estatura;
    private boolean tieneProblemasCardiacos;
    private boolean tieneProblemasDeEspalda;

    // constructor
    public Usuario(double estatura, boolean tieneProblemasCardiacos, boolean tieneProblemasDeEspalda) {
        this.estatura = estatura;
        this.tieneProblemasCardiacos = tieneProblemasCardiacos;
        this.tieneProblemasDeEspalda = tieneProblemasDeEspalda;
    }

    // getters
    public double getEstatura() {
        return estatura;
    }

    public boolean tieneProblemasCardiacos() {
        return tieneProblemasCardiacos;
    }

    public boolean tieneProblemasDeEspalda() {
        return tieneProblemasDeEspalda;
    }
}

class Atraccion {
    private String nombre;
    private double estaturaMinima;

    // constructor
    public Atraccion(String nombre, double estaturaMinima) {
        this.nombre = nombre;
        this.estaturaMinima = estaturaMinima;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public double getEstaturaMinima() {
        return estaturaMinima;
    }
}
