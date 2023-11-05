package controller;

import javax.swing.JOptionPane;

import br.edu.fatec.zl.Lista;

public class OrdenaController {

	Lista<Integer>[] hashTable = new Lista[5];
	Lista<Integer>[] hashTable2 = new Lista[10];

	public OrdenaController() {
		int tamanho = hashTable.length;
		for (int i = 0; i < tamanho; i++) {
			hashTable[i] = new Lista<Integer>();
		}

		tamanho = hashTable2.length;
		for (int i = 0; i < tamanho; i++) {
			hashTable2[i] = new Lista<Integer>();
		}
	}

	public void carregaHash() {
		for (int i = 0; i < 10; i++) {
			int n = 1;
			Lista<Integer> linha = hashTable2[i];
			while (n != 0) {
				n = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da linha " + i));
				if (n != 0) {
					if (linha.isEmpty()) {
						linha.addFirst(n);
					} else {
						try {
							linha.addLast(n);
						} catch (Exception e) {
							System.err.println(e);
						}
					}
				}
			}
		}
	}

	public void ordenaHash() {
		for (int i = 0; i < 10; i++) {
			Lista<Integer> linha = hashTable2[i];
			int hash = hash(i);
			Lista<Integer> linha2 = hashTable[hash];
			int size = linha.size();
			for (int c = 0; c < size; c++) {
				if (linha2.isEmpty()) {
					try {
						linha2.addFirst(linha.get(c));
					} catch (Exception e) {
						System.err.println(e);
					}
				} else {
					try {
						linha2.addLast(linha.get(c));
					} catch (Exception e) {
						System.err.println(e);
					}
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			Lista<Integer> linha = hashTable[i];
			int size = linha.size();
			System.out.println("Existem " + size + " elementos na posição " + i + ".\nEles são:");
			for (int c = 0; c < size; c++) {
				try {
					System.out.println("#" + linha.get(c));
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}

	}

	private int hash(int n) {
		if (n % 2 == 0) {
			int hash = n / 2;
			return hash;
		} else {
			if (n < 9) {
				int hash = (n / 2) + 1;
				return hash;
			} else {
				int hash = (n / 2);
				return hash;
			}
		}
	}

}
