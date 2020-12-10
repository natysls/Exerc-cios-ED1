package Filas.questao1;

public class Fila<T> extends EstruturaPilha<T>{
	public Fila() {
		super();
	}
	
	public Fila(int capacidade) {
		super(capacidade);
	}
	
	public void enfileira(T elemento) {
		this.adiciona(elemento);
	}
	
	public void inverte() {
		Fila<T> filaInvertida = new Fila<T>();
		
		for(Integer i=this.elementos.length + 1; i>=0; i--) {
			try {
				filaInvertida.enfileira(this.elementos[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				e.getMessage();
			}
		}
		System.out.println("Fila invertida");
		this.elementos = filaInvertida.elementos;
	}
	
	public T desenfileira() {
		final int POS = 0;
		if(this.estaVazia()) {
			return null;
		}
		
		T elementoASerRemovido = this.elementos[POS];
		
		this.remove(POS);
		
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
