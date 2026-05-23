package Gerenciamentodeacademia;
import Gerenciamentodeacademia.enuns.Especialidade;
import Gerenciamentodeacademia.enuns.Cargo;
import Gerenciamentodeacademia.enuns.Horario;


public class Personaltrainer extends Funcionario {
    private Especialidade especialidade;
    public Personaltrainer(String cpf, String nome, double salario, String endereco, String numero, Cargo cargo, Horario horario, Especialidade especialidade) {
        super(cpf, nome, salario, endereco, numero, cargo,horario);
        this.especialidade = especialidade;
    }
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("Especialidade: " + getEspecialidade());
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
