package HashListaEncadeada;

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

	public boolean insereHash_EnderecoAberto(Object object) {
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
				novoObject.setItem(object);
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
		return elemento;
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
	
	
	
}
