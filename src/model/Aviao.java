package model;

import java.util.ArrayList;

// Cuidado com os extends, Aviao estende de aeronave e não de aeroporto.
public class Aviao extends Aeronave {
    private Prefixo<String, Integer> prefixo;
    private String capacidade;
    private Companhia companhia;

    public static ArrayList<Aviao> aviaos = new ArrayList<Aviao>();

    public Aviao(int id, Prefixo<String, Integer> prefixo, String marca, String modelo, Companhia companhia,
            String capacidade) {
        super(id, marca, modelo);
        try {
            if (aviaos.isEmpty()) {
                this.prefixo = prefixo;
                this.capacidade = capacidade;
                this.companhia = companhia;

                aviaos.add(this);
            } else if (!aviaos.isEmpty())
                for (Aviao aviao : aviaos) {
                    if (aviao.getPrefixo().equals(prefixo)) {
                        throw new Exception("Prefixo já cadastradao");
                    } else {
                        this.prefixo = prefixo;
                        this.capacidade = capacidade;
                        this.companhia = companhia;

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

    public Prefixo<String, Integer> getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Prefixo<String, Integer> prefixo) {
        this.prefixo = prefixo;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean verificaPrefixo(Prefixo<String, Integer> prefixo) {
        for (Aviao aviao : aviaos) {
            if (aviao.getPrefixo().equals(prefixo) == true) {
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
        return super.toString() + "| Id: " + this.id + "Placa: " + this.prefixo + "| Marca: " + this.marca
                + "| Modelo: " + this.modelo + "| Capacidade: " + this.capacidade + " | IdCompanhia: " + this.companhia;
    }
}