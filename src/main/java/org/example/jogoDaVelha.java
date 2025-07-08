package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class jogoDaVelha {

    static Scanner s = new Scanner(System.in);
    static String[][] vetor = new String[3][3];

    public static void main(String[] args) {


        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[0].length; j++) {
                vetor[i][j] = "-";
            }
        }

        int jogadas = 0;
        String jogadorAtual = "X";
        String vencedor = null;


        while (vencedor == null && jogadas < 9) {
            menu();


            if (jogadorAtual.equals("X")) {
                solicitarJogada(jogadorAtual);
            } else {
                solicitarJogada(jogadorAtual);
            }
            jogadas++;

            vencedor = verificarGanhador();

            if (vencedor != null) {
                jogoFinalizado(vencedor);
            } else if (jogadas == 9) {

                System.out.println(vetor[0][0] + " : " + vetor[0][1] + " : " + vetor[0][2]);
                System.out.println("..........");
                System.out.println(vetor[1][0] + " : " + vetor[1][1] + " : " + vetor[1][2]);
                System.out.println("..........");
                System.out.println(vetor[2][0] + " : " + vetor[2][1] + " : " + vetor[2][2] + "\n");

                System.out.println("================");
                System.out.println("O jogo terminou em EMPATE!");
                System.out.println("================");
            }


            jogadorAtual = (jogadorAtual.equals("X")) ? "O" : "X";
        }
        s.close();
    }

    public static void menu() {
        System.out.println("\nJOGO DA VELHA: \n");

        System.out.println("   1   2   3");
        System.out.println("1| " + vetor[0][0] + " : " + vetor[0][1] + " : " + vetor[0][2]);
        System.out.println("..............");
        System.out.println("2| " + vetor[1][0] + " : " + vetor[1][1] + " : " + vetor[1][2]);
        System.out.println("..............");
        System.out.println("3| " + vetor[2][0] + " : " + vetor[2][1] + " : " + vetor[2][2] + "\n");

        System.out.println("\nOBS: Primeiro Linha depois Coluna!\n");
    }

    public static void solicitarJogada(String jogador) {
        boolean jogadaValida = false;
        int coluna, linha = 0;

        do {
            System.out.println("Escolha Jogador " + jogador + ": \n");

            System.out.println("*Digite a Linha (1-3):");
            coluna = s.nextInt();
            coluna--;


            System.out.println("*Digite a Coluna (1-3):");
            linha = s.nextInt();
            linha--;


            if (coluna >= 0 && coluna < 3 && linha >= 0 && linha < 3) {
                if (vetor[coluna][linha].equals("-")) {
                    vetor[coluna][linha] = jogador;
                    jogadaValida = true;
                } else {
                    System.out.println("\n================");
                    System.out.println("Opção já jogada. Tente novamente.");
                    System.out.println("================");
                }
            } else {
                System.out.println("\n================");
                System.out.println("Entrada inválida. Coluna e linha devem ser entre 1 e 3.");
                System.out.println("================");
            }
        } while (!jogadaValida);
    }


    private static String verificarGanhador() {

        for (int i = 0; i < 3; i++) {
            if (!vetor[i][0].equals("-") && vetor[i][0].equals(vetor[i][1]) && vetor[i][1].equals(vetor[i][2])) {
                return vetor[i][0];
            }
        }


        for (int j = 0; j < 3; j++) {
            if (!vetor[0][j].equals("-") && vetor[0][j].equals(vetor[1][j]) && vetor[1][j].equals(vetor[2][j])) {
                return vetor[0][j];
            }
        }


        if (!vetor[0][0].equals("-") && vetor[0][0].equals(vetor[1][1]) && vetor[1][1].equals(vetor[2][2])) {
            return vetor[0][0];
        }
        if (!vetor[0][2].equals("-") && vetor[0][2].equals(vetor[1][1]) && vetor[1][1].equals(vetor[2][0])) {
            return vetor[0][2];
        }

        return null;
    }

    public static void jogoFinalizado(String vencedor) {

        System.out.println(vetor[0][0] + " : " + vetor[0][1] + " : " + vetor[0][2]);
        System.out.println("..........");
        System.out.println(vetor[1][0] + " : " + vetor[1][1] + " : " + vetor[1][2]);
        System.out.println("..........");
        System.out.println(vetor[2][0] + " : " + vetor[2][1] + " : " + vetor[2][2] + "\n");

        System.out.println("\n==================================");
        System.out.println("Parabéns! O Vencedor foi o " + vencedor + "!!");
        System.out.println("==================================");
    }
}
