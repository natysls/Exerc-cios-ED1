package vetor.teste;

import java.util.ArrayList;

public class Aula12 {

	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<String>();
		
		arraylist.add("A");
		arraylist.add("C");
		
		System.out.println(arraylist);
		
		arraylist.add(1, "B");
		
		System.out.println(arraylist);
		
		boolean existe = arraylist.contains("A");
		if(existe) {
			System.out.println("Elemento existe no array\n");
		} else {
			System.out.println("Elemento não existe no array\n");
		}
		
		int posicao = arraylist.indexOf("B");
		if(posicao > -1) {
			System.out.println("Elemento existe no array na posição " + posicao);
		} else {
			System.out.println("Elemento não existe no array " + posicao);
		}
		
		System.out.println(arraylist.get(2));
	
		arraylist.remove(0);
		arraylist.remove("B");
		
		System.out.println(arraylist);
		
		System.out.println(arraylist.size());
	}

}
