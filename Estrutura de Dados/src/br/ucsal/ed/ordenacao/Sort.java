package br.ucsal.ed.ordenacao;

public class Sort {
	static int[] x = {7234, 323, 34345756, 9, 287};
	int j, eleito, menor, pos, aux;
	
	public static void main(String[] args) {
		Sort ordem = new Sort();
		ordem.bubbleSort(x);
	}
	
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
}
