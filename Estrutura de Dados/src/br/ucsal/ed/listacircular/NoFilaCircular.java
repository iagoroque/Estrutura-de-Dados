package br.ucsal.ed.listacircular;

public class NoFilaCircular {

	public NoFilaCircular proximo;
	public int dado;

	public void NoFilaCircular(int dado){
		this.proximo = null;
		this.dado = dado;
	}
}
