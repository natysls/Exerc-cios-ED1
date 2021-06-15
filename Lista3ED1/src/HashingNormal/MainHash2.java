package HashingNormal;

import java.util.ArrayList;

public class MainHash2 {

	public static void main(String[] args) {
		
		Hash hash = new Hash();
		
		int chaves[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		for(int chave: chaves) {
			int k = 50 * chave;
			hash.adiciona(k);
		}

		ArrayList<Object> palavras = hash.pegaTodas();
		for(Object n: palavras) {
			System.out.println(n);
		}
		
		
	}

}
