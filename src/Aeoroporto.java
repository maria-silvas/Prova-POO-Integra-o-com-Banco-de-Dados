
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
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("Sistema de cadastro geral e acesso do Aeroporto: ");
            System.out.println("\n");
          
            System.out.println("\n\n[01] - Cadastrar Aviao");
            System.out.println("[02] - Cadastrar Jato");
            System.out.println("[03] - Cadastrar Helicopetero");
            System.out.println("[04] - Cadastrar Hangar");
            System.out.println("[05] - Cadastrar Companhia");
            System.out.println("[06] - Cadastrar Pista");
            System.out.println("[07] - Cadastrar VOO");
            System.out.println("[08] - Inserir Aviao");
            System.out.println("[09] - Inserir Jato");
            System.out.println("[10] - Inserir Helicopetero");
            System.out.println("[11] - Inserir Hangar");
            System.out.println("[12] - Inserir Companhia");
            System.out.println("[13] - Inserir Pista");
            System.out.println("[14] - Inserir VOO");
            System.out.println("[15] - Listar Aviao");
            System.out.println("[16] - Listar Jato");
            System.out.println("[17] - Listar Helicopetero");
            System.out.println("[18] - Listar Hangar");
            System.out.println("[19] - Listar Companhia");
            System.out.println("[20] - Listar Pista");
            System.out.println("[21] - Listar VOO");
            System.out.println("[22] - Excluir Aviao");
            System.out.println("[23] - Excluir Jato");
            System.out.println("[24] - Excluir Helicopetero");
            System.out.println("[25] - Excluir Hangar");
            System.out.println("[26] - Excluir Companhia");
            System.out.println("[27] - Excluir Pista");
            System.out.println("[28] - Excluir VOO");
            System.out.println("[29] - Sair");
            op = sc.nextInt();

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
