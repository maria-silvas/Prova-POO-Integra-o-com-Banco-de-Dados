import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Voo {
    private int id;
    private int numero;
    private LocalDate data;
    private LocalTime hora;
    private String origem;
    private String destino;
    private String piloto;
    private String copiloto;
    private String observacao;
    private int idPista;
    private int idAeronave;

    public static ArrayList<Voo> voos = new ArrayList<Voo>();

    public Voo(int id, LocalDate data, LocalTime hora, int idAeronave, int idPista) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.observacao = observacao;
        this.idPista = idPista;
        this.idAeronave = idAeronave;

        voos.add(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return this.id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getOrigem() {
        return this.origem;
    }

    public void setDestino(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public String getPiloto() {
        return this.piloto;
    }

    public void setCopiloto(String copiloto) {
        this.copiloto = copiloto;
    }

    public String getCoPiloto() {
        return this.copiloto;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public int getIdPista() {
        return this.idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public int getIdAeronave() {
        return this.idAeronave;
    }

    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Data: " + this.data + " | Hora: " + this.hora + " | Origem: " + this.origem
                + " | Piloto: " + this.piloto + " | CoPiloto: " + this.copiloto + " | Observação: " + this.observacao;
    }

    public static Voo getVooById(int id) {
        for (Voo voo : Voo.voos) {
            if (voo.id == id) {
                return voo;
            }
        }

        return null;
    }

    public static Voo deleteVooById(int id) {
        for (Voo voo : Voo.voos) {
            if (voo.id == id) {
                Voo.voos.remove(voo);
                return voo;
            }
        }

        return null;
    }
}44