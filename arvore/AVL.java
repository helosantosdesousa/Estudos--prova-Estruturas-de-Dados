package arvore;

import beans.Cliente;


public class AVL {

    private class NODE {
        Cliente dado;
        NODE esq;
        NODE dir;
        int hDir;
        int hEsq;
    }

    public NODE root = null;

    public void mostraFB(NODE p) {
        if (p != null) {
            mostraFB(p.esq);
            mostraFB(p.dir);
            System.out.println("dado: " + p.dado + "\t FB= " + (p.hDir - p.hEsq));
        }
    }

    public NODE rotacaoDireita(NODE p) {
        // faz rotação para direita em relação ao nó apontado por p
        NODE q, temp;
        q = p.esq;
        temp = q.dir;
        q.dir = p;
        p.esq = temp;
        return q;
    }

    public NODE rotacaoEsquerda(NODE p) {
        // faz rotação para esquerda em relação ao nó apontado por p
        NODE q, temp;
        q = p.dir;
        temp = q.esq;
        q.esq = p;
        p.dir = temp;
        return q;
    }

    public NODE balanceamento(NODE p) {
        // analisa FB e realiza rotações necessárias para balancear árvore
        int FB = p.hDir - p.hEsq;
        if (FB > 1) {
            int fbFilhoDir = p.dir.hDir - p.dir.hEsq;
            if (fbFilhoDir >= 0)
                p = rotacaoEsquerda(p);
            else {
                p.dir = rotacaoDireita(p.dir);
                p = rotacaoEsquerda(p);
            }
        } else {
            if (FB < -1) {
                int fbFilhoEsq = p.esq.hDir - p.esq.hEsq;
                if (fbFilhoEsq <= 0)
                    p = rotacaoDireita(p);
                else {
                    p.esq = rotacaoEsquerda(p.esq);
                    p = rotacaoDireita(p);
                }
            }
        }
        return p;
    }

    public NODE inserir(NODE p, Cliente info) {
        if (p == null) { // nó inserido sempre será nó folha
            p = new NODE();
            p.dado = info;
            p.esq = null;
            p.dir = null;
            p.hDir = 0;
            p.hEsq = 0;
        } else if (info.getCpf().compareTo(p.dado.getCpf()) < 0) {
            p.esq = inserir(p.esq, info);
            if (p.esq.hDir > p.esq.hEsq) // Altura do nó será a maior
                p.hEsq = p.esq.hDir + 1; // altura dos seus filhos
            else
                p.hEsq = p.esq.hEsq + 1;
            p = balanceamento(p);
        } else {
            p.dir = inserir(p.dir, info);
            if (p.dir.hDir > p.dir.hEsq)
                p.hDir = p.dir.hDir + 1;
            else
                p.hDir = p.dir.hEsq + 1;
            p = balanceamento(p);
        }
        return p;
    }

    public void atualizaAlturas(NODE p) {
        /*
         * atualiza informação da altura de cada nó depois da remoção percorre a árvore
         * usando percurso pós-ordem para ajustar primeiro os nós folhas (profundidade
         * maior) e depois os níveis acima
         */
        if (p != null) {
            atualizaAlturas(p.esq);
            if (p.esq == null)
                p.hEsq = 0;
            else if (p.esq.hEsq > p.esq.hDir)
                p.hEsq = p.esq.hEsq + 1;
            else
                p.hEsq = p.esq.hDir + 1;
            atualizaAlturas(p.dir);
            if (p.dir == null)
                p.hDir = 0;
            else if (p.dir.hEsq > p.dir.hDir)
                p.hDir = p.dir.hEsq + 1;
            else
                p.hDir = p.dir.hDir + 1;
        }
    }

    public NODE removeValor(NODE p, String info) {
        if (p != null) {
            if (info.equals(p.dado)) {
                if (p.esq == null && p.dir == null)
                    return null;
                else {
                    if (p.esq == null)
                        return p.dir;
                    else if (p.dir == null)
                        return p.esq;
                    else {
                        NODE aux, ref;
                        ref = p.dir;
                        aux = p.dir;
                        while (aux.esq != null)
                            aux = aux.esq;
                        aux.esq = p.esq;
                        return ref;
                    }
                }
            } else { // procura dado a ser removido na ABB
                if (info.compareTo(p.dado.getCpf()) < 0)
                    p.esq = removeValor(p.esq, info);
                else
                    p.dir = removeValor(p.dir, info);
            }
        }
        return p;
    }

    public NODE atualizaAlturaBalanceamento(NODE p) {
        /*
         * atualiza informação da altura de cada nó depois da remoção percorre a árvore
         * usando percurso pós-ordem para ajustar primeiro os nós folhas (profundidade
         * maior) e depois os níveis acima
         */
        if (p != null) {
            p.esq = atualizaAlturaBalanceamento(p.esq);
            if (p.esq == null)
                p.hEsq = 0;
            else if (p.esq.hEsq > p.esq.hDir)
                p.hEsq = p.esq.hEsq + 1;
            else
                p.hEsq = p.esq.hDir + 1;
            p.dir = atualizaAlturaBalanceamento(p.dir);
            if (p.dir == null)
                p.hDir = 0;
            else if (p.dir.hEsq > p.dir.hDir)
                p.hDir = p.dir.hEsq + 1;
            else
                p.hDir = p.dir.hDir + 1;
            p = balanceamento(p);
        }
        return p;
    }

    public void gerarOferta(NODE p, AVL oferta) {
        if (p != null) {
            if (p.dado.isApto()) {
                oferta.root = oferta.inserirConsumo(oferta.root, p.dado);
            }
            gerarOferta(p.esq, oferta);
            gerarOferta(p.dir, oferta);
        }
    }

    public void verificaApto(double minimo, NODE p) {
        if (p != null) {
            if (p.dado.getConsumoMensal() > minimo) {
                p.dado.setApto(true);
            }
            verificaApto(minimo, p.esq);
            verificaApto(minimo, p.dir);
        }
    }

    public NODE inserirConsumo(NODE p, Cliente info) {
        if (p == null) { // nó inserido sempre será nó folha
            p = new NODE();
            p.dado = info;
            p.esq = null;
            p.dir = null;
            p.hDir = 0;
            p.hEsq = 0;
        } else if (info.getConsumoMensal() > p.dado.getConsumoMensal()) { // Inverter a comparação para maior consumo à esquerda
            p.esq = inserirConsumo(p.esq, info); // Insere à esquerda para garantir decrescente
            if (p.esq.hDir > p.esq.hEsq) // Altura do nó será a maior
                p.hEsq = p.esq.hDir + 1; // altura dos seus filhos
            else
                p.hEsq = p.esq.hEsq + 1;
            p = balanceamento(p); // Realiza o balanceamento da árvore
        } else { // Para consumo igual ou menor, insere à direita
            p.dir = inserirConsumo(p.dir, info);
            if (p.dir.hDir > p.dir.hEsq)
                p.hDir = p.dir.hDir + 1;
            else
                p.hDir = p.dir.hEsq + 1;
            p = balanceamento(p); // Realiza o balanceamento da árvore
        }
        return p;
    }

    public void consultarPorCpf(NODE p, String cpf) {
        if (p.dado == null) {
            System.out.println("Cliente não existe");
            return;
        } else if (cpf.equals(p.dado.getCpf())) {
            System.out.println("CLIENTE: " + p.dado.getNome() + " -- Consumo Mensal: " + p.dado.getConsumoMensal());
            return;
        } else if (cpf.compareTo(p.dado.getCpf()) < 0) {
            consultarPorCpf(p.esq, cpf);
        } else {
            consultarPorCpf(p.dir, cpf);
        }
    }

    public double somarConsumoTodosClientes(NODE p) {
        if (p == null) {
            return 0;
        }
        return somarConsumoTodosClientes(p.esq) + somarConsumoTodosClientes(p.dir);
    }
    public int contarClientesAcimaDeMinimo(NODE p, double minimo){
        int soma=0;
        if (p!=null){
            if (p.dado.getConsumoMensal() > minimo){
                soma++;
            }
            soma+=contarClientesAcimaDeMinimo(p.esq, minimo);
            soma+=contarClientesAcimaDeMinimo(p.dir, minimo);
        }
        return soma;
    }

    public void imprimirClientesNaoAceitaramOferta(NODE p){
        System.out.println("------ CLIENTES NAO APTOS ----------");
        if (p!=null){
            if (!p.dado.isApto()){
                System.out.println("CLIENTE: " + p.dado.getNome());
            }
            imprimirClientesNaoAceitaramOferta(p.esq);
            imprimirClientesNaoAceitaramOferta(p.dir);
        }
    }
}



