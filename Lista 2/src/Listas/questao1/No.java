package Listas.questao1;

public class No {
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
