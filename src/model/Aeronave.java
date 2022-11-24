import java.util.ArrayList;

public abstract class Aeronave {
    private int id;
    private String nome;
    

    public static ArrayList< Aeronave> aeronaves = new ArrayList<Aeronave>();


    
    protected Aeronave (int id, String nome) {
        this.id = id;
        this.nome = nome;
        
        aeronaves.add(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome= nome;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Nome: " + this.nome;
    }

}