package br.ucsal.ed.arvore;

public class No {
	public No pai;
	public No esquerda;
	public No direita;
	public String info;

	public No(String info) {
		pai = null;
		esquerda = null;
		direita = null;
		this.info = info;
	}
}
