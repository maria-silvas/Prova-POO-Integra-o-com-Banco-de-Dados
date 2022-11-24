import java.util.ArrayList;

public class Aviao extends Compania {
    private NumeroGeneric <String, Integer> placa;
    private String marca;
    private String modelo;
    private String capacidade;
    private 
   


    public static ArrayList<Aviao> aviaos = new ArrayList<Aviao>();

    public Aviao ( int id, String nome, NumeroGeneric <String, Integer> placa, String cor) {
        super(id, nome);
        try{
            if(aviaos.isEmpty()){        
                this.placa = placa;
                this.marca= marca;
        
                aviaos.add(this);
            }else if(!aviaos.isEmpty())
                for(Aviao aviao : aviaos){
                    
                    if(aviao.getPlaca().equals(placa)){
                        throw new Exception("Placa já cadastrada");
                    }else{
                        this.placa = placa;
                        this.marca = marca;

                
                        aviaos.add(this);
                    }
            }else{
                throw new Exception("Avião já Cadastrado ");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public NumeroGeneric<String, Integer> getPlaca() {
        return placa;
    }

  

    public void setCor(String marca) {
        this.marca = marca;
    }

    public Boolean verificaPlaca(NumeroGeneric <String, Integer> placa){
        for(Carro aviao: aviaos){
            if( aviao.getPlaca().equals(placa) == true){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Marca: " + this.marca + "| Modelo: " + this.modelo + "Capacidade:" + this.capacidade + "Placa:" + this.placa;
    }
}