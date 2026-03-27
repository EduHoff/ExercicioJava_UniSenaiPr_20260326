package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Faça um programa em Java que leia uma matriz 3x4 de números reais informados
pelo usuário. Após o preenchimento completo da matriz, o programa deve exibir
todos os valores armazenados e, em seguida, calcular e apresentar a média dos
elementos de cada linha e também a média dos elementos de cada coluna.
*/

public class Ex8 implements Exercise {

    private static final int ROW_SIZE = 3;
    private static final int COLUMN_SIZE = 4;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 8 ---\n");

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

        System.out.println("\n--- Média das Linhas ---");
        for (int i = 0; i < ROW_SIZE; i++) {
            double sum_row = 0;
            for (int j = 0; j < COLUMN_SIZE; j++) {
                sum_row += matrix[i][j];
            }
            System.out.printf("Linha %d: %.2f\n", i+1, (sum_row / COLUMN_SIZE));
        }

        System.out.println("\n--- Média das Colunas ---");
        for (int j = 0; j < COLUMN_SIZE; j++) {
            double sum_column = 0;
            for (int i = 0; i < ROW_SIZE; i++) {
                sum_column += matrix[i][j]; 
            }
            System.out.printf("Coluna %d: %.2f\n", j+1, (sum_column / ROW_SIZE));
        }
    }
}