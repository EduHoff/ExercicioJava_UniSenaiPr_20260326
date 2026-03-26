package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Faça um programa que lê duas matrizes 2x3 e 3x2 de números inteiros e calcula
o produto das duas matrizes, exibindo o resultado.
*/

public class Ex6 implements Exercise {

    private static final int ROW_SIZE = 2;
    private static final int COLUMN_SIZE = 3;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 6 ---\n");

        Integer[][] matrixA = new Integer[ROW_SIZE][COLUMN_SIZE];
        Integer[][] matrixB = new Integer[COLUMN_SIZE][ROW_SIZE];
        Integer[][] matrixC = new Integer[ROW_SIZE][ROW_SIZE];


        int last_i = 0;
        int last_j = 0;
        while (last_i < ROW_SIZE) {
            try{

                for(int i=last_i; i<ROW_SIZE; i++){

                    for(int j=last_j; j<COLUMN_SIZE; j++){

                        System.out.println("Matriz A (2x3):");
                        System.out.println("Digite um valor inteiro na linha "+(i+1)+" e coluna "+(j+1));
                        System.out.print("||");
                        int num = sc.nextInt();

                        matrixA[i][j] = num;
                        last_j = j + 1;
                        ConsoleUtils.clear();
                    }
                        last_j = 0;
                        last_i = i + 1;
                }
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }

        last_i = 0;
        last_j = 0;
        while (last_i < COLUMN_SIZE) {
            try{

                for(int i=last_i; i<COLUMN_SIZE; i++){

                    for(int j=last_j; j<ROW_SIZE; j++){

                        System.out.println("\nMatriz B (3x2):");
                        System.out.println("Digite um valor inteiro na linha "+(i+1)+" e coluna "+(j+1));
                        System.out.print("||");
                        int num = sc.nextInt();

                        matrixB[i][j] = num;
                        last_j = j + 1;
                        ConsoleUtils.clear();
                    }
                        last_j = 0;
                        last_i = i + 1;
                }
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }


        System.out.println("\nMatriz A (2x3):");
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                System.out.print("[" + matrixA[i][j] + "]");
            }
            System.out.println("");
        }

        System.out.println("\nMatriz B (3x2):");
        for (int i = 0; i < COLUMN_SIZE; i++) {
            for (int j = 0; j < ROW_SIZE; j++) {
                System.out.print("[" + matrixB[i][j] + "]");
            }
            System.out.println("");
        }

        System.out.println("\nResultado A x B (2x2):");
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < ROW_SIZE; j++) {
                System.out.print("[" + matrixC[i][j] + "]");
            }
            System.out.println("");
        }



    }
}