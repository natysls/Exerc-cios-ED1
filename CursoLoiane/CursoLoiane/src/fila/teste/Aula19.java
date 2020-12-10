package fila.teste;

import fila.Fila;

public class Aula19 {

	public static void main(String[] args) {
		Fila<Integer> fila = new Fila<Integer>();
		
		System.out.println(fila.estaVazia());
		System.out.println(fila.getTamanho());
		
		fila.enfileira(1);
		fila.enfileira(2);
		fila.enfileira(3);
		System.out.println(fila);
		
		System.out.println(fila.estaVazia());
		System.out.println(fila.getTamanho());
		
		System.out.println(fila.desenfileira());
		System.out.println(fila);
		
		System.out.println(fila.desenfileira());
		System.out.println(fila);
		System.out.println(fila.estaVazia());
		System.out.println(fila.getTamanho());
		
		System.out.println(fila.desenfileira());
		System.out.println(fila);
		System.out.println(fila.estaVazia());
		System.out.println(fila.getTamanho());
	}

}
