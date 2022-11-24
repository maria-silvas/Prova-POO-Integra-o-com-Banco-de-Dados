// Criando o programa principal do sistema.
public class MainPadaria {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        //Criando os menus de escolha do Crud do Cliente e do chef e informações das padarias, mercados e receitas
        do {
            System.out.println("Sistema de cadastro geral e acesso do Aeoroporto: ");
            System.out.println("\n");
            System.out.println("Crud de Aviao: ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. SELECT Aviao COM STATEMENT");
            System.out.println("2. INSERT Aviao COM PREP STATEMENT");
            System.out.println("3. UPDATE Aviao COM STATEMENT");
            System.out.println("4. DELETE Aviao COM PREP STATEMENT");
            System.out.println("\n");
            System.out.println("Crud do Jatinho: ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("5. SELECT Jato  COM PREP STATEMENT");
            System.out.println("6. INSERT Jato STATEMENT");
            System.out.println("7. UPDATE Jato COM PREP STATEMENT");
            System.out.println("8. DELETE Jato COM STATEMENT");
            System.out.println("\n");
            System.out.println("Crud do Helicopetero ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("5. SELECT Helicopetero  COM PREP STATEMENT");
            System.out.println("6. INSERT Helicopetero STATEMENT");
            System.out.println("7. UPDATE Helicopetero COM PREP STATEMENT");
            System.out.println("8. DELETE Helicopetero COM STATEMENT");
            System.out.println("\n");
            System.out.println("15.Dados da primeira Receita");
            System.out.println("16.Dados da segunda Receita");
            System.out.println("17.Dados da terceira Receita");
            System.out.println("18.Dados da quarta Receita");
            System.out.println("19.Dados da quinta Receita");
            System.out.println("20.Dados da sexta Receita");
            System.out.println("21.Dados da setima Receita");
            System.out.println("22.Dados da oitava Receita");
            System.out.println("23.Dados da nona Receita");
            System.out.println("24.Dados da decima Receita");
            try{
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            //Chamando os metodos da escolha do menu apartir do cases da chave Switch menu.    
            }
            switch (menu) {
                case 1:
                    try {
                        ClienteDAO.printCliente(
                            ClienteDAO.getclienteS()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ClienteDAO.insertClientePS(
                            ClienteDAO.getClienteInsert(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ClienteDAO.updateClienteS(
                            ClienteDAO.getClienteUpdate(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        ClienteDAO.deleteClientePS(
                            ClienteDAO.getCLiente(scanner)                     
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        ChefDAO.printChef(
                            ChefDAO.getChefPS()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        ChefDAO.insertChefS(
                            ChefDAO.getChefInsertChef(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        ChefDAO.updateChefPS(
                            ChefDAO.getChefUpdate(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        ChefDAO.deleteChefS(
                            ChefDAO.getChef(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        System.out.println(Padaria.dadosPadariaum());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        System.out.println(Padaria.dadosPadariadois());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    try {
                        System.out.println(Padaria.dadosPadariatres());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    try {
                        System.out.println(Mercados.dadosMercadosum());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 13:
                    try {
                        System.out.println(Mercados.dadosMercadosdois());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 14:
                    try {
                        System.out.println(Mercados.dadosMercadostres());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 15:
                    try {
                        System.out.println(Receita.dadosReceitaum());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 16:
                    try {
                        System.out.println(Receita.dadosReceitadois());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
            case 17:
                    try {
                        System.out.println(Receita.dadosReceitatres());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 18:
                    try {
                        System.out.println(Receita.dadosReceitaquatro());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 19:
                    try {
                        System.out.println(Receita.dadosReceitacinco());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 20:
                    try {
                        System.out.println(Receita.dadosReceitaseis());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 21:
                    try {
                        System.out.println(Receita.dadosReceitasete());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 22:
                    try {
                        System.out.println(Receita.dadosReceitaoito());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 23:
                    try {
                        System.out.println(Receita.dadosReceitanove());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 24:
                    try {
                        System.out.println(Receita.dadosReceitadez());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;             
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
        scanner.close();
    }
}
