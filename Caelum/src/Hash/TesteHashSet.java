package Hash;

import java.util.HashSet;

public class TesteHashSet {

	public static void main(String[] args) {
		HashSet<String> conjunto = new HashSet<String>();
		conjunto.add("Rafael");
		conjunto.add("Rafael");
		conjunto.add("Ana");
		conjunto.add("Paulo");
		
		System.out.println(conjunto);
	}

}
