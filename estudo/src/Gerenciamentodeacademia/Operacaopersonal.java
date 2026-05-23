package Gerenciamentodeacademia;
import Gerenciamentodeacademia.enuns.Cargo;
import Gerenciamentodeacademia.enuns.Especialidade;
import Gerenciamentodeacademia.enuns.Horario;

import java.util.ArrayList;
import java.util.Scanner;
public class Operacaopersonal implements ioperacao {
    private final ArrayList<Personaltrainer> personal = Repositorio.getInstancia().getPersonaltrainers();
    private final Scanner sc = new Scanner(System.in);

    public void listar() {
        for (Personaltrainer p : personal) {
            p.exibir();
        }
    }
    public Personaltrainer acharpersonal(String cpf){
        for(Personaltrainer p : personal){
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }

    public void cadastrar() {
        int opcao;
        String nome, endereco,cpf, telefone;
        double salario;
        Horario horario = null;
        Cargo cargo = Cargo.personaltrainer;
        Especialidade especialidade = null;
        while (true){
            System.out.println("Adicione um cpf:");
            cpf = sc.nextLine();
            Personaltrainer p = acharpersonal(cpf);
            if (p != null){
                System.out.println("cpf ja existente:");
                continue;
            }
            break;
        }
        System.out.println("adicione um nome:");
        nome = sc.nextLine();
        System.out.println("adicione um endereco:");
        endereco = sc.nextLine();
        while (true) {
            System.out.println("adicione um telefone:");
            telefone = sc.nextLine();
            boolean telefoneJaExiste = false;
            for (Personaltrainer p : this.personal) {
                if (p.getTelefone().equals(telefone)) {
                    telefoneJaExiste = true;
                    break;
                }
            }
            if (telefoneJaExiste) {
                System.out.println("telefone ja existente:");
                continue;
            }
            break;
        }
        System.out.println("Adicione uma Especialidade:");
        System.out.println("1 - Treinamentofisicopersonalizado,\n" +
                        "2 -   Musculacao_e_hipertrofia,\n" +
                        "3 -   Emagrecimento_e_condicionamento,\n" +
                        "4 -   Idosos,\n" +
                        "5 -   Gestantes,\n" +
                        "6 =   Reabilitacao;");
        opcao = sc.nextInt();
        sc.nextLine();
        switch(opcao){
            case 1:
                        especialidade = Especialidade.Treinamentofisicopersonalizado;
                        break;
                        case 2:
                        especialidade = Especialidade.Musculacao_e_hipertrofia;
                        break;
                    case 3:
                        especialidade = Especialidade.Emagrecimento_e_condicionamento;
                        break;
                    case 4:
                        especialidade = Especialidade.Idosos;
                        break;
                    case 5:
                        especialidade = Especialidade.Gestantes;
                        break;
                    case 6:
                        especialidade = Especialidade.Reabilitacao;
                        break;
                    default:
                        System.out.println("opcao invalido");
                        return;
                }
        System.out.print("adicione um salario:");
        salario = sc.nextDouble();
        sc.nextLine();
        System.out.print("adicione um horario:");
        System.out.println("1 - Manhã = 06:00 às 14:00\n"+"2 - Tarde = 14:00 às 22:00");
        opcao = sc.nextInt();
        sc.nextLine();
        switch(opcao){
            case 1:
                horario = Horario.Manhã;
            case 2:
                horario = Horario.Tarde;
        }
        Personaltrainer p = new Personaltrainer(cpf,nome,salario,endereco,telefone,cargo,horario,especialidade);
        personal.add(p);
        System.out.println("Personal cadastrado com sucesso!");
    }

    public void buscarentidade() {
        String cpf;
        System.out.println("digite CPF: ");
        cpf = sc.nextLine();
        Personaltrainer p = acharpersonal(cpf);
        if (p != null) {
            p.exibir();
        } else {
            System.out.println("Cpf não existente!");
        }
    }

    public void deletar() {
        String cpf;
        System.out.println("digite CPF para deletar: ");
        cpf = sc.nextLine();
        Personaltrainer p = acharpersonal(cpf);
        if (p != null) {
            personal.remove(p);
            System.out.println("Personal removido com sucesso!");
        } else {
            System.out.println("Cpf não existente!");
        }
    }

    public void atualizar() {
        int opcao;
        String novonome, novoendereco,cpf,novotelefone;
        double novosalario = 0;
        Horario novohorario = null;
        Cargo novocargo = null;
        Especialidade novoespecialidade = null;
        System.out.println("digite CPF para atualizar: ");
        cpf = sc.nextLine();
        Personaltrainer p = acharpersonal(cpf);
        if (p != null) {
            System.out.println("adicione um novo nome:");
            novonome = sc.nextLine();
            System.out.println("adicione um novo endereco:");
            novoendereco = sc.nextLine();
            System.out.println("adicione um novo telefone:");
            novotelefone = sc.nextLine();
                    novocargo = Cargo.personaltrainer;
                    System.out.println("Adicione uma Especialidade:");
                    System.out.println("1 = Treinamentofisicopersonalizado,\n" +
                            "2 =   Musculacao_e_hipertrofia,\n" +
                            "3 =   Emagrecimento_e_condicionamento,\n" +
                            "4 =   Idosos,\n" +
                            "5 =   Gestantes,\n" +
                            "6 =   Reabilitacao;");
                    opcao = sc.nextInt();
                    switch(opcao){
                        case 1:
                            novoespecialidade = Especialidade.Treinamentofisicopersonalizado;
                            break;
                        case 2:
                            novoespecialidade = Especialidade.Musculacao_e_hipertrofia;
                            break;
                        case 3:
                            novoespecialidade = Especialidade.Emagrecimento_e_condicionamento;
                            break;
                        case 4:
                            novoespecialidade = Especialidade.Idosos;
                            break;
                        case 5:
                            novoespecialidade = Especialidade.Gestantes;
                            break;
                        case 6:
                            novoespecialidade = Especialidade.Reabilitacao;
                            break;
                        default:
                            System.out.println("opcao invalido");
                            return;
                    }
            System.out.println("adicione um novo salario:");
            novosalario = sc.nextDouble();
            System.out.println("adicione um novo horario:");
            System.out.println("1 - Manhã = 06:00 às 14:00\n"+"2 - Tarde = 14:00 às 22:00");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1:
                    novohorario = Horario.Manhã;
                case 2:
                    novohorario = Horario.Tarde;
            }
            p.setNome(novonome);
            p.setSalario(novosalario);
            p.setEndereco(novoendereco);
            p.setTelefone(novotelefone);
            p.setCargo(novocargo);
            p.setHorario(novohorario);
            p.setEspecialidade(novoespecialidade);
            System.out.println("Personal atualizado com sucesso!");

        } else {
            System.out.println("Cpf não existente!");
        }
    }
    public void criartreinamento() {
        String treinamento;
        System.out.println("digite CPF do aluno para fazer o treinamento: ");
        String cpf = sc.nextLine();
        Alunos aluno = Repositorio.getInstancia().achar(cpf);
        if (aluno != null) {
            System.out.println("crie um treinamento para: " + aluno.getNome());
            treinamento = sc.nextLine();
            aluno.setTreinamento(treinamento);
            System.out.println("Treinamento adicionado com sucesso!");
        } else {
            System.out.println("Cpf não existente!");
        }
    }
}