public class Lista<T> {

	private Nodo<T> primeiro;
	private Nodo<T> ultimo;

	public Lista() {
		primeiro = null;
		ultimo = primeiro;
	}

	public void set(T n, int linha, int coluna) {
		//Nodo<Celula>
		Nodo<T> novoNodo = new Nodo<T>(linha, coluna);
		novoNodo.setProximo(null);
		novoNodo.setAnterior(ultimo);
		novoNodo.setCelula(n);
 
		//se o nodo ultimo ja estiver com algo o proximo recebe o novonodo
		if (ultimo != null) {
			ultimo.setProximo(novoNodo);
		}

		//se o primeiro novo for null, o primeiro recebe o novonodo e o ultimo recebe o novonodo tambem
		if (primeiro == null)
			primeiro = novoNodo;
		ultimo = novoNodo;

	}

	//generics t, pega, linha e coluna
	public T get(int linha, int coluna) {
		Nodo<T> n = primeiro;
		//
		while (n != null) {
			if (n.getLinha() == linha && n.getColuna() == coluna) {
				return n.getCelula();
			}
			n = n.getProximo();
		}
		return null;
	}

}
