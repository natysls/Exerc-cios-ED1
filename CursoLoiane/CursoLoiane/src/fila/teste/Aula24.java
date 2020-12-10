package fila.teste;

import fila.FilaComPrioridade;

public class Aula24 {

	public static void main(String[] args) {
		FilaComPrioridade<Integer> fila = new FilaComPrioridade<Integer>();
		
		fila.enfileira(1);
		fila.enfileira(3);
		fila.enfileira(2);
		
		System.out.println(fila); //1 2 3 e não 1 3 2
		
	}

}
