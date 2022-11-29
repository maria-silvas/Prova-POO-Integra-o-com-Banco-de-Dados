import java.util.ArrayList;

public class Helicopetero extends Aeoronave {

    private String cor;

    private int capacidade;

    public static ArrayList<Helicopetero> helicopeteros = new ArrayList<Helicopetero>();

    public Helicopetero(int id, String nome, String marca, String cor, String modelo, int capacidade) {
        super(id, nome);

        this.cor = cor;

        this.capacidade = capacidade;

        helicopeteros.add(this);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCapacidade(int capacidade) {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;

    }

    public static Helicopetero getHelicopeteroyId(int id) {
        for (Helicopetero helicopetero : Helicopetero.helicopeteros) {
            if (helicopetero.id == id) {
                return helicopetero;
            }
        }

        return null;
    }

    public static Helicopetero deleteHelicopeteroById(int id) {
        for (Helicopetero helicopetero : Helicopetero.helicopeteros) {
            if (helicopetero.id == id) {
                Helicopetero.helicopeteros.remove(helicopetero);
                return helicopetero;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "| Cor" + this.cor +
                "| Capacidade: "
                + this.capacidade;
    }

}