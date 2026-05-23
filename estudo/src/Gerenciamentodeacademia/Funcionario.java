package Gerenciamentodeacademia;

import Gerenciamentodeacademia.enuns.Especialidade;
import Gerenciamentodeacademia.enuns.Cargo;
import Gerenciamentodeacademia.enuns.Horario;

public class Funcionario extends Pessoa{
    private Cargo cargo;
    private double salario;
    private Horario horario;
    public Funcionario(String cpf, String nome, double salario, String endereco, String telefone, Cargo cargo, Horario horario) {
        super(cpf, nome, endereco, telefone);
        this.cargo = cargo;
        this.salario = salario;
        this.horario = horario;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void adicionarsalario(double salario){
        this.salario+=salario;
    }

    public Horario getHorario() {
        return horario;
    }
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Horario: " + getHorario());
        System.out.println("Salario: " + getSalario());
        System.out.println("Cargo: " + getCargo());
    }


}
