package br.ucsal.ed.fila;


public class Fila {
	No inicio;
	No cabeca;
	int tamanho;

	public static void main(String[] args) {
		Fila f = new Fila();
		f.enqueue("Harrison");
		f.enqueue("Iago");
		f.enqueue("Hamilton");
		f.enqueue("fagner");
//		while (!f.isEmpty()) {
//			System.out.println(f.size());
//			System.out.println(f.dequeue());
//		}
		System.out.println(f.find("Iago"));
		System.out.println(f.index("Hamilton"));
		System.out.println(f.index("Harrison"));
		System.out.println(f.index("fagner"));
		System.out.println(f.index("Iago"));
		
		int[] pilha = {1, 2, 3};
//		arraytest(pilha);
		
		
	}
//	Teste
//	public static int arraytest(int[] pilha) {
//		int resultado = pilha[0];
//		pilha[pilha.length-1];
//		return resultado;
//	}

	public Fila() {
		inicio = null;
		cabeca = null;
		tamanho = 0;
	}

	public int size() {
		return tamanho;
	}
	
	public void invert() {
		No local = inicio;
		for (int i = tamanho; i != 0; i--) {
			System.out.println(local.info);
			local = local.proximo;
		}
	}

	public String find(String nome) {
		String str = null;
		No local = inicio;
		while (local != null) {
			str += local.info;
			local = local.proximo;
		}
		if (str.contains(nome)) {
			str = "Esse nome está na fila.";
		} else {
			str = "Esse nome não está na fila.";
		}
		return str;
	}
	
	public int index(String nome) {
		String str = null;
		int cont = tamanho;
		No local = inicio;
		while (cont > 0) {
			str = local.info;
			if (str.contains(nome)) {
				return cont;
			}
			cont--;
			local = local.proximo;
		}
		if (cont == 0) {
			System.out.println("Elemento não encontrado na fila.");
		}
		return 0;
	}

	public String front() {
		if (cabeca == null) {
			return null;

		}
		return cabeca.info;
	}

	public boolean isEmpty() {
		return inicio == null;
	}

	public void enqueue(String info) {
		No no = new No();
		no.info = info;
		no.proximo = inicio;
		inicio = no;
		if (tamanho == 0) {
			// Lista vazia
			cabeca = no;

		}
		tamanho++;
	}

	public String dequeue() {
		if (isEmpty()) {
			return null;

		}
		String info = cabeca.info;
		if (tamanho == 1) {
			inicio = null;
			cabeca = null;
		} else {
			No local = inicio;
			while (local.proximo != cabeca) {
				local = local.proximo;

			}
			cabeca = local;
			cabeca.proximo = null;
		}
		tamanho--;
		return info;
	}
}
