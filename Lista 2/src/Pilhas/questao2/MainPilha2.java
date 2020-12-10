package Pilhas.questao2;

public class MainPilha2 {

	public static void main(String[] args) {
		Conversao pilha = new Conversao();
		
		pilha.empilha("101001");
		pilha.empilha("100111");
		pilha.empilha("111");
		pilha.empilha("11000");
		
		System.out.println(pilha);
		
		pilha.conversao("binario", pilha);
		System.out.println(pilha);
	}
}
