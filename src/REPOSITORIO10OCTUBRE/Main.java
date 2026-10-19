package REPOSITORIO10OCTUBRE;

public class Main {
    public static void main(String[] args) {
        System.out.println("Resolviendo Sistema de Ecuaciones Lineales");

        // Ejecución secuencial de los métodos modulares
        MetodosIterativos.resolverJacobi();
        MetodosIterativos.resolverGaussSeidel();
    }
}
