import java.util.Scanner;

public class Matriz extends Funcoes {
    int linha;
    int coluna;
    int[][] matriz;

    int[][] matrizResultado = new int[2][2];

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.matriz = new int[linha][coluna];
    }

    public int[][] criarMatriz() {
        System.out.println("Hora de digitar os elementos da matriz!");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                try {
                    System.out.println("Digite o elemento [" + i + ", " + j + "]");
                    matriz[i][j] = scan.nextInt();
                } catch (NullPointerException e) {
                    e.getMessage();
                }
            }
        }
        return matriz;
    }

    public void imprime() {
        for (int i = 0; i < linha; i++) {
            System.out.print("[");
            for (int j = 0; j < coluna; j++) {
                System.out.print(" " + matriz[i][j] + " ");
                if (j == linha - 1)
                    System.out.println("]");

            }
        }
    }

    @Override
    public void somarMatrizes (int [][] matriz2){
        System.out.println("Soma");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[");
            matrizResultado[i][0] = matriz[0][0] + matriz2[0][0];
            for (int j = 0; j < matriz[i].length; j++) {
                matrizResultado[i][j] = matriz[0][0] + matriz2[0][0];
                System.out.print(" " + matrizResultado[i][j] + " ");
                if (j == matriz[i].length - 1)
                    System.out.println("]");

            }
        }
    }

    @Override
    public void subtrairMatrizes (int [][] matriz2){
        System.out.println("Subtração");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[");
            matrizResultado[i][0] = matriz[0][0] - matriz2[0][0];
            for (int j = 0; j < matriz[i].length; j++) {
                matrizResultado[i][j] = matriz[0][0] - matriz2[0][0];
                System.out.print(" " + matrizResultado[i][j] + " ");
                if (j == matriz[i].length - 1)
                    System.out.println("]");

            }
        }

    }

    @Override
    public void quantidadeLinhas () {
        System.out.println("Quantidade de linhas");
        System.out.println(linha);
    }

    @Override
    public void quantidadeColunas () {
        System.out.println("Quantidade de colunas");
        System.out.println(coluna);
    }
}

