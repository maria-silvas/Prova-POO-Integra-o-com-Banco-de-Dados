import java.util.ArrayList;

public class Pista {
    private String numero;

    private int id;

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

    public static Pista getPistaById(int id) {
        for (Pista pista : Pista.pistas) {
            if (pista.id == id) {
                return pista;
            }
        }

        return null;
    }

    public static Pista deletePistaById(int id) {
        for (Pista pista : Pista.pistas) {
            if (pista.id == id) {
                Pista.pistas.remove(pista);
                return pista;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "numero" + this.numero;
    }

}