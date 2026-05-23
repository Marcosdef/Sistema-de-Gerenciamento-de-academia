package Gerenciamentodeacademia;

import Gerenciamentodeacademia.enuns.objetosacademia;

public class objetosdemalhacao {
    private objetosacademia objetosacademia;
    private int quantidade;
    public objetosdemalhacao(objetosacademia objetosacademia, int quantidade) {
        this.objetosacademia = objetosacademia;
        this.quantidade = quantidade;
    }
    public objetosacademia getObjetosacademia() {
        return objetosacademia;
    }

    public void setObjetosacademia(objetosacademia objetosacademia) {
        this.objetosacademia = objetosacademia;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void exibir() {
        System.out.println("Nome: " + getObjetosacademia());
        System.out.println("Quantidade: " + getQuantidade());
    }
}
