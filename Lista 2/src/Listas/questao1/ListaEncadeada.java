package Listas.questao1;

public class ListaEncadeada {
	private Object[] elementos;
	private No inicio, fim;
	private int tamanho;
	
	public ListaEncadeada(int capacidade) {
		this.setElementos(new Object[capacidade]);
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}
	
	public ListaEncadeada() {
		this(5);
	}

	public void addInicio(Object item) { //adiciona no inicio da lista
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia	
			inicio = novo;
			fim = novo;
		}else {
			novo.setProx(inicio);
			//novo irá apontar para o inicio
			
			inicio = novo;
			//inicio -> prox -> prox -> fim
		}
		tamanho++; //novo elemento na lista
	}
	
	public Object remInicio() {
		if(isEmpty()) return null;
		
		No aux = inicio;
		inicio = aux.getProx(); //head = prox
		
		aux.setProx(null); //anterior que era o head ta apontando para null
		//logo o garbage colletor vai verificar se ele ta sendo utilizado pela 
		//lista e vai deletá-lo da memória
		tamanho--;
		return aux.getItem();
	}
	
	public void addFim(Object item) {
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia
			inicio = novo;
			fim = novo;
			adiciona(inicio);
		}else {
			fim.setProx(novo);
			fim = novo;
			//tail = ultimo
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
			Object[] elementosNovos = new Object[this.elementos.length * 2]; //apenas aumentando a capacidade
			for(int i=0; i<this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i]; //para que ele possa receber o elemento i
			}
			this.elementos = elementosNovos;
		}
	}
	
	public Object remFim(int posicao) {
		if(isEmpty()) return null;
		
		No aux = inicio;
		while(aux != null) {
			if(aux.getProx().getProx() == null) { //aux.getProx() == tail
				No aux2 = fim;
				fim = aux;
				fim.setProx(null); //cortando a referencia com o ultimo nó, limpa a memória
				remove(posicao);
				return aux2.getItem();
			}
			aux = aux.getProx();
		}
		return null;
	}
	
	public void remove(int posicao) {
		for(int i=posicao; i<this.tamanho - 1; i++){
			this.elementos[i] = this.elementos[i+1]; // i=1 -> i=2
		}
		this.elementos[this.tamanho - 1] = null;
		this.tamanho--; //o tamanho vai passar para 4 para tirar o ultimo F
	}
	
	public Object copiaEstatica() { //em estática
		ListaEstatica estatica = new ListaEstatica(this.tamanho);
		for(int i = 0; i < this.tamanho; i++) {
			estatica.adiciona(this.elementos[i]);
			try {
				if(estatica.getElementos()[i] == this.elementos[i + 1]) {
					estatica.remove(i);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				e.getMessage();
			}
		}
		return estatica;
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

	private boolean isEmpty() {
		return inicio == null;
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
