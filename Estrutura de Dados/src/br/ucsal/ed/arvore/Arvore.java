package br.ucsal.ed.arvore;

public class Arvore {
	public No raiz;

	public Arvore() {
		raiz = null;

	}

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		String[] info = { "5", "7", "2", "1", "8", "9", "8", "7", "3", "0" };
		// Caso um elemento ja exista, ele pode ser excluido da lista, para apenas
		// conter elementos nao repetidos.
		for (int i = 0; i < 10; i++) {
			boolean inseriu = arvore.inserir(info[i]);
			System.out.println("inseriu " + info[i] + " : " + inseriu);
		}
		System.out.println(arvore.preOrder());
	}
	
	
	
	
	
	

	public String preOrder() {
		No local = raiz;
		String result = raiz.info + " ";
		while (local != null) {
			local = local.esquerda;
			result += local.esquerda.info;
			result += local.direita.info;
			
		}
		 return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	public boolean inserir(String info) {
		// O no local inicia como raiz
		No local = raiz;
		// Cria o no
		No no = new No(info);
		// Se nao existe nenhum elemento na lista, coloca-o como raiz

		if (raiz == null) {
			raiz = no;
			return true;

		}
		// Enquanto local nao for nulo
		while (local != null) {
			// o pai do no vai ser o local
			no.pai = local;
			if (info == local.info) {
				// se ja existir, nao insere e retorna falso
				return false;
			} else if (Integer.parseInt(info) < Integer.parseInt(local.info)) {
				// se for menor que o local, entao eh filho da esquerda
				local = local.esquerda;
				if (local == null) {
					// se ao ir para esquerda for nulo, coloca ali
					no.pai.esquerda = no;
					return true;
				}
			} else {
				// senao eh filho da direita
				local = local.direita;
				if (local == null) {
					// se for para direita e for nulo, coloca o no nesse local
					no.pai.direita = no;
					return true;
				}
			}
		}
		return false;
	}
}
