
// Criando o programa principal do sistema.
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

            switch (op) {
                case 1: {
                    CadastrarAviao(sc);
                    break;
                }

                case 2: {
                    CadastrarJato(sc);
                    break;
                }

                case 3: {
                    CadastrarHelicopetero(sc);
                    break;
                }

                case 4: {
                    CadastrarHanga(sc);
                    break;
                }

               
                case 16: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }

        } while (op != 16);
    }

    // Cadastros
    public static void CadastrarAviao(Scanner scanner) {
        Boolean prefixoVerificada = false;
        System.out.println("Cadastro de Aviao");

        System.out.println("Informe a marca do Aviao: ");
        String marca = scanner.next();

        System.out.println("Informe o Modelo do Aviao: ");
        String modelo = scanner.next();

        System.out.println("Informe a capacidade do Aviao: ");
        String capacidade = scanner.next();

        System.out.println("Informe as letras da prefixo do aviao: ");
        String letra = scanner.next();

        System.out.println("Informe os números prefixo do aviao: ");
        String numero = scanner.next();


        while(prefixoVerificada != true){
            if( letra.length() == 3 && numero.length() == 4) {
                prefixoVerificada = true;
            }else if(letra.length() != 3 && numero.length() ==4){
                System.out.println("Digite as letras da prefixo novamente: ");
                letra = scanner.next();
            }else if(letra.length() ==3 && numero.length() != 4){
                System.out.println("Digite os números da prefixo novamente ");
                numero = scanner.next();
            }else{
                System.out.println("Digite as letras da prefixo novamente");
                letra = scanner.next();
                System.out.println("Digite os numeros da prefixo novamente");
                numero = scanner.next();
            }
            
        }

        if(prefixoVerificada == true){

            try{
                Aviao aviao = new Aviao(+1, null, marca, modelo, null, capacidade);
                while(aviao.getPrefixo() == null){
                    int idAviao = aviao.getId();
                    System.out.println("Já cadastrada");
                    System.out.println("Digite as letras da prefixo novamente");
                    letra = scanner.next();
                    System.out.println("Digite os numeros da prefixo novamente");
                    numero = scanner.next();   
                    Prefixo = new Prefixo<String,Integer>(letra,Integer.parseInt(numero));
                    for (Aeoronave aer : Aeoronave.aeronaves) {
                        if (aer instanceof Aviao && aer.getId() == idAviao) {
                            Aeoronave.aeronaves.remove(aer);
                            break;
                        }
                    }
                    aviao = new Aviao(idAviao, marca, modelo, prefixo);
                }
                System.out.println("Aviao cadastrado com sucesso!\n" + aviao);
            }catch(Exception e){
                System.out.println("Erro ao cadastrar aviao: " + e.getMessage());
            }
            
        }

    }

    
    public static void CadastrarJato(Scanner scanner) {
        System.out.println("Cadastro de Jato");

        System.out.println("Informe a cor da Jato: ");
        String cor = scanner.next();

        System.out.println("Informe a velocidade da Jato: ");
        String velocidade = scanner.next();

        Aeoronave jato = new Jato(Aeoronave.aeronaves.size() + 1,cor,velocidade);

        System.out.println("Jato cadastrado com sucesso!\n" + jato);
    }



    public static void CadastrarHelicopetero(Scanner scanner) {
        System.out.println("Cadastro de Helicopetero");

        System.out.println("Informe a cor do Helicopetero: ");
        String cor = scanner.next();

        System.out.println("Informe a Capacidade do Helicopetero: ");
        String capacidade= scanner.next();

        Aeoronave helicopetero = new Helicopetero (Aeoronave.aeronaves.size() + 1,cor,capacidade);

        System.out.println("Helicopetero cadastrado com sucesso!\n" + helicopetero);
    }

    public static void CadastrarHangar(Scanner sc) {
        System.out.println("Cadastro de Hangar");

        System.out.println("----------------------------------");
        System.out.println("Aeronaves  Hangar: ");
        for (Aeoronave aeronave : Aeoronave.aeronaves) {
            if (aeronave instanceof Aeoronave) {
                System.out.println(aeronave);
            }
        }
        System.out.println("----------------------------------");

        System.out.println("Informe o id da Aeronave: ");
        int idVeiculo = sc.nextInt();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	    Calendar calendario = Calendar.getInstance();
        String data = dateFormat.format(calendario.getTime());
	    System.out.println("Data e Horario : " + data);
        System.out.println(data.equals("27-10-2022 21:37"));
    }


    public static void CadastrarCompanhia(Scanner scanner) {
        System.out.println("Cadastro de Companhia");

        System.out.println("Informe o nome da Companhia: ");
        String nome = scanner.next();

        System.out.println("Informe o CNPJ Companhia: ");
        String cnpj = scanner.next();

        Companhia companhia = new Companhia(Companhia.companhias.size() + 1,nome,cnpj);

        System.out.println("Jato cadastrado com sucesso!\n" + companhia);
    }

    private static void CadastrarHanga(Scanner sc) {
    }

    private static void CadastrarHelicopetero(Scanner sc) {
    }

    private static void CadastrarAviao(Scanner sc) {
    }
}