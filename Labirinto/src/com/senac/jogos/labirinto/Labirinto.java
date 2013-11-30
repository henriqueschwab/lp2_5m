package com.senac.jogos.labirinto;

import static java.lang.System.*;

import java.io.FileInputStream;
import java.util.Scanner;

public class Labirinto {
	
	private static final Scanner teclado = new Scanner(System.in);
	
	private Sala[] salas;
	private int countSalas = 0;
	private int salaAtual;
	
	
	public Labirinto()
	{
		run();
	}
	
	private void run()
	{
		inicializaLabirinto();
		
		out.println(salas[salaAtual]);
		
		/*
		while (! isGameOver()) {
		 
			exibeStatus();
			executaComando ( teclado.next() );
		}
		*/
	}
	
	private void inicializaLabirinto()
	{
		salas = new Sala[50];
		salas[0] = new Sala();
		try {
			leLabirinto( new Scanner( new FileInputStream("labirinto.txt") ) );
			salaAtual = getSalaRandomica();
		} catch (Exception e) {
			err.println(e.getMessage());
			exit(1);
		}
	}
	
	private int getSalaRandomica(){
		return (int) (countSalas * (Math.random()));
	}

	private void leLabirinto( Scanner arquivo ) throws Exception
	{
		String cmd = arquivo.next().toLowerCase();
		while (cmd.equals("room")) {
			int salaId = arquivo.nextInt();
			salas[salaId] = new Sala();
			Sala sala = salas[salaId];
			
			countSalas++;
			String direcao = arquivo.next();

			do {
				if (arquivo.hasNextInt()) {
					salaId = arquivo.nextInt();
				} else if (arquivo.next().equalsIgnoreCase("EXIT")) {
					salaId = 0;
				} else break;
			
				sala.addConexao(direcao, salaId);
			
				if (!arquivo.hasNext())
					return;
				cmd = arquivo.next().toLowerCase();	
				if (cmd.equals("trap")) {
					sala.setArmadilha(direcao);
					if (!arquivo.hasNext())
						return;
					cmd = arquivo.next();
				}
				direcao = cmd;
			} while (!cmd.equals("room"));
		}
		throw new Exception("Arquivo de descricao do labirinto invalido.");
	}

	public Sala getSalaAtual()
	{
		return salas[salaAtual];
	}
	
	public int getValorSalaAtual()
	{
		return salaAtual;
	}

	public boolean temConexaoPara(String sala)
	{
		return getSalaAtual() == null;
	}
	
	public Sala getSala(String direcao)
	{
		Sala sala = null;
		try {
			sala = salas[Sala.getDirecaoIndex(direcao)];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sala;
	}
	

	public void setSalaAtual(String direcao)
	{
		this.salaAtual =  Integer.parseInt(direcao);
	}
	

}
