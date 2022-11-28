import java.util.ArrayList;

public class Companhia {
    private static final ArrayList<Aviao> companhias = null;
    private int idCompanhia;
    private String nome;
    private String cnpj;

    public static ArrayList<Aviao> aviaos = new ArrayList<Aviao>();

    public Companhia(int idCompanhia, String nome, String cnpj) {
        this.idCompanhia = idCompanhia;
        this.nome = nome;
        this.cnpj = cnpj;

        companhias.add(this);
    }

    public int getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(int idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Aviao> getAviaos() {
        return aviaos;
    }

    public void setAviaos(ArrayList<Aviao> aviaos) {
        this.aviaos = aviaos;
    }

    @Override
    public String toString() {
        return super.toString() + "Marca" + this.nome + "| Cor" + this.cnpj;
    }

}
