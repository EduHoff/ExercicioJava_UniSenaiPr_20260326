package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Crie um programa que lê uma matriz 3x3 de números reais e exibe sua transposta
(a matriz em que as linhas são trocadas pelas colunas).
*/

public class Ex5 implements Exercise {

    private static final int ROW_SIZE = 3;
    private static final int COLUMN_SIZE = 3;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 5 ---\n");

        Integer[][] matrix = new Integer[ROW_SIZE][COLUMN_SIZE];


        int last_i = 0;
        int last_j = 0;
        while (last_i < ROW_SIZE) {
            try{

                for(int i=last_i; i<ROW_SIZE; i++){

                    for(int j=last_j; j<COLUMN_SIZE; j++){

                        System.out.println("Digite um valor inteiro na linha "+(i+1)+" e coluna "+(j+1));
                        System.out.print("||");
                        int num = sc.nextInt();

                        matrix[i][j] = num;
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

        System.out.println("Matriz original:");
        for(int i=0; i<ROW_SIZE; i++){
            for(int j=0; j<COLUMN_SIZE; j++){
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println("");
        }

        System.out.println("------");

        System.out.println("Matriz transposta:");
        for(int i=0; i<ROW_SIZE; i++){
            for(int j=0; j<COLUMN_SIZE; j++){
                System.out.print("["+matrix[j][i]+"]");
            }
            System.out.println("");
        }
    }
}