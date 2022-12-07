// Criando o programa principal do sistema.

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import database.DAO;
import model.Aeronave;

import model.Aviao;
import model.Companhia;
import model.Hangar;
import model.Helicoptero;
import model.Jato;
import model.Pista;
import model.Prefixo;
import model.Voo;;

// Criando o programa principal do sistema.
public class Aeroporto {

    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        // Criando os menus de escolha do Crud
        Scanner sc = new Scanner(System.in);
        FileWriter arq = new FileWriter("aeroporto.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        int op = 0;

        do {
            System.out.println("Sistema de cadastro geral e acesso do Aeroporto: ");
            System.out.println("\n");

            System.out.println("\n\n[01] - Cadastrar Aviao");
            System.out.println("[02] - Cadastrar Jato");
            System.out.println("[03] - Cadastrar Helicoptero");
            System.out.println("[04] - Cadastrar Hangar");
            System.out.println("[05] - Cadastrar Companhia");
            System.out.println("[06] - Cadastrar Pista");
            System.out.println("[07] - Cadastrar VOO");
            System.out.println("*********************");
            System.out.println("[08] - Listar Aviao");
            System.out.println("[09] - Listar Jato");
            System.out.println("[10] - Listar Helicoptero");
            System.out.println("[11] - Listar Hangar");
            System.out.println("[12] - Listar Companhia");
            System.out.println("[13] - Listar Pista");
            System.out.println("[14] - Listar VOO");
            System.out.println("*********************");
            System.out.println("[15] - Excluir Aviao");
            System.out.println("[16] - Excluir Jato");
            System.out.println("[17] - Excluir Helicoptero");
            System.out.println("[18] - Excluir Hangar");
            System.out.println("[19] - Excluir Companhia");
            System.out.println("[20] - Excluir Pista");
            System.out.println("[21] - Excluir VOO");
            System.out.println("*********************");
            System.out.println("[22] - Alterar Aviao");
            System.out.println("[23] - Alterar Jato");
            System.out.println("[24] - Alterar Helicoptero");
            System.out.println("[25] - Alterar Hangar");
            System.out.println("[26] - Alterar Companhia");
            System.out.println("[27] - Alterar Pista");
            System.out.println("[28] - Alterar VOO");
            System.out.println("[29] - Salvar arquivo");
            System.out.println("[20] - Sair");

            op = sc.nextInt();

            System.out.println("\n");
            System.out.println("\n");

            switch (op) {
                case 1: {
                    if (Companhia.companhias.size() > 0) {
                        CadastrarAviao(sc);
                    } else {
                        System.out.println("Cadastre uma companhia antes de cadastrar um aviao");
                    }

                    break;
                }

                case 2: {
                    CadastrarJato(sc);
                    break;
                }

                case 3: {
                    CadastrarHelicoptero(sc);
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
                    CadastrarVoo(sc);
                    break;
                }
                case 8: {
                    ListarAviao(gravarArq);
                    break;
                }
                case 9: {
                    ListarJato(gravarArq);
                    break;
                }
                case 10: {
                    ListarHelicopetero(gravarArq);
                    break;
                }
                case 11: {
                    ListarHangar(gravarArq);
                    break;
                }
                case 12: {
                    ListarCompanhia(gravarArq);
                    break;
                }
                case 13: {
                    ListarPista(gravarArq);
                    break;
                }
                case 14: {
                    ListarVoo(gravarArq);
                    break;
                }

                case 15: {
                    ExcluirAviao(sc);
                    break;
                }

                case 16: {
                    ExcluirJato(gravarArq);
                    break;
                }

                case 17: {
                    ExcluirHelicopetero(sc);
                    break;
                }

                case 18: {
                    ExcluirHangar(sc);
                    break;
                }

                case 19: {
                    ExcluirCompanhia(sc);
                    break;
                }

                case 20: {
                    ExcluirPista(sc);
                    break;
                }
                case 21: {
                    ExcluirVoo(sc);
                    break;
                }
                case 22: {
                    AlterarAviao(sc);
                    break;
                }

                case 29: {
                    SalvarArquivo(gravarArq);
                    break;
                }

                case 30: {
                    arq.close();
                    sc.close();
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

    private static void AlterarAviao(Scanner sc) {
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

        System.out.println("Informe a companhia do aviao: ");
        int companhia = scanner.nextInt();

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
            }
        }

        if (prefixoVerificada == true) {
            Prefixo<String, Integer> prefixo = new Prefixo<String, Integer>(letra, Integer.parseInt(numero));
            try {
                Aviao aviao = new Aviao(null);
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
                    aviao = new Aviao(null);
                }
                System.out.println("Aviao cadastrado com sucesso!\n" + aviao);
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar aviao: " + e.getMessage());
            }

        }

    }

    public static void CadastrarJato(Scanner scanner) {
        System.out.println("------Cadastro de Jato------");

        System.out.println("Informe a marca do Jato: ");
        String marca = scanner.next();

        System.out.println("Informe a cor do Jato: ");
        String cor = scanner.next();

        System.out.println("Informe o modelo do Jato: ");
        String modelo = scanner.next();

        System.out.println("Informe a velocidade da Jato: ");
        int velocidade = scanner.nextInt();

        Aeronave jato = new Jato (Jato.jatos.size() + 1, marca, cor, modelo, velocidade);
        System.out.println("Jato cadastrado com sucesso!\n" + jato);

    }

    public static void CadastrarHelicoptero(Scanner scanner) {
        System.out.println("------Cadastro de Helicoptero------");

        System.out.println("Informe a marca do Helicoptero: ");
        String marca = scanner.next();

        System.out.println("Informe o modelo do Helicoptero: ");
        String modelo = scanner.next();

        System.out.println("Informe a cor do Helicoptero: ");
        String cor = scanner.next();

        System.out.println("Informe a Capacidade do Helicoptero: ");
        int capacidade = scanner.nextInt();

        Aeronave helicopetero = new Helicoptero(Helicoptero.helicopteros.size() + 1, marca, modelo, cor, capacidade);

        System.out.println("Helicoptero cadastrado com sucesso!\n" + helicopetero);
    }

    public static void CadastrarCompanhia(Scanner scanner) {
        System.out.println("------Cadastro de Companhia------");

        System.out.println("Informe o nome da Companhia: ");
        String nome = scanner.next();

        System.out.println("Informe o CNPJ Companhia: ");
        String cnpj = scanner.next();

        Companhia companhia = new Companhia(Companhia.companhias.size() + 1, nome, cnpj);

        System.out.println("Companhia cadastrado com sucesso!\n" + companhia);
    }

    public static void CadastrarPista(Scanner scanner, String letra) {
        System.out.println("------Cadastro de Pista------");

        System.out.println("Informe o número da pista: ");
        String numero = scanner.next();

        Pista pista = new Pista(Pista.pistas.size() + 1, numero);
        System.out.println("Pista cadastrada com sucesso!\n" + pista);
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

        System.out.println("Informe o id da pista: ");
        String id = sc.next();

        System.out.println("Informe o numero da Pista:  ");
        String numero = sc.next();

        Pista pista = new Pista(+1, numero);

        
    }

    public static void CadastrarVoo(Scanner sc) {

        System.out.println("------Cadastro de Voo------");

        System.out.println("Informe a data do Voo: ");
        String data = sc.next();

        System.out.println("informe o numero do voo");
        int numero = sc.nextInt();

        System.out.println("Informe o horario do Voo: ");
        String hora = sc.next();

        System.out.println("Informe a origem do Voo: ");
        String origem = sc.next();

        System.out.println("Informe o destino do Voo: ");
        String destino = sc.next();

        System.out.println("Informe o Piloto do Voo: ");
        String piloto = sc.next();

        System.out.println("Informe o Copiloto do Voo: ");
        String copiloto = sc.next();

        System.out.println("Observações sobre o Voo: ");
        String observacao = sc.next();

        System.out.println("Informe a pista de decolagem: ");
        int idPista = sc.nextInt();

        System.out.println("Informe o id da Aeronave: ");
        int idAeronave = sc.nextInt();

        Voo voo = new Voo(Voo.voos.size() + 1, numero, data, hora, origem, destino, piloto, copiloto, observacao,
                idPista,
                idAeronave);
    }

    public static void SalvarArquivo(PrintWriter gravarArq) {
        System.out.println("------Salvar Voos em Arquivo------");
        gravarArq.println("------Voos Salvos no Sistema------");

        for (Voo voo : Voo.voos) {
            if (voo instanceof Voo) {
                gravarArq.println(voo);
            }
        }
    }

    // Listagens das classes abaixo
    public static void ListarAviao(PrintWriter gravarArq) {
        System.out.println("------Listagem de Aviao------");
        for (Aeronave aeronave : Aeronave.aeoronaves) {
            if (aeronave instanceof Aviao) {
                System.out.println(aeronave);
            }
        }

    }

    public static void ListarJato(PrintWriter gravarArq) {
        System.out.println("------Listagem de Jato------");

        for (Aeronave jato : Aeronave.aeoronaves) {
            if (jato instanceof Jato) {
                System.out.println(jato);
            }
        }

    }

    public static void ListarHelicopetero(PrintWriter gravarArq) {
        System.out.println("------Listagem de Helicoptero------");

        for (Aeronave helicopetero : Aeronave.aeoronaves) {
            if (helicopetero instanceof Helicoptero) {
                System.out.println(helicopetero);
            }
        }

    }

    public static void ListarHangar(PrintWriter gravarArq) {
        System.out.println("------Listagem de Hangar------");

        for (Hangar hangar : Hangar.hangares) {
            if (hangar instanceof Hangar) {
                System.out.println(hangar);
            }
        }

    }

    public static void ListarCompanhia(PrintWriter gravarArq) {
        System.out.println("------Listagem de Companhia------");

        for (Companhia companhia : Companhia.companhias) {
            if (companhia instanceof Companhia) {
                System.out.println(companhia);
            }
        }

    }

    public static void ListarPista(PrintWriter gravarArq) {
        System.out.println("------Listagem de Pista------");

        for (Pista pista : Pista.pistas) {
            if (pista instanceof Pista) {
                System.out.println(pista);
            }
        }
        ;
    }

    public static void ListarVoo(PrintWriter gravarArq) {
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

        for (Aviao aviao : Aviao.avioes) {
            if (aviao instanceof Aviao && aviao.getId() == id) {
                Aviao.avioes.remove(aviao);
                System.out.println("Avião excluído com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirJato(PrintWriter gravarArq) {
        System.out.println("------Exclusão de Jato------");

     
        System.out.println("Informe o ID do Jato: ");
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
        System.out.println("------Exclusão de Helicoptero------");

        System.out.println("Informe o ID do Helicoptero: ");
        int id = sc.nextInt();

        for (Helicoptero helicopetero : Helicoptero.helicopteros) {
            if (helicopetero instanceof Helicoptero && helicopetero.getId() == id) {
                Helicoptero.helicopteros.remove(helicopetero);
                System.out.println("Helicoptero excluído com sucesso!");
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

    // ALTERAÇÃO


}