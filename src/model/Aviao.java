import java.util.ArrayList;

public class Aviao extends Aeoronave {
    private NumeroGeneric<String, Integer> prefixo;
    private String marca;
    private String modelo;
    private String capacidade;
    private Companhia companhia;
    

    public Aviao(int id, String nome, NumeroGeneric<String, Integer> placa, String marca, int idCompanhia) {
        super(id, marca);
        try {
            if (Aviao.isEmpty()) {
                this.prefixo = prefixo;
                this.marca = marca;
                this.modelo = modelo;

                aviaos.add(this);
            } else if (!aviaos.isEmpty())
                for (Aviao aviao : aviaos) {
                    if (aviao.getPrefixo().equals(prefixo)) {
                        throw new Exception("Prefixo já cadastradao");
                    } else {
                        this.prefixo = prefixo;
                        this.marca = marca;
                        this.modelo = modelo;

                        aviaos.add(this);
                    }
                }
            else {
                throw new Exception("Aviao já cadastrado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public NumeroGeneric<String, Integer> getPrefixo() {
        return prefixo;
    }

    public void setPlaca(NumeroGeneric<String, Integer> prefixo) {
        this.prefixo = prefixo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCagetCapacidade(String marca) {
        this.capacidade = capacidade;
    }

    public Companhia getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    public Aviao id(int id) {
        setIdAeronave(id);
        return this;
    }

    private void setIdAeronave(int id) {
    }

    public Aviao marca(String marca) {
        setMarca(marca);
        return this;
    }

    public Aviao CompanhiaId(Companhia com) {
        setCompanhia(companhia);
        return this;
    }

    public Boolean verificaPrefixo(NumeroGeneric<String, Integer> prefixo) {
        for (Aviao aviao : aviaos) {
            if (aviao.getPrefixo().equals(prefixo) == true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Placa: " + this.prefixo + "| Cor: " + this.marca + "| Modelo: " + this.modelo
                + "| Capacidade: " + this.capacidade + "| Companhia: " + getCompanhia().getIdCompanhia();
    }
}