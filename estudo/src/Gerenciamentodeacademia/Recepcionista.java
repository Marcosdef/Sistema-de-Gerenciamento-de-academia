package Gerenciamentodeacademia;
import Gerenciamentodeacademia.enuns.Especialidade;
import Gerenciamentodeacademia.enuns.Cargo;
import Gerenciamentodeacademia.enuns.Horario;

public class Recepcionista extends Funcionario{
    public Recepcionista(String cpf, String nome, double salario, String endereco, String telefone, Cargo cargo, Horario horario) {
        super(cpf,nome,salario,endereco,telefone,cargo,horario);
    }
    @Override
    public void exibir() {
        super.exibir();
    }

}
