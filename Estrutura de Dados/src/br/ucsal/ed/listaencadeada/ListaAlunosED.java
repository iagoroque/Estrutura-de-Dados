package br.ucsal.ed.listaencadeada;

import java.util.Scanner;

public class ListaAlunosED {
	No inicio = null;
	int tamanho = 0;

	public static void main(String[] args) {
		ListaAlunosED lista = new ListaAlunosED();
		listaDosNomes(lista);
		System.out.println(lista);
		
		lista.retirarIndice(5);
		System.out.println("Removendo o 5º registro da lista\n" + lista);

		Scanner in = new Scanner(System.in);
		System.out.print("Digite um nome para verificar se ele está na lista: ");
		String nome = in.nextLine().toUpperCase();
		System.out.println(lista.pesquisarNome(nome));
		in.close();
	}

	private static void listaDosNomes(ListaAlunosED lista) {
		lista.inserirInicio("PROFESSOR HAMILTON BATISTA LIMA SOBRINHO");
		lista.inserirFim("LUIZ ALBERTO");
		lista.inserirFim("MARCO ANTONIO");
		lista.inserirFim("HENRIQUE ARAUJO");
		lista.inserirFim("MATHEUS BARRETO");
		lista.inserirFim("HARRISON BORGES");
		lista.inserirFim("MARCOS CARVALHO");
		lista.inserirFim("IAGO ROQUE");
		lista.inserirFim("GUILHERME DA SILVA");
		lista.inserirFim("NEILLANE DE CARVALHO");
		lista.inserirFim("GUILHERME DE JESUS");
		lista.inserirFim("LUCAS FARIAS");
		lista.inserirFim("LUCAS GOMES");
		lista.inserirFim("OSEIAS LOPES");
		lista.inserirFim("PEDRO LUIZ");
		lista.inserirFim("JOAO MARCOS");
		lista.inserirFim("LUCAS MORENO");
		lista.inserirFim("GABRIELA SANTOS");
		lista.inserirFim("GUILHERME SANTOS");
		lista.inserirFim("KEVIN VASQUES");
	}

	public String pesquisarNome(String nome) {
		String str = null;
		No local = inicio;
		while (local != null) {
			str += local.info;
			local = local.proximo;
		}
		if (str.contains(nome)) {
			str = "Esse nome está na lista.";
		} else {
			str = "Esse nome não está na lista.";
		}
		return str;
	}

	public void inserirInicio(String info) {
		No no = new No();
		no.info = info;
		no.proximo = inicio;
		inicio = no;
		tamanho++;
	}

	public String retirarInicio() {
		if (inicio == null) {
			return null;
		}
		String info = inicio.info;
		inicio = inicio.proximo;
		tamanho--;
		return info;
	}

	public void inserirIndice(int indice, String info) {
		if (indice <= 0) {
			inserirInicio(info);
		} else if (indice >= tamanho) {
			inserirFim(info);
		} else {
			No local = inicio;
			for (int i = 0; i < indice - 1; i++) {
				local = local.proximo;
			}
			No no = new No();
			no.info = info;
			no.proximo = local.proximo;
			local.proximo = no;
			tamanho++;
		}
	}

	public String retirarIndice(int indice) {
		if (indice < 0 || indice >= tamanho || inicio == null) {
			return null;
		} else if (indice == 0) {
			return retirarInicio();
		} else if (indice == tamanho - 1) {
			return retirarFim();
		}
		No local = inicio;
		for (int i = 0; i < indice - 1; i++) {
			local = local.proximo;
		}
		String info = local.proximo.info;
		local.proximo = local.proximo.proximo;
		tamanho--;
		return info;
	}

	public void inserirFim(String info) {
		No no = new No();
		no.info = info;
		if (inicio == null) {
			no.proximo = null;
			inicio = no;
		} else {
			No local = inicio;
			while (local.proximo != null) {
				local = local.proximo;
			}
			local.proximo = no;
			no.proximo = null;
		}
		tamanho++;
	}

	public String retirarFim() {
		if (inicio == null) {
			return null;
		}
		No local = inicio;
		while (local.proximo != null) {
			No aux = local;
			local = local.proximo;
			if (local.proximo == null) {
				aux.proximo = null;
				tamanho--;
				return local.info;
			}
		}
		inicio = null;
		tamanho--;
		return local.info;
	}

	@Override
	public String toString() {
		String str = "Tamanho da Lista: " + tamanho + "\n";
		No local = inicio;
		while (local != null) {
			str += local.info + "\n";
			local = local.proximo;
		}
		return str;
	}
}
