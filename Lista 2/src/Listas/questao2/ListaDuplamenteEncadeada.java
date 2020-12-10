package Listas.questao2;

public class ListaDuplamenteEncadeada{
	protected Object[] elementos;
	protected No inicio, fim;
	protected int tamanho;

	public ListaDuplamenteEncadeada(int capacidade) {
		this.setElementos(new Object[capacidade]);
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}
	
	public ListaDuplamenteEncadeada() {
		this(5);
	}

	public void adicionaInicio(Object item) { 
		No novo = new No(item);
		if(vazio()) { //lista vazia
			inicio = novo; // inicio <- novo -> fim
			fim = novo;
			//adiciona(inicio);
		}else {
			inicio.setAnt(novo); //inicio <- novo
			novo.setProx(inicio); //novo -> inicio
			inicio = novo; //inicio = novo;
			//adiciona(inicio);
		}
		tamanho++; //novo elemento na lista
	}
	
	public void adicionaFim(Object item) {
		No novo = new No(item);
		
		if(vazio()) { //lista vazia
			inicio = novo; // inicio <- novo -> fim
			fim = novo;
			adiciona(inicio);
		}else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
			adiciona(fim);
		}
	}
	
	public boolean adiciona(No elemento) { // e criar uma lista
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			try {
				this.elementos[this.tamanho] = elemento.getItem();
				
			}catch(ArrayStoreException e) {
				e.getMessage();
			}
			this.tamanho++;
			return true;
		} 
		return false;
	}
	
	public void aumentaCapacidade() { 
		if(this.tamanho == this.elementos.length) { 
			Object[] elementosNovos = new Object[this.elementos.length * 2]; 
			for(int i=0; i<this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i]; 
			}
			this.elementos = elementosNovos;
		}
	}
	
	public Object removeInicio(int posicao) {
		if(vazio()) return null; //se não tiver nada, retorna nulo
		
		if(inicio.getProx() != null) {
			inicio = inicio.getProx(); // inicio = prox
			inicio.getAnt().setProx(null); // ant <- null)
			inicio.setAnt(null); //inicio <- null
			remove(posicao);
		}else {
			inicio = null;
			fim = null;
		}
		
		return inicio.getItem();
	}
	
	public Object removeFim() {
		if(vazio()) return null;
		
		if(fim.getAnt() != null) {
			fim = fim.getAnt();
			fim.getProx().setAnt(null);
			fim.setProx(null);
		}else {
			inicio = null;
			fim = null;
		}
		tamanho--;
		return fim.getItem();
	}
	
	public void remove(int posicao) {
		for(int i=posicao; i<this.tamanho - 1; i++){
			this.elementos[i] = this.elementos[i+1]; // i=1 -> i=2
		}
		this.elementos[this.tamanho - 1] = null;
		this.tamanho--; //o tamanho vai passar para 4 para tirar o ultimo F
	}
	
	protected boolean vazio() {
		return inicio == null;
	}

	public Object[] getElementos() {
		return elementos;
	}

	public void setElementos(Object[] elementos) {
		this.elementos = elementos;
	}

	public No getInicio() {
		return inicio;
	}

	public void setInicio(No inicio) {
		this.inicio = inicio;
	}

	public No getFim() {
		return fim;
	}

	public void setFim(No fim) {
		this.fim = fim;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
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
