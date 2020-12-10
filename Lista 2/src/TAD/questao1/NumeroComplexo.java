package TAD.questao1;

public abstract class NumeroComplexo{
	private double x; //real
	private double y; //imaginario
	private double i;
	private Double z1 = null; //numero complexo
	private Double z2 = null;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getI() {
		return i;
	}
	public void setI(double i) {
		this.i = i;
	}
	public Double getZ1() {
		return z1;
	}
	public void setZ1(Double z1) {
		this.z1 = z1;
	}
	public Double getZ2() {
		return z2;
	}
	public void setZ2(Double z2) {
		this.z2 = z2;
	}

	public abstract Double criarNumeroComplexo(double x, double y, double i);
	
	public abstract Double destruirNumeroComplexo(Double z);
	
	public abstract Double somarDoisNumerosComplexos();
	
	public abstract Double multiplicarNumerosComplexos();

	@Override
	public String toString() {
		return "NumeroComplexo [z=" + z1 + "]";
	}
	
}
