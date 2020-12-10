package TAD.questao2;
public abstract class Esfera {
	//raio, a sua  ́area e o seu volume.
	private double raio;
	private double volume; // (4/3) *  π * r³
	private double area; //4 . π . r²
	
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	public abstract void retornaRaio();
	public abstract void calcularArea();
	public abstract void calcularVolume();
}
