package model;
import database.DAO;
import java.util.ArrayList;

public class Pista {
    private String numero;

    private int id;

    public static ArrayList<Pista> pistas = new ArrayList<Pista>();

    public Pista(int id, String numero) {
        this.numero = numero;
        this.id=id;

        pistas.add(this);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public static Pista getPistaById(int id) {
        for (Pista pista : Pista.pistas) {
            if (pista.id == id) {
                return pista;
            }
        }

        return null;
    }

    public static Pista deletePistaById(int id) {
        for (Pista pista : Pista.pistas) {
            if (pista.id == id) {
                Pista.pistas.remove(pista);
                return pista;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "ID" + this.id + "Numero" + this.numero;
    }

    public Object getPrefixo() {
        return null;
    }

    public int getId() {
        return 0;
    }


    public static deletePistaById(int id) {
        for (Pista pistas : Pista.pistas) {
            if (pistas.id == id) {
                Pista.pistas.remove(pistas);
                return pista;
            }
        }

        return null;
    }


    public static void printAviao(
        ArrayList<Pista> aviaos
    ) {
        try {
            for (Pista pista : aviaos) {
                System.out.println(pista);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Pista> getAviaoS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM pista;");
            ArrayList<Pista> aviaos = new ArrayList<>();
            while (rs.next()) {
                aviaos.add(
                    new Pista(rs)
                );
            }
            DAO.deleteConnect();
            return aviaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static Pista getAviaoInsert(Scanner scanner) {
        
        System.out.println("Informe o numero da Pista");
        String numero= scanner.next();
        

        return new Pista(
            numero,
           
        );
    }

    public static void insertPistaS(Pista pista) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into Pista "
                + "(numero) VALUES "
                + "('"+pista.getnumero()+.getId()+"')");
            System.out.println("Dados inseridos com sucesso");
            System.out.println(pista); 
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Pista getPistaUpdate(Scanner scanner) throws Exception {
        try {
            Pista pista = getHangar(scanner);
            System.out.println("Informe o numero do Pista");
            String numero = scanner.next();
        
            return pista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updatePistaS(Pista pista) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE pista SET "
                + " marca = '" + pista.getnumero() + "'"
                + " WHERE id = " + pista.getId());
                System.out.println("Dados atualizados com sucesso"); 
            DAO.deleteConnect();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Pista getPista(Scanner scanner) throws Exception { 
        try {
            System.out.println("Informe o ID do pista: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM pista WHERE id = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            
            Pista pista = new Pista(rs);
            DAO.deleteConnect();
            return pista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deletPistaPS(Pista pista) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM pista WHERE id = ?");
            pStm.setInt(1, pista.getId());
            System.out.println("Dados deletado com sucesso");  
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}