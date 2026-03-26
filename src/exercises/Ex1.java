package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Crie um programa que preencha uma matriz 3x3 com números inteiros
informados pelo usuário e, em seguida, exiba a matriz.
*/

public class Ex1 implements Exercise {

    private static final int ROW_SIZE = 3;
    private static final int COLUMN_SIZE = 3;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 1 ---\n");

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


        for(int i=0; i<ROW_SIZE; i++){
            for(int j=0; j<COLUMN_SIZE; j++){
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println("");
        }


    }
}