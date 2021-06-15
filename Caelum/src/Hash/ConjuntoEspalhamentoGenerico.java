package Hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class ConjuntoEspalhamentoGenerico {
	private ArrayList<LinkedList<Object>> tabela = new ArrayList<LinkedList<Object>>();
	private int tamanho = 0;

	public ConjuntoEspalhamentoGenerico() {
		for(int i = 0; i < 26; i++) {
			LinkedList<Object> lista = new LinkedList<Object>();
			tabela.add(lista);
		}
	}
	
	public void adiciona(Object objeto) {
		if(!this.contem(objeto)) { //evitar a repetição de palavras fazendo uma pequena verificação antes de adicionar uma palavra.
			this.verificaCarga();
			int indice = this.calcularIndiceDaTabela(objeto);
			LinkedList<Object> lista = this.tabela.get(indice);
			lista.add(objeto);
			this.tamanho++;
		}
	}
	
	public void remove(Object objeto) {
		if(this.contem(objeto)) {
			int indice = this.calcularIndiceDaTabela(objeto);
			LinkedList<Object> lista = this.tabela.get(indice);
			lista.remove(objeto);
			this.tamanho--;
			this.verificaCarga();
		}
	}
	
	public boolean contem(Object objeto) {
		int indice = this.calcularIndiceDaTabela(objeto);
		LinkedList<Object> lista = this.tabela.get(indice);
		
		return lista.contains(objeto);	
	}
	
	public ArrayList<Object> pegaTodas(){
		ArrayList<Object> objetos = new ArrayList<Object>();
		for(int i = 0; i < this.tabela.size(); i++) {
			objetos.addAll(this.tabela.get(i));
		}
		return objetos;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	private int calcularIndiceDaTabela(Object objeto) {
		int codigoDeEspelhamento = objeto.hashCode();
		codigoDeEspelhamento = Math.abs(codigoDeEspelhamento); //evitar gerar um numero negativo
		return codigoDeEspelhamento % tabela.size();
	}
	
	public void imprimeTabela() {
		for(LinkedList<Object> lista : this.tabela) {
			System.out.println("[");
			for(int i = 0; i < lista.size(); i++) {
				System.out.println("*");
			}
			System.out.println("]");
		}
	}
	
	private void redimensionaTabela(int novaCapacidade) {
		ArrayList<Object> objetos = this.pegaTodas();
		this.tabela.clear();
		
		for(int i = 0; i < novaCapacidade; i++) {
			this.tabela.add(new LinkedList<Object>());
		}
		
		for(Object objeto : objetos) {
			this.adiciona(objeto);
		}
	}
	
	private void verificaCarga() { //utilizado antes de adicionar e após remover uma palavra
		int capacidade = this.tabela.size();
		double carga = (double) this.tamanho / capacidade;
		
		if(carga > 0.75) {
			this.redimensionaTabela(capacidade * 2);
		} else if(carga < 0.25) {
			this.redimensionaTabela(Math.max(capacidade/2, 10));
		}
	}
	
}

