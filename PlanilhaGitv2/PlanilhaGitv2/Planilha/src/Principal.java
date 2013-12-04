import java.util.Scanner;
import static java.lang.System.*;

public class Principal {
	public static void main(String[] args) {
		Planilha obj = new Planilha('j',100);
		Scanner ler = new Scanner(in);
		String x;
		boolean sair = false;
		
		while(true)
		{
			//digitar ex: c3
			out.println("Celula a ser alterada: ");
			x = ler.next();
			
			if (x.equalsIgnoreCase("sair")) break;
			
			char n1 = Character.toUpperCase(x.charAt(0));
			int n2 = Integer.parseInt(x.substring(1));
			
			Celula valor = obj.getValor(n1,n2);
			//if than else se valor ja tiver algo formula imprime o que ja tem senao imprime vazio
			String formula = valor != null ? valor.getFormula() : "(Vazio)";
			out.println("-- Valor atual da célula "+ x+": "+ formula +"--");
			
			//digitar valor para formula
			out.println("Insira a nova fórumla: "+x+"=");
			x = ler.next();
			//o obj da classe planilha acesrsa o metodo setvalor que pega o c3 e a nova formula
			obj.setValor(n1, n2, x);
			
			if (x.equalsIgnoreCase("sair")) break;
		} 	
		
		out.println("Fim");
	}
	
	
}