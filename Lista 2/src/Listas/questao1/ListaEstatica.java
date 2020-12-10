package Listas.questao1;

public class ListaEstatica{
	private Object[] elementos;
	private int tamanho;

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public Object[] getElementos() {
		return elementos;
	}

	public void setElementos(Object[] elementos) {
		this.elementos = elementos;
	}
	
	public ListaEstatica() {
		this(5);
	}

	public ListaEstatica(int capacidade) {
		this.setElementos(new Object[capacidade]);
		this.tamanho = 0;
	}

	public boolean adiciona(Object elemento) { // e criar uma lista
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
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

	public void remove(int posicao) {
		for(int i=posicao; i<this.tamanho - 1; i++){
			this.elementos[i] = this.elementos[i+1]; // i=1 -> i=2
		}
		this.elementos[this.tamanho - 1] = null;
		this.tamanho--; //o tamanho vai passar para 4 para tirar o ultimo F
	}
	
	public Object copiaDinamica() {
		ListaEncadeada encadeada = new ListaEncadeada(this.tamanho);
		for(int i = 0; i < this.elementos.length; i++) {
			encadeada.addFim(this.elementos[i]);
			try {
				if(encadeada.getElementos()[i] == this.elementos[i + 1]) {
					encadeada.remFim(i);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				e.getMessage();
			}	
		}
		return encadeada;
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
