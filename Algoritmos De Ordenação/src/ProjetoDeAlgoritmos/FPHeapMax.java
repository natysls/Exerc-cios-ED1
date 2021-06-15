package ProjetoDeAlgoritmos;

public class FPHeapMax {
	private Item v[];
	private int n;
	
	public FPHeapMax(Item v[]) {
		this.v = v;
		this.n = this.v.length - 1;
	}
	
	//refaz o heap para os itens v[1], v[2], ... , v[n−1].
	public void refaz(int esq, int dir) {
		int j = esq * 2;
		Item x = this.v[esq];
		while(j <= dir) {
			if((j<dir) && (this.v[j].compara(this.v[j+1]) < 0)) {
				j++;
			}
			if(x.compara(this.v[j]) >= 0) {
				break;
			}
			this.v[esq] = this.v[j];
			esq = j;
			j = esq * 2;
		}
		this.v[esq] = x;
	}
	
	//construir o heap
	public void constroi() {
		int esq = n/2+1;
		while(esq > 1) {
			esq--;
			this.refaz(esq, this.n);
		}
	}
	
	//informa o item com maior chave
	public Item max() { 
		return this.v[1];
	}
	
	//implementa a operação de retirar o item com maior chave
	public Item retiraMax() throws Exception{
		Item maximo;
		if(this.n < 1) {
			throw new Exception("Erro: Heap Vazio");
		}else {
			maximo = this.v[1];
			this.v[1] = this.v[this.n--];
			refaz(1, this.n);
		}
		return maximo;
	}
	
	//implementa a operação de aumentar o valor da chave do item i
	public void aumentaChave(int i, Object chaveNova) throws Exception {
		Item x = this.v[i];
		if(chaveNova == null) {
			throw new Exception("Erro: chaveNova com valor null");
		}
		x.alteraChave(chaveNova);
		while((i>1) && (x.compara(this.v[i/2]) >= 0)) {
			this.v[i] = this.v[i/2];
			i/=2;
		}
		this.v[i] = x;
	}
	
	//implementa a operação de inserir um novo item no heap
	public void insere(Item x) throws Exception{
		this.n++;
		if(this.n == this.v.length) {
			throw new Exception("Erro: heap cheio");
		}
		Object chaveNova = x.recuperaChave();
		this.v[this.n] = x;
		this.v[this.n].alteraChave(new Integer(Integer.MIN_VALUE)); //−infinito
		this.aumentaChave(this.n, chaveNova);
	}
		
	
	
}
