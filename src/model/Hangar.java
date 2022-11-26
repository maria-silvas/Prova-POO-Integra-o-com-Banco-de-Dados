import java.util.ArrayList;

public class Hangar {
    private int id;
    private String local;
    private static NumeroGeneric<String, Integer> hangar;

    public static ArrayList<Hangar> hangares = new ArrayList<Hangar>();
44
    public void Vaga(int id, NumeroGeneric<String, Integer> hangar, String local, String tamanho, double preco) {
        try {
            if (hangares.isEmpty()) {
                this.id = id;
                this.hangar = hangar;
                this.local = local;

                hangares.add(this);
            } else if (!hangares.isEmpty()) {
                for (Hangar vg : hangares) {
                    if (vg.getHangar().equals(hangar)) {
                        throw new Exception("Hangar já cadastrada");
                    } else {
                        this.id = id;
                        this.hangar = hangar;
                        this.local = local;

                        hangares.add(this);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NumeroGeneric<String, Integer> getHangar() {
        return this.hangar;
    }

    public void setHangar(NumeroGeneric<String, Integer> hangar) {
        this.hangar = hangar;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Local: " + this.local;
    }

    public static Hangar getHangarById(int id) {
        for (Hangar hangar : Hangar.hangares) {
            if (hangar.id == id) {
                return hangar;
            }
        }

        return null;
    }

    public Boolean verificaHangar(NumeroGeneric<String, Integer> hangar) {
        for (Hangar vagaPesquisa : hangares) {
            if (vagaPesquisa.getHangar().equals(hangar) == true) {
                return true;
            }
        }
        return false;
    }

    public static NumeroGeneric<String, Integer> deleteHangarById(int id) {
        for (Hangar hangares : Hangar.hangares) {
            if (hangares.id == id) {
                Hangar.hangares.remove(hangares);
                return hangar;
            }
        }

        return null;
    }
}