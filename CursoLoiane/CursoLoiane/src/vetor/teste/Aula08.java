package vetor.teste;

import vetor.Vetor;

public class Aula08 {
	public static void main(String[] args) {
		Vetor vetor = new Vetor(3);
		
		vetor.adiciona("B");
		vetor.adiciona("G");
		vetor.adiciona("D");
		vetor.adiciona("E");
		vetor.adiciona("F");
		
		System.out.println(vetor);
		
		vetor.removeEmQQLugar(1);
		
		System.out.println(vetor);
		
		System.out.println("Remover o elemento B");
		
		int pos = vetor.busca("B");
		if(pos > -1) {
			vetor.removeEmQQLugar(pos);
		}else {
			System.out.println("Elemento não existe no vetor ");
		}
		
		System.out.println(vetor);
	}
}
