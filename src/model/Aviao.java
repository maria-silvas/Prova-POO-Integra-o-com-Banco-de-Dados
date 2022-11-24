import java.util.ArrayList;

public class Aviao extends Aeoronave {
    private NumeroGeneric<String, Integer> prefixo;
    private String marca;
    private String modelo;
    private String capacidade;

    public static ArrayList<Aviao> aviaos = new ArrayList<Aviao>();

    public Aviao(int id, String nome, NumeroGeneric<String, Integer> placa, String marca) {
        super(id, marca);
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

    public NumeroGeneric<String, Integer> getPrefixo() {
        return prefixo;
    }

    public void setPlaca(NumeroGeneric<String, Integer> prefixo) {
        this.prefixo = prefixo;
    }

    public String getCor() {
        return marca;
    }

    public void setCor(String marca) {
        this.marca = marca;
    }

    public Boolean verificaPrefixo(NumeroGeneric<String, Integer> prefixo){
        for(Aviao aviao: aviaos){
            if( aviao.getPrefixo().equals(prefixo) == true){
                return true;
            }
        }
        return false;
    }

    
    @Override
    public String toString() {
        return super.toString() + "Placa: " + this.prefixo + "| Cor: " + this.marca + "| Modelo: " + this.modelo + "| Capacidade: " + this.capacidade;
    }
}