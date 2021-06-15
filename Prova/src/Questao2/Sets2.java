/* Natália Sales Aragão - 1461765 */
package Questao2;

import java.util.Scanner;

class No{
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

public class Sets2 {
	private Object[] elementos;
	private No inicio, fim;
	private int tamanho;
	
	public Object[] getElementos() {
		return elementos;
	}
	public void setElementos(Object[] elementos) {
		this.elementos = elementos;
	}
	public No getInicio() {
		return inicio;
	}
	public void setInicio(No inicio) {
		this.inicio = inicio;
	}
	public No getFim() {
		return fim;
	}
	public void setFim(No fim) {
		this.fim = fim;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	private boolean isEmpty() {
		return inicio == null;
	}

	public Sets2(int capacidade) {
		this.setElementos(new Object[capacidade]);
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}
	
	public Sets2() {
		this(5);
	}
	
	public void addFim(Object item) {
		No novo = new No(item);
		
		if(isEmpty()) { //lista vazia
			inicio = novo;
			fim = novo;
			adiciona(inicio);
		}else {
			fim.setProx(novo);
			fim = novo; //fim = ultimo
			adiciona(fim);
		}
	}
	
	public boolean adiciona(No elemento) {
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			try {
				this.elementos[this.tamanho] = elemento.getItem();
			}catch(ArrayStoreException e) {
				e.getMessage();
			}
			this.tamanho++;
			return true;
		} 
		return false;
	}
	
	/* Constrains !! */
	public void aumentaCapacidade() { 
		if(this.tamanho < 1000) {
			if(this.tamanho == this.elementos.length) { 
				Object[] elementosNovos = new Object[this.elementos.length * 2]; //apenas aumentando a capacidade
				for(int i=0; i<this.elementos.length; i++) {
					elementosNovos[i] = this.elementos[i]; //para que ele possa receber o elemento i
				}
				this.elementos = elementosNovos;
			}
		}else {
			System.out.println("Tamanho não autorizado");
		}
	}
	
	/* Percorre os elementos da lista e adiciona */
	public static Object uniao(Sets2 list1, Sets2 list2) {
		Sets2 list3 = new Sets2();
		if(list1.getTamanho() > list2.getTamanho()) {
			for (int i = 0; i < list1.getTamanho(); i++) { 
				list3.addFim(list1.getElementos()[i]);
				list3.addFim(list2.getElementos()[i]); 
			} 
		}else if(list1.getTamanho() < list2.getTamanho()){
			for (int i = 0; i < list2.getTamanho() ; i++) { 
				list3.addFim(list1.getElementos()[i]);
				list3.addFim(list2.getElementos()[i]); 
			} 
		}
		return list3;
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
		Sets2 list1 = new Sets2();
		Sets2 list2 = new Sets2();
		Sets2 list3 = new Sets2();
		
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Digite o tamanho: ");
		int tamanho = scan1.nextInt();
		list1.setTamanho(tamanho);
		System.out.println("Digite os elementos da lista 1: ");
		int elemlist1 = scan1.nextInt();
		list1.addFim(elemlist1);
		boolean flag = true;
		while(flag) {
			System.out.println("Adicionar mais? [S/N]");
			String op = scan1.next();
			if(op.equalsIgnoreCase("S")) {
				int elem2list1 = scan1.nextInt();
				list1.addFim(elem2list1);
			}else {
				flag = false;
			}
		}
		System.out.println(list1);

		System.out.println("---------------------------");
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Digite o tamanho: ");
		int tamanho2 = scan2.nextInt();
		list1.setTamanho(tamanho2);
		System.out.println("Digite os elementos da lista 2: ");
		int elemlist2 = scan2.nextInt();
		list2.addFim(elemlist2);
		boolean flag2 = true;
		while(flag2) {
			System.out.println("Adicionar mais? [S/N]");
			String op2 = scan1.next();
			if(op2.equalsIgnoreCase("S")) {
				int elem2list2 = scan2.nextInt();
				list2.addFim(elem2list2);
			}else {
				flag2 = false;
			}
		}
		System.out.println(list2);
		
		System.out.println("---------------------------");
		
		System.out.println("União");
		list3 = (Sets2) uniao(list1, list2);
		
		System.out.println(list3);
	}

}

