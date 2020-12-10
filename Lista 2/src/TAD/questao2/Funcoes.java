package TAD.questao2;

public class Funcoes extends Esfera{
	public Funcoes(double raio) {
		super();
		setRaio(raio);
	}
	
	@Override
	public void retornaRaio() {
		System.out.println(getRaio());
	}

	@Override
	public void calcularArea() { //4 . π . r²
		double area = 4 * 3.14 * getRaio() * getRaio();
		setArea(area);
		System.out.println(area);
	}

	@Override
	public void calcularVolume() { // (4/3) *  π * r³
		double volume = (4/3) * 3.14 * (getRaio() * getRaio() * getRaio());
		setArea(volume);
		System.out.println(volume);
		
	}
}
