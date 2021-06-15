package Cormen;

public class Heapsort {
	public static void heapSort(int a[]) {
		for(int k = (a.length/2) - 1; k >= 0; k--) { 
			maxHeapfy(a, k, a.length);
		}
		
		for(int N = a.length-1; N >= 1; N--) {
			int T = a[0];
			a[0] = a[N];
			a[N] = T;
			maxHeapfy(a, 0, N); //torna o vetor uma árvore heap
		}
	}

	public static void maxHeapfy(int a[] , int i, int N) {
		int maior = i;
		int esq = 2*i + 1; //posiçao do filho esquerdo de i
		int dir = 2*i + 2; //posiçao do filho direito de i
		
		if(esq < N && a[esq] > a[i]) {
			maior = esq;
		}
		if(dir < N && a[dir] > a[maior]) {
			maior = dir;
		}
		if(maior != i) {
			int T = a[i];
			a[i] = a[maior];
			a[maior] = T;
			maxHeapfy(a, maior, N);
		}
	}
	
	
}
