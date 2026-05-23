package Gerenciamentodeacademia;
import Gerenciamentodeacademia.enuns.Cargo;
import Gerenciamentodeacademia.enuns.Horario;

import java.util.ArrayList;
import java.util.Scanner;
public class Operacaorecepcionista implements ioperacao {
    private final ArrayList<Recepcionista> recepcionista = Repositorio.getInstancia().getRecepcionistas();
    private final Scanner sc = new Scanner(System.in);

    public void listar() {
        for (Recepcionista r : recepcionista) {
            r.exibir();
        }
    }
    public Recepcionista acharrecepcionista(String cpf){
        for(Recepcionista r : recepcionista){
            if(r.getCpf().equals(cpf)){
                return r;
            }
        }
        return null;
    }

    public void cadastrar() {
        String nome, endereco,cpf, telefone;
        double salario;
        Cargo cargo = null;
        Horario horario = null;
        int opcao;
        while (true){
            System.out.println("Adicione um cpf:");
            cpf = sc.nextLine();
            Recepcionista r = acharrecepcionista(cpf);
            if (r != null){
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
            for (Recepcionista r : this.recepcionista) {
                if (r.getTelefone().equals(telefone)) {
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
        cargo = Cargo.recepiscionista;
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
        Recepcionista r = new Recepcionista(cpf,nome,salario,endereco,telefone,cargo,horario);
        recepcionista.add(r);
        System.out.println("Recepcionista cadastrado com sucesso!");
    }

    public void buscarentidade() {
        String cpf;
        System.out.println("digite CPF: ");
        cpf = sc.nextLine();
        Recepcionista r = acharrecepcionista(cpf);
        if (r != null) {
            r.exibir();
        } else {
            System.out.println("Cpf não existente!");
        }
    }

    public void deletar() {
        String cpf;
        System.out.println("digite CPF para deletar: ");
        cpf = sc.nextLine();
        Recepcionista r = acharrecepcionista(cpf);
        if (r != null) {
            recepcionista.remove(r);
            System.out.println("Recepcionista removido com sucesso!");
        } else {
            System.out.println("Cpf não existente!");
        }
    }

    public void atualizar() {
        String novonome, novoendereco,cpf,novotelefone;
        double novosalario = 0;
        int opcao;
        Horario novohorario = null;
        Cargo novocargo = null;
        System.out.println("digite CPF para atualizar: ");
        cpf = sc.nextLine();
        Recepcionista r = acharrecepcionista(cpf);
        if (r != null) {
            System.out.println("adicione um novo nome:");
            novonome = sc.nextLine();
            System.out.println("adicione um novo endereco:");
            novoendereco = sc.nextLine();
            System.out.println("adicione um novo telefone:");
            novotelefone = sc.nextLine();
            novocargo = Cargo.recepiscionista;
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
            r.setNome(novonome);
            r.setSalario(novosalario);
            r.setEndereco(novoendereco);
            r.setTelefone(novotelefone);
            r.setCargo(novocargo);
            r.setHorario(novohorario);
            System.out.println("Recepcionista atualizado com sucesso!");

        } else {
            System.out.println("Cpf não existente!");
        }
    }
}