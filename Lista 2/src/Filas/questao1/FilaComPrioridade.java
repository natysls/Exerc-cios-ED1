package Filas.questao1;

public class FilaComPrioridade<T> extends EstruturaPilha<T>{
	public FilaComPrioridade() {
		super();
	}
	
	public FilaComPrioridade(int capacidade) {
		super(capacidade);
	}
	
	public void empilha(T elemento) { //seria a enfileira, estou sobrescrevendo
		Comparable<T> chave = (Comparable<T>) elemento;
		
		int i;
		for(i = 0; i < this.tamanho; i++) {
			if(chave.compareTo(this.elementos[i]) < 0) {
				break;
			}
		}
		this.adiciona(i, elemento);
	}
	
	
	
	public T desempilha() { //seria a desenfileira, estou sobrescrevendo
		final int POS = 0;
		if(this.estaVazia()) {
			return null;
		}
		
		T elementoASerRemovido = this.elementos[POS];
		
		this.remove(POS);
		
		return elementoASerRemovido;
	}
}
