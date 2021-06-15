package ArvoreBalanceada;

class No<T> {
	private No<T> esquerda, direita, pai;
	private T chave;
	private int balanceamento;

	public No(T k) {
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(k);
	}

	public String toString() {
		return Integer.toString((int) getChave());
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public No<T> getPai() {
		return pai;
	}

	public No<T> setPai(No<T> pai) {
		this.pai = pai;
		return pai;
	}

	public No<T> getDireita() {
		return direita;
	}

	public No<T> setDireita(No<T> direita) {
		this.direita = direita;
		return direita;
	}

	public No<T> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No<T> esquerda) {
		this.esquerda = esquerda;
	}
}

public class AVL<T extends Comparable<T>> {
	
	private No<T> raiz;
	private int quantRotacoes = 0;
	
	public No<T> getRaiz() {
		return raiz;
	}
	public void setRaiz(No<T> raiz) {
		this.raiz = raiz;
	}
	public int getQuantRotacoes() {
		return quantRotacoes;
	}
	public void setQuantRotacoes(int quantRotacoes) {
		this.quantRotacoes += quantRotacoes;
	}
	
	public void inserir(T k) {
		No<T> n = new No<T>(k);
		inserirAVL(this.raiz, n);
	}
	
	public void inserirAVL(No<T> aComparar, No<T> aInserir) {
		if(aComparar == null) { //propria raiz
			this.raiz = aInserir;
		} else {
			if(aInserir.getChave().compareTo(aComparar.getChave()) == -1) { // aInserir for menor
				
				if(aComparar.getEsquerda() == null) {
					aComparar.setEsquerda(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
				}else {
					inserirAVL(aComparar.getEsquerda(), aInserir);
				}
			}else if (aInserir.getChave().compareTo(aComparar.getChave()) == 1) { //maior

				if (aComparar.getDireita() == null) {
					aComparar.setDireita(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
				} else {
					inserirAVL(aComparar.getDireita(), aInserir);
				}

			} else {
				System.out.println("O nó já existe");
			}
		}	
	}
	
	public void remover(T k) {
		No<T> n = new No<T>(k);
		removerAVL(this.raiz, n);
	}

	public void removerAVL(No<T> atual, No<T> aRemover) {
		if (atual == null) {
			return;

		} else {

			if (atual.getChave().compareTo(aRemover.getChave()) == 1) { //se item for maior do q a raiz, está na esquerda
				removerAVL(atual.getEsquerda(), aRemover);

			} else if (atual.getChave().compareTo(aRemover.getChave()) == -1) { //se for menor q a raiz, na direita
				removerAVL(atual.getDireita(), aRemover);

			} else { //é ele
				removerNoEncontrado(atual);
			}
		}
	}

	public void removerNoEncontrado(No<T> atual) {
		No<T> r;
		if (atual.getEsquerda() == null || atual.getDireita() == null) {
			if (atual.getPai() == null) { 
				this.raiz = null;
				atual = null;
				return;
			}
			r = atual;

		} else {
			r = sucessor(atual);
			atual.setChave(r.getChave());
		}

		No<T> p;
		if (r.getEsquerda() != null) {
			p = r.getEsquerda();
		} else {
			p = r.getDireita();
		}

		if (p != null) {
			p.setPai(r.getPai());
		}

		if (r.getPai() == null) {
			this.raiz = p;
		} else {
			if (r == r.getPai().getEsquerda()) {
				r.getPai().setEsquerda(p);
			} else {
				r.getPai().setDireita(p);
			}
			verificarBalanceamento(r.getPai());
		}
		r = null;
	}
	
	private void verificarBalanceamento(No<T> atual) {
		definaBalanceamento(atual);
		int balanceamento = atual.getBalanceamento();

		if (balanceamento == -2) {
			//Rotacionar para a direita
			if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
				atual = rotacaoDireita(atual);

			} else {
				atual = duplaRotacaoEsquerdaDireita(atual);
			}
			setQuantRotacoes(1);

		} else if (balanceamento == 2) {
			//Rotacionar para a esquerda
			if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
				atual = rotacaoEsquerda(atual);

			} else {
				atual = duplaRotacaoDireitaEsquerda(atual);
			}
			setQuantRotacoes(1); 
		}

		if (atual.getPai() != null) {
			verificarBalanceamento(atual.getPai());
		} else {
			this.raiz = atual;
		}
		
	}
	
	private void definaBalanceamento(No<T> no) {
		no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
	}
	
	private int altura(No<T> atual) {
		if (atual == null) {
			return -1;
		}

		if (atual.getEsquerda() == null && atual.getDireita() == null) {
			return 0;
		
		} else if (atual.getEsquerda() == null) {
			return 1 + altura(atual.getDireita());
		
		} else if (atual.getDireita() == null) {
			return 1 + altura(atual.getEsquerda());
		
		} else { //retorna a maior das duas alturas
			return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
		}
	}
	
	public No<T> rotacaoDireita(No<T> inicial) {

		No<T> esquerda = inicial.getEsquerda();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerda(esquerda.getDireita());

		if (inicial.getEsquerda() != null) {
			inicial.getEsquerda().setPai(inicial);
		}

		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireita() == inicial) {
				esquerda.getPai().setDireita(esquerda);
			
			} else if (esquerda.getPai().getEsquerda() == inicial) {
				esquerda.getPai().setEsquerda(esquerda);
			}
		}

		definaBalanceamento(inicial);
		definaBalanceamento(esquerda);

		return esquerda;
	}
	
	public No<T> duplaRotacaoEsquerdaDireita(No<T> inicial) {
		inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
		return rotacaoDireita(inicial);
	}

	public No<T> duplaRotacaoDireitaEsquerda(No<T> inicial) {
		inicial.setDireita(rotacaoDireita(inicial.getDireita()));
		return rotacaoEsquerda(inicial);
	}
	
	public No<T> rotacaoEsquerda(No<T> inicial) {

		No<T> direita = inicial.getDireita();
		direita.setPai(inicial.getPai());

		inicial.setDireita(direita.getEsquerda());

		if (inicial.getDireita() != null) {
			inicial.getDireita().setPai(inicial);
		}

		direita.setEsquerda(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireita() == inicial) {
				direita.getPai().setDireita(direita);
			
			} else if (direita.getPai().getEsquerda() == inicial) {
				direita.getPai().setEsquerda(direita);
			}
		}

		definaBalanceamento(inicial);
		definaBalanceamento(direita);

		return direita;
	}
	
	public No<T> sucessor(No<T> atual) {
		if (atual.getDireita() != null) {
			No<T> direita = atual.getDireita();
			while (direita.getEsquerda() != null) {
				direita = direita.getEsquerda();
			}
			return direita;
		} else {
			No<T> pai = atual.getPai();
			while (pai != null && atual == pai.getDireita()) {
				atual = pai;
				pai = atual.getPai();
			}
			return pai;
		}
	}
	
	final public void emOrdem(No<T> no) { //esq, cima, dir
		if (no == null) {
			return;
		}
		emOrdem(no.getEsquerda());
		System.out.println(no.getChave());	
		emOrdem(no.getDireita());
	}
	
	final public void preOrdem(No<T> atual) { // cima, esq, dir
		if(atual != null) {
			System.out.println(atual.getChave());
			preOrdem(atual.getEsquerda());	
			preOrdem(atual.getDireita());
		}
	}
	
	final public void posOrdem(No<T> atual) { // esq, dir, cima
		if(atual != null) {
			posOrdem(atual.getEsquerda());	
			posOrdem(atual.getDireita());
			System.out.println(atual.getChave());
		}
	}
	
}
