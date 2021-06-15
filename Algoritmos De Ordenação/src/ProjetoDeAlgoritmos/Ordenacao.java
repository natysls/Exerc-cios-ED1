package ProjetoDeAlgoritmos;
public class Ordenacao {
	public static void selecao(Item v[], int n) {
		for(int i = 1; i <= n-1; i++) {
			int min = i;
			for(int j = i+1; j <= n; j++) {
				if(v[j].compara(v[min]) < 0) {
					min = j;
				}
			}
			Item x = v[min];
			v[min] = v[i];
			v[i] = x;
		}
	}
	
	//mostra a implementação doHeapsort para um conjunto de n itens 
	//implementado como um vetor do tipo Item
	public static void heapSort(Item v[], int n) {
		FPHeapMax fpHeap = new FPHeapMax(v);
		int dir = n;
		fpHeap.constroi(); //constroi o heap
		while(dir > 1) { //ordena o vetor
			Item x = v[1];
			v[1] = v[dir];
			v[dir] = x;
			dir--;
			fpHeap.refaz(1, dir);
		}
	}
}
