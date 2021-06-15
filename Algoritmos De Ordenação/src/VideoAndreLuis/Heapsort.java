package VideoAndreLuis;

public class Heapsort {
	
	public static void main(String[] args) {
		int[] lista = {9, 5, 88, 76, 44, 18, 0, 11, 21};
		
		System.out.print("Lista antes: ");
		for(int i: lista) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		ordenar(lista);
		
		System.out.print("Lista depois: ");
		for(int i: lista) {
			System.out.print(i + " ");
		}
		
	}
	
	public static void ordenar(int[] lista) {
		/*
		 * Montagem da arvore mesmo se ela nãoestiver ordenada
		 */
		montarArvoreHeap(lista);
		int n = lista.length;
		
		//Para uma arvore de tamanho n, ordene n-1 vezes
		for(int i = lista.length-1; i > 0; i--) {
			int aux = lista[i];
			lista[i] = lista[0];
			lista[0] = aux;
			//removemos o primeiro item da lista(o maior)
			
			ordenarArvore(lista, 0, --n);
		}
	}
	
	public static void montarArvoreHeap(int[] lista) {
		for(int posicao = (lista.length - 1)/2; posicao >= 0; posicao--) {
			ordenarArvore(lista, posicao, lista.length);
		}
	}
	
	public static void ordenarArvore(int[] lista, int posicao, int tamanhoDoVetor) {
		//Nó pai com indice 0: 2 * 0 + 1, 2 * 0 + 2
		int indiceFilhoUm = 2 * posicao + 1;
		int indiceFilhoDois = indiceFilhoUm + 1;
		
		if(indiceFilhoUm < tamanhoDoVetor) {
			if(indiceFilhoDois < tamanhoDoVetor) {
				/*
				 * Se ainda estivermos dentro do vetor, teste qual maior filho
				 */
				if(lista[indiceFilhoUm] < lista[indiceFilhoDois]) {
					indiceFilhoUm = indiceFilhoDois;
				}
			}
			
			if(lista[indiceFilhoUm] > lista[posicao]) {
				/*
				 * Comparação filho um com o Nó pai
				 */
				int aux = lista[indiceFilhoUm];
				lista[indiceFilhoUm] = lista[posicao];
				lista[posicao] = aux;
				
				//Remontagem da árvore 
				ordenarArvore(lista, indiceFilhoUm, tamanhoDoVetor);
			}
		}
		
		
	}
}
