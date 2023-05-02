package caixaEletronico;

import javax.swing.JOptionPane;


public class Saque {
	CadastrarCli cadastrarCli = new CadastrarCli();
	CarregarCaixa carregarCaixa = new CarregarCaixa();
	
	int contNota100 = 0;
	int contNota50 = 0;
	int contNota20 = 0;
	int contNota10 = 0;
	int contNota5 = 0;
	int contNota2 = 0;
    boolean verificacao = false;
	int saque = 0;
	
	public int getSaque() {
		return saque;
	}

	public void setSaque(int saque) {
		this.saque = saque;
	}

	public boolean isVerificacao() {
		return verificacao;
	}

	public void setVerificacao(boolean verificacao) {
		this.verificacao = verificacao;
	}

	public void sacar() {
		saque = Integer.parseInt(JOptionPane.showInputDialog(
				
				"\nNotas Disponíveis de 100: "+ carregarCaixa.getNota100()+
				"\nNotas Disponíveis de 50: "+ carregarCaixa.getNota50()+
				"\nNotas Disponíveis de 20: "+ carregarCaixa.getNota20()+
				"\nNotas Disponíveis de 10: "+ carregarCaixa.getNota10()+
				"\nNotas Disponíveis de 5: "+ carregarCaixa.getNota5()+
				"\nNotas Disponíveis de 2: "+ carregarCaixa.getNota2() +
				"\nQuanto Você Gostaria de Sacar?"));
		 
		if(saque < 2) {
				JOptionPane.showMessageDialog(null, "Você não pode sacar menos de 2 reais");
		
		}else {
			validarNotas();
			
			if(verificacao == true) {
				atualizarNotas();
			}else {
				JOptionPane.showMessageDialog(null, "Não é possível sacar!\nTente novamente outro dia.");
			}
		} 
	}
	
	public void validarNotas() {
		int centenas  = saque / 100;
		int dezenas = (saque%100) / 10;
		int unidades = ((saque%100)%10);
		
		if(centenas >= 1) {
			if(carregarCaixa.getNota100() == 0) {
				if(carregarCaixa.getNota50() == 0 && carregarCaixa.getNota20() > 4) {
					contNota20 = contNota20 + ((centenas*100)/20);
					verificacao = true;
				}else {
					contNota50 = contNota50 + ((centenas*100)/50);
					verificacao = true;
				}
			}
			contNota100 = (centenas*100)/100;
			verificacao = true;
		}
			
		if(dezenas >= 1 && carregarCaixa.getNota10() != 0) {
			if(dezenas % 2 == 0 && dezenas >= 2){
				contNota20 = contNota20 + (dezenas*10)/20;
				verificacao = true;
				
			}
			
			if(dezenas == 5) {
				if(carregarCaixa.getNota50() == 0) {
					contNota20 = contNota20 + 2;
					contNota10 = contNota10 + 1;
					verificacao = true;
				}else {
					contNota50++;
					verificacao = true;
				}	
			}
			if(dezenas == 1 || (carregarCaixa.getNota50() == 0 && carregarCaixa.getNota20() == 0)) {
				contNota10 = contNota10 + dezenas;
				verificacao = true;
			}
			
		}else if(dezenas != 0) {
			if(carregarCaixa.getNota5() > 1) {
				contNota5 = contNota5 + 2;
				verificacao = true;
			}else {
				if(carregarCaixa.getNota2() > 4) {
					contNota2 = contNota2 + 5;
					verificacao = true;
				}
			}
		}
		
		if(unidades >= 2) {
			if(unidades == 5 && carregarCaixa.getNota5() != 0) {
				contNota5++;
				verificacao = true;
			}
			if(unidades == 7 && carregarCaixa.getNota2() != 0){
				contNota5++;
				contNota2++;
				verificacao = true;
				
			}
			if(unidades == 9 && carregarCaixa.getNota2() != 0) {
				contNota5++;
				contNota2 = contNota2 + 2;
				verificacao = true;
				
			}
			else {
				if(unidades % 2 == 0 && carregarCaixa.getNota2() != 0) {
					contNota2 = contNota2 + (unidades/2);
					verificacao = true;
				}
			}
			
		}else if(carregarCaixa.getNota2() == 0 && carregarCaixa.getNota5() == 0 && carregarCaixa.getNota10() == 0 && carregarCaixa.getNota20() == 0 && carregarCaixa.getNota50() == 0 && carregarCaixa.getNota100() == 0) {
			JOptionPane.showMessageDialog(null, "Não é possível sacar!\nNotas Insuficientes!\nTente novamente outro dia.");
			verificacao = false;
		}
}
	
	public void atualizarNotas() {
		if(contNota2 == 0) {
			carregarCaixa.setNota2(carregarCaixa.getNota2());
		}else {
			int novasNotas2 = carregarCaixa.getNota2() - contNota2;
			if(novasNotas2 < 0) {
				carregarCaixa.setNota2(0);
			}else {
				carregarCaixa.setNota2(novasNotas2);
			}
		}
		
		if(contNota5 == 0) {
			carregarCaixa.setNota5(carregarCaixa.getNota5());
		}else {
			int novasNotas5 = carregarCaixa.getNota5() - contNota5;
			
			
			if(novasNotas5 < 0) {
				carregarCaixa.setNota5(0);
			}else {
				carregarCaixa.setNota5(novasNotas5);
			}
		}
		
		if(contNota10 == 0) {
			carregarCaixa.setNota10(carregarCaixa.getNota10());
		}else {
			int novasNotas10 = carregarCaixa.getNota10() - contNota10;
			if(novasNotas10 < 0) {
				carregarCaixa.setNota10(0);
			}else {
				carregarCaixa.setNota10(novasNotas10);
			}
		}
		
		if(contNota20 == 0) {
			carregarCaixa.setNota20(carregarCaixa.getNota20());
		}else {
			int novasNotas20 = carregarCaixa.getNota20() - contNota20;
			if(novasNotas20 < 0) {
				carregarCaixa.setNota20(0);
			}else {
				carregarCaixa.setNota20(novasNotas20);
			}
		}
		
		if(contNota50 == 0) {
			carregarCaixa.setNota50(carregarCaixa.getNota50());
		}else {
			int novasNotas50 = carregarCaixa.getNota50() - contNota50;
			if(novasNotas50 < 0) {
				carregarCaixa.setNota50(0);
			}else {
				carregarCaixa.setNota50(novasNotas50);
			}
		}
		
		if(contNota100 == 0) {
			carregarCaixa.setNota100(carregarCaixa.getNota100());
		}else {
			int novasNotas100 = carregarCaixa.getNota100() - contNota100;
			if(novasNotas100 < 0) {
				carregarCaixa.setNota100(0);
			}else {
				carregarCaixa.setNota100(novasNotas100);
			}
		}
		
	}
	

}	
