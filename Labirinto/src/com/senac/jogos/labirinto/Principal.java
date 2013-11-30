package com.senac.jogos.labirinto;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class Principal {
	
	Labirinto labirinto;
	
	public Principal()
	{
		labirinto = new Labirinto();
	}
	public void run()
	{
		String  entra;
		
		Scanner entrada = new Scanner(in);
		
		do 
		{
			out.println("Jogador na sala: " + labirinto.getValorSalaAtual() );
			out.println(labirinto.getSalaAtual().toString());
			out.println("Digite o comando: ");
			entra = entrada.next().toUpperCase();
					//Le o comando
			try
			{
				comando(TipoComando.valueOf(entra));	
			}
			catch(Exception exc)
			{
				out.println("Comando Inv�lido");
			}
		} while (true);	
	}

	
	private void mover()
	{
		Scanner entrada = new Scanner(in);
		out.println("Digite a dire��o: ");
		
		String direcao = entrada.next();
		
		
		Sala salaAtual = labirinto.getSalaAtual();
		
		Sala proximaSala = labirinto.getSala(direcao);

		
		if (salaAtual.getConexao(direcao) == null ){
			out.println("Dire��o inv�lida");
		}
		else
		{
			Conexao conexao = salaAtual.getConexao(direcao);
			int salaConexao = conexao.getSala();
			labirinto.setSalaAtual(String.valueOf(salaConexao));
		}				
		
	}
	
	public void comando(TipoComando comando)
	{
		switch(comando)
		{
			case MOVER:
				mover();
				break;
			case OLHAR:
			case ATACAR:
				
			case PEGAR:
			case LARGAR_CHAVE:
			case LARGAR_ARMA:
			case LARGAR_ARMADURA:
			case SAIR:
				out.println("SAIR");
				System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{	
		new Principal().run();
	}
}
