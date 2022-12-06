package model;
import database.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Voo {
    private int id;
    private int numero;
    private String data;
    private String hora;
    private String origem;
    private String destino;
    private String piloto;
    private String copiloto;
    private String observacao;
    private int idPista;
    private Pista pista;
    private int idAeronave;
    private int idAviao;
    private int idHelicoptero;
    private int idJato;
    private int Jato Jato;

    public static ArrayList<Voo> voos = new ArrayList<Voo>();

    public Voo() {
    }

    public Voo(String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao, int idPista, int idAviao, int idHelicoptero, int idJato) {
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.observacao = observacao;
        this.idPista = idPista;
        this.idAviao = idAviao;
        this.idHelicoptero = idHelicoptero;
        this.idJato = idJato;
    }
    // Colocanado atributos no construtor
    public Voo(int id,
            int numero,
            String data,
            String hora,
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

        try{
            Connection conn = DAO.getConnect();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO voo (numero, data, hora, origem, destino, piloto, copiloto, observacao, idPista, idAeronave) VALUES (" + this.numero + ", '" + this.data + "', '" + this.hora + "', '" + this.origem + "', '" + this.destino + "', '" + this.piloto + "', '" + this.copiloto + "', '" + this.observacao + "', " + this.idPista + ", " + this.idAeronave + ")";
            stmt.execute(sql);
            stmt.close();
            conn.close();
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

    public int getNumero() {
        return this.id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
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

    public int getIdAviao() {
        return this.idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public int getIdHelicoptero() {
        return this.idHelicoptero;
    }

    public void setIdHelicoptero(int idHelicoptero) {
        this.idHelicoptero = idHelicoptero;
    }

    public int getIdJato() {
        return this.idJato;
    }

    public void setIdJato(int idJato) {
        this.idJato = idJato;
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
            if (hangares.getId() == id) {
                Hangar.hangares.remove(hangares);
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

    public static void getTodosOsVoos() throws Exception{
        Connection con = DAO.getConnect();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM voo;");
        while (rs.next()) {
            System.out.println("Id: " + rs.getInt("id") + " | Data: " + rs.getString("data") + " | Hora: " + rs.getString("hora") + " | Origem: " + rs.getString("origem")
                    + " | Piloto: " + rs.getString("piloto") + " | CoPiloto: " + rs.getString("copiloto") + " | Observação: " + rs.getString("observacao"));
        }
        DAO.deleteConnect();
    }

    public static void update(int id, String data, String hora, String origem, String piloto, String copiloto, String observacao) throws Exception{
        Connection con = DAO.getConnect();
        Statement stm = con.createStatement();
        stm.executeUpdate("UPDATE voo SET data = '" + data + "', hora = '" + hora + "', origem = '" + origem + "', piloto = '" + piloto + "', copiloto = '" + copiloto + "', observacao = '" + observacao + "' WHERE id = " + id + ";");
        DAO.deleteConnect();
    }
    

}