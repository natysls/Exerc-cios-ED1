package questao1;

import java.util.Scanner;

public class Fatorial {

	int fatorial = 1;
	int N; //máximo fatorial

	public static Fatorial novoFat(int n) {
		Fatorial aux = new Fatorial();
		aux.N = n;
		return aux;
	}
	
	public static Fatorial somaFat(Fatorial a) {
		if(!(a.N < 1000 && a.N > 0)) { //se ele for maior que 1000 e menor que 0
			return null;
		}
		
		for(int i=a.N; i>1; i--) {
			a.fatorial = a.fatorial * i;
		}
		return a;
		
	}

	@Override
	public String toString() {
		return "" + fatorial;
	}

	public static void main(String[] args) {
		System.out.println("Digite o número fatorial ");
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();
		
		Fatorial fat = novoFat(numero);
		Fatorial soma = somaFat(fat);
		System.out.println("A soma dos " + numero + " primeiros números naturais é: " + soma);
		
	}

}
