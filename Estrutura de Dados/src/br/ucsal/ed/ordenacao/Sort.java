package br.ucsal.ed.ordenacao;

public class Sort {
	static int[] x = {7234, 323, 343457, 9, 287};
	int j, eleito, menor, pos, aux;
	
	public static void main(String[] args) {
		Sort ordem = new Sort();
		ordem.quickSort(x, 0, 4);
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
	
//	public static void main(String[] args) {
//		int quantidade = 10;
//		int[] vetor = new int[quantidade];
//
//		for (int i = 0; i < vetor.length; i++) {
//			vetor[i] = (int) (Math.random() * quantidade);
//		}
//		
//		for (int j = 0; j < vetor.length; j++) {
//			System.out.print(vetor[j] + " ");
//		}
//
//		long tempoInicial = System.currentTimeMillis();
//
//		quickSort(vetor, 0, 9);
//
//		long tempoFinal = System.currentTimeMillis();
//
//		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
//		for (int j = 0; j < vetor.length; j++) {
//			System.out.print(vetor[j] + " ");
//		}
//	}
	
	public void insertionSort(int[] x) {
		for (int i = 0; i < x.length; i++) {
			eleito = x[i];
			j = i - 1;
			while (j >= 0 && x[j] > eleito) {
				x[j+1] = x[j];
				j--;
			}
			x[j + 1] = eleito;
		}
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
	
	public void selectionSort(int[] x) {
		for (int i = 0; i < x.length - 1; i++) {
			eleito = x[i];
			menor = x[i + 1];
			pos = i + 1;
			for (int j = i + 1; j < x.length; j++) {
				if (x[j] < menor) {
					menor = x[j];
					pos = j;
				}
			}
			if (menor < eleito) {
				x[i] = x[pos];
				x[pos] = eleito;
			}
		}
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
	
	public void bubbleSort(int[] x) {
		for (int n = 1; n < x.length; n++) {
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i] > x[i + 1]) {
					aux = x[i];
					x[i] = x[i + 1];
					x[i + 1] = aux;
				}
			}
		}
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
	
	public void mergeSort(int[] x, int inicio, int fim) {
		int meio;
		if (inicio < fim) {
			meio = (inicio + fim) / 2;
			mergeSort(x, inicio, meio);
			mergeSort(x, meio + 1, fim);
			// falta o intercala.
		}
	}
	
	public void quickSort(int[] x, int p, int r) {
		int q;
		if (p < r) {
			q = particao(x, p, r);
			quickSort(x, p, q);
			quickSort(x, q + 1, r);
		}
	}

	private int particao(int[] x, int p, int r) {
		int pivo, i, j;
		pivo = x[(p + r) / 2];
		i = p - 1;
		j = r + 1;
		while (i < j) {
			do {
				j = j - 1;
			} while (x[j] > pivo);
			do {
				i = i + 1;
			} while (x[i] < pivo);
			if (i < j) {
				troca(x, i, j);
			}
		}
		return j;
	}

	private void troca(int[] x, int i, int j) {
		int aux;
		aux = x[i];
		x[i] = x[j];
		x[j] = aux;
	}
	
	// Metodo que eu peguei do TED de ED
	public void quickSort2(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort2(vetor, inicio, posicaoPivo - 1);
			quickSort2(vetor, posicaoPivo + 1, fim);
		}
	}

	private int separar(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
	
	
}
