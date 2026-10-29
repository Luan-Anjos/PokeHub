package methods;

import api.Request;

import java.util.Scanner;

public class Metodos {

    int escolha;

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    Scanner scanner = new Scanner(System.in);

    public void menu (){
        System.out.println("PokeMania\n");
        System.out.println("1 - Buscar Pokemon");
        System.out.println("2 - Comparar Pokemon");
        System.out.println("3 - Consultar evolucao");
        System.out.println("4 - Adicionar aos favoritos");
        System.out.println("5 - Listar favoritos");
        System.out.println("6 - Remover dos favoritos");
        System.out.println("0 - Sair");
    }

    public void comparison (Request dados, Request jsonComplementar){


    }



}

