public class Good {
    /*código (inteiro), descrição, preço*/
    private int IUD;
    private String description;
    private double value;

    public Good(int IUD, String description, double value) {
        this.IUD = IUD;
        this.description = description;
        this.value = value;
    }

    public int getIUD() {
        return IUD;
    }

    public void setIUD(int IUD) {
        this.IUD = IUD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
