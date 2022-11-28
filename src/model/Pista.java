import java.util.ArrayList;

public class Pista {
    private String numero;

    public static ArrayList<Pista> pistas = new ArrayList<Pista>();

    public Pista(int id, String numero) {
        this.numero = numero;

        pistas.add(this);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() + "numero" + this.numero;
    }

}