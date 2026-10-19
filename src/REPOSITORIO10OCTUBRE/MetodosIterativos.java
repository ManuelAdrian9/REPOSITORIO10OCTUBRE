package REPOSITORIO10OCTUBRE;

public class MetodosIterativos {
    // Método de Jacobi
    public static void resolverJacobi() {
        double[][] A = SistemaEcuaciones.A;
        double[] b = SistemaEcuaciones.b;
        double[] X = SistemaEcuaciones.X0.clone();
        double tolerancia = SistemaEcuaciones.TOLERANCIA;
        int n = b.length;

        System.out.println("\n--- EJECUCIÓN: MÉTODO DE JACOBI ---");
        int iteracion = 0;
        double error = Double.MAX_VALUE;

        while (error > tolerancia) {
            double[] X_nuevo = new double[n]; // Vector auxiliar

            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * X[j];
                    }
                }
                X_nuevo[i] = (b[i] - suma) / A[i][i];
            }

            // Calcular el error (Norma infinito)
            error = 0.0;
            for (int i = 0; i < n; i++) {
                double diff = Math.abs(X_nuevo[i] - X[i]);
                if (diff > error) {
                    error = diff;
                }
            }

            X = X_nuevo; // Actualización simultánea al final de la iteración
            iteracion++;

            System.out.printf("Iteración %d: x1=%.5f, x2=%.5f, x3=%.5f | Error=%.5f%n",
                    iteracion, X[0], X[1], X[2], error);
        }
        System.out.println("Jacobi convergió en " + iteracion + " iteraciones.");
    }

    // Método de Gauss-Seidel
    public static void resolverGaussSeidel() {
        double[][] A = SistemaEcuaciones.A;
        double[] b = SistemaEcuaciones.b;
        double[] X = SistemaEcuaciones.X0.clone();
        double tolerancia = SistemaEcuaciones.TOLERANCIA;
        int n = b.length;

        System.out.println("\n--- EJECUCIÓN: MÉTODO DE GAUSS-SEIDEL ---");
        int iteracion = 0;
        double error = Double.MAX_VALUE;

        while (error > tolerancia) {
            error = 0.0; // Se evalúa el error respecto a la iteración anterior

            for (int i = 0; i < n; i++) {
                double valorAnterior = X[i];
                double suma = 0.0;

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * X[j]; // Emplea actualización inmediata
                    }
                }
                X[i] = (b[i] - suma) / A[i][i];

                // Calcular error parcial para la norma infinito
                double diff = Math.abs(X[i] - valorAnterior);
                if (diff > error) {
                    error = diff;
                }
            }
            iteracion++;

            System.out.printf("Iteración %d: x1=%.5f, x2=%.5f, x3=%.5f | Error=%.5f%n",
                    iteracion, X[0], X[1], X[2], error);
        }
        System.out.println("Gauss-Seidel convergió en " + iteracion + " iteraciones.");
    }
}
