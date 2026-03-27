package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.StateTictactoe;
import entities.Board;
import entities.Piece;
import utils.ConsoleUtils;

/* 
Desenvolva um programa em Java que simule o clássico Jogo da Velha. O programa
deve utilizar uma matriz 3x3 para representar o tabuleiro, onde dois jogadores
alternam entre as marcações X e O. A cada jogada, o programa deve verificar se há
um vencedor, ou seja, se três símbolos iguais estão alinhados na mesma linha,
coluna ou diagonal. Caso todas as posições do tabuleiro sejam preenchidas sem
que haja um vencedor, o programa deve indicar que o jogo terminou em velha. Além
disso, o programa deve garantir que, uma vez colocado um símbolo no tabuleiro, a
posição não possa ser selecionada novamente pelo outro jogador, evitando
sobreposições.m a média dos elementos de cada coluna.
*/

public class Ex9 implements Exercise {

    private static final int ROW_SIZE = 3;
    private static final int COLUMN_SIZE = 3;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 9 ---\n");

        Board board = new Board(ROW_SIZE, COLUMN_SIZE);

        for(int i=0; i<ROW_SIZE; i++){
            for(int j=0; j<COLUMN_SIZE; j++){
                Piece piece = new Piece(StateTictactoe.N, i, j);
                board.addBoard(piece);
            }  
        }

        /* 
        MODELO MENTAL PARA EU LEMBRAR O QUE ESTOU FAZENDO
        System.out.printf(" %s | %s | %s \n", Matrix[0][0].printPosition(),Matrix[0][1].printPosition(),Matrix[0][2].printPosition());
        System.out.println("---+---+---");
        System.out.printf(" %s | %s | %s \n", Matrix[1][0].printPosition(),Matrix[1][1].printPosition(),Matrix[1][2].printPosition());
        System.out.println("---+---+---");
        System.out.printf(" %s | %s | %s \n", Matrix[2][0].printPosition(),Matrix[2][1].printPosition(),Matrix[2][2].printPosition());
        */

        for (int i = 0; i < ROW_SIZE; i++) {

            for (int j = 0; j < COLUMN_SIZE; j++) {
                System.out.printf(" %s ", board.getPiece(i, j).printPosition());
                if (j < COLUMN_SIZE - 1) System.out.print("|");
            }
            
            System.out.println();

            if (i < ROW_SIZE - 1) {
                System.out.println("---+---+---");
            }
        }
    }
}