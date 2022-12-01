
// Criando o programa principal do sistema.


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import database.DAO;
import model.Aeronave;

import model.Aviao;
import model.Companhia;
import model.Hangar;
import model.Helicopetero;
import model.Jato;
import model.Pista;
import model.Prefixo;
import model.Voo;;

// Criando o programa principal do sistema.
public class Aeroporto {

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
                    CadastrarHangar(sc);
                    break;
                }

                case 5: {
                    CadastrarCompanhia(sc);
                    break;
                }
                case 6: {
                    CadastrarPista(sc, null);
                    break;
                }
                case 7: {
                    CadastrarAviao(sc);
                    break;
                }
                case 8: {
                    InserirAviao(sc, null);
                    break;
                }

                case 29: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }

        } while (op != 29);
    }

    private static void InserirAviao(Scanner sc, Object object) {
    }

    // Cadastros
    public static void CadastrarAviao(Scanner scanner) {
        Boolean prefixoVerificada = false;
        System.out.println("------Cadastro de Aviao------");

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

        while (prefixoVerificada != true) {
            if (letra.length() == 3 && numero.length() == 4) {
                prefixoVerificada = true;
            } else if (letra.length() != 3 && numero.length() == 4) {
                System.out.println("Digite as letras da prefixo novamente: ");
                letra = scanner.next();
            } else if (letra.length() == 3 && numero.length() != 4) {
                System.out.println("Digite os números da prefixo novamente ");
                numero = scanner.next();
            } else {
                System.out.println("Digite as letras da prefixo novamente");
                letra = scanner.next();
                System.out.println("Digite os numeros da prefixo novamente");
                numero = scanner.next();
            }
        }

        if (prefixoVerificada == true) {
            Prefixo<String, Integer> prefixo = new Prefixo<String, Integer>(letra, Integer.parseInt(numero));
            try {
                Aviao aviao = new Aviao(+1, prefixo, marca, modelo, null, capacidade);
                while (aviao.getPrefixo() == null) {
                    int idAviao = aviao.getId();
                    System.out.println("Já cadastrada");
                    System.out.println("Digite as letras da prefixo novamente");
                    letra = scanner.next();
                    System.out.println("Digite os numeros da prefixo novamente");
                    numero = scanner.next();
                    prefixo = new Prefixo<String, Integer>(letra, Integer.parseInt(numero));
                    for (Aeronave aeronave : Aeronave.aeronaves) {
                        if (aeronave instanceof Aviao && aeronave.getId() == idAviao) {
                            Aeronave.aeoronaves.remove(aviao);
                            break;
                        }
                    }
                    aviao = new Aviao(+1, prefixo, marca, modelo, null, capacidade);
                }
                System.out.println("Aviao cadastrado com sucesso!\n" + aviao);
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar aviao: " + e.getMessage());
            }

        }

    }

    public static void CadastrarJato(Scanner scanner) {
        System.out.println("------Cadastro de Jato------");

        System.out.println("Informe a cor da Jato: ");
        String cor = scanner.next();

        System.out.println("Informe a velocidade da Jato: ");
        String velocidade = scanner.next();

        Aeronave jato = new Jato<>(+1, velocidade, cor, velocidade, 0);

        System.out.println("Jato cadastrado com sucesso!\n" + jato);
    }

    public static void CadastrarHelicopetero(Scanner scanner) {
        System.out.println("------Cadastro de Helicopetero------");

        System.out.println("Informe a cor do Helicopetero: ");
        String cor = scanner.next();

        System.out.println("Informe a Capacidade do Helicopetero: ");
        String capacidade = scanner.next();

        Aeronave helicopetero = new Helicopetero(+1, capacidade, cor, capacidade, 0);

        System.out.println("Helicopetero cadastrado com sucesso!\n" + helicopetero);
    }

    public static void CadastrarHangar(Scanner sc) {
        System.out.println("------Cadastro de Hangar------");

        System.out.println("Aeronaves  Hangar: ");
        for (Aeronave aeronave : Aeronave.aeronaves) {
            if (aeronave instanceof Aeronave) {
                System.out.println(aeronave);
            }
        }

        System.out.println("Informe o id da Aeronave: ");
        int idAeronave = sc.nextInt();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Calendar calendario = Calendar.getInstance();
        String data = dateFormat.format(calendario.getTime());
        System.out.println("Data e Horario : " + data);
        System.out.println(data.equals("27-10-2022 21:37"));
    }

    public static void CadastrarCompanhia(Scanner scanner) {
        System.out.println("------Cadastro de Companhia------");

        System.out.println("Informe o nome da Companhia: ");
        String nome = scanner.next();

        System.out.println("Informe o CNPJ Companhia: ");
        String cnpj = scanner.next();

        Companhia companhia = new Companhia(Companhia.companhias.size() + 1, nome, cnpj);

        System.out.println("Jato cadastrado com sucesso!\n" + companhia);
    }

    public static void CadastrarPista(Scanner scanner, String letra) {
        System.out.println("------Cadastro de Pista------");

        System.out.println("Informe o id da pista: ");
        String id = scanner.next();

        System.out.println("Informe o numero da Pista:  ");
        String numero = scanner.next();

        Pista pista = new Pista(+1, numero);

        boolean prefixoVerificada;
        while (prefixoVerificada != true) {
            if (letra.length() == 1 && numero.length() == 2) {
                prefixoVerificada = true;
            } else if (letra.length() != 3 && numero.length() == 4) {
                System.out.println("Digite as letras da pista novamente: ");
                letra = scanner.next();
            } else if (letra.length() == 3 && numero.length() != 4) {
                System.out.println("Digite os números da pista novamente ");
                numero = scanner.next();
            } else {
                System.out.println("Digite as letras da pista novamente");
                letra = scanner.next();
                System.out.println("Digite os numeros da pista novamente");
                numero = scanner.next();
            }
        }

        if (prefixoVerificada == true) {
            Prefixo<String, Integer> prefixo = new Prefixo<String, Integer>(letra, Integer.parseInt(numero));
            try {
                Pista pista = new Pista(+1, numero);
                while (pista.getPrefixo() == null) {
                    int idPista = pista.getId();
                    System.out.println("Já cadastrada");
                    System.out.println("Digite as letras da prefixo novamente");
                    letra = scanner.next();
                    System.out.println("Digite os numeros da prefixo novamente");
                    numero = scanner.next();
                    prefixo = new Prefixo<String, Integer>(letra, Integer.parseInt(numero));
                    for (Pista pistas : Pista.pistas) {
                        if (pistas instanceof Pista && pista.getId() == idPista) {
                            Pista.pistas.remove(pista);
                            break;
                        }
                    }
                    Pista pista = new Pista(Pista.pistas.size() + 1, numero);
                }
                
                System.out.println("Pista cadastrado com sucesso!\n" + pista);
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar pista: " + e.getMessage());
            }

        }
    }

    // Listagens das classes abaixo
    public static void ListarAviao(Scanner sc) {
        System.out.println("------Listagem de Aviao------");
        for (Aeronave aeronave : Aeronave.aeoronaves) {
            if (aeronave instanceof Aviao) {
                System.out.println(aeronave);
            }
        }

    }

    public static void ListarJato(Scanner sc) {
        System.out.println("------Listagem de Jato------");

        for (Aeronave jato : Aeronave.aeoronaves) {
            if (jato instanceof Jato) {
                System.out.println(jato);
            }
        }

    }

    public static void ListarHelicopetero(Scanner sc) {
        System.out.println("------Listagem de Helicopetero------");

        for (Aeronave helicopetero : Aeronave.aeoronaves) {
            if (helicopetero instanceof Helicopetero) {
                System.out.println(helicopetero);
            }
        }

    }

    public static void ListarHangar(Scanner sc) {
        System.out.println("------Listagem de Hangar------");

        for (Hangar hangar : Hangar.hangares) {
            if (hangar instanceof Hangar) {
                System.out.println(hangar);
            }
        }

    }

    public static void ListarCompanhia(Scanner sc) {
        System.out.println("------Listagem de Companhia------");

        for (Companhia companhia : Companhia.companhias) {
            if (companhia instanceof Companhia) {
                System.out.println(companhia);
            }
        }

    }

    public static void ListarPista(Scanner sc) {
        System.out.println("------Listagem de Pista------");

        for (Pista pista : Pista.pistas) {
            if (pista instanceof Pista) {
                System.out.println(pista);
            }
        }
        ;
    }

    public static void ListarVoo(Scanner sc) {
        System.out.println("------Listagem de VOO------");
        for (Voo voo : Voo.voos) {
            if (voo instanceof Voo) {
                System.out.println(voo);
            }
        }

    }

    // EXCLUSÃO das classes abaixo
    public static void ExcluirAviao(Scanner sc) {
        System.out.println("------Exclusão de Aviao------");

        System.out.println("Informe o ID do Aviao: ");
        int id = sc.nextInt();

        for (Aviao aviao : Aviao.aviaos) {
            if (aviao instanceof Aviao && aviao.getId() == id) {
                Aviao.aviaos.remove(aviao);
                System.out.println("Avião excluído com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirJato(Scanner sc) {
        System.out.println("------Exclusão de Jato------");

        System.out.println("Informe o ID de Jato: ");
        int id = sc.nextInt();

        for (Jato jato : Jato.jatos) {
            if (jato instanceof Jato && jato.getId() == id) {
                Jato.jatos.remove(jato);
                System.out.println("Jato excluído com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirHelicopetero(Scanner sc) {
        System.out.println("------Exclusão de Helicopetero------");

        System.out.println("Informe o ID do Helicopetero: ");
        int id = sc.nextInt();

        for (Helicopetero helicopetero : Helicopetero.helicopeteros) {
            if (helicopetero instanceof Helicopetero && helicopetero.getId() == id) {
                Helicopetero.helicopeteros.remove(helicopetero);
                System.out.println("Helicopetero excluído com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirHangar(Scanner sc) {
        System.out.println("------Exclusão de Hangar------");

        System.out.println("Informe o ID do Hangar: ");
        int id = sc.nextInt();

        for (Hangar hangar : Hangar.hangares) {
            if (hangar instanceof Hangar && hangar.getId() == id) {
                Hangar.hangares.remove(hangar);
                System.out.println("Hangar excluído com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirCompanhia(Scanner sc) {
        System.out.println("------Exclusão de Companhia------");

        System.out.println("Informe o ID da Companhia: ");
        int id = sc.nextInt();

        for (Companhia companhia : Companhia.companhias) {
            if (companhia instanceof Companhia && companhia.getId() == id) {
                Companhia.companhias.remove(companhia);
                System.out.println("Companhia excluída com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirPista(Scanner sc) {
        System.out.println("------Exclusão de Pista------");

        System.out.println("Informe o ID da Pista: ");
        int id = sc.nextInt();

        for (Pista pista : Pista.pistas) {
            if (pista instanceof Pista && pista.getId() == id) {
                Pista.pistas.remove(pista);
                System.out.println("Pista excluída com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirVoo(Scanner sc) {
        System.out.println("------Exclusão de Voo------");

        System.out.println("Informe o ID do Voo: ");
        int id = sc.nextInt();

        for (Voo voo : Voo.voos) {
            if (voo instanceof Voo && voo.getId() == id) {
                Voo.voos.remove(voo);
                System.out.println("Voo excluído com sucesso!");
                break;
            }
        }
    }
}

