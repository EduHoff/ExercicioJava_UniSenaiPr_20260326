package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Crie um programa que leia uma matriz 3x3 de números inteiros e verifique se ela
é simétrica, isto é, se os elementos acima da diagonal principal são iguais aos
correspondentes abaixo dela.
*/

public class Ex7 implements Exercise {

    private static final int ROW_SIZE = 3;
    private static final int COLUMN_SIZE = 3;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 7 ---\n");

        Integer[][] matrix = new Integer[ROW_SIZE][COLUMN_SIZE];
        boolean isSymmetrical = true;


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

        start_loop:
        for(int i=0; i<ROW_SIZE; i++){

            for(int j=0; j<COLUMN_SIZE; j++){

                if(i != j && !matrix[i][j].equals(matrix[j][i])) {
                    isSymmetrical=false;
                    break start_loop; 
                }         
            }
        }

        if(isSymmetrical){
            System.out.println("A Matriz é simétrica!");
        }else{
            System.out.println("A Matriz NÃO é simétrica!");
        }

       
    }
}