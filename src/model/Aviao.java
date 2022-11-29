import java.util.ArrayList;

// Cuidado com os extends, Aviao estende de aeronave e não de aeroporto.
public class Aviao extends Aeoronave {
    private Prefixo<String, Integer> prefixo;
    private String marca;
    private String modelo;
    private String capacidade;
    private Companhia companhia;

    public static ArrayList<Aviao> aviaos = new ArrayList<Aviao>();

    public Aviao(int id, String nome, Prefixo<String, Integer> placa, String marca, int idCompanhia) {
        super(id, nome);
        try{
            if(aviaos.isEmpty()){        
                this.prefixo = prefixo;
                this.marca = marca;
        
                aviaos.add(this);
            }else if(!aviaos.isEmpty())
                for(Aviao aviao : aviaos){
                    if(aviao.getPrefixo().equals(prefixo)){
                        throw new Exception("Prefixo já cadastradao");
                    }else{
                    this.prefixo = prefixo;
                        this.marca = marca;
                
                        aviaos.add(this);
                    }
            }else{
                throw new Exception("Aviao já cadastrado");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public Prefixo<String, Integer> getPrefixo() {
        return prefixo;
    }

    public void setPlaca(Prefixo<String, Integer> prefixo) {
        this.prefixo = prefixo;
    }

    public String getCor() {
        return marca;
    }

    public void setCor(String marca) {
        this.marca = marca;
    }

    public Boolean verificaPrefixo(Prefixo<String, Integer> prefixo){
        for(Aviao aviao: aviaos){
            if( aviao.getPrefixo().equals(prefixo) == true){
                return true;
            }
        }
        return false;
    }

    public static Aviao getAviaoById(int id) {
        for (Aviao aviao : Aviao.aviaos) {
            if (aviao.id == id) {
                return aviao;
            }
        }

        return null;
    }

    public static Aviao deleteAviaoById(int id) {
        for (Aviao aviao : Aviao.aviaos) {
            if (aviao.id == id) {
                Aviao.aviaos.remove(aviao);
                return aviao;
            }
        }
        return null;
        }

    @Override
    public String toString() {
        return super.toString() + "Placa: " + this.prefixo + "| Cor: " + this.marca + "| Modelo: " + this.modelo + "| Capacidade: " + this.capacidade;
    }
}