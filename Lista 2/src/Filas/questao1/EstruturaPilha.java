package Filas.questao1;

public class EstruturaPilha<T> {
	protected T[] elementos;
	protected int tamanho;

	public int getTamanho() {
		return tamanho;
	}
	public T[] getElementos() {
		return elementos;
	}
	public void setElementos(T[] elementos) {
		this.elementos = elementos;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public EstruturaPilha(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	public EstruturaPilha() {
		this(6);
	}
	
	public boolean estaVazia() {
		return this.tamanho == 0;
	}
	
	public void empilha(T elemento) {
		adiciona(elemento);
	}
	
	public T desempilha() {
		if(this.estaVazia()) {
			return null;
		}
		T elemento = this.elementos[tamanho - 1];
		tamanho--;
		return elemento;
	}
	
	public T topo() {
		if(this.estaVazia()) {
			return null;
		}
		return this.elementos[tamanho -1];
	}
	
	protected boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} 
		return false;
	}
	
	protected boolean adiciona(int posicao, T elemento) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida");
		}
		this.aumentaCapacidade();
		
		//mover todos os elementos
		for(int i=this.tamanho - 1; i>=posicao; i--){
			this.elementos[i + 1] = this.elementos[i]; // i=3 -> i=2
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
		
		return true;
	}
	
	protected void remove(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida");
		}
		
		//mover todos os elementos para trás
		for(int i=posicao; i<this.tamanho - 1; i++){
			this.elementos[i] = this.elementos[i+1]; // i=1 -> i=2
		}
		
		this.elementos[this.tamanho - 1] = null;
		this.tamanho--; //o tamanho vai passar para 4 para tirar o ultimo F
	}
	
	protected Object busca(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida");
		}
		return this.elementos[posicao];
	}
	
	protected int busca(T elemento) {
		for(int i = 0; i<this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1; //(nao existe)
	}
	
	protected void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) {
			T[] elementosNovos =(T[]) new Object[this.elementos.length * 2];
			for(int i=0; i<this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for(int i=0; i<this.tamanho-1;i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		if(this.tamanho > 0) {
			s.append(this.elementos[this.tamanho -1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
}
