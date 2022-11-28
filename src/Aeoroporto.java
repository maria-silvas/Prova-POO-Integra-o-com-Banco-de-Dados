
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
            System.out.println("Sistema de cadastro geral e acesso da Padaria: ");
            System.out.println("\n");
            System.out.println("Crud de Cliente: ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. SELECT Aviao COM STATEMENT");
            System.out.println("2. INSERT Aviao COM STATEMENT");
            System.out.println("3. UPDATE Aviao COM STATEMENT");
            System.out.println("4. DELETE Aviao COM  PREPARE STATEMENT");
            
            System.out.println("5. SELECT Helicopetero COM STATEMENT");
            System.out.println("6. INSERT Helicopetero COM STATEMENT");
            System.out.println("7. UPDATE Helicopetero COM STATEMENT");
            System.out.println("8. DELETE Helicopetero COM PREPARE STATEMENT");
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
                                AeroportoDao.getAviaoS());
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
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
        scanner.close();
    }
}
