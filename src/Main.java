import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Aviao;
import model.Companhia;
import model.Generic;
import model.GenericTXT;
import model.Hangar;
import model.Helicoptero;
import model.Jato;
import model.Pista;
import model.Voo;

public class Main {

    public static int opcao;
    public static ArrayList<Aviao> avioes = new ArrayList<Aviao>();
    public static ArrayList<Companhia> companhias = new ArrayList<Companhia>();
    public static ArrayList<Hangar> hangares = new ArrayList<Hangar>();
    public static ArrayList<Helicoptero> helicopteros = new ArrayList<Helicoptero>();
    public static ArrayList<Jato> jatos = new ArrayList<Jato>();
    public static ArrayList<Pista> pistas = new ArrayList<Pista>();
    public static ArrayList<Voo> voos = new ArrayList<Voo>();

    public static void main(String[] args) {
        do {

            System.out.println("Aeroporto de ViraCopos");
            System.out.println("Digite as opções desejadas:");
            System.out.println("1 - Cadastrar Avião");
            System.out.println("2 - Cadastrar Companhia");
            System.out.println("3 - Cadastrar Hangar");
            System.out.println("4 - Cadastrar Helicoptero");
            System.out.println("5 - Cadastrar Jato");
            System.out.println("6 - Cadastrar Pista");
            System.out.println("7 - Cadastrar Voo");
            System.out.println("8 - Listar Avião");
            System.out.println("9 - Listar Companhia");
            System.out.println("10 - Listar Hangar");
            System.out.println("11 - Listar Helicoptero");
            System.out.println("12 - Listar Jato");
            System.out.println("13 - Listar Pista");
            System.out.println("14 - Listar Voo");
            System.out.println("15 - Alterar Avião");
            System.out.println("15 - Alterar Companhia");
            System.out.println("16 - Alterar Hangar");
            System.out.println("17 - Alterar Helicoptero");
            System.out.println("18 - Alterar Jato");
            System.out.println("19 - Alterar Pista");
            System.out.println("20 - Alterar Voo");
            System.out.println("29 - Excluir Avião");
            System.out.println("30 - Excluir Companhia");
            System.out.println("31 - Excluir Hangar");
            System.out.println("32 - Excluir Helicoptero");
            System.out.println("33 - Excluir Jato");
            System.out.println("34 - Excluir Pista");
            System.out.println("35 - Excluir Voo");
            System.out.println("36 - Sair");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAviao(scanner);
                    break;
                case 2:
                    cadastrarCompanhia(scanner);
                    break;
                case 3:
                    cadastrarHangar(scanner);
                    break;
                case 4:
                    cadastrarHelicoptero(scanner);
                    break;
                case 5:
                    cadastrarJato(scanner);
                    break;
                case 6:
                    cadastrarPista(scanner);
                    break;
                case 7:
                    cadastrarVoo(scanner);
                    break;
                case 8:
                    listarAviao(scanner);
                    break;
                case 9:
                    listarCompanhia(scanner);
                    break;
                case 10:
                    listarHangar(scanner);
                    break;
                case 11:
                    listarHelicoptero(scanner);
                    break;
                case 12:
                    listarJato(scanner);
                    break;
                case 13:
                    listarPista(scanner);
                    break;
                case 14:
                    listarVoo(scanner);
                    break;
                case 15:
                    alterarAviao(scanner);
                    break;
                case 16:
                    alterarCompanhia(scanner);
                    break;
                case 17:
                    alterarHangar(scanner);
                    break;
                case 18:
                    alterarHelicoptero(scanner);
                    break;
                case 19:
                    alterarJato(scanner);
                    break;
                case 20:
                    alterarPista(scanner);
                    break;
                case 21:
                    alterarVoo(scanner);
                    break;
                case 29:
                    excluirAviao(scanner);
                    break;
                case 30:
                    excluirCompanhia(scanner);
                    break;
                case 31:
                    excluirHangar(scanner);
                    break;
                case 32:
                    excluirHelicoptero(scanner);
                    break;
                case 33:
                    excluirJato(scanner);
                    break;
                case 34:
                    excluirPista(scanner);
                    break;
                case 35:
                    excluirVoo(scanner);
                    break;
                case 36:
                    salvarMeuBilhete(scanner);
                    break;
                case 37:
                    lerMeuBilhete(scanner);
                    break;
                case 38:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 38);
    }

    static void cadastrarAviao(Scanner sc) {
        System.out.println("Digite a MARCA do Avião");
        String marca = sc.next();
        System.out.println("Digite o MODELO do Avião");
        String modelo = sc.next();
        System.out.println("Digite as 3 letras do n. do avião");
        String numero = sc.next();
        if (numero.length() != 3) {
            while (numero.length() != 3) {
                System.out.println("Digite as 3 letras do n. do avião");
                numero = sc.next();
            }
        }
        System.out.println("Digite os 4 números do n. do avião");
        String letra = sc.next();
        if (letra.length() != 4) {
            while (letra.length() != 4) {
                System.out.println("Digite os 4 números do n. do avião");
                letra = sc.next();
            }
        }
        System.out.println("Digite a capacidade do avião");
        int capacidade = sc.nextInt();
        System.out.println("Digite o id da companhia");
        int idCompanhia = sc.nextInt();
        if (Aviao.getUltimoId() != 0) {
            Aviao aviao = new Aviao(Aviao.getUltimoId() + 1, marca, modelo,
                    new Generic<String, Integer>(letra, Integer.parseInt(numero)), capacidade, idCompanhia);
            avioes.add(aviao);
        }

    }

    static void cadastrarCompanhia(Scanner sc) {
        System.out.println("Digite o nome da companhia");
        String nome = sc.next();
        System.out.println("Digite o CNPJ da companhia");
        String cnpj = sc.next();
        if (Companhia.getUltimoId() != 0) {
            Companhia companhia = new Companhia(Companhia.getUltimoId() + 1, nome, cnpj);
            companhias.add(companhia);
        }
    }

    static void cadastrarHangar(Scanner sc) {
        System.out.println("Digite o nome do hangar");
        String nome = sc.next();
        System.out.println("Digite a capacidade do hangar");
        int capacidade = sc.nextInt();
        if (Hangar.getUltimoId() != 0) {
            Hangar hangar = new Hangar(Hangar.getUltimoId() + 1, nome, capacidade);
            hangares.add(hangar);
        }
    }

    static void cadastrarHelicoptero(Scanner sc) {
        System.out.println("Digite a MARCA do Helicóptero");
        String marca = sc.next();
        System.out.println("Digite o MODELO do Helicóptero");
        String modelo = sc.next();
        System.out.println("Digite a cor do Helicóptero");
        String cor = sc.next();
        System.out.println("Digite a capacidade do helicóptero");
        int capacidade = sc.nextInt();
        if (Helicoptero.getUltimoId() != 0) {
            Helicoptero helicoptero = new Helicoptero(Helicoptero.getUltimoId() + 1, marca, modelo, cor, capacidade);
            helicopteros.add(helicoptero);
        }
    }

    static void cadastrarJato(Scanner sc) {
        System.out.println("Digite a MARCA do Jato");
        String marca = sc.next();
        System.out.println("Digite o MODELO do Jato");
        String modelo = sc.next();
        System.out.println("Digite a cor do Jato");
        String cor = sc.next();
        System.out.println("Digite a capacidade do Jato");
        int capacidade = sc.nextInt();
        if (Jato.getUltimoId() != 0) {
            Jato jato = new Jato(Jato.getUltimoId() + 1, marca, modelo, cor, capacidade);
            jatos.add(jato);
        }
    }

    static void cadastrarPista(Scanner sc) {
        System.out.println("Digite a 1 letras do n. da pista");
        String numero = sc.next();
        if (numero.length() != 1) {
            while (numero.length() != 1) {
                System.out.println("Digite a 1 letras do n. da pista");
                numero = sc.next();
            }
        }
        System.out.println("Digite os 2 números do n. do pista");
        String letra = sc.next();
        if (letra.length() != 2) {
            while (letra.length() != 2) {
                System.out.println("Digite os 2 números do n. da pista");
                letra = sc.next();
            }
        }

        if (Pista.getUltimoId() != 0) {
            Pista pista = new Pista(Pista.getUltimoId() + 1,
                    new Generic<String, Integer>(letra, Integer.parseInt(numero)));
            pistas.add(pista);
        }
    }

    static void cadastrarVoo(Scanner sc) {
        System.out.println("Digite [1] para cadastrar aviao, [2] para cadastrar helicoptero, [3] para cadastrar jato");
        int opcao = sc.nextInt();
        int idAviao = 0;
        int idHelicoptero = 0;
        int idJato = 0;
        do {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o id do avião");
                    idAviao = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Digite o id do helicoptero");
                    idHelicoptero = sc.nextInt();
                    break;
                case 3:
                    System.out.println("Digite o id do jato");
                    idJato = sc.nextInt();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 40);

        System.out.println("Digite o id da pista");
        int idPista = sc.nextInt();
        System.out.println("Digite o nome do piloto");
        Pista pista = Pista.getByPista(idPista);
        String nomePiloto = sc.next();
        System.out.println("Digite o nome do copiloto");
        String nomeCopiloto = sc.next();
        System.out.println("Digite a data: ");
        String data = sc.next();
        System.out.println("Digite a hora: ");
        String hora = sc.next();
        System.out.println("Digite a origem");
        String origem = sc.next();
        System.out.println("Digite o destino");
        String destino = sc.next();
        System.out.println("Digite a observacao");
        String observacao = sc.next();
        String letra = "";
        String numero = "";
        String concatenacao = "";
        while (concatenacao.length() < 7) {
            System.out.println("Digite os 3 digitos da numeração:");
            letra = sc.next();
            if (letra.length() != 3) {
                while (letra.length() != 3) {
                    System.out.println("Digite os 3 digitos da numeração:");
                    letra = sc.next();
                }
            }
            System.out.println("Digite os 6 numeros da numeracao ");
            numero = sc.next();
            if (numero.length() != 6) {
                while (numero.length() != 6) {
                    System.out.println("Digite os 6 numeros da numeracao ");
                    numero = sc.next();
                }
            }
            concatenacao = letra + numero;
        }
        Aviao aviao = Aviao.getById(idAviao);
        Helicoptero helicoptero = Helicoptero.getById(idHelicoptero);
        Jato jato = Jato.getById(idJato);
        if (Voo.getUltimoId() != 0) {
            Voo voo = new Voo(Voo.getUltimoId() + 1, new Generic<String, Integer>(letra, Integer.parseInt(numero)),
                    data, hora, origem, destino, nomePiloto, nomeCopiloto, observacao, idPista, pista, idHelicoptero,
                    helicoptero, idJato, jato, idAviao, aviao);
            voos.add(voo);
        }

    }

    static void listarAviao(Scanner sc) {
        Aviao.getAll();
    }

    static void listarCompanhia(Scanner sc) {
        Companhia.getAll();
    }

    static void listarHangar(Scanner sc) {
        Hangar.getAll();
    }

    static void listarHelicoptero(Scanner sc) {
        Helicoptero.getAll();
    }

    static void listarJato(Scanner sc) {
        Jato.getAll();
    }

    static void listarPista(Scanner sc) {
        Pista.getAll();
    }

    static void listarVoo(Scanner sc) {
        Voo.getAll();
    }

    static void alterarAviao(Scanner sc) {
        System.out.println("Digite o id do aviao");
        int id = sc.nextInt();
        System.out.println("Digite a MARCA do Avião");
        String marca = sc.next();
        System.out.println("Digite o MODELO do Avião");
        String modelo = sc.next();
        String numero = sc.next();
        System.out.println("Digite as 3 letras do n. do avião");
        numero = sc.next();
        if (numero.length() != 3) {
            while (numero.length() != 3) {
                System.out.println("Digite as 3 letras do n. do avião");
                numero = sc.next();
            }
        }
        System.out.println("Digite os 4 números do n. do avião");
        String letra = sc.next();
        if (letra.length() != 4) {
            while (letra.length() != 4) {
                System.out.println("Digite os 4 números do n. do avião");
                letra = sc.next();
            }
        }
        System.out.println("Digite a capacidade do avião");
        int capacidade = sc.nextInt();
        System.out.println("Digite o id da companhia");
        int idCompanhia = sc.nextInt();
        if (Aviao.getUltimoId() != 0) {
            Aviao.update(id, marca, modelo, letra, capacidade, null, idCompanhia);
        }
    }

    static void alterarCompanhia(Scanner sc) {

    }

    static void alterarHangar(Scanner sc) {
        System.out.println("Digite o id do hangar");
        int id = sc.nextInt();
        System.out.println("Digite o local do hangar");
        String local = sc.next();
        System.out.println("Digite o id do aviao");
        int idAviao = sc.nextInt();
        Hangar.update(id, local, idAviao);

    }

    static void alterarHelicoptero(Scanner sc) {
        System.out.println("Digite o id do helicoptero");
        int id = sc.nextInt();
        System.out.println("Digite a MARCA do Helicoptero");
        String marca = sc.next();
        System.out.println("Digite o MODELO do Helicoptero");
        String modelo = sc.next();
        System.out.println("Digite a cor do Helicoptero");
        String cor = sc.next();
        System.out.println("Digite o numero de assentos do Helicoptero");
        int capacidade = sc.nextInt();
        Helicoptero.update(id, marca, modelo, cor, capacidade);
    }

    static void alterarJato(Scanner sc) {
        System.out.println("Digite o id do jato");
        int id = sc.nextInt();
        System.out.println("Digite a MARCA do Jato");
        String marca = sc.next();
        System.out.println("Digite o MODELO do Jato");
        String modelo = sc.next();
        System.out.println("Digite a cor do Jato");
        String cor = sc.next();
        System.out.println("Digite a velocidade do Jato");
        int velocidade = sc.nextInt();
        Jato.update(id, marca, modelo, cor, velocidade);
    }

    static void alterarPista(Scanner sc) {
        String numero = sc.next();
        System.out.println("Digite as 3 letras do n. do avião");
        numero = sc.next();
        if (numero.length() != 1) {
            while (numero.length() != 1) {
                System.out.println("Digite as 3 letras do n. do avião");
                numero = sc.next();
            }
        }
        System.out.println("Digite os 4 números do n. do avião");
        String letra = sc.next();
        if (letra.length() != 2) {
            while (letra.length() != 2) {
                System.out.println("Digite os 4 números do n. do avião");
                letra = sc.next();
            }
        }
        Pista.update(Pista.getUltimoId() + 1, new Generic<String, Integer>(letra, Integer.parseInt(numero)));
    }

    static void alterarVoo(Scanner sc) {
        System.out.println("Digite o id do voo");
        int id = sc.nextInt();
        System.out.println("Digite [1] para cadastrar aviao, [2] para cadastrar helicoptero, [3] para cadastrar jato");
        int opcao = sc.nextInt();
        int idAviao = 0;
        int idHelicoptero = 0;
        int idJato = 0;
        do {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o id do avião");
                    idAviao = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Digite o id do helicoptero");
                    idHelicoptero = sc.nextInt();
                    break;
                case 3:
                    System.out.println("Digite o id do jato");
                    idJato = sc.nextInt();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 40);

        System.out.println("Digite o id da pista");
        int idPista = sc.nextInt();
        System.out.println("Digite o nome do piloto");
        Pista pista = Pista.getByPista(idPista);
        String nomePiloto = sc.next();
        System.out.println("Digite o nome do copiloto");
        String nomeCopiloto = sc.next();
        System.out.println("Digite a data: ");
        String data = sc.next();
        System.out.println("Digite a hora: ");
        String hora = sc.next();
        System.out.println("Digite a origem");
        String origem = sc.next();
        System.out.println("Digite o destino");
        String destino = sc.next();
        System.out.println("Digite a observacao");
        String observacao = sc.next();
        String letra = "";
        String numero = "";
        String concatenacao = "";
        while (concatenacao.length() < 7) {
            System.out.println("Digite os 3 digitos da numeração:");
            letra = sc.next();
            if (letra.length() != 3) {
                while (letra.length() != 3) {
                    System.out.println("Digite os 3 digitos da numeração:");
                    letra = sc.next();
                }
            }
            System.out.println("Digite os 6 numeros da numeracao ");
            numero = sc.next();
            if (numero.length() != 6) {
                while (numero.length() != 6) {
                    System.out.println("Digite os 6 numeros da numeracao ");
                    numero = sc.next();
                }
            }
            concatenacao = letra + numero;
        }
        Aviao aviao = Aviao.getById(idAviao);
        Helicoptero helicoptero = Helicoptero.getById(idHelicoptero);
        Jato jato = Jato.getById(idJato);

        Voo.update(id, concatenacao, data, hora, origem, destino, nomePiloto, nomeCopiloto, observacao, idPista, pista,
                idHelicoptero, helicoptero, idJato, jato, idAviao, aviao);
    }

    static void excluirAviao(Scanner sc) {
        System.out.println("Digite o id do avião");
        int id = sc.nextInt();
        Aviao.delete(id);
    }

    static void excluirCompanhia(Scanner sc) {
        System.out.println("Digite o id da companhia");
        int id = sc.nextInt();
        Companhia.delete(id);
    }

    static void excluirHangar(Scanner sc) {
        System.out.println("Digite o id do hangar");
        int id = sc.nextInt();
        Hangar.delete(id);
    }

    static void excluirHelicoptero(Scanner sc) {
        System.out.println("Digite o id do helicoptero");
        int id = sc.nextInt();
        Helicoptero.delete(id);
    }

    static void excluirJato(Scanner sc) {
        System.out.println("Digite o id do jato");
        int id = sc.nextInt();
        Jato.delete(id);
    }

    static void excluirPista(Scanner sc) {
        System.out.println("Digite o id da pista");
        int id = sc.nextInt();
        Pista.delete(id);
    }

    static void excluirVoo(Scanner sc) {
        System.out.println("Digite o id do voo");
        int id = sc.nextInt();
        Voo.delete(id);
    }

    static void salvarMeuBilhete(Scanner sc) {
        System.out.println("Digite o id do voo");
        int id = sc.nextInt();
        GenericTXT g = new GenericTXT("voo.txt", id);
    }

    public static void lerMeuBilhete(Scanner sc) {
        GenericTXT.readArquivo("voo.txt");
    }

}
