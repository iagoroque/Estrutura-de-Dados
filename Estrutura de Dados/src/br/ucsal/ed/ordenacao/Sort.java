package br.ucsal.ed.ordenacao;

public class Sort {
	static int[] x = {7234, 323, 34345756, 9, 287, 4545, 445, 6, 8232, 10434};
	int j, eleito, menor, pos;
	
	public static void main(String[] args) {
		Sort ordem = new Sort();
		ordem.selectionSort(x);
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
}
