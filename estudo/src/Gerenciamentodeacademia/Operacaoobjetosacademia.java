package Gerenciamentodeacademia;

import Gerenciamentodeacademia.enuns.objetosacademia;

import java.util.ArrayList;
import java.util.Scanner;

public class Operacaoobjetosacademia implements ioperacao {
    private final ArrayList<objetosdemalhacao> obj = Repositorio.getInstancia().getObjetosdemalhacao();
    private final Scanner sc = new Scanner(System.in);

    public void listar() {
        for (objetosdemalhacao o : obj) {
            o.exibir();
        }
    }

    public objetosdemalhacao acharobjetosdemalhacao(objetosacademia objetos) {
        for (objetosdemalhacao o : obj) {
            if (o.getObjetosacademia().equals(objetos)) {
                return o;
            }
        }
        return null;
    }
    public objetosacademia escolherobjetos() {
        int opcao;
        objetosacademia objetos = null;
        System.out.println("escolha um equipamento:");
        System.out.print("1 - HALTERES\n" +
                "2 -    ANILHAS\n" +
                "3 -    BARRAS\n" +
                "4 -    KETTLEBELLS\n" +
                "5 -    CANELEIRAS\n" +
                "6 -    TORNOZELEIRAS\n" +
                "7 -    COLCHONETES\n" +
                "8 -    TAPETES_EVA\n" +
                "9 -    STEPS\n" +
                "10 -    CORDAS_PULAR\n" +
                "11 -    FAIXAS_ELASTICAS\n" +
                "12 -    MINI_BANDS\n" +
                "13 -    EXTENSORES\n" +
                "14 -    BOLA_SUICA\n" +
                "15 -    BOLA_PILATES\n" +
                "16 -    RODA_ABDOMINAL\n" +
                "17 -    CAIXAS_SALTO\n" +
                "18 -    CONES\n" +
                "19 -    DEMARCATORIOS\n" +
                "20 -    LUVAS_MUSCULACAO\n" +
                "21 -    CINTOS_LEVANTAMENTO\n" +
                "22 -    GARRAFAS_AGUA\n" +
                "23 -    TOALHAS\n" +
                "24 -    ESTEIRAS\n" +
                "25 -    BICICLETAS_ERGOMETRICAS\n" +
                "26 -    JUMP\n");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                objetos = objetosacademia.HALTERES;
                break;
            case 2:
                objetos = objetosacademia.ANILHAS;
                break;
            case 3:
                objetos = objetosacademia.BARRAS;
                break;
            case 4:
                objetos = objetosacademia.KETTLEBELLS;
                break;
            case 5:
                objetos = objetosacademia.CANELEIRAS;
                break;
            case 6:
                objetos = objetosacademia.TORNOZELEIRAS;
                break;
            case 7:
                objetos = objetosacademia.COLCHONETES;
                break;
            case 8:
                objetos = objetosacademia.TAPETES_EVA;
                break;
            case 9:
                objetos = objetosacademia.STEPS;
                break;
            case 10:
                objetos = objetosacademia.CORDAS_PULAR;
                break;
            case 11:
                objetos = objetosacademia.FAIXAS_ELASTICAS;
                break;
            case 12:
                objetos = objetosacademia.MINI_BANDS;
                break;
            case 13:
                objetos = objetosacademia.EXTENSORES;
                break;
            case 14:
                objetos = objetosacademia.BOLA_SUICA;
                break;
            case 15:
                objetos = objetosacademia.BOLA_PILATES;
                break;
            case 16:
                objetos = objetosacademia.RODA_ABDOMINAL;
                break;
            case 17:
                objetos = objetosacademia.CAIXAS_SALTO;
                break;
            case 18:
                objetos = objetosacademia.CONES;
                break;
            case 19:
                objetos = objetosacademia.DEMARCATORIOS;
                break;
            case 20:
                objetos = objetosacademia.LUVAS_MUSCULACAO;
                break;
            case 21:
                objetos = objetosacademia.CINTOS_LEVANTAMENTO;
                break;
            case 22:
                objetos = objetosacademia.GARRAFAS_AGUA;
                break;
            case 23:
                objetos = objetosacademia.TOALHAS;
                break;
            case 24:
                objetos = objetosacademia.ESTEIRAS;
                break;
            case 25:
                objetos = objetosacademia.BICICLETAS_ERGOMETRICAS;
                break;
            case 26:
                objetos = objetosacademia.JUMP;
                break;
            default:
                System.out.println("opcao invalida");
                return null;
        }
        return objetos;
    }

    public void cadastrar() {
        int quantidade;
        while(true) {
            objetosacademia objetosacademia = escolherobjetos();
            if (objetosacademia == null){
                continue;
            }
            objetosdemalhacao existente = acharobjetosdemalhacao(objetosacademia);
            if (existente != null) {
                System.out.println("Equipamento já existente no estoque!");
                continue;
            }
            System.out.println("adicione uma quantidade:");
            quantidade = sc.nextInt();
            sc.nextLine();
            objetosdemalhacao o = new objetosdemalhacao(objetosacademia, quantidade);
            obj.add(o);
            System.out.println("equipamento criado com sucesso!");
            System.out.println("0 - sair | 1 - continuar:");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 0) {
                break;
            }
        }
    }

    public void buscarentidade() {
        objetosacademia objetos = escolherobjetos();
        if (objetos != null) {
            objetosdemalhacao o = acharobjetosdemalhacao(objetos);
            if (o != null){
                o.exibir();
            }
        } else {
            System.out.println("Equipamento não existente!");
        }
    }

    public void deletar() {
        objetosacademia objetos = escolherobjetos();
        if (objetos != null) {
            objetosdemalhacao o = acharobjetosdemalhacao(objetos);
            if (o != null) {
                obj.remove(o);
                System.out.println("Equipamento removido com sucesso!");
            } else {
                System.out.println("Equipamento não existente!");
            }
        }
    }
    public void atualizar() {
        int novaquantidade;
        while (true) {
            objetosacademia objetos = escolherobjetos();
            if (objetos != null) {
                objetosdemalhacao o = acharobjetosdemalhacao(objetos);
                if (o != null) {
                    objetosacademia novoobjetosacademia = escolherobjetos();
                    if (novoobjetosacademia == null){ continue;}
                    System.out.println("adicione uma quantidade:");
                    novaquantidade = sc.nextInt();
                    sc.nextLine();
                    o.setObjetosacademia(novoobjetosacademia);
                    o.setQuantidade(novaquantidade);
                    System.out.println("Equipamento atualizado com sucesso!");
                    System.out.println("0 - sair | 1 - continuar:");
                    int opcao = sc.nextInt();
                    sc.nextLine();
                    if (opcao == 0) {
                        break;

                } else {
                    System.out.println("Equipamento não existente!");
                }
            }
        }
    }
}
}