import java.util.ArrayList;

public class Jato extends Aeoronave {
    private String marca;
    private String cor;
    private String modelo;
    private int velocidade;

    public static ArrayList<Jato> jatos = new ArrayList<Jato>();

    public Jato ( int id, String nome, String marca, String cor, String modelo, int velocidade) {
        super(id, nome);
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.velocidade = velocidade;

        jatos.add(this);
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

    public String getModelo( String modelo) {
        return modelo;
    }

    public void setModelo(String modelo) {
    this.modelo = modelo;
    }

    public Int getVelocidade(Int velocidade) {
        return velocidade;
    }

    public Int setVelocidade (int velocidade) {
        this.velocidade = velocidade;
        return null;
    }

 


    @Override
    public String toString() {
        return super.toString() + "Marca" + this.marca + "| Cor" + this.cor;
    } 

}