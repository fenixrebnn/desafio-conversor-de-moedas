package application;

import java.util.Scanner;

import entities.ConversorMoedasAPI;

public class ConversorMoedasConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("=== Conversor de Moedas ===");
                System.out.println("1. BRL (Real Brasileiro) -> USD (Dólar Americano)");
                System.out.println("2. BRL (Real Brasileiro) -> EUR (Euro)");
                System.out.println("3. USD (Dólar Americano) -> BRL (Real Brasileiro)");
                System.out.println("4. EUR (Euro) -> BRL (Real Brasileiro)");
                System.out.println("5. USD (Dólar Americano) -> EUR (Euro)");
                System.out.println("6. EUR (Euro) -> USD (Dólar Americano)");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                if (opcao == 0) {
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                }

                System.out.print("Digite o valor a ser convertido: ");
                double valor = scanner.nextDouble();

                String from = "";
                String to = "";

                switch (opcao) {
                    case 1: from = "BRL"; to = "USD"; break;
                    case 2: from = "BRL"; to = "EUR"; break;
                    case 3: from = "USD"; to = "BRL"; break;
                    case 4: from = "EUR"; to = "BRL"; break;
                    case 5: from = "USD"; to = "EUR"; break;
                    case 6: from = "EUR"; to = "USD"; break;
                    default:
                        System.out.println("Opção inválida!");
                        continue;
                }

                try {
                    double taxa = ConversorMoedasAPI.getTaxa(from, to);
                    double resultado = valor * taxa;

                    System.out.printf("%.2f %s = %.2f %s%n", valor, from, resultado, to);
                } catch (Exception e) {
                    System.out.println("Erro ao obter taxa de câmbio: " + e.getMessage());
                }

                System.out.println();
            }
        } finally {
            scanner.close();
        }
    }
}
