// Natália Sales Aragão - 1461765
// Tentei inserir numa Lista Encadeada no método insereHash_endereçamentoAberto() e busca()
package CompanhiaTelefonica;

import java.util.Scanner;

class NoDuplamenteEncadeado {

	private NoDuplamenteEncadeado prox; // apontara para o proximo endereço de memoria
	private NoDuplamenteEncadeado ant; //apontará para o enederço anterio no endereço de meroria
	private Object elemento; //tipo de Objeto
	
	public NoDuplamenteEncadeado(){
	}
	
	public NoDuplamenteEncadeado getProx() {
		return prox;
	}
	public void setProx(NoDuplamenteEncadeado prox) {
		this.prox = prox;
	}
	
	public NoDuplamenteEncadeado getAnt() {
		return ant;
	}

	public void setAnt(NoDuplamenteEncadeado ant) {
		this.ant = ant;
	}

	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return  (String) elemento;
	}
	
}

class ListaEncadeada<T> {

	private NoDuplamenteEncadeado inicio;
	private NoDuplamenteEncadeado fim;
	
	private Object item;
	private String nome;

	protected int quantidade;

	public ListaEncadeada() {
			this.inicio = null;
			this.fim = inicio;
			this.quantidade = 0;
		}

	public NoDuplamenteEncadeado getInicio() {
		return inicio;
	}

	public void setInicio(NoDuplamenteEncadeado inicio) {
		this.inicio = inicio;
	}

	public NoDuplamenteEncadeado getFim() {
		return fim;
	}

	public void setFim(NoDuplamenteEncadeado fim) {

		this.fim = fim;
	}
	
	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return this.quantidade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
/*
	// metodo para criar uma lista
	public void criarLista(Object elemento) {
		if (this.inicio == null) {
			inicio = new NoDuplamenteEncadeado();
			fim = inicio;
			NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
			novoNo.setElemento(elemento);
			novoNo.setProx(null);
			novoNo.setAnt(null);
			fim.setProx(novoNo);
			inicio = fim = novoNo;
			quantidade++;

		} else {
			// caso a lista ja exista será chamado o metodo
			inserirNoFim(elemento);
		}
	}
	*/

	

	// metodo para inserir um elemento no final da lista
	public boolean inserirNoFim(Object elemento, String nome) {
		if (this.inicio == null) {
			inicio = new NoDuplamenteEncadeado();
			fim = inicio;
			NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
			novoNo.setElemento(elemento);
			novoNo.setProx(null);
			novoNo.setAnt(null);
			fim.setProx(novoNo);
			inicio = fim = novoNo;
			quantidade++;

		} else if (quantidade != 0) {
			NoDuplamenteEncadeado novoNome = new NoDuplamenteEncadeado();
			novoNome.setElemento(nome);
			NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
			novoNo.setElemento(elemento);
			novoNo.setProx(novoNome);
			novoNo.setAnt(fim);
			fim.setProx(novoNo);
			fim = novoNo;
			quantidade++;
			return true;
		} 
		return false;
	}

	public boolean removerElemento(Object elemento) {

		NoDuplamenteEncadeado aux = new NoDuplamenteEncadeado();
		aux = inicio;
		for (int i = quantidade; i > 0; i--) {
			if (elemento == aux.getElemento()) {
				// caso so tenha um elemento na lista
				if (aux.getAnt() == null && aux.getProx() == null) {
					inicio = fim = null;
					return true;
				}
				// caso o elemento seja o primeiro da lista
				else if (aux.getAnt() == null && aux.getProx() != null) {
					inicio = null;
					inicio = aux.getProx();
					quantidade--;
					return true;
				}
				// caso o elemento seja o ultimo da lista
				else if (aux.getAnt() != null && aux.getProx() == null) {
					fim = null;
					fim = aux.getAnt(); // pegando o endereço de memeria anteria
					aux.getAnt().setProx(null); // apangando o endereço de memoria do proximo
					quantidade--;
					return true;
				}
				// caso o elemento esteja no meio da lista
				else if (aux.getAnt() != null && aux.getProx() != null) {
					aux.getAnt().setProx(aux.getProx());
					aux.getProx().setAnt(aux.getAnt());
					quantidade--;
					return true;

				}

			}
			aux = aux.getProx();
		}
		return false;
	}

	public boolean listarElementos() {
		if (this.inicio == null) {
			System.out.println("[]");
			return false;
		}
		NoDuplamenteEncadeado aux = this.inicio;

		while (aux != null) {
			System.out.print(aux.getElemento()+" ");
			aux = aux.getProx();
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.item+" - ");
		
		NoDuplamenteEncadeado aux = this.inicio;

		while (aux != null) {
			sb.append(aux.getElemento()+" ");
			aux = aux.getProx();
		}
		return sb.toString();
	}
	
	
	
}


public class Hash {

	private int quant;
	private ListaEncadeada<Integer> tabela[];

	public Hash(int tamanho) {
		tabela = new ListaEncadeada[tamanho];
	}

	public ListaEncadeada<Integer>[] getTabela() {
		return tabela;
	}

	public void setTabela(ListaEncadeada<Integer>[] tabela) {
		this.tabela = tabela;
	}

	public int getQuant() {
		return quant;
	}

	public boolean insereHash_EnderecoAberto(Object object, String nome) {
		if (object == null || quant == tabela.length) {
			return false;
		}
		// deve colocar a chave como elemento de busca. String ou Inteiro
		// int chave = object.TipoInteiro
		int chave = (int) object;

		int pos, novaPosicao;

		pos = chaveDivisao(chave, tabela.length);
		for (int i = 0; i < tabela.length; i++) {
			novaPosicao = sondagemLinear(pos, i, tabela.length);
			if (tabela[novaPosicao] == null) {
				ListaEncadeada<Integer> novoObject = new ListaEncadeada<Integer>();
				//NoDuplamenteEncadeado novoNome = new NoDuplamenteEncadeado();
				novoObject.setItem(object);
				novoObject.inserirNoFim(object, nome);
				
				tabela[novaPosicao] = novoObject;
				this.quant++;
				return true;
			}
		}
		return false;
	}

	public ListaEncadeada<Integer> buscaHash_SemColisão(Object chave) {
		int num = (int) chave;
		int pos = chaveDivisao(num, tabela.length);

		if (tabela[pos] == null) {
			return null;
		}
		ListaEncadeada<Integer> elemento = tabela[pos];
		return (ListaEncadeada<Integer>) elemento.getFim().getElemento();
	}
	

	// Metodos para tratar colisões
	public int sondagemLinear(int pos, int i, int tabela_size) {
		return ((pos + i) & 0x7FFFFFFF) % tabela_size;
	}

	public int sondagemQuadratica(int pos, int i, int tabela_size) {
		pos = (int) (pos + 2 * i + 5 * (Math.pow(i, 2)));
		return (pos & 0x7FFFFFFF) % tabela_size;
	}

	public int duploHash(int h1, int chave, int i, int tabela_size) {
		int h2 = chaveDivisao(chave, tabela_size) + 1; // metodo chave divisao escolhida, por padrão de outras funçoes
		return ((h1 + i * h2) & 0x7FFFFFFF) % tabela_size;
	}

	// Metodos para calcular os tipos de chave.
	public int chaveDivisao(int chave, int tabela_size) {
		return (chave & 0x7FFFFFFF) % tabela_size;
	}

	public int chaveMultiplicacao(int chave, int tabela_size) {
		double a = 0.6180339887; // constante: 0 < A < 1
		double valor = chave * a;
		valor = valor - (int) valor;
		return (int) (tabela_size * valor);
	}

	public int chaveDobra(int chave, int tabela_size) {
		int num_bits = 5;
		int parte1 = chave >> num_bits;
		int parte2 = chave & (tabela_size - 1);
		return (parte1 ^ parte2);
	}
	
	//metodo para ordenar elementos na tabela hash.
	private void ordenarTabela() {
		for(int i = 0; i < tabela.length; i++) {
			for(int j = 0; j < tabela.length; j++) {
				boolean b = tabela[i].getItem().equals(tabela[j].getItem());
				if(b) { // se forem iguais
					ListaEncadeada<Integer> aux = tabela[i];
					tabela[i] = tabela[j];
					tabela[j] = aux;
				}
				
			}
		}
	}

	@Override
	public String toString() {
		ordenarTabela();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tabela.length; i++) {
			sb.append(tabela[i]+"\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Hash hash = new Hash(10);
		
		Scanner scan = new Scanner(System.in);
		int numero;
		String nome;
		while(true) {
			for(int i=0; i < 1; i++) {
				System.out.println("Digite o número de telefone para contato");
				numero = scan.nextInt();
				 
				System.out.println("Digite o nome");
				nome = scan.next();
			
				hash.insereHash_EnderecoAberto(numero, nome);
			}
			break;
			
		}
		
		System.out.println("Qual queres buscar? ");
		int numeroABuscar = scan.nextInt();
		System.out.println(hash.buscaHash_SemColisão(numeroABuscar));
	}
	

}
