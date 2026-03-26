package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Faça um programa que lê uma matriz 4x4 de números inteiros e exibe os
elementos da diagonal principal.
*/

public class Ex4 implements Exercise {

    private static final int ROW_SIZE = 4;
    private static final int COLUMN_SIZE = 4;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 4 ---\n");

        Integer[][] matrix = new Integer[ROW_SIZE][COLUMN_SIZE];
        Integer[] main_diagonal = new Integer[ROW_SIZE];

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

                        if(i == j){
                            main_diagonal[i] = num;
                        }
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


        System.out.println("Elementos da diagonal principal: " + Arrays.toString(main_diagonal));


    }
}