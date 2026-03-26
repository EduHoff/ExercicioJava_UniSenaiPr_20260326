package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Escreva um programa que lê duas matrizes 4x4 de números inteiros e calcula a
soma das duas matrizes, exibindo o resultado.
*/

public class Ex3 implements Exercise {

    private static final int ROW_SIZE = 4;
    private static final int COLUMN_SIZE = 4;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 2 ---\n");

        Integer[][] matrixA = new Integer[ROW_SIZE][COLUMN_SIZE];
        Integer[][] matrixB = new Integer[ROW_SIZE][COLUMN_SIZE];


        int last_i = 0;
        int last_j = 0;
        while (last_i < ROW_SIZE) {
            try{

                for(int i=last_i; i<ROW_SIZE; i++){

                    for(int j=last_j; j<COLUMN_SIZE; j++){
                        System.out.println("Matriz A");
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
        while (last_i < ROW_SIZE) {
            try{

                for(int i=last_i; i<ROW_SIZE; i++){

                    for(int j=last_j; j<COLUMN_SIZE; j++){
                        System.out.println("Matriz B");
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

        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                System.out.print("[" + matrixA[i][j] + "]");
            }

            System.out.print("  +  ");

            for (int j = 0; j < COLUMN_SIZE; j++) {
                System.out.print("[" + matrixB[i][j] + "]");
            }

            System.out.print("  =  ");

            for (int j = 0; j < COLUMN_SIZE; j++) {
                System.out.print("[" + (matrixA[i][j] + matrixB[i][j]) + "]");
            }
            System.out.println("");
        }
    }
}