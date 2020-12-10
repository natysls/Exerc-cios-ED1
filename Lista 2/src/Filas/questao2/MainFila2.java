package Filas.questao2;

public class MainFila2 {
	public static void main(String[] args) {
		FilaDuplaEncadeada fila = new FilaDuplaEncadeada(4);
		
		fila.enfileira(1);
		fila.enfileira(2);
		fila.enfileira(3);
		fila.enfileira(4);
		System.out.println(fila);
		
		fila.desenfileira();
		System.out.println(fila);
	}
}
