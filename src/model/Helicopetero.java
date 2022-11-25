import java.util.ArrayList;

public class Helicopetero extends Aeoronave {
    private String marca;
    private String cor;
    private String modelo;
    private int capacidade;

    public static ArrayList<Helicopetero> helicopeteros = new ArrayList<Helicopetero>();

    public Helicopetero(int id, String nome, String marca, String cor, String modelo, int capacidade) {
        super(id, nome);
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.capacidade = capacidade;

        helicopeteros.add(this);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo(String modelo) {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade(int capacidade) {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;

    }

    @Override
    public String toString() {
        return super.toString() + "Marca" + this.marca + "| Cor" + this.cor + "| Modelo:" + this.modelo
                + "| Capacidade: "
                + this.capacidade;
    }

}
