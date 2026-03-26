package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Escreva um programa que lê uma matriz 5x5 de números inteiros e conta quantos
elementos são negativos.
*/

public class Ex2 implements Exercise {

    private static final int ROW_SIZE = 5;
    private static final int COLUMN_SIZE = 5;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 2 ---\n");

        Integer[][] matrix = new Integer[ROW_SIZE][COLUMN_SIZE];

        int negative_number_count = 0;

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

                        if(num < 0){
                            negative_number_count++;
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

        System.out.println("O total de elementos negativos digitados na matriz foi: " + negative_number_count);
    }
}