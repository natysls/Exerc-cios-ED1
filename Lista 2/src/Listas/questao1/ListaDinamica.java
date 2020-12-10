package Listas.questao1;

import java.util.Arrays;

public class ListaDinamica<T> { //Generic classType
	private T[] elementos;
	private int tamanho;
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public T[] getElementos() {
		return elementos;
	}

	public void setElementos(T[] elementos) {
		this.elementos = elementos;
	}
	
	public ListaDinamica() {
		this(5);
	}
	
	public ListaDinamica(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	
	public void adiciona(T elemento) {
		this.aumentaCapacidade();
		if(this.tamanho <= this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} 
	}
	
	public void remove(int posicao) {
		for(int i=posicao; i<this.tamanho - 1; i++){
			this.elementos[i] = this.elementos[i+1]; // i=1 -> i=2
		}
		
		this.elementos[this.tamanho - 1] = null;
		this.tamanho--; //o tamanho vai passar para 4 para tirar o ultimo F
		
	}
	
	public void aumentaCapacidade() { 
		if(this.tamanho == this.elementos.length) { 
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2]; //apenas aumentando a capacidade
			for(int i=0; i<this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i]; //para que ele possa receber o elemento i
			}
			this.elementos = elementosNovos;
		}
	}
	
	
	public Object transformacao() { //em estática
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

	@Override
	public String toString() {
		return "[" + Arrays.toString(elementos) + "]";
	}
	
	/*
	   public Object transformacaoDinamica() { //em dinamica
		ListaDinamica<Object> dinamica = new ListaDinamica<Object>(this.tamanho); 
		for(int i = 0; i < this.elementos.length; i++) {
			dinamica.adiciona(this.elementos[i]);
			try {
				if(dinamica.getElementos()[i] == this.elementos[i + 1]) {
					dinamica.remove(i);
					
				}
			
			}catch(ArrayIndexOutOfBoundsException e) {
				e.getMessage();
			}
			//falta limpar o espaço vazio com o Garbage Colletion
		}
	
		return dinamica;
	}
	 */
		
}
