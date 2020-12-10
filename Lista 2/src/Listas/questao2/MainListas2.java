package Listas.questao2;

public class MainListas2 {
	
	public static void main(String[] args) {
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		
		lista.adicionaFim("C");
		lista.adicionaFim("B");
		lista.adicionaFim("D");
		lista.adicionaFim("E");
		lista.adicionaFim("F");
		System.out.println(lista);
		
		lista.removeFim();
		System.out.println(lista);
	}
}
