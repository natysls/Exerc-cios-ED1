package pilha.teste;

import pilha.Pilha;

public class Aula13 {

	public static void main(String[] args) {
		Pilha<Integer> pilha = new Pilha<Integer>();
		
		System.out.println(pilha);
		System.out.println(pilha.getTamanho());
		System.out.println(pilha.topo());
		
		for(int i = 1; i<=8; i++) {
			pilha.empilha(i);
		}
		
		System.out.println(pilha);
		System.out.println(pilha.getTamanho());
		
		System.out.println(pilha.estaVazia());
		
		System.out.println(pilha.topo());
		System.out.println(pilha);
		
		System.out.println("Desempilhando: "+ pilha.desempilha());
		System.out.println(pilha);
	}

}
