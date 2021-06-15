package HashListaEncadeada;

public class MainHash {
	public static void main(String[] args) {
			
			int chaves[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
			Hash hash = new Hash(chaves.length);
			for(int chave: chaves) {
				int k = 50 * chave;
				hash.insereHash_EnderecoAberto(k);
			}
	
			System.out.println(hash);
			
			
		}
}
