/* Natália Sales Aragão - 1461765 */
package Questao3;

import java.util.Scanner;

public class Palíndromo<T> {

	protected T[] elementos;
	protected int tamanho;

	public int getTamanho() {
		return tamanho;
	}
	public T[] getElementos() {
		return elementos;
	}
	public void setElementos(T[] elementos) {
		this.elementos = elementos;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public Palíndromo() {
		this(5);
	}
	
	public Palíndromo(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	public void enfileira(T elemento) {
		this.adiciona(elemento);
	}
	
	protected boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} 
		return false;
	}
	
	protected void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) {
			T[] elementosNovos =(T[]) new Object[this.elementos.length * 2];
			for(int i=0; i<this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
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
	
	protected void remove(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida");
		}
		
		//mover todos os elementos para trás
		for(int i=posicao; i<this.tamanho - 1; i++){
			this.elementos[i] = this.elementos[i+1]; // i=1 -> i=2
		}
		
		this.elementos[this.tamanho - 1] = null;
		this.tamanho--; //o tamanho vai passar para 4 para tirar o ultimo F
	}
	
	
	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	public Object inverte() {
		Palíndromo<T> filaInvertida = new Palíndromo<T>();
		
		for(Integer i=this.elementos.length + 1; i>=0; i--) {
			try {
				filaInvertida.enfileira(this.elementos[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				e.getMessage();
			}
		}
		System.out.println("Fila invertida");
		this.elementos = filaInvertida.elementos;
		return filaInvertida;
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
		Palíndromo<String> palavra = new Palíndromo<String>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a palavra: ");
		String input = scan.next();
		palavra.enfileira(input);
		
		if(palavra.inverte() == palavra) {
			System.out.println("É palíndromo");
		}else {
			System.out.println("Não é palíndromo");
		}
		
	}

}
