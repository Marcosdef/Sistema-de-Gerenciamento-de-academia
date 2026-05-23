package Gerenciamentodeacademia;
import java.util.Scanner;
public class igerenciamentodeacademia {
    private static Scanner sc = new Scanner(System.in);
    private final Operacaorecepcionista rece = new Operacaorecepcionista();
    private final Operacaoaluno aluno = new Operacaoaluno();
    private final Operacaopersonal personal = new Operacaopersonal();
    private final Operacaoobjetosacademia obj = new Operacaoobjetosacademia();
    public void Menu(){
        int opcao;
    do {
        System.out.println("1 - recepcionista:");
        System.out.println("2 - aluno:");
        System.out.println("3 - personal:");
        System.out.println("4 - equipamentos:");
        System.out.println("0 - sair:");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                    int opcaosub;
                do {
                    System.out.println("1 - cadastrar recepcionista: ");
                    System.out.println("2 - listar recepcionistas: ");
                    System.out.println("3 - buscar recepcionista por cpf: ");
                    System.out.println("4 - deletar recepcionista: ");
                    System.out.println("5 - atualizar recepcionista: ");
                    System.out.println("0 - sair: ");
                    opcaosub = sc.nextInt();
                    sc.nextLine();
                    switch (opcaosub) {
                        case 1:
                            rece.cadastrar();
                            break;
                        case 2:
                            rece.listar();
                            break;
                        case 3:
                            rece.buscarentidade();
                            break;
                        case 4:
                            rece.deletar();
                            break;
                        case 5:
                            rece.atualizar();
                            break;
                    }
                } while (opcaosub != 0);
                    break;
            case 2:
                    int opcao2;
                do {
                    System.out.println("1 - cadastrar aluno: ");
                    System.out.println("2 - listar alunos: ");
                    System.out.println("3 - buscar aluno por cpf: ");
                    System.out.println("4 - deletar aluno: ");
                    System.out.println("5 - atualizar aluno: ");
                    System.out.println("6 - mensalidade aluno: ");
                    System.out.println("0 - sair: ");
                    opcao2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcao2) {
                        case 1:
                            aluno.cadastrar();
                            break;
                        case 2:
                            aluno.listar();
                            break;
                        case 3:
                            aluno.buscarentidade();
                            break;
                        case 4:
                            aluno.deletar();
                            break;
                        case 5:
                            aluno.atualizar();
                            break;
                        case 6:
                            aluno.renovarmensalidade();
                            break;
                    }

                } while (opcao2 != 0);
                    break;
            case 3:
                int opcao3;
                do {
                    System.out.println("1 - cadastrar personaltrainer: ");
                    System.out.println("2 - listar personaltrainer: ");
                    System.out.println("3 - buscar personaltrainer por cpf: ");
                    System.out.println("4 - deletar personaltrainer: ");
                    System.out.println("5 - atualizar personaltrainer: ");
                    System.out.println("6 - fazer treino para aluno: ");
                    System.out.println("0 - sair: ");
                    opcao3 = sc.nextInt();
                    sc.nextLine();
                    switch (opcao3) {
                        case 1:
                            personal.cadastrar();
                            break;
                        case 2:
                            personal.listar();
                            break;
                        case 3:
                            personal.buscarentidade();
                            break;
                        case 4:
                            personal.deletar();
                            break;
                        case 5:
                            personal.atualizar();
                            break;
                        case 6:
                            personal.criartreinamento();
                            break;
                    }
                } while (opcao3 != 0);
                break;
            case 4:
                int opcao4;
                do {
                    System.out.println("1 - criar equipamentos: ");
                    System.out.println("2 - listar equipamentos: ");
                    System.out.println("3 - buscar equipamentos por nome: ");
                    System.out.println("4 - deletar equipamentos: ");
                    System.out.println("5 - atualizar equipamentos: ");
                    System.out.println("0 - sair: ");
                    opcao4 = sc.nextInt();
                    sc.nextLine();
                    switch (opcao4) {
                        case 1:
                            obj.cadastrar();
                            break;
                        case 2:
                            obj.listar();
                            break;
                        case 3:
                            obj.buscarentidade();
                            break;
                        case 4:
                            obj.deletar();
                            break;
                        case 5:
                            obj.atualizar();
                            break;
                    }
                } while (opcao4 != 0);
                break;
        }

    } while(opcao != 0);

    }
}
