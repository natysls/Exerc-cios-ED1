package ArvoreBinariaBusca;

class No<T>{
	private T valor;
	private No<T> esq;
	private No<T> dir;
	
	public No(T novoValor) {
		setValor(novoValor);
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public No<T> getEsq() {
		return esq;
	}
	public void setEsq(No<T> esq) {
		this.esq = esq;
	}
	public No<T> getDir() {
		return dir;
	}
	public void setDir(No<T> dir) {
		this.dir = dir;
	}
}

public class ArvoreBinaria<T extends Comparable<T>>{
	private No<T> raiz;
	
	public No<T> getRaiz() {
		return raiz;
	}
	public void setRaiz(No<T> raiz) {
		this.raiz = raiz;
	}
	
	// .compareTo() se retorna -1, é menor. Se retorna 1, é maior. Se retorna 0, é igual

	public void adicionar(T valor) {
		No<T> novoElem = new No<T>(valor);
		
		if(raiz == null) {
			this.raiz = novoElem;
		}else {
			No<T> atual = this.raiz;
			while(true) {
				if(novoElem.getValor().compareTo(atual.getValor()) == -1) { //menor
					if(atual.getEsq() != null) { //vai para esquerda
						atual = atual.getEsq();
					}else {
						atual.setEsq(novoElem);
						break;
					}
				}else { // se for maior ou igual
					if(atual.getDir() != null) { //vai para direita
						atual = atual.getDir();
					}else {
						atual.setDir(novoElem);
						break;
					}
				}
			}
		}
	}
	
	public void emOrdem(No<T> atual) { //esq, cima, dir
		if(atual != null) {
			emOrdem(atual.getEsq());
			System.out.println(atual.getValor());	
			emOrdem(atual.getDir());
		}
	}
	
	public void preOrdem(No<T> atual) { // cima, esq, dir
		if(atual != null) {
			System.out.println(atual.getValor());
			preOrdem(atual.getEsq());	
			preOrdem(atual.getDir());
		}
	}
	
	public void posOrdem(No<T> atual) { // esq, dir, cima
		if(atual != null) {
			posOrdem(atual.getEsq());	
			posOrdem(atual.getDir());
			System.out.println(atual.getValor());
		}
	}
	
	public boolean remover(T valor) {
		//buscar o elemento na arvore
		No<T> atual = this.raiz;
		No<T> paiAtual = null;
		while(atual != null) {
			if(atual.getValor().equals(valor)) {
				break;
			}else if(valor.compareTo(atual.getValor()) == -1) { //valor é menor q o atual
				paiAtual = atual;
				atual = atual.getEsq();
			}else {
				paiAtual = atual;
				atual = atual.getDir();
			}
		}
		//verifica se existe o elemento
		if(atual != null) {
			
			//elem tem 2 filhos ou elem tem somente filho à direita
			if(atual.getDir() != null) { //tem filhos só a direita
				No<T> substituto = atual.getDir();
				No<T> paiSubstituto = atual;
				while(substituto.getEsq() != null) {
					paiSubstituto = substituto;
					substituto = substituto.getEsq();
				}
				
				substituto.setEsq(atual.getEsq());
				
				if(paiAtual != null) {
					if(atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual < paiAtual
						paiAtual.setEsq(substituto);
					}else {
						paiAtual.setDir(substituto);
					}
				}else { //se não tem paiAtual. então é a raiz
					this.raiz = substituto;
				}
				//removeu o elemento da árvore
				if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) { //substituto < paiSubstituto
					paiSubstituto.setEsq(null);
				}else {
					paiSubstituto.setDir(null);
				}
				
				
			}else if(atual.getEsq() != null) { //tem filho só a esquerda
				No<T> substituto = atual.getEsq();
				No<T> paiSubstituto = atual;
				while(substituto.getDir() != null) {
					paiSubstituto = substituto;
					substituto = substituto.getDir();
				}
				
				if(paiAtual != null) {
					if(atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual < paiAtual
						paiAtual.setEsq(substituto);
					}else {
						paiAtual.setDir(substituto);
					}
				}else { //se for a raiz
					this.raiz = substituto;
				}
				
				//removeu o elemento da árvore
				if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) { //substituto < paiSubstituto
					paiSubstituto.setEsq(null);
				}else {
					paiSubstituto.setDir(null);
				}
				
				
			}else{ //não tem filho
				if(paiAtual != null) {
					if(atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual < paiAtual
						paiAtual.setEsq(null);
					}else {
						paiAtual.setDir(null);
						
					}
				}else { //é a raiz
					this.raiz = null;
				}
			}
			
			return true;
			
		}else {
			return false;
		}
	}

}
