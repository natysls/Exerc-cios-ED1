package vetor.teste;

import vetor.Lista;
import vetor.VetorObjetos;

public class Aula11 {

	public static void main(String[] args) {
		VetorObjetos vetor = new VetorObjetos(2);
		
		//não pode ter elementos de tipos diferentes
		vetor.adiciona(1);
		vetor.adiciona("Elemento do tipo string");
		
		System.out.println(vetor);
		
		Lista<String> lista = new Lista<String>(1);
		lista.adiciona("Elemento 1");
		lista.adiciona("Elemento 2");
		
		System.out.println(lista);
		
		Lista<Contato> contatos = new Lista<Contato>(1);
		
		Contato c1 = new Contato("Contato 1", "1234-5678", "contato1@email.com");
		Contato c2 = new Contato("Contato 2", "9283-1637", "contato2@email.com");
		
		contatos.adiciona(c1);
		
		System.out.println(contatos);
	}

}
