package TAD.questao1;

public class MainTAD1 {

	public static void main(String[] args) throws Exception {
		Funcoes funcao = new Funcoes();
		
		Double z1 = funcao.criarNumeroComplexo(1, 2, 3);
		
		Double z2 = funcao.criarNumeroComplexo(4, 5, 6);
		
		funcao.somarDoisNumerosComplexos();
		
		funcao.multiplicarNumerosComplexos();
		
		funcao.destruirNumeroComplexo(z1);
		
		funcao.somarDoisNumerosComplexos();
		
		funcao.multiplicarNumerosComplexos();
		
		Double z = 4.0; //numero qualquer, vai dar uma exception!!
		
		System.out.println("Vou destruir um numero " + z + " que não criei: ");
		funcao.destruirNumeroComplexo(z);
	}

}
