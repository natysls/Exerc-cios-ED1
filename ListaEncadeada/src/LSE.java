
public class LSE {
	private No head = null, tail = null;
	private int size = 0;
	
	
	public void addH(Object item) { //adiciona no inicio da lista
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia
			head = novo;
			tail = novo;
		}else {
			novo.setProx(head);
			//novo irá apontar para o head
			
			head = novo;
			//head -> prox -> prox -> tail
			
		}
		
		size++; //novo elemento na lista
	}
	
	public Object remH() {
		if(isEmpty()) return null;
		
		No aux = head;
		head = aux.getProx(); //head = prox
		
		aux.setProx(null); //anterior que era o head ta apontando para null
		//logo o garbage colletor vai verificar se ele ta sendo utilizado pela lista e vai deletá-lo da memória
		
		size--;
		
		return aux.getItem();
	}
	
	public void addT(Object item) { //adiciona no inicio da lista
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia
			head = novo;
			tail = novo;
		}else {
			tail.setProx(novo);
			tail = novo;
			//tail = ultimo
			
		}
		
		size++; //novo elemento na lista
	}
	
	public Object remT() {
		if(isEmpty()) return null;
		
		No aux = head;
		while(aux != null) {
			if(aux.getProx().getProx() == null) { //aux.getProx() == tail
				No aux2 = tail;
				tail = aux;
				tail.setProx(null); //cortando a referencia com o ultimo nó, limpa a memória
				return aux2.getItem();
			}
			aux = aux.getProx();
		}
		
		size--;
		
		return null;
	}
	
	public No getHead() {
		return head;
	}

	public void setHead(No head) {
		this.head = head;
	}

	public No getTail() {
		return tail;
	}

	public void setTail(No tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		return "LSE [" + head.getItem() + ", "+ head.getProx().getItem() + ", " + tail.getItem() + "]";
	}
	
	
}
