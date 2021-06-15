package ArvoreBalanceada;

public class MainAVL2 {

	public static void main(String[] args) {
		AVL<Integer> arvore = new AVL<Integer>();
		
		System.out.println("Inserção dos elementos: [57 30 12 5 27 19 39 45 52 63 59 85 71 69 81]");
		int vetor[] = {57, 30, 12, 5, 27, 19, 39, 45, 52, 63, 59, 85, 71, 69, 81};
		for(int chave : vetor) {
			arvore.inserir(chave);
		}
		arvore.preOrdem(arvore.getRaiz());

		System.out.println("Quantidade de Rotações");
		System.out.println(arvore.getQuantRotacoes());
	}

}
