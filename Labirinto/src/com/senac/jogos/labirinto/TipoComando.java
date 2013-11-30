package com.senac.jogos.labirinto;

public enum TipoComando {
	MOVER("Mover"), OLHAR("Olhar"), ATACAR("Atacar"), PEGAR("Pegar"), LARGAR_CHAVE(
			"Largar Chave"), LARGAR_ARMA("Largar Arma"), LARGAR_ARMADURA(
			"Largar Armadura"), SAIR("Sair");
	private TipoComando(String nome) {
		this.nome = nome;
	}

	private String nome;

	public String getNome() {
		return nome;
	}
}