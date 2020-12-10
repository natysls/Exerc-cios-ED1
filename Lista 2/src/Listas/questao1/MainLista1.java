package Listas.questao1;
public class MainLista1 {
	public static void main(String[] args){
		ListaEstatica estatica = new ListaEstatica(4);
		estatica.adiciona(1);
		estatica.adiciona(2);
		estatica.adiciona(2);
		estatica.adiciona(4);
		
		System.out.println("Lista estática = " + estatica);
		System.out.println("Lista transformada em encadeada = " + estatica.copiaDinamica());
	
		ListaEncadeada encadeada = new ListaEncadeada(4);
		encadeada.addFim(5);
		encadeada.addFim(6);
		encadeada.addFim(7);
		encadeada.addFim(7);
		
		System.out.println("Lista Encadeada = " + encadeada);
		System.out.println("Lista transformada em estática = " + encadeada.copiaEstatica());
	}
}