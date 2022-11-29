import java.util.ArrayList;

public class Jato<Int> extends Aeoronave {
    
    private String cor;
   
    private int velocidade;

    public static ArrayList<Jato> jatos = new ArrayList<Jato>();

    public Jato(int id, String nome, String marca, String cor, String modelo, int velocidade) {
        super(id, nome);
        
        this.cor = cor;
        this.modelo = modelo;
       

        jatos.add(this);
    }

    

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    public int getVelocidade(int velocidade) {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public static Jato getJatoById(int id) {
        for (Jato jato : Jato.jatos) {
            if (jato.id == id) {
                return jato;
            }
        }

        return null;
    }

    public static Jato deleteJatoById(int id) {
        for (Jato jato : Jato.jatos) {
            if (jato.id == id) {
                Jato.jatos.remove(jato);
                return jato;
            }
        }

        return null;
    }
    @Override
    public String toString() {
        return super.toString() + "| Cor" + this.cor + "| Velocidade"
                + this.velocidade;
    }

}