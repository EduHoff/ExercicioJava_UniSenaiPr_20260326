package application;

import exercises.Exercise;
import java.util.InputMismatchException;
import java.util.Scanner;
import utils.ConsoleUtils;



public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConsoleUtils.clear();
        while (true) {
            try{

                System.out.print("""
                ============================================
                            MENU DE EXERCÍCIOS
                ============================================
                1 - Leitura e Exibição 3x3
                2 - Contagem de Elementos Negativos
                3 - Soma de Duas Matrizes 4x4
                4 - Extração da Diagonal Principal
                5 - Matriz Transposta 3x3
                6 - Produto de Matrizes (2x3 por 3x2)
                7 - Verificação de Simetria
                8 - Médias de Linhas e Colunas 3x4
                9 - Jogo da Velha
                0 - Sair
                ===========================================
                """);

                System.out.print("||");
                int num = sc.nextInt();

                if (num == 0) {
                    break;
                }

                Class<?> clazz = Class.forName("exercises.Ex" + num);
                Exercise ex = (Exercise) clazz.getDeclaredConstructor().newInstance();
                ConsoleUtils.clear();
                ex.run(sc);

            
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch (ClassNotFoundException e) {
                ConsoleUtils.clear();
                System.out.println("Exercício não existe!\n");
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            } 
        }

        sc.close();
    }
}