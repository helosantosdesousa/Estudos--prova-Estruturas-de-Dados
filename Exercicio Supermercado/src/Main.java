import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Elabore um programa que crie uma AVL para armazenar produtos de um supermercado. Cada produto possui os seguintes atributos: código (inteiro), descrição, preço. A AVL deve ser organizar seus nós pelo atributo código do produto. O programa deve possuir um menu que permita:
0 - Sair do programa
1 – Inserir 1 novo produto no cadastro da loja;
2 - Apresenta todos os produtos com preço menores do que um valor escolhido;
3- Remove um produto do cadastro da loja escolhido por seu código
4- Consulta pelo código um produto, apresentando a descrição e preço,
*/

        int op = 0;
        AVLGood tree = new AVLGood();

        do {
            System.out.println("0 - END\n1 - Insert goods\n2 - Shows goods with prices below a chosen value." +
                    "\n3 - Remove goods\n4 - Find goods ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Insert good IUD: ");
                    int iud = sc.nextInt();
                    System.out.println("Insert good description: ");
                    String des = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Insert good price: ");
                    double price = sc.nextDouble();
                    Good good = new Good(iud, des, price);
                    tree.root = tree.insert(tree.root, good);
                    break;
                case 2:
                    System.out.println("Price: ");
                    price = sc.nextDouble();
                    tree.showLowerValues(tree.root, price);
                    break;

                case 3:
                    System.out.println("Insert an IUD to remove: ");
                    iud = sc.nextInt();
                    tree.removal(tree.root, iud);
                    break;
                case 4:
                    System.out.println("Insert an IUD");
                    iud = sc.nextInt();
                    tree.findGood(tree.root, iud);
                    break;
                default:
                    System.out.println("Invalid");
            }
        } while (op != 0);
    }
}