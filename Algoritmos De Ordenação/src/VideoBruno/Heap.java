package VideoBruno;

public class Heap implements Interface{
	private int vetor[];
	private int n;
	
	public Heap(int tamanho) {
		this.vetor = new int[tamanho];
		this.n = 0;
	}
	
	public void inserir(int elemento) {
		this.vetor[++this.n] = elemento;
		subir(n);
	}

	public void subir(int filho) {
		int pai = filho/2;
		if(pai >= 1) { //pai possivel
			if(this.vetor[filho] > this.vetor[pai]) {
				int aux = this.vetor[pai];
				this.vetor[pai] = this.vetor[filho];
				this.vetor[filho] = aux;
				subir(pai);
			}	
		}
	}
	
	public int remover() {
		int removed = this.vetor[1];
		this.vetor[1] = this.vetor[n];
		this.n--;
		descer(1);
		return removed;
	}
	
	public void descer(int pai) {
		int filhoEsq = pai*2;
		int filhoDir = (pai*2) + 1;
		int maior = pai;
		
		if((filhoEsq <= n) && this.vetor[filhoEsq] > this.vetor[maior]) {
			maior = filhoEsq;
		}
		if((filhoDir <= n) && this.vetor[filhoDir] > this.vetor[maior]) {
			maior = filhoDir;
		}
		if(maior != pai) { //checa se ele passou na verificação anterior
			int aux = this.vetor[pai];
			this.vetor[pai] = this.vetor[maior];
			this.vetor[maior] = aux;
			descer(maior);
		}
	}
	
	
}
