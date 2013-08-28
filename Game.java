import java.util.Scanner;

public class Game {
	private int tamanho = 10;
	private int TAM = 6;
	private int posicao = 0;
	private int mapa[] = new int[tamanho];
	private int extra = 4;

	public void avancar() {
		if (posicao == 0 && TAM > 0 && posicao < tamanho) {
			posicao++;
			mapa[posicao] = TAM;
			mostramapa();
			jogoAcabou();
		} else if (posicao > 0 && TAM > 0 && posicao < tamanho) {
			TAM--;
			posicao++;
			mapa[posicao] = TAM;
			mostramapa();
			jogoAcabou();
		}

	}

	public void retornar() {

		if (posicao == 0) {
			System.out.println("Nao e possivel retornar");
		} else if (posicao >= 1 && TAM > 0 && posicao <= tamanho) {
			TAM--;
			posicao--;
			mapa[posicao] = TAM;
			mostramapa();
			jogoAcabou();
		}
	}

	public void abastecer() {
		if (extra > 0) {
			extra--;
			TAM++;
			mapa[posicao] = TAM;
			mostramapa();
		} else {
			System.out.println("Nao ha mais como abastecer");
		}
	}

	public void descarregar() {
		TAM--;
		mapa[posicao] = TAM;
		mostramapa();
		jogoAcabou();
	}

	public boolean jogoAcabou() {
		boolean jogo = false;
		if (TAM == 0) {
			jogo = true;
			System.out.println("G A M E  O V E R");
			System.exit(0);
		}

		if (posicao >= 9) {
			jogo = true;
			System.out.println("YOU WIN!");
			System.exit(0);
		}
		return jogo;
	}

	public void acao() {
		Scanner entra = new Scanner(System.in);
		do {
			String opc;
			System.out
					.println("Voce pode avancar, retornar, abastecer e/ou descarregar. Se voce ficar sem combustivel ou chegar ao fim do caminho o jogo acaba, nao esqueca de abastecer!");
			opc = entra.next();

			switch (opc) {
			case "avancar":
				avancar();
				break;
			case "retornar":
				retornar();
				break;
			case "abastecer":
				abastecer();
				break;
			case "descarregar":
				descarregar();
				break;
			default:
				System.out.println("Invalido");
				break;
			}
		} while (!jogoAcabou());

	}

	public void mostramapa() {
		String mostra = "";
		for (int i = 0; i < mapa.length; i++) {
			mostra = mostra + " " + mapa[i];
		}
		System.out.println(mostra);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.acao();
	}
}
