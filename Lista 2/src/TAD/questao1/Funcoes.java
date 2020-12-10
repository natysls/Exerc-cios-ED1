package TAD.questao1;

public class Funcoes extends NumeroComplexo {
	
	@Override
	public Double criarNumeroComplexo(double x, double y, double i) {
		Double z = x + i * y;
		if(getZ1() == null) {	
			setZ1(z);
			System.out.println("Número z1 = " + getZ1() + " criado.\n");
			return getZ1();
		} 
		
		setZ2(z);
		System.out.println("Número z2 = " + getZ2() + " criado.\n");
		return getZ2();

	}
	
	@Override
	public Double destruirNumeroComplexo(Double z){
		if(z == getZ1()) {
			setZ1(null);
			System.out.println("O numero complexo z1 foi destruido: " + getZ1() + "\n");
			return getZ1();
		} else if(z == getZ2()) {
			setZ2(null);
			System.out.println("O numero complexo z2 foi destruido: " + getZ2() + "\n");
			return getZ2();
		} else {
			System.out.println("Número não existe, por favor crie.\n");
			return null;
		}
	}

	@Override
	public Double somarDoisNumerosComplexos() {
		if(getZ1() == null) {
			System.out.println("A soma deu " + getZ2() + "\n");
			return getZ2();
		}else if(getZ2() == null) {
			System.out.println("A soma deu " + getZ1() + "\n");
			return getZ1();
		}
		//se não
		Double soma = getZ1() + getZ2();
		
		System.out.println("A soma deu " + soma + "\n");
		return soma;
		
	}

	@Override
	public Double multiplicarNumerosComplexos() {
		if(getZ1() == null) {
			System.out.println("A multiplicação deu " + getZ2() + "\n");
			return getZ2();
		}else if(getZ2() == null) {
			System.out.println("A multiplicação deu " + getZ1() + "\n");
			return getZ1();
		}
		//se não
		Double multi = getZ1() * getZ2();
		
		System.out.println("A multiplicação deu " + multi + "\n");
		
		return multi;
	}
	

}
