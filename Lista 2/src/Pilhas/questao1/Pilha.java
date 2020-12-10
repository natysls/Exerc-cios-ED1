package Pilhas.questao1;

public class Pilha{
	private Object[] elementos;
	private int tamanho;
	
	public Object[] getElementos() { return elementos; }
	public void setElementos(Object[] elementos) { this.elementos = elementos; }
	public int getTamanho() { return tamanho; }
	public void setTamanho(int tamanho) { this.tamanho = tamanho; }
	
	public Pilha() { //tamanho padrão do tamanho caso o user não queira botar a capacidade
		this(5);
	}

	public Pilha(int capacidade) {
		this.elementos = (Object[]) new Object[capacidade]; //solução mais elegante
		this.tamanho = 0;
	}
	
	public boolean empilha(Object elemento) {
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		
		} 
		return false;
	}
	
	public boolean existeParenteseRepetido() {
		for(int i = 0; i<this.elementos.length; i++) {
			for(int j=1; j<this.tamanho;j++) {
				
				if(this.elementos[i].equals("(")) {
					if(this.elementos[i+j].equals(")")) {
						this.elementos[i+j] = this.elementos[i+j+1];
						
						return false;
					}
					return true;
					
				}else {
					return false;
				}
			}
						
		}
		return false;
			
	}
	
	private void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) {
			Object[] elementosNovos =(Object[]) new Object[this.elementos.length * 2];
			for(int i=0; i<this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	public Object desempilha() {
		if(this.estaVazia()) {
			return null;
		}
		Object elemento = this.elementos[tamanho - 1];
		tamanho--;
		return elemento;
	}
	
	public Object topo() {
		if(this.estaVazia()) {
			return null;
		}
		return this.elementos[tamanho -1];
	}
	
	private boolean estaVazia() {
		return this.tamanho == 0;
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
