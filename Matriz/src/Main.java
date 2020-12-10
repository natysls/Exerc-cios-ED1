import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Matriz matriz1 = new Matriz(2,2);
        Matriz matriz2 = new Matriz(3,2);

        matriz1.criarMatriz();
        matriz1.imprime();

        int[][] ma2 = matriz2.criarMatriz();
        System.out.println(ma2);
        matriz2.imprime();

        matriz1.somarMatrizes(ma2);
        matriz1.subtrairMatrizes(ma2);

        matriz1.quantidadeLinhas();
        matriz1.quantidadeLinhas();

        matriz2.quantidadeLinhas();
        matriz2.quantidadeColunas();
    }
}
