package Gerenciamentodeacademia;

import Gerenciamentodeacademia.enuns.tipoPlano;
import java.time.LocalDate;

public class Alunos extends Pessoa {
    private tipoPlano tipo;
    private double peso;
    private double altura;
    private String dataNascimento;
    private String treinamento;
    private LocalDate vencido;
    public Alunos(String cpf, String nome, String endereco, String telefone, tipoPlano tipo, double peso, double altura, String dataNascimento, String treinamento) {
        super(cpf, nome, endereco, telefone);
        this.tipo=tipo;
        this.peso=peso;
        this.altura=altura;
        this.dataNascimento=dataNascimento;
        this.treinamento=treinamento;
        this.vencido= null;
    }
    @Override
    public String exibir() {
        return super.exibir() +
        "\ndataNascimento" + dataNascimento +
        "\nAltura: " + altura +
        "\nPeso: " + peso +
        "\nimc: " + imc() +
        "\nPlano: " + tipo +
        "\nTreinamento: " + treinamento +
        "\nestado: " + (esvencido()? "VENCIDO ❌" : "ATIVO ✅") +
        "\nData de vencimento: " + this.vencido;
    }
    public void planomensal(){
        LocalDate data = LocalDate.now();

        if(this.vencido!=null && !esvencido()){
            this.vencido = this.vencido.plusDays(30);
        } else {
            this.vencido = data.plusDays(30);
        }
    }
    public void planoanual(){
        LocalDate data = LocalDate.now();

        if(this.vencido!=null && !esvencido()){
            this.vencido = this.vencido.plusYears(1);
        } else {
            this.vencido = data.plusYears(1);
        }
    }
    public boolean esvencido(){
        if (this.vencido == null){
            return true;
        }
        return LocalDate.now().isAfter(this.vencido);
    }
    public double imc(){
        return getPeso() / (getAltura() * getAltura());
    }
    public tipoPlano getTipo() {
        return tipo;
    }
    public void setTipo(tipoPlano tipo) {
        this.tipo = tipo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(String treinamento) {
        this.treinamento = treinamento;
    }

    public LocalDate getVencido() {
        return vencido;
    }



}


