public class Nodo<T> {

	//nodo guarda os elementos da lista
	
	private int posicaoLinha;
	private int posicaoColuna;

	private Nodo<T> nodoProximo;
	private Nodo<T> nodoAnterior;

	private T celula;

	public Nodo() {

	}

	
	public Nodo(int posLinha, int posColuna) {
		posicaoLinha = posLinha;
		posicaoColuna = posColuna;
	}

	public void setProximo(Nodo<T> nodo) {
		nodoProximo = nodo;
	}

	public void setAnterior(Nodo<T> nodo) {
		nodoAnterior = nodo;
	}

	public int getLinha() {
		return posicaoLinha;
	}

	public int getColuna() {
		return posicaoColuna;
	}

	public Nodo<T> getProximo() {
		return nodoProximo;
	}

	public T getCelula() {
		return celula;
	}

	public void setCelula(T celula) {
		this.celula = celula;
	}
}
