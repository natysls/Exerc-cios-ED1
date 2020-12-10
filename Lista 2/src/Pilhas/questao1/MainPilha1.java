package Pilhas.questao1;

public class MainPilha1 {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();

		pilha.empilha("(");
		pilha.empilha("(");
		pilha.empilha(")");
		pilha.empilha(")");
		pilha.empilha("(");
		
		System.out.println(pilha);
		System.out.println(pilha.existeParenteseRepetido());
	}
}
