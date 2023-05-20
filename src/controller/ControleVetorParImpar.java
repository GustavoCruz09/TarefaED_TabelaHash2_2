package controller;

import javax.swing.JOptionPane;

import GustavoCruz.ListaSObject.Lista;

public class ControleVetorParImpar {

	Lista[] vtlista;

	public ControleVetorParImpar() {
		vtlista = new Lista[2];
		for (int i = 0; i < 2; i++) {
			vtlista[i] = new Lista();
		}
	}

	public void PreencheVetor() {
		int tam = (int) (Math.random() * 10) + 1; // Tamanho Vetor
		for (int i = 0; i < tam; i++) {
			int valor = (int) (Math.random() * 20);
			int pos = HashCode(valor);
			if (vtlista[pos].isEmpty()) {
				vtlista[pos].addFirst(valor);
			} else {
				try {
					vtlista[pos].addLast(valor);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		MostraVetores();
	}

	private int HashCode(int valor) {
		return valor % 2;
	}

	private void MostraVetores() {
		int num = 0;

		do {

			num = Integer.parseInt(JOptionPane
					.showInputDialog("QUAL VETOR QUERES MOSTRAR?\n 0 - Par\n 1 - Impar\n 9 Finaliza Programa"));

			switch (num) {
			case 0:
				System.out.println("Vetor de Pares");
				int tam = vtlista[0].size();
				for (int i = 0; i < tam; i++) {
					try {
						System.out.print(vtlista[0].get(i) + " ");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.print("\n\n");
				break;
			case 1:
				System.out.println("Vetor de Impares");
				tam = vtlista[1].size();
				for (int i = 0; i < tam; i++) {
					try {
						System.out.print(vtlista[1].get(i) + " ");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.print("\n\n");
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida Digite Novamente", "ERRO", JOptionPane.ERROR_MESSAGE);

			}

		} while (num != 9);
	}

}
