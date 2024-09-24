package br.com.alura.conversormoedas.principal;

import br.com.alura.conversormoedas.service.ConversorService;
import br.com.alura.conversormoedas.excecao.ValorInvalidoExcecao;
import br.com.alura.conversormoedas.util.Moeda;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        double valor;
        Moeda entrada = null;
        Moeda saida = null;

        ConversorService conversorService = new ConversorService();

        while (true) {
            System.out.print("""
                    ********************************************
                    Seja bem-vinda(o) ao conversorService de moedas!
                    
                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino =>> Dólar
                    3) Dólar =>> Real Brasileiro
                    4) Real Brasileiro =>> Dólar
                    5) Dólar =>> Peso Colombiano
                    6) Peso Colombiano =>> Dólar
                    7) Dólar ==> Boliviano da Bolívia
                    8) Boliviano da Bolívia ==> Dólar
                    9) Dólar ==> Peso Chileno
                    10) Peso Chileno =>> Dólar
                    11) Sair
                    
                    Escolha uma opção válida:
                    ********************************************
                    """);
            try {
                opcao = scanner.nextInt();

                if (opcao < 1 || opcao > 11) {
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
                } else if (opcao == 11) {
                    System.out.println("Obrigada por utilizar nosso serviço!");
                    break;
                }

                switch (opcao) {
                    case 1 -> {
                        entrada = Moeda.DOLAR;
                        saida = Moeda.PESO_ARGENTINO;
                    }
                    case 2 -> {
                        entrada = Moeda.PESO_ARGENTINO;
                        saida = Moeda.DOLAR;
                    }
                    case 3 -> {
                        entrada = Moeda.DOLAR;
                        saida = Moeda.REAL_BRASELEIRO;
                    }
                    case 4 -> {
                        entrada = Moeda.REAL_BRASELEIRO;
                        saida = Moeda.DOLAR;
                    }
                    case 5 -> {
                        entrada = Moeda.DOLAR;
                        saida = Moeda.PESO_COLOMBIANO;
                    }
                    case 6 -> {
                        entrada = Moeda.PESO_COLOMBIANO;
                        saida = Moeda.DOLAR;
                    }
                    case 7 -> {
                        entrada = Moeda.DOLAR;
                        saida = Moeda.BOLIVIANO;
                    }
                    case 8 -> {
                        entrada = Moeda.BOLIVIANO;
                        saida = Moeda.DOLAR;
                    }
                    case 9 -> {
                        entrada = Moeda.DOLAR;
                        saida = Moeda.PESO_CHILENO;
                    }
                    case 10 -> {
                        entrada = Moeda.PESO_CHILENO;
                        saida = Moeda.DOLAR;
                    }
                }

                System.out.println("Digite o valor a ser convertido: ");
                valor = scanner.nextDouble();

                double resultado = conversorService.converter(entrada, saida, valor);

                System.out.printf("O valor de %.2f [%s] corresponde ao valor final de =>>> %.2f [%s] %n%n", valor, entrada.getCodigo(), resultado, saida.getCodigo());
            } catch (IOException e) {
                System.out.println("Erro ao acessar a API: " + e.getMessage());
            } catch (InterruptedException e1) {
                System.out.println("Thread interrompido, saindo...");
                return;
            } catch (ValorInvalidoExcecao e2) {
                System.out.println("Erro: " + e2.getMessage());
            } catch (InputMismatchException e3) {
                System.out.println("Erro: Formato incorreto de entrada de dados...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
