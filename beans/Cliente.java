package beans;

public class Cliente {
    /*Nome
o CPF
o Tipo de energia consumida (por exemplo: solar, eólica, elétrica)
o Consumo Mensal de Energia (em kWh)
o Apto para Oferta (Inicialmente, true)*/
    String nome, cpf, tipo;
    double consumoMensal;
    boolean apto = false;

    public Cliente(String nome, String cpf, String tipo, double consumoMensal) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
        this.consumoMensal = consumoMensal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(double consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }
}
