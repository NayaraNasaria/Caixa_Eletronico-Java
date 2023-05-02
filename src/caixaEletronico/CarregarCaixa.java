package caixaEletronico;

import javax.swing.JOptionPane;

public class CarregarCaixa {
	static int nota2;
	static int nota5;
	static int nota10;
	static int nota20;
	static int nota50;
	static int nota100;
	
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		CarregarCaixa.nota2 = nota2;
	}
	public int getNota5() {
		return nota5;
	}
	public void setNota5(int nota5) {
		CarregarCaixa.nota5 = nota5;
	}
	public int getNota10() {
		return nota10;
	}
	public void setNota10(int nota10) {
		CarregarCaixa.nota10 = nota10;
	}
	public int getNota20() {
		return nota20;
	}
	public void setNota20(int nota20) {
		CarregarCaixa.nota20 = nota20;
	}
	public int getNota50() {
		return nota50;
	}
	public void setNota50(int nota50) {
		CarregarCaixa.nota50 = nota50;
	}
	public int getNota100() {
		return nota100;
	}
	public void setNota100(int nota100) {
		CarregarCaixa.nota100 = nota100;
	}
	
	public void carregarCaixa() {
		nota2 = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas de 2 há?"));
		nota5 = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas de 5 há?"));
		nota10 = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas de 10 há?"));
		nota20 = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas de 20 há?"));
		nota50 = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas de 50 há?"));
		nota100 = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas de 100 há?"));	
	}

	public void confirmarCaixa() {
		
		int confirmar = Integer.parseInt(JOptionPane.showInputDialog(
				"Notas de 2: " + getNota2()
				+ "\nNotas de 5: " + getNota5() + "\nNotas de 10: " + getNota10()
				+ "\nNotas de 20: " + getNota20() + "\nNotas de 50: " + getNota50()
				+ "\nNotas de 100: " + getNota100() + "\n\n"
				+ "(1) Confirmar                                   (2) Editar  \n\n"));
		
		switch (confirmar) {
		case 1:
			JOptionPane.showMessageDialog(null, "Caixa Carregada com Sucesso!");
		break;
		case 2:
			carregarCaixa();
		break;
		}
	}
}
	
