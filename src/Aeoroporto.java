
// Criando o programa principal do sistema.
import java.util.Scanner;

import dao.AeroportoDao;
import model.Aviao;
import model.Companhia;

// Criando o programa principal do sistema.
public class Aeoroporto {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        // Criando os menus de escolha do Crud 
        
        do {
            System.out.println("Sistema de cadastro geral e acesso do Aeroporto: ");
            System.out.println("\n");
          
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. CADASTRAR Aviao");
            System.out.println("2. INCLUIR Aviao");
            System.out.println("3. LISTAR Aviao");
            System.out.println("4. Deletar Aviao ");
            
            System.out.println("5. CADASTRAR Helicopetero  ");
            System.out.println("6. INCLUIR Helicopetero  ");
            System.out.println("7. LISTAR Helicopetero  ");
            System.out.println("8. Deletar Helicopetero  ");

            System.out.println("5. CADASTRAR Jato");
            System.out.println("6. INCLUIR Jato");
            System.out.println("7. LISTAR Jato");
            System.out.println("8. Deletar Jato");

            System.out.println("5. CADASTRAR Hangar  ");
            System.out.println("6. INCLUIR Hangar  ");
            System.out.println("7. LISTAR Hangar  ");
            System.out.println("8. Deletar Hangar  ");

            System.out.println("5. CADASTRAR Companhia ");
            System.out.println("6. INCLUIR Companhia ");
            System.out.println("7. LISTAR Companhia ");
            System.out.println("8. Deletar Companhia ");


            System.out.println("5. CADASTRAR Pista  ");
            System.out.println("6. INCLUIR Pista  ");
            System.out.println("7. LISTAR Pista  ");
            System.out.println("8. Deletar Pista  ");

            System.out.println("5. CADASTRAR VOO  ");
            System.out.println("6. INCLUIR VOO  ");
            System.out.println("7. LISTAR VOO  ");
            System.out.println("8. Deletar VOO  ");
            System.out.println("\n");
            System.out.println("\n");

            try {
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // Chamando os metodos da escolha do menu apartir do cases da chave Switch menu.
            }
            switch (menu) {
                case 1:
                    try {
                        AeroportoDao.printAviao(
                                AeroportoDao.getAviao());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        AeroportoDao.insertAviaoS(
                                AeroportoDao.getAviaoInsert(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        AeroportoDao.updateAviaoS(
                                AeroportoDao.getAviaoUpdate(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        AeroportoDao.deleteAviaoPS(
                                AeroportoDao.getAviao(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                    case 5:
                    try {
                        AeroportoDao.printHelicopetero(
                                AeroportoDao.getHelicopetero());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        AeroportoDao.insertHelicopetero(
                                AeroportoDao.getHelicopeteroInsert(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        AeroportoDao.updateHelicoetero(
                                AeroportoDao.getHelicopeteroUpdate(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        AeroportoDao.deleteAviaoPS(
                                AeroportoDao.getHelicopetero(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                   case 9:
                    try {
                        AeroportoDao.printJato(
                                AeroportoDao.getJato());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        AeroportoDao.insertJato(
                                AeroportoDao.getJatoInsert(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    try {
                        AeroportoDao.updateJato(
                                AeroportoDao.getJatoUpdate(scanner));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    try {
                        AeroportoDao.deleteJatoPS(
                                AeroportoDao.getJato(scanner));
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
