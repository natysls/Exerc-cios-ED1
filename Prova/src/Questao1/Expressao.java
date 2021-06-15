/* Natália Sales Aragão - 1461765 */
package Questao1;

import java.util.Scanner;

public class Expressao{
	private Object[] elementos;
	private int tamanho;
	
	public Object[] getElementos() { return elementos; }
	public void setElementos(Object[] elementos) { this.elementos = elementos; }
	public int getTamanho() { return tamanho; }
	public void setTamanho(int tamanho) { this.tamanho = tamanho; }
	
	public Expressao() { //tamanho padrão do tamanho caso o user não queira botar a capacidade
		this(5);
	}

	public Expressao(int capacidade) {
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
	
	
	
	public boolean check(char str[], int size) {
		for(int i =0; i<size; i++) {
			if(str[i] == '(') {
				empilha('(');
			}else if(str[i] == '{') {
				empilha('{');
			}else if(str[i] == '[') {
				empilha('[');
			}
			if(str[i] == ')' || str[i] == '}' || str[i] == ']') {
				if(!(this.estaVazia())) {
					return false;
				}else {
					desempilha();
				}
			}
		}
		return true;	
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
		Expressao exp = new Expressao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a string 1: ");
		char str1[] = scan.next().toCharArray(); //{'[','(','{','}',')',']'}
		
		System.out.println("Digite a string 2: ");
		char str2[] = scan.next().toCharArray(); //{'(',')','[','{','}',']'}
		
		System.out.println("Digite a string 3: ");
		char str3[] = scan.next().toCharArray(); //{'{','[','}',']'}
		int size1 = str1.length;
		int size2 = str2.length;
		int size3 = str3.length;
		
		if(exp.check(str1, size1)) {
			System.out.println("String1 é válida");
		}else {
			System.out.println("String1 não é válida");
		}
		
		if(exp.check(str2, size2)) {
			System.out.println("String2 é válida");
		}else {
			System.out.println("String2 não é válida");
		}
		
		if(exp.check(str3, size3)) {
			System.out.println("String3 é válida");
		}else {
			System.out.println("String3 não é válida");
		}
	}
}
