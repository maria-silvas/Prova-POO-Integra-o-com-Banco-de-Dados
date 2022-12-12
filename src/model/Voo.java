package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import database.DAO;

public class Voo {
    private int id;
    private Generic<String, Integer> numero;
    private String data;
    private String hora;
    private String origem;
    private String destino;
    private String piloto;
    private String copiloto;
    private String observacao;
    private int idPista;
    private Pista pista;
    private int idAviao;
    private Aviao aviao;
    private int idHelicoptero;
    private Helicoptero helicoptero;
    private int idJato;
    private Jato jato;

    public Voo() {

    }

    public Voo(int id, Generic<String, Integer> numero, String data, String hora, String origem, String destino,
            String piloto, String copiloto, String observacao, int idPista, Pista pista, int idHelicoptero,
            Helicoptero helicoptero, int idJato, Jato jato, int idAviao, Aviao aviao) {
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
        this.idAviao = idAviao;
        this.idHelicoptero = idHelicoptero;
        this.idJato = idJato;

        try {
            PreparedStatement preparacao = DAO.createConnection().prepareStatement(
                    "INSERT INTO voo (id, numero, data, hora, origem, destino, piloto, copiloto, observacao, idPista, idAviao, idHelicoptero, idJato) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            if (idAviao != 0) {
                preparacao.setInt(1, id);
                preparacao.setString(2, numero.toString());
                preparacao.setString(3, data);
                preparacao.setString(4, hora);
                preparacao.setString(5, origem);
                preparacao.setString(6, destino);
                preparacao.setString(7, piloto);
                preparacao.setString(8, copiloto);
                preparacao.setString(9, observacao);
                preparacao.setInt(10, idPista);
                preparacao.setInt(11, idAviao);
                preparacao.setNull(12, Types.NULL);
                preparacao.setNull(13, Types.NULL);
                preparacao.execute();
                preparacao.close();
            } else if (idHelicoptero != 0) {
                preparacao.setInt(1, id);
                preparacao.setString(2, numero.toString());
                preparacao.setString(3, data);
                preparacao.setString(4, hora);
                preparacao.setString(5, origem);
                preparacao.setString(6, destino);
                preparacao.setString(7, piloto);
                preparacao.setString(8, copiloto);
                preparacao.setString(9, observacao);
                preparacao.setInt(10, idPista);
                preparacao.setInt(11, Types.NULL);
                preparacao.setNull(12, Types.NULL);
                preparacao.setNull(13, idJato);
                preparacao.execute();
                preparacao.close();
            } else {
                preparacao.setInt(1, id);
                preparacao.setString(2, numero.toString());
                preparacao.setString(3, data);
                preparacao.setString(4, hora);
                preparacao.setString(5, origem);
                preparacao.setString(6, destino);
                preparacao.setString(7, piloto);
                preparacao.setString(8, copiloto);
                preparacao.setString(9, observacao);
                preparacao.setInt(10, idPista);
                preparacao.setInt(11, Types.NULL);
                preparacao.setNull(12, idHelicoptero);
                preparacao.setNull(13, Types.NULL);
                preparacao.execute();
                preparacao.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Voo(String data, String hora, String origem, String destino, String piloto, String copiloto,
            String observacao, int idPista, int idAviao, int idHelicoptero, int idJato) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Generic<String, Integer> getNumero() {
        return numero;
    }

    public void setNumero(Generic<String, Integer> numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public String getCopiloto() {
        return copiloto;
    }

    public void setCopiloto(String copiloto) {
        this.copiloto = copiloto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public int getidHelicoptero() {
        return idHelicoptero;
    }

    public void setidHelicoptero(int idHelicoptero) {
        this.idHelicoptero = idHelicoptero;
    }

    public Helicoptero getHelicoptero() {
        return helicoptero;
    }

    public void setHelicoptero(Helicoptero helicoptero) {
        this.helicoptero = helicoptero;
    }

    public int getIdJato() {
        return idJato;
    }

    public void setIdJato(int idJato) {
        this.idJato = idJato;
    }

    public Jato getJato() {
        return jato;
    }

    public void setJato(Jato jato) {
        this.jato = jato;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", piloto='" + piloto + '\'' +
                ", copiloto='" + copiloto + '\'' +
                ", observacao='" + observacao + '\'' +
                ", idPista=" + idPista +
                ", pista=" + pista +
                ", idAviao=" + idAviao +
                ", aviao=" + aviao +
                ", idHelicoptero=" + idHelicoptero +
                ", helicoptero=" + helicoptero +
                ", idJato=" + idJato +
                ", jato=" + jato +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voo other = (Voo) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.data == null) ? (other.data != null) : !this.data.equals(other.data)) {
            return false;
        }
        if ((this.hora == null) ? (other.hora != null) : !this.hora.equals(other.hora)) {
            return false;
        }
        if ((this.origem == null) ? (other.origem != null) : !this.origem.equals(other.origem)) {
            return false;
        }
        if ((this.destino == null) ? (other.destino != null) : !this.destino.equals(other.destino)) {
            return false;
        }
        if ((this.piloto == null) ? (other.piloto != null) : !this.piloto.equals(other.piloto)) {
            return false;
        }
        if ((this.copiloto == null) ? (other.copiloto != null) : !this.copiloto.equals(other.copiloto)) {
            return false;
        }
        if ((this.observacao == null) ? (other.observacao != null) : !this.observacao.equals(other.observacao)) {
            return false;
        }
        if (this.idPista != other.idPista) {
            return false;
        }
        if (this.idAviao != other.idAviao) {
            return false;
        }
        if (this.idHelicoptero != other.idHelicoptero) {
            return false;
        }
        if (this.idJato != other.idJato) {
            return false;
        }
        return true;
    }

    public static void update(int id, String numero, String data, String hora, String origem, String destino,
            String piloto, String copiloto, String observacao, int idPista, Pista pista, int idHelicoptero,
            Helicoptero helicoptero, int idJato, Jato jato, int idAviao, Aviao aviao) {

        Connection con = DAO.createConnection();
        try {
            PreparedStatement preparacao = con.prepareStatement(
                    "UPDATE voo SET numero = ?, data = ?, hora = ?, origem = ?, destino = ?, piloto = ?, copiloto = ?, observacao = ?, idPista = ?, idHelicoptero = ?, idJato = ?, idAviao = ? WHERE id = ?");
            preparacao.setString(1, numero);
            preparacao.setString(2, data);
            preparacao.setString(3, hora);
            preparacao.setString(4, origem);
            preparacao.setString(5, destino);
            preparacao.setString(6, piloto);
            preparacao.setString(7, copiloto);
            preparacao.setString(8, observacao);
            preparacao.setInt(9, idPista);
            if (idHelicoptero != 0) {
                preparacao.setInt(10, idHelicoptero);
            } else if (idJato != 0) {
                preparacao.setInt(10, idJato);
            } else {
                preparacao.setInt(12, idAviao);
            }
            preparacao.setInt(13, id);
            preparacao.execute();
            preparacao.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        Connection con = DAO.createConnection();
        try {
            PreparedStatement preparacao = con.prepareStatement("DELETE FROM voo WHERE id = ?");
            preparacao.setInt(1, id);
            preparacao.execute();
            preparacao.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getAll() {
        Connection con = DAO.createConnection();
        try {
            PreparedStatement preparacao = con.prepareStatement("SELECT * FROM voo");
            ResultSet resultado = preparacao.executeQuery();
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Numero: " + resultado.getString("numero"));
                System.out.println("Data: " + resultado.getString("data"));
                System.out.println("Hora: " + resultado.getString("hora"));
                System.out.println("Origem: " + resultado.getString("origem"));
                System.out.println("Destino: " + resultado.getString("destino"));
                System.out.println("Piloto: " + resultado.getString("piloto"));
                System.out.println("Copiloto: " + resultado.getString("copiloto"));
                System.out.println("Observacao: " + resultado.getString("observacao"));
                System.out.println("ID Pista: " + resultado.getInt("idPista"));
                System.out.println("ID Helicoptero: " + resultado.getInt("idHelicoptero"));
                System.out.println("ID Jato: " + resultado.getInt("idJato"));
                System.out.println("ID Aviao: " + resultado.getInt("idAviao"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Voo getByID(int id) {
        Connection con = DAO.createConnection();
        try {
            PreparedStatement preparacao = con.prepareStatement("SELECT * FROM voo WHERE id = ?");
            preparacao.setInt(1, id);
            ResultSet resultado = preparacao.executeQuery();
            while (resultado.next()) {
                return new Voo(resultado.getString("data"), resultado.getString("hora"), resultado.getString("origem"),
                        resultado.getString("destino"), resultado.getString("piloto"), resultado.getString("copiloto"),
                        resultado.getString("observacao"), resultado.getInt("idPista"),
                        resultado.getInt("idHelicoptero"), resultado.getInt("idJato"), resultado.getInt("idAviao"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static int getUltimoId() {
        Connection con = DAO.createConnection();
        try {
            PreparedStatement preparacao = con.prepareStatement("SELECT MAX(id) FROM voo");
            ResultSet resultado = preparacao.executeQuery();
            while (resultado.next()) {
                return resultado.getInt("MAX(id)");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}