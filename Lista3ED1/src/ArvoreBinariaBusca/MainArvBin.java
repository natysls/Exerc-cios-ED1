package ArvoreBinariaBusca;

public class MainArvBin {

	public static void main(String[] args) {
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
		int vetor[] = {25, 10, 8, 3, 1, 5, 15, 18, 16, 17, 23, 30, 28, 26, 27, 47, 52};

		for(int i: vetor) {
			arvore.adicionar(i);
		}
		System.out.println("Árvore em ordem: ");
		arvore.emOrdem(arvore.getRaiz());
		
		System.out.println("Pós Ordem");
		arvore.posOrdem(arvore.getRaiz());
		
		System.out.println("Depois da remoção do elemento [ 26 ]");
		arvore.remover(26);
		arvore.emOrdem(arvore.getRaiz());
		
		System.out.println("Depois da remoção dos elementos [ 26 15 ]");
		arvore.remover(15);
		arvore.emOrdem(arvore.getRaiz());
		
		System.out.println("Depois da remoção dos elementos [ 26 15 52 ]");
		arvore.remover(52);
		arvore.emOrdem(arvore.getRaiz());
		
		System.out.println("Depois da remoção dos elementos [ 26 15 52 8 ]");
		arvore.remover(8);
		arvore.emOrdem(arvore.getRaiz());
		
		System.out.println("Depois da remoção dos elementos [ 26 15 52 8 5 ]");
		arvore.remover(5);
		arvore.emOrdem(arvore.getRaiz());
		
		System.out.println("Pós Ordem");
		arvore.posOrdem(arvore.getRaiz());
	}

}
