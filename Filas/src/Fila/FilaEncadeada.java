package Fila;

public class FilaEncadeada implements OperacoesFila{
	private No inicioFila;
	private No finalFila;
	private int qtd;
	private int senha;
	
	public FilaEncadeada() {
		qtd = 0;
		senha = 0;
		inicioFila = null;
		finalFila = null;
	}

	public No getInicioFila() {
		return inicioFila;
	}


	public void setInicioFila(No inicioFila) {
		this.inicioFila = inicioFila;
	}


	public No getFinalFila() {
		return finalFila;
	}


	public void setFinalFila(No finalFila) {
		this.finalFila = finalFila;
	}


	public int getQtd() {
		return qtd;
	}


	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}


	@Override
	public boolean filaVazia() {
		if(qtd == 0) {
			return true;
			
		}else {
			return false;
			
		}
		
	}

	@Override
	public void inserir() {
		senha++;
		
		No novo = new No(senha);
		if(filaVazia()) {
			inicioFila = novo;
			finalFila = novo;
			qtd++;
			
		}else {
			finalFila.setProx(novo);
			finalFila = novo;
			
		}
		
		qtd++;
	}

	@Override
	public void remover() {
		if(filaVazia()) {
			System.out.println("Fila esta vazia");
			
		}else if(inicioFila == finalFila){
			inicioFila = null;
			qtd--;
			
		}else {
			No aux = inicioFila;
			aux = inicioFila.getProx();
			inicioFila = aux;
			qtd--;
			
		}
	}

	@Override
	public void imprimir() {
		No aux = inicioFila;
		
		if(filaVazia())
			System.out.println("A fila está vazia");
		else
			for(int i = 0; i < qtd; i++) {
				try {
					System.out.println("Senha: " + aux.getValor());
					aux = aux.getProx();
				}catch(NullPointerException e) {
					e.getMessage();
				}
			}
		
	}

	@Override
	public void tamanhoFila() {
		System.out.println("A fila tem " + qtd + " senhas");
	}


}
