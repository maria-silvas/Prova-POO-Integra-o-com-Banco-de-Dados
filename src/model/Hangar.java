package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DAO;
public class Hangar {
    private int id;
    private String local;
    private int idAviao;
    private Aviao aviao;

    public Hangar() {
    }

    public Hangar(int id, String local, int idAviao) {
        this.id = id;
        this.local = local;
        this.idAviao = idAviao;
        this.aviao = Aviao.getById(idAviao);

        try {
            ResultSet result = DAO.createConnection().createStatement()
                    .executeQuery("SELECT * FROM hangar WHERE aviao_id = " + idAviao);

            if (result.next()) {
                throw new Exception("Apenas pode ser cadastrado apenas um avião por hangar!");
            } else {
                PreparedStatement preparacao = DAO.createConnection()
                        .prepareStatement("INSERT INTO hangar (id,local, aviao_id) VALUES (?, ?)");
                preparacao.setInt(1, id);
                preparacao.setString(2, local);
                preparacao.setInt(3, idAviao);
                preparacao.execute();
                preparacao.close();
            }
            result.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Hangar(String local, int idAviao) {
        this.local = local;
        this.idAviao = idAviao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    @Override
    public String toString() {
        return "Hangar{" + "id=" + id + ", local=" + local + ", idAviao=" + idAviao + ", aviao=" + aviao + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hangar other = (Hangar) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.local == null) ? (other.local != null) : !this.local.equals(other.local)) {
            return false;
        }
        if (this.idAviao != other.idAviao) {
            return false;
        }
        if (this.aviao != other.aviao && (this.aviao == null || !this.aviao.equals(other.aviao))) {
            return false;
        }
        return true;
    }

    public static void update(int id, String local, int idAviao) {
        try {
            PreparedStatement preparacao = DAO.createConnection()
                    .prepareStatement("UPDATE hangar SET local = ?, aviao_id = ? WHERE id = ?");
            preparacao.setString(1, local);
            preparacao.setInt(2, idAviao);
            preparacao.setInt(3, id);
            preparacao.execute();
            preparacao.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        try {
            PreparedStatement preparacao = DAO.createConnection().prepareStatement("DELETE FROM hangar WHERE id = ?");
            preparacao.setInt(1, id);
            preparacao.execute();
            preparacao.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Hangar getById(int id) {
        try {
            ResultSet result = DAO.createConnection().createStatement()
                    .executeQuery("SELECT * FROM hangar WHERE id = " + id);
            if (result.next()) {
                return new Hangar(result.getString("local"), result.getInt("aviao_id"));
            }
            result.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void getAll() {
        try {
            ResultSet result = DAO.createConnection().createStatement().executeQuery("SELECT * FROM hangar");
            while (result.next()) {
                System.out
                        .println(new Hangar(result.getInt("id"), result.getString("local"), result.getInt("aviao_id")));
            }
            result.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getUltimoId() {
        try {
            ResultSet result = DAO.createConnection().createStatement().executeQuery("SELECT MAX(id) FROM hangar");
            if (result.next()) {
                return result.getInt("MAX(id)");
            }
            result.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}