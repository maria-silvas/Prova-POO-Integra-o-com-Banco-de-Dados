package model;

import java.util.ArrayList;
import database.DAO;
public class Hangar {
    private int id;
    private String local;
    private static Prefixo<String, Integer> hangar;

    public static ArrayList<Hangar> hangares = new ArrayList<Hangar>();

    public void Vaga(int id, Prefixo<String, Integer> hangar, String local, String tamanho, double preco) {
        try {
            if (hangares.isEmpty()) {
                this.id = id;
                this.local = local;

                hangares.add(this);
            } else if (!hangares.isEmpty()) {
                for (Hangar vg : hangares) {
                    if (vg.getHangar().equals(hangar)) {
                        throw new Exception("Hangar já cadastrada");
                    } else {
                        this.id = id;
                        this.local = local;

                        hangares.add(this);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Object getHangar() {
        return null;
    }

    public static int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Pegar este cara dos hangares
    // public Prefixo<String, Integer> getHangar() {
    // return this.hangar;
    // }

    // public void setHangar(Prefixo<String, Integer> hangar) {
    // this.hangar = hangar;
    // }

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

    // Pegar este cara dos hangares
    // public Boolean verificaHangar(Prefixo<String, Integer> hangar) {
    // for (Hangar vagaPesquisa : hangares) {
    // if (vagaPesquisa.getHangar().equals(hangar) == true) {
    // return true;
    // }
    // }
    // return false;
    // }

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

    public static void insertHangarS(Hangar hangar) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into Hangar "
                + "(local) VALUES "
                + "('"+hangar.getLocal()+.getId()+"')");
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

    public static void updateHngarS(Hangar hangar) throws Exception {
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

    public static void deleteCompanhiaPS(Hangar hangar) {
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