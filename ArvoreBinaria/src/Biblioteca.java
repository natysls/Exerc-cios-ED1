// .h
public abstract class Biblioteca<T> {
	abstract public void adicionar(T valor);
	abstract public void emOrdem(No<T> atual);
	abstract public void preOrdem(No<T> atual);
	abstract public void posOrdem(No<T> atual);
	abstract public boolean remover(T valor);
}
