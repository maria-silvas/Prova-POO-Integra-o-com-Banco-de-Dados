
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import database.DAO;

public class Hangar {
    
    private static int id;
    private String local;
    private int idAviao;
    private Aviao aviao;
    private LocalDate data;
    private LocalTime hora;
    //private LocalDate data;
    //private LocalTime hora;
    private static Prefixo<String, Integer> hangar;
    public static ArrayList<Hangar> hangares = new ArrayList<Hangar>();

    public Hangar() {

    }

    public  Hangar(int id, String local, int idAviao, Aviao aviao, /* LocalDate data, LocalTime hora,*/ Prefixo<String, Integer> hangar) {
        
        try{
            if(hangares.isEmpty()) {   
                
                this.id = id;
                this.local = local;
                this.idAviao = idAviao;
                this.aviao = aviao;
                //this.data = data;
                //this.hora = hora;
                
                hangares.add(this);
            }else{
                    throw new Exception("Jato já cadastrado");
            }
        }catch(Exception e){
             System.out.println(e.getMessage());
            
        

        }

    }

    public Hangar(String local, int idAviao) {
       
        try{
            if(hangares.isEmpty()) {        
                  
                this.local = local;
                this.idAviao = idAviao;
                hangares.add(this);
            }else if(!hangares.isEmpty()){
                for(Hangar vaga : hangares){
                    if(vaga.getHangar().equals(hangar)){
                        throw new Exception("Hangar já cadastrada");
                    }else{

                        this.local = local;
                        this.idAviao = idAviao;
                        hangares.add(this);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public Hangar(ResultSet rs) {
    }


    public static int getId() {
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

    
    public LocalDate getData() {
        return getData();
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return getHora();
    }

    public String getHangar() {
        return local;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    
   


    public static Prefixo<String, Integer> getHangar() {
        return hangar;
    }


    public static void setHangar(Prefixo<String, Integer> hangar) {
        Hangar.hangar = hangar;
    }


    @Override
    public String toString() {
        return "Id: " + this.id + " | Local: " + this.local + " | Data: " /*+ this.data + " | Hora: " + this.hora*/ ;
    }


    public static Hangar getHangarId(int id) {
        for (Hangar hangar : Hangar.hangares) {
            if (hangar.id == id) {
                return hangar;
            }
        }

        return null;
    }


    public static Hangar deleteHangarId(int id) {
        for (Hangar hangar : Hangar.hangares) {
            if (hangar.id == id) {
                hangar.hangares.remove(hangar);
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

    public static ArrayList<Hangar> getHangar () throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM hangar;");
            ArrayList<Hangar> aviaos = new ArrayList<>();
            while (rs.next()) {
                aviaos.add(new Hangar(rs));
            }
            DAO.deleteConnect();
            return aviaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }


    public static Hangar getHangarInsert(Scanner scanner) {
        
        System.out.println("Informe o local do Hangar");
        String local= scanner.next();
        

        return new Hangar(local, id);

    }

    public static void insertHangar(Hangar hangar) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into Hangar "
                + "(local) VALUES "
                + "('"+hangar.getLocal() + getId() + "')");
            System.out.println("Dados inseridos com sucesso");
            System.out.println(hangar); 
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static Hangar getHangarUpdate(Scanner scanner) throws Exception {
        try {
            Hangar hangar = getHangar(scanner);
            System.out.println("Informe o local do Hangar");
            String local = scanner.next();
        
            return hangar;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public static void updateHangar(Hangar hangar) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE hangar SET "
                + " marca = '" + hangar.getLocal() + "'"
                + " WHERE id = " + hangar.getId());
                System.out.println("Dados atualizados com sucesso"); 
            DAO.deleteConnect();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Hangar getHangar(Scanner scanner) throws Exception { 
        try {
            System.out.println("Informe o ID do hangar: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM hangar WHERE id = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            
            Hangar hangar = new Hangar(rs);
            DAO.deleteConnect();
            return hangar;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteHangarById(Hangar hangar) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM hangar WHERE id = ?");
            pStm.setInt(1, hangar.getId());
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
