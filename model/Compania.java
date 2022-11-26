import java.util.ArrayList;
44
public class Companhia {
    private String nome;
    private String cnpj;

    public static ArrayList<Companhia> companhias = new ArrayList<Companhia>();

    public Companhia(int id, String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;

        companhias.add(this);
    }

    public String getMarca() {
        return nome;
    }

    public void setMarca(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cnpj;
    }

    public void setCor(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + "Marca" + this.nome + "| Cor" + this.cnpj;
    }

}
