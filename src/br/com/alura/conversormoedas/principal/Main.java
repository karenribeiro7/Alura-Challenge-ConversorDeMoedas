package br.com.alura.conversormoedas.principal;

import br.com.alura.conversormoedas.entities.Conversao;
import br.com.alura.conversormoedas.service.ConversorService;
import br.com.alura.conversormoedas.excecao.ValorInvalidoExcecao;
import br.com.alura.conversormoedas.util.Moeda;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        double valor;
        Moeda entrada = null;
        Moeda saida = null;

        ConversorService conversorService = new ConversorService();

        List<Conversao> historico = new ArrayList<>();

        while (true) {
            System.out.print("""
                    ********************************************
                    Seja bem-vinda(o) ao conversor de moedas!
                    
                    1) Real Brasileiro =>> Peso Argentino
                    2) Peso Argentino =>> Real Brasileiro
                    3) Real Brasileiro =>> Dólar 
                    4) Dólar =>> Real Brasileiro
                    5) Real Brasileiro =>> Peso Colombiano
                    6) Peso Colombiano =>> Real Brasileiro
                    7) Real Brasileiro ==> Boliviano da Bolívia
                    8) Boliviano da Bolívia ==> Real Brasileiro
                    9) Real Brasileiro ==> Peso Chileno
                    10) Peso Chileno =>> Real Brasileiro
                    11) Real Brasileiro ==> Euro
                    12) Euro ==> Real Brasileiro
                    13) Imprimir histórico de conversões
                    14) Sair
                    
                    Escolha uma opção válida:
                    ********************************************
                    """);
            try {
                opcao = scanner.nextInt();

                if (opcao < 1 || opcao > 14) {
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
                } else if (opcao == 14) {
                    System.out.println("Obrigada por utilizar nosso serviço!");
                    break;
                }

                switch (opcao) {
                    case 1 -> {
                        entrada = Moeda.REAL_BRASILEIRO;
                        saida = Moeda.PESO_ARGENTINO;
                    }
                    case 2 -> {
                        entrada = Moeda.PESO_ARGENTINO;
                        saida = Moeda.REAL_BRASILEIRO;
                    }
                    case 3 -> {
                        entrada = Moeda.REAL_BRASILEIRO;
                        saida = Moeda.DOLAR;
                    }
                    case 4 -> {
                        entrada = Moeda.DOLAR;
                        saida = Moeda.REAL_BRASILEIRO;
                    }
                    case 5 -> {
                        entrada = Moeda.REAL_BRASILEIRO;
                        saida = Moeda.PESO_COLOMBIANO;
                    }
                    case 6 -> {
                        entrada = Moeda.PESO_COLOMBIANO;
                        saida = Moeda.REAL_BRASILEIRO;
                    }
                    case 7 -> {
                        entrada = Moeda.REAL_BRASILEIRO;
                        saida = Moeda.BOLIVIANO;
                    }
                    case 8 -> {
                        entrada = Moeda.BOLIVIANO;
                        saida = Moeda.REAL_BRASILEIRO;
                    }
                    case 9 -> {
                        entrada = Moeda.REAL_BRASILEIRO;
                        saida = Moeda.PESO_CHILENO;
                    }
                    case 10 -> {
                        entrada = Moeda.PESO_CHILENO;
                        saida = Moeda.REAL_BRASILEIRO;
                    }
                    case 11 -> {
                        entrada = Moeda.REAL_BRASILEIRO;
                        saida = Moeda.EURO;
                    }
                    case 12 -> {
                        entrada = Moeda.EURO;
                        saida = Moeda.REAL_BRASILEIRO;
                    }
                    case 13 -> {
                        if (historico.isEmpty()) {
                            System.out.println("Nenhuma conversão feita ainda!");
                        } else {
                            System.out.println("""
                                    \n********************************************
                                    HISTÓRICO DE CONVERSÃO:
                                    """);

                            for (Conversao conversao : historico) {
                                System.out.println("- " + conversao);
                            }
                            System.out.println("********************************************\n");
                        }
                        continue;
                    }

                }

                System.out.println("Digite o valor a ser convertido: ");
                valor = scanner.nextDouble();

                double resultado = conversorService.converter(entrada, saida, valor);

                historico.add(new Conversao(entrada, saida, valor, resultado, LocalDateTime.now()));

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
