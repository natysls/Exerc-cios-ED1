package Filas.questao2;

import Listas.questao2.ListaDuplamenteEncadeada;

public class FilaDuplaEncadeada extends ListaDuplamenteEncadeada{
	public FilaDuplaEncadeada() {
		super();
	}
	
	public FilaDuplaEncadeada(int capacidade) {
		super(capacidade);
	}
	
	public void enfileira(Object item) {
		this.adicionaFim(item);
	}
	
	public Object desenfileira() {
		final int POS = 0;
		if(this.vazio()) {
			return null;
		}
		Object elementoASerRemovido = this.elementos[POS];
		this.removeInicio(POS);
		return elementoASerRemovido;
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
