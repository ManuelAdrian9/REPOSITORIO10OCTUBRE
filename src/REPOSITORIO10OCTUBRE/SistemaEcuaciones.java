package REPOSITORIO10OCTUBRE;

public class SistemaEcuaciones {
    // Matriz de coeficientes A
    public static final double[][] A = {
            {5.0, 1.0, 1.0},
            {1.0, 4.0, 1.0},
            {1.0, 2.0, 5.0}
    };

    // Vector de términos independientes b
    public static final double[] b = {7.0, 6.0, 8.0};

    // Vector de aproximación inicial X(0) = [0, 0, 0]^T
    public static final double[] X0 = {0.0, 0.0, 0.0};

    // Tolerancia de error establecida
    public static final double TOLERANCIA = 0.0001;
}
