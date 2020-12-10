package Filas.questao1;

public class MainFila1 {

	public static void main(String[] args) {
		Fila<Integer> fila = new Fila<Integer>(6);
		fila.enfileira(1);
		fila.enfileira(2);
		fila.enfileira(3);
		fila.enfileira(4);
		fila.enfileira(5);
		fila.enfileira(6);
		System.out.println(fila);

		fila.inverte();
		System.out.println(fila);
	}
}
