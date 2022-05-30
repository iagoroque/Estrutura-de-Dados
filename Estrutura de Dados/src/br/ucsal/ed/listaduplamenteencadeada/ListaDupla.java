package br.ucsal.ed.listaduplamenteencadeada;

public class ListaDupla {
	No inicio;
	No fim;
	int tamanho;

	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();
		lista.inserirInicio("Iago");
		lista.inserirInicio("Marcos");

		for (int i = 0; i < 6; i++) {
			lista.inserirInicio("" + (char) (i + 97));
		}
		System.out.println(lista);

		lista.inserirMeio(1, "i");
		System.out.println(lista);

		System.out.println("Retirei :" + lista.retirarMeio(4));
		System.out.println(lista);

		while (lista.retirarFim() != null) {
			System.out.println(lista);
		}
	}

	public void inserirInicio(String info) {
		No no = new No(); 			// Instancio um novo n�
		no.info = info; 			// Atribui o valor ao n�
		no.anterior = null; 		// Atribui o valor null ao ponteiro anterior do n�
		no.proximo = inicio; 		// Faz o ponteiro proximo apontar para o inicio
		if (inicio != null) {
			inicio.anterior = no; 	// Se inicio for diferente de null, o ponteiro anterior de inicio aponta para no
		}
		inicio = no; 				// Inicio recebe o no
		if (tamanho == 0) {
			fim = inicio; 			// Se o tamanho da lista for igual a 0, fim recebe/aponta para inicio
		}
		tamanho++; 					// Incremento o tamanho da lista em mais 1
	}

	public void inserirMeio(int indice, String info) {
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
			no.anterior = local;
			no.proximo = local.proximo;
			local.proximo = no;
			no.proximo.anterior = no;
			tamanho++;
		}
	}

	public void inserirFim(String info) {
		No no = new No();
		no.info = info;
		no.proximo = null;
		no.anterior = fim;
		if (fim != null) {
			fim.proximo = no;
		}
		fim = no;
		if (tamanho == 0) {
			inicio = fim;
		}
		tamanho++;
	}

	public String retirarInicio() {
		if (inicio == null) {
			return null;
		}
		String out = inicio.info;
		inicio = inicio.proximo;
		if (inicio != null) {
			inicio.anterior = null;
		} else {
			fim = null;
		}
		tamanho--;
		return out;
	}

	public String retirarMeio(int indice) {
		if (indice < 0 || indice >= tamanho || inicio == null) {
			return null;
		} else if (indice == 0) {
			return retirarInicio();
		} else if (indice == tamanho - 1) {
			return retirarFim();
		}
		No local = inicio;
		for (int i = 0; i < indice; i++) {
			local = local.proximo;
		}
		if (local.anterior != null) {
			local.anterior.proximo = local.proximo;
		}
		if (local.proximo != null) {
			local.proximo.anterior = local.anterior;
		}
		tamanho--;
		return local.info;
	}

	public String retirarFim() {
		if (fim == null) {
			return null;
		}
		String out = fim.info;
		fim = fim.anterior;
		if (fim != null) {
			fim.proximo = null;
		} else {
			inicio = null;
		}
		tamanho--;
		return out;
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
