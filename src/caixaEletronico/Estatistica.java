package caixaEletronico;

import javax.swing.JOptionPane;

public class Estatistica {
	CadastrarCli cliente = new CadastrarCli();
	int itau = cliente.getItau();
	int santander = cliente.getSantander();
	int bradesco = cliente.getBradesco();
	int hsbc = cliente.getHsbc();
	String bancoMaiorSaque;
	String bancoMenorSaque;
	double media;
	
	
	public void maiorSaque(){
		
		if(itau > santander && itau > bradesco && itau > hsbc){
			bancoMaiorSaque = "Itaú";
		}
		else if(santander > itau && santander > bradesco && santander > hsbc){
			bancoMaiorSaque = "Santander";
		}
		else if(bradesco > santander && itau < bradesco && bradesco > hsbc){
			bancoMaiorSaque = "Bradesco";
		}
		else if(hsbc > santander && hsbc > bradesco && itau < hsbc){
			bancoMaiorSaque = "HSBC";
		}	
		else {
			bancoMaiorSaque = "Iguais";
		}
	}
	
	public void menorSaque(){
		
		if(itau < santander && itau < bradesco && itau < hsbc){
			bancoMenorSaque = "Itaú";
		}
		else if(santander < itau && santander < bradesco && santander < hsbc){
			bancoMenorSaque = "Santander";
		}
		else if(bradesco < santander && itau < bradesco && bradesco < hsbc){
			bancoMenorSaque = "Bradesco";
		}
		else if(hsbc < santander && hsbc < bradesco && itau < hsbc){
			bancoMenorSaque = "HSBC";
		}	
		else {
			bancoMenorSaque = "Iguais";
		}
	}
	
	public void mediaGeral(){
		int mediaGeral = (itau + santander + bradesco + hsbc)/4;
		media = (double) mediaGeral;
		
	}
	
	public void estatisticaRealizada() {
		JOptionPane.showMessageDialog(null, 
				"------------------------ Estatística ---------------------------  "
				+"\n\n O Banco com maior número de saques foi: \n" + bancoMaiorSaque
				+"\n\n O Banco de menor saque foi: \n" + bancoMenorSaque
				+"\n\n A Média Geral de saques realizados: \n" + media
				+"\n\n\n O Banco para você!   :)\n\n");
	}
}
