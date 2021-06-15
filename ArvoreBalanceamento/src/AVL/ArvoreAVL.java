package AVL;

class No<T>{
	private T info;
	private int altura;
	private No<T> esq;
	private No<T> dir;
	
	public No(T novoValor) {
		this.info = novoValor;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T valor) {
		this.info = valor;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
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

public class ArvoreAVL<T extends Comparable<T>> {
	
	void rotacionaEsquerda(No<T> no) {
		No<T> filho = no.getDir();
		No<T> neto = filho.getEsq();
		
		//troca de informação do pai com o filho
		T aux = no.getInfo();
		no.getInfo().equals(filho.getInfo());
		filho.getInfo().equals(aux);
		
		//subindo a ávore
		no.getDir().equals(filho.getDir());
		filho.getDir().equals(neto);
		filho.getEsq().equals(no.getEsq());
		no.getEsq().equals(filho);
		
		//atualizar a altura do filho;
		//atualizar a altura do no;
		
	}
	
	void rotacionaDireita(No<T> no) {
		No<T> filho = no.getEsq();
		No<T> neto = filho.getDir();
		
		//troca de informação do pai com o filho
		T aux = no.getInfo();
		no.getInfo().equals(filho.getInfo());
		filho.getInfo().equals(aux);
		
		//subindo a ávore
		no.getEsq().equals(filho.getEsq());
		filho.getEsq().equals(neto);
		filho.getDir().equals(no.getDir());
		no.getDir().equals(filho);
		
		//atualizar a altura do filho;
		//atualizar a altura do no;
		
	}
	
	void balancear(No<T> no, int bal) {
		if(bal == 2) { //subarvore da direita é maior do que a esquerda, rotação a esquerda
			if(no.getDir().getEsq().getAltura() > no.getDir().getDir().getAltura()) {
				//caso precise de uma rotação dupla
				rotacionaDireita(no.getDir());
			}
			rotacionaEsquerda(no);
		}
		else { //subarvore da esquerda é maior do que a direita, rotação a direita
			if(no.getEsq().getDir().getAltura() > no.getEsq().getEsq().getAltura()) {
				//caso precise de uma rotação dupla
				rotacionaEsquerda(no.getEsq());
			}
			rotacionaDireita(no);
		}
	}
	
	boolean insere(T valor, No<T> no) {
		boolean ret = true;
		int bal = 0;
		if(no.getInfo() == null) {
			//insere novo nó com altura 1
		}else {
			if(valor.compareTo(no.getInfo()) > 0) {
				ret = insere(valor, no.getDir());
			}else if(valor.compareTo(no.getInfo()) < 0) {
				ret = insere(valor, no.getEsq());
			}else {
				ret = false;
			}
			
			if(ret) { //se houve inserção
				//atualiza no.altura;
				//atualiza bal;
				if(bal > 1) {
					balancear(no, bal);
				}
			}
		}
		return ret;
	}
	
	No<T> remove(T valor, No<T> no){
		No<T> ret = null;
		if(no.getInfo() != null) {
			if(valor.compareTo(no.getInfo()) > 0) {
				ret = remove(valor, no.getDir());
			}else if(valor.compareTo(no.getInfo()) < 0) {
				ret = remove(valor, no.getEsq());
			}else {
				ret = no;
				if(no.getDir() != null && no.getEsq() != null) {
					T maiorDaEsquerda = retorneMaiorEsq(no);
					remove(maiorDaEsquerda, no);
					no.getInfo().equals(maiorDaEsquerda);
				}else if(no.getEsq() != null) {
					no = no.getEsq();
				}else {
					no = no.getDir();
				}
				return ret;
			}
			
			if(ret != null) {
				//atualiza altura do no;
				int bal = 0;//fator de balanceamento do nó
				if(bal > 1) {
					balancear(no, bal);
				}
			}
		}
		return ret;
	}

	private T retorneMaiorEsq(No<T> no) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
