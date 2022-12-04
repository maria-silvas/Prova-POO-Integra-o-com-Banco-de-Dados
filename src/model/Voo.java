package model;
import database.DAO;
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
    private Pista pista;
    private int idAeronave;

    public static ArrayList<Voo> voos = new ArrayList<Voo>();

    // Colocanado atributos no construtor
    public Voo(int id,
            int numero,
            LocalDate data,
            LocalTime hora,
            String origem,
            String destino,
            String piloto,
            String copiloto,
            String observacao,
            int idPista,
            int idAeronave) {
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

     public static Prefixo<String, Integer> deleteHangarById(int id) {
        for (Hangar hangares : Hangar.hangares) {
            if (hangares.id == id) {
                Hangar.hangares.remove(hangares);
                return hangar;
            }
        }

        return null;
    }


    public static void printAviao(
        ArrayList<Hangar> aviaos
    ) {
        try {
            for (Hangar hangar : aviaos) {
                System.out.println(hangar);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Hangar> getAviaoS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM hangar;");
            ArrayList<Hangar> aviaos = new ArrayList<>();
            while (rs.next()) {
                aviaos.add(
                    new Hangar(rs)
                );
            }
            DAO.deleteConnect();
            return aviaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static Hangar getAviaoInsert(Scanner scanner) {
        
        System.out.println("Informe o local do Hangar");
        String local= scanner.next();
        

        return new Hangar(
            new Prefixo<String,Integer>(null, null),
            local,
           
        );
    }

   

}