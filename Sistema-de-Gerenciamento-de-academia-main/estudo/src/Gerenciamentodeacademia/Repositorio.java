package Gerenciamentodeacademia;
import java.util.ArrayList;

public class Repositorio {
    private static Repositorio instancia;
    private final ArrayList<Alunos> alunos;
    private final ArrayList<Recepcionista> recepcionistas;
    private final ArrayList<Personaltrainer> Personaltrainers;
    private final ArrayList<objetosdemalhacao> objetosdemalhacao;
    private Repositorio() {
        alunos = new ArrayList<>();
        recepcionistas = new ArrayList<>();
        Personaltrainers = new ArrayList<>();
        objetosdemalhacao = new ArrayList<>();
    }
    public static Repositorio getInstancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }
    public Alunos achar(String cpf){
        for(Alunos aluno : alunos){
            if(aluno.getCpf().equals(cpf)){
                return aluno;
            }
        }
        return null;
    }

    public ArrayList<Alunos> getAlunos() {
        return alunos;
    }
    public ArrayList<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }
    public ArrayList<Personaltrainer> getPersonaltrainers() {
        return Personaltrainers;
    }
    public ArrayList<objetosdemalhacao> getObjetosdemalhacao() {return objetosdemalhacao;}
}
