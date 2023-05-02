package caixaEletronico;

import javax.swing.JOptionPane;

public class Menu {
				
public static void main(String[] args) {
		
		int opcao = 0;
		
		do { 
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" Bem Vindo ao seu Caixa Eletrônico "
					+ "\n\n Cadastrar Clientes (1) "
					+ "\n Consultar Conta (2)"
					+ "\n Carregar Caixa (3)"
					+ "\n Saque (4)"
					+ "\n Estatística (5)"
					+ "\n Finalizar Operação (6)\n\n"));
			executando(opcao); 
				
		}while(opcao != 6);	
		
	}
	
	public static void executando(int opcao) {
		
		String senhaAdm = "adm";
		String senha;
		int tentativas = 0;
		

			switch (opcao) {

			case 1:
				senha = JOptionPane.showInputDialog("Digite a senha de administrador");
				
				while(tentativas <= 3) {
					if(senha.equals(senhaAdm)) {
						CadastrarCli cadcli = new CadastrarCli();
						cadcli.cadastrar();
						cadcli.exibirDados();	
						
					break;
					}
					else {
						tentativas++;
						senha = JOptionPane.showInputDialog("Digite a senha de administrador novamente");
					}
				}
			break;

			case 2:
				senha = JOptionPane.showInputDialog("Digite a senha de administrador");
				
				while(tentativas <= 3) {
					if(senha.equals(senhaAdm)) {
						CadastrarCli cadcli = new CadastrarCli();
						
						cadcli.acessarConta();
						break;
					}
					else {
						tentativas++;
						senha = JOptionPane.showInputDialog("Digite a senha de administrador novamente");
					}
				}
			break;

			case 3:
				senha = JOptionPane.showInputDialog("Digite a senha de administrador");
				
				while(tentativas <= 3) {
					if(senha.equals(senhaAdm)) {
						CarregarCaixa carregarCaixa = new CarregarCaixa();
						carregarCaixa.carregarCaixa();
						carregarCaixa.confirmarCaixa();
						break;
					}
					else {
						tentativas++;
						senha = JOptionPane.showInputDialog("Digite a senha de administrador novamente");
					}
				}
			break;
			
			case 4:
				CadastrarCli cadcli = new CadastrarCli();
				cadcli.acessarSaque();
				break;
				
			case 5:
				
				senha = JOptionPane.showInputDialog("Digite a senha de administrador");
				
				while(tentativas <= 3) {
					if(senha.equals(senhaAdm)) {
						Estatistica estatistica = new Estatistica();
						estatistica.maiorSaque();
						estatistica.menorSaque();
						estatistica.mediaGeral();
						estatistica.estatisticaRealizada();
						break;
					}
					else {
						tentativas++;
						senha = JOptionPane.showInputDialog("Digite a senha de administrador novamente");
					}
				}
				break;

			default:
				return;
			}
	}

}
		
		
	


