package vetor.teste;

import vetor.VetorObjetos;

public class Aula10 {

	public static void main(String[] args) {
		VetorObjetos vetor = new VetorObjetos(3);
		
		Contato c1 = new Contato("Contato 1", "1234-5678", "contato1@email.com");
		Contato c2 = new Contato("Contato 2", "9283-1637", "contato2@email.com");
		Contato c3 = new Contato("Contato 3", "1982-4859", "contato3@email.com");
		
		Contato c4 = new Contato("Contato 1", "1234-5678", "contato1@email.com");
		
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		
		System.out.println("Tamanho = " + vetor.getTamanho());
		
		int pos = vetor.busca(c4);
		if(pos > -1) {
			System.out.println("Elemento existe no vetor");
		}else {
			System.out.println("Não existe no vetor");
		}
		System.out.println(vetor);
	}

}
