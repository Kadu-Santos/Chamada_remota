import java.rmi.registry.*;
import java.util.Scanner;

public class CircleClient {
    public static void main(String[] args) {
        try {
            // Conectar ao registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Procurar a stub do servidor
            Circle stub = (Circle) registry.lookup("CircleService");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;

            // Loop para repetição das operações até o usuário escolher sair
            while (choice != 4) {
                System.out.println("Escolha a opção para calcular a área de um círculo:");
                System.out.println("[1] Raio                   [3] Circunferência");
                System.out.println("[2] Diâmetro               [4] Sair");
                System.out.print("-> ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Informe o raio(cm): ");
                        double radius = scanner.nextDouble();
                        System.out.println("Área: " + stub.areaFromRadius(radius) + " cm²");
                        break;
                    case 2:
                        System.out.print("Informe o diâmetro(cm): ");
                        double diameter = scanner.nextDouble();
                        System.out.println("Área: " + stub.areaFromDiameter(diameter) + " cm²");
                        break;
                    case 3:
                        System.out.print("Informe a circunferência(cm): ");
                        double circumference = scanner.nextDouble();
                        System.out.println("Área: " + stub.areaFromCircumference(circumference) + " cm²");
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                System.out.println(); // Espaço entre iterações
            }

            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
