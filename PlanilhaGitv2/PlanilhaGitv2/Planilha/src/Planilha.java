public class Planilha {

	private Lista<Celula> planilha;
	private final char VALOR_A_TABELA_ASCII = 'A';

	public Planilha(char ultPosicaoColuna, int tamanhoLinhas) {
		planilha = new Lista<Celula>();

	}

	public Celula getValor(char x, int y) {
		return planilha.get(getPosicao(x), y);
	}

	private Celula getValor(int x, int y) {
		return planilha.get(x, y);
	}

	public void setValor(char x, int y, String formula) {
		//celula pega as coordenadas ,retorna na lista as coordenadas
		Celula cel = getValor(getPosicao(x), y);

		// se a celular estiver vazia
		if (cel == null) {
			
			cel = new Celula();
			//a lista coloca as cordenadas no novonodo e celula Nodo<Celula>
			planilha.set(cel, getPosicao(x), y);
		}
		//formula vai para a classe celula
		cel.setFormula(formula);
	}

	public int getPosicao(char x) {
		//faz o valor na tabela asc de um char menos o `A` resultando a posicao tabela/linha
		return Character.toUpperCase(x) - VALOR_A_TABELA_ASCII;
	}

}
