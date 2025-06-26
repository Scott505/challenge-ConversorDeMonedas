import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConvertidorDeMoneda convertidor = new ConvertidorDeMoneda();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n--- Bienvenido al conversor de monedas ---");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar ");
            System.out.println("3. Dólar a Real Brasileño ");
            System.out.println("4. Real Brasileño a Dólar ");
            System.out.println("5. Dólar a Peso Colombiano ");
            System.out.println("6. Peso Colombiano a Dólar ");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            opcion = teclado.nextInt();

            String origen = "";
            String destino = "";
            switch (opcion) {
                case 1 -> {
                    origen = "USD";
                    destino = "ARS";
                }
                case 2 -> {
                    origen = "ARS";
                    destino = "USD";
                }
                case 3 -> {
                    origen = "USD";
                    destino = "BRL";
                }
                case 4 -> {
                    origen = "BRL";
                    destino = "USD";
                }
                case 5 -> {
                    origen = "USD";
                    destino = "COP";
                }
                case 6 -> {
                    origen = "COP";
                    destino = "USD";
                }
                case 7 -> {
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    continue;
                }
                default -> {
                    System.out.println("Opción inválida. Intente de nuevo.");
                    continue;
                }
            }

            System.out.print("Ingrese el monto a convertir: ");
            double monto = teclado.nextDouble();

            double resultado = convertidor.convertir(origen, destino, monto);
            System.out.printf("Resultado: %.2f %s = %.2f %s\n", monto, origen, resultado, destino);
        }

        teclado.close();
    }
}
