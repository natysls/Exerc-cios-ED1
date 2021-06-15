package questao2;

class No{
	private No prox;
	private Object item;
	
	public No(Object item) {
		this.prox = null;
		this.item = item;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
}

public class ListaEncadeada {
	private Object[] elementos;
	private No inicio, fim;
	private int tamanho;
	
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

	public ListaEncadeada(int capacidade) {
		this.setElementos(new Object[capacidade]);
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}
	
	public ListaEncadeada() {
		this(5);
	}
	
	public void addFim(Object item) {
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia
			inicio = novo;
			fim = novo;
			adiciona(inicio);
		}else {
			fim.setProx(novo);
			fim = novo; //fim = ultimo
			adiciona(fim);
		}
	}
	
	public boolean adiciona(No elemento) {
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
	
	public static void main(String[] args) {
		ListaEncadeada list = new ListaEncadeada();
		

	}

}
