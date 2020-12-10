
public class LDE {
	private No head = null, tail = null;
	private int size = 0;
	
	
	private void addH(Object item) { //adiciona no inicio da lista
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia
			head = novo;
			tail = novo;
		}else {
			head.setAnt(novo); //head <-- novo
			novo.setProx(head); //novo --> head
			head = novo; //head = novo;
			
		}
		
		size++; //novo elemento na lista
	}
	
	private Object remH() {
		if(isEmpty()) return null;
		
		No aux = head;
		
		if(head.getProx() != null) {
			head = head.getProx();
			head.getAnt().setProx(null);
			head.setAnt(null);
		}else {
			head = null;
			tail = null;
		}
		
		size--;
		
		return aux.getItem();
	}
	
	private void addT(Object item) { //adiciona no inicio da lista
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia
			head = novo;
			tail = novo;
		}else {
			novo.setAnt(tail);
			tail.setProx(novo);
			tail = novo;
		}
		
		size++; //novo elemento na lista
	}
	
	private Object remT() {
		if(isEmpty()) return null;
		
		No aux = tail;
		
		if(tail.getAnt() != null) {
			tail = tail.getAnt();
			tail.getProx().setAnt(null);
			tail.setProx(null);
		}else {
			head = null;
			tail = null;
		}
		
		size--;
		
		return aux.getItem();
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
}
