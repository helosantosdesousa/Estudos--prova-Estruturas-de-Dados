import java.util.stream.Stream;

public class AVLGood {
    private class Node {
        Good data;
        Node left;
        Node right;
        int hLeft, hRight;
    }

    public Node root = null;

    public Node insert(Node tree, Good good) {
        if (tree == null) {
            tree = new Node();
            tree.data = good;
            tree.right = null;
            tree.left = null;
            tree.hRight = 0;
            tree.hLeft = 0;
        } else if (good.getIUD() < tree.data.getIUD()) {
            tree.left = insert(tree.left, good);
            if (tree.left.hRight > tree.left.hLeft) {
                tree.hLeft = tree.hRight + 1;
            } else {
                tree.hLeft = tree.hLeft + 1;
            }
        } else {
            tree.right = insert(tree.right, good);
            if (tree.right.hRight > tree.right.hLeft) {
                tree.hRight = tree.right.hRight + 1;
            } else {
                tree.hRight = tree.right.hLeft + 1;
            }
        }
        return tree;
    }

    //2 - Apresenta todos os produtos com preço menores do que um valor escolhido;
    public void showLowerValues(Node tree, double price) {
        if (tree != null) {
            if (tree.data.getValue() < price) {
                System.out.println("Good IUD: " + tree.data.getIUD() + " -- " + "Description: " + tree.data.getDescription());
            }
            showLowerValues(tree.left, price);
            showLowerValues(tree.right, price);
        }
    }

    //3- Remove um produto do cadastro da loja escolhido por seu código
    public Node removal(Node tree, int iud) {
        if (tree != null) {
            if (tree.data.getIUD() == iud) {
                if (tree.left == null && tree.right == null) {
                    return null;
                } else {
                    if (tree.left == null) {
                        return tree.right;
                    } else if (tree.right == null) {
                        return tree.left;
                    } else {
                        Node aux, ref;
                        ref = tree.right;
                        aux = tree.right;
                        while (aux.left != null) {
                            aux = aux.left;
                        }
                        aux.left = tree.left;
                        return ref;
                    }
                }
            } else {
                if (iud < tree.data.getIUD()) {
                    tree.left = removal(tree.left, iud);
                } else {
                    tree.right = removal(tree.right, iud);
                }
            }
        }
        return tree;
    }

    //4- Consulta pelo código um produto, apresentando a descrição e preço,
    public void findGood(Node tree, int iud) {
        if (tree != null) {
            System.out.println("Good not found.");
        }
        if (tree.data.getIUD() == iud) {
            System.out.println("Good IUD: " + tree.data.getIUD() + " -- Description: " + tree.data.getDescription()
                    + " -- Price: " + tree.data.getValue());
        }
        if (iud < tree.data.getIUD()) {
            findGood(tree.left, iud);
        } else {
            findGood(tree.right, iud);
        }
    }
}
