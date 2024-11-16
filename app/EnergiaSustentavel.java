package app;

import arvore.AVL;
import beans.Cliente;

import java.util.Scanner;
public class EnergiaSustentavel {
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        AVL cadastro = new AVL();
        AVL ofertaArvore = new AVL();
        int opcao, op;
        String nome, tipoEnergia, cpf;
        double consumoMensal;

        do {
            System.out.println("0 - Encerrar o programa");
            System.out.println("1 - Inscrição de um cliente");
            System.out.println("2 - Oferta de energia sustentável");
            System.out.println("3 - Entrar no Submenu");
            opcao = le.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("\n\nClientes que não estavam aptos para a oferta:");
                    cadastro.imprimirClientesNaoAceitaramOferta(cadastro.root);
                    break;
                case 1:
                    System.out.print("Digite nome: ");
                    le.nextLine(); // Consumir a linha de quebra
                    nome = le.nextLine();
                    System.out.print("Digite CPF: ");
                    cpf = le.next();
                    System.out.print("Tipo de energia consumida (solar, eólica, elétrica): ");
                    tipoEnergia = le.next();
                    System.out.print("Informe consumo mensal de energia (kWh): ");
                    consumoMensal = le.nextDouble();

                    Cliente cliente = new Cliente(nome, cpf, tipoEnergia, consumoMensal);
                    cadastro.root = cadastro.inserir(cadastro.root, cliente);
                    break;
                case 2:
                    System.out.print("Qual o valor mínimo de consumo de energia (kWh) para a ofertaArvore? ");
                    double minimo = le.nextDouble();
                    cadastro.verificaApto(minimo, cadastro.root);
                    cadastro.gerarOferta(cadastro.root, ofertaArvore);
                    break;

                case 3:
                    do {
                        System.out.println("\t1) Consulta cliente buscando pelo CPF");
                        System.out.println("\t2) Apresenta o total de consumo de energia de todos os clientes");
                        System.out.println("\t3) Apresenta a quantidade de clientes com consumo acima de um valor");
                        System.out.println("\t4) Voltar menu principal");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                System.out.print("Informe CPF para consulta: ");
                                cpf = le.next();
                                cadastro.consultarPorCpf(cadastro.root, cpf);
                                break;
                            case 2:
                                cadastro.somarConsumoTodosClientes(cadastro.root);
                                break;
                            case 3:
                                System.out.print("Qual valor mínimo de consumo de energia para consulta? ");
                                minimo = le.nextDouble();
                                cadastro.contarClientesAcimaDeMinimo(cadastro.root, minimo);
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (op != 4);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
        le.close();
    }
}