package Hash;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
		conjunto.adiciona("palavra");
		conjunto.adiciona("computador");
		conjunto.adiciona("apostila");
		conjunto.adiciona("instrutor");
		conjunto.adiciona("mesa");
		conjunto.adiciona("telefone");
		
		if (!conjunto.contem("apostila")) {
			System.out.println("Erro: não tem a palavra: apostila");
		}
		conjunto.remove("apostila");
		
		if (conjunto.contem("apostila")) {
			System.out.println("Erro: tem a palavra: apostila");
		}
		if (conjunto.tamanho() != 5) {
			System.out.println("Erro: o tamanho do conjunto deveria ser 5");
		}
		
		//Teste 2
		ConjuntoEspalhamento conj2 = new ConjuntoEspalhamento();
		conj2.adiciona("Rafael");
		conj2.adiciona("Ana");
		conj2.adiciona("Paulo");
		conj2.adiciona("Paulo");
		System.out.println(conj2.tamanho());
		ArrayList<String> palavras = conj2.pegaTodas();
		
		System.out.println("Antes de remover");
		for(String palavra: palavras) {
			System.out.println(palavra);
		}
		
		//Teste 3
		conj2.remove("Rafael");
		palavras = conj2.pegaTodas();
		
		System.out.println("Depois de remover");
		for(String palavra: palavras) {
			System.out.println(palavra);
		}
		
		//Teste 4
		if(conj2.contem("Ana")) {
			System.out.println("True");
		}
		
		//Teste 5
		System.out.println(conj2.tamanho());
		
		//Teste 6
		ConjuntoEspalhamento cj = new ConjuntoEspalhamento();
		for(int i = 0; i< 100; i++) {
			cj.adiciona("" + i);
		}
		
		cj.imprimeTabela();
		
		//Teste 7
		ConjuntoEspalhamento cj2 = new ConjuntoEspalhamento();
		long inicio = System.currentTimeMillis();
		
		for(int i = 0; i < 50000; i++) {
			cj2.adiciona("palavra " + i);
		}
		
		for(int i = 0; i < 50000; i++) {
			cj2.contem("palavra " + i);
		}
		
	}
}
