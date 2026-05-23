package Gerenciamentodeacademia;
import Gerenciamentodeacademia.enuns.tipoPlano;

import java.util.ArrayList;
import java.util.Scanner;
public class Operacaoaluno implements ioperacao {
    private final ArrayList<Alunos> alunos = Repositorio.getInstancia().getAlunos();
    private final Scanner sc = new Scanner(System.in);

    public void listar() {
        for (Alunos aluno : alunos) {
            aluno.exibir();
        }
    }
    public Alunos acharaluno(String cpf){
        for(Alunos aluno : alunos){
            if(aluno.getCpf().equals(cpf)){
                return aluno;
            }
        }
        return null;
    }

    public void cadastrar() {
        double peso,altura;
        int opcao,dataNascimento;
        String nome,endereco,cpf,telefone,treinamento = "Nenhum";
        tipoPlano tipo = tipoPlano.Basico;
        while (true){
            System.out.println("Adicione um cpf:");
            cpf = sc.nextLine();
            Alunos aluno = acharaluno(cpf);
            if (aluno != null){
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
            for (Alunos a : this.alunos) {
                if (a.getTelefone().equals(telefone)) {
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
        System.out.println("adicione um peso:");
        peso = sc.nextDouble();
        System.out.println("adicione um altura:");
        altura = sc.nextDouble();
        System.out.println("adicione data nascimento:");
        dataNascimento = sc.nextInt();
        sc.nextLine();
        System.out.println("adicione um plano 1 ou 2 :");
        System.out.println("digite 1 - Basico");
        System.out.println("digite 2 - Premium");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                tipo = tipoPlano.Basico;
                break;
            case 2:
                tipo = tipoPlano.Premium;
                break;
            default:
                System.out.println("opcao invalida");
        }
        Alunos aluno = new Alunos(cpf, nome, endereco, telefone, tipo,peso,altura,dataNascimento,treinamento);
        System.out.println("adicione um plano:");
        System.out.println("digite 1 - Mensal");
        System.out.println("digite 2 - Anual");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                aluno.planomensal();
                break;
            case 2:
                aluno.planoanual();
                break;
            default:
                System.out.println("opcao invalida");
        }
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void buscarentidade() {
        String cpf;
        System.out.println("digite CPF: ");
        cpf = sc.nextLine();
        Alunos aluno = acharaluno(cpf);
        if (aluno != null) {
                aluno.exibir();
            } else {
            System.out.println("Cpf não existente!");
        }
    }

    public void deletar() {
        String cpf;
        System.out.println("digite CPF para deletar: ");
        cpf = sc.nextLine();
        Alunos aluno = acharaluno(cpf);
            if (aluno != null) {
                alunos.remove(aluno);
                System.out.println("Aluno removido com sucesso!");
            } else {
                System.out.println("Cpf não existente!");
            }
    }

    public void atualizar() {
        double novopeso, novoaltura;
        String cpf,novotelefone,novonome,novoendereco;
        tipoPlano novotipo = null;
        int opcao,novodataNascimento;
        System.out.println("Digite o cpf: ");
        cpf = sc.nextLine();
        Alunos aluno = acharaluno(cpf);
            if (aluno != null) {
                System.out.println("adicione um novo nome:");
                novonome = sc.nextLine();
                System.out.println("adicione um novo endereco:");
                novoendereco = sc.nextLine();
                System.out.println("adicione um novo telefone:");
                novotelefone = sc.nextLine();
                System.out.println("adicione um novo peso:");
                novopeso = sc.nextDouble();
                System.out.println("adicione um novo altura:");
                novoaltura = sc.nextDouble();
                System.out.println("adicione nova data nascimento:");
                novodataNascimento = sc.nextInt();
                sc.nextLine();
                System.out.println("adicione um novo plano 1 ou 2 :");
                System.out.println("digite 1 - Basico");
                System.out.println("digite 2 - Premium");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        novotipo = tipoPlano.Basico;
                        break;
                    case 2:
                        novotipo = tipoPlano.Premium;
                        break;
                }
                aluno.setNome(novonome);
                aluno.setEndereco(novoendereco);
                aluno.setTelefone(novotelefone);
                aluno.setTipo(novotipo);
                aluno.setPeso(novopeso);
                aluno.setAltura(novoaltura);
                aluno.setDataNascimento(novodataNascimento);
                System.out.println("Aluno atualizado com sucesso!");

            } else {
                System.out.println("Cpf não existente!");
            }
        }
    public void renovarmensalidade() {
        int opcao;
        String cpf;
        System.out.println("Digite o cpf: ");
        cpf = sc.nextLine();
        Alunos aluno = acharaluno(cpf);
        if (aluno != null){
        System.out.println("adicione um plano:");
        System.out.println("digite 1 - Mensal");
        System.out.println("digite 2 - Anual");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                aluno.planomensal();
                break;
            case 2:
                aluno.planoanual();
                break;
            default:
                System.out.println("opcao invalida");
        }
        }
    }

    }