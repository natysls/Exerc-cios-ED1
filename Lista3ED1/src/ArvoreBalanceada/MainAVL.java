package ArvoreBalanceada;

public class MainAVL {

	public static void main(String[] args) {
		AVL<Integer> arvore = new AVL<Integer>();
		
		System.out.println("Inserção dos elementos: [ 60 45 42 83 69 ]");
		int vetorA[] = {60, 45, 42, 83, 69};
		for(int chave : vetorA) {
			arvore.inserir(chave);
		}
		System.out.println("Árvore pré ordem: ");
		arvore.preOrdem(arvore.getRaiz());
		
		System.out.println("Remoção do elemento: [ 45 ]");
		arvore.remover(45);
		arvore.preOrdem(arvore.getRaiz());
		System.out.println("Remoção dos elementos: [ 45 83 ]");
		arvore.remover(83);
		arvore.preOrdem(arvore.getRaiz());

		System.out.println("Inserção dos elementos: [ 77 85 44 83 17 20 ]");
		int vetorB[] = {77, 85, 44, 83, 17, 20};
		for(int chave : vetorB) {
			arvore.inserir(chave);
		}
		arvore.preOrdem(arvore.getRaiz());
		
		System.out.println("Árvore em Ordem");
		arvore.emOrdem(arvore.getRaiz());
	
	}

}
