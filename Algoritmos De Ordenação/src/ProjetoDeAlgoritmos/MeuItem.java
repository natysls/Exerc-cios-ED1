package ProjetoDeAlgoritmos;
public class MeuItem implements Item{
	private int chave;
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}

	public MeuItem(int chave) {
		this.chave = chave;
	}
	@Override
	public int compara(Item it) {
		MeuItem item = (MeuItem) it;
		if(this.chave < item.chave) {
			return -1;
		}else if(this.chave > item.chave) {
			return 1;
		}
		return 0;
	}

	@Override
	public void alteraChave(Object chave) {
		Integer ch = (Integer) chave;
		this.chave = ch.intValue();
	}

	@Override
	public Object recuperaChave() {
		return new Integer(this.chave);
	}

}

