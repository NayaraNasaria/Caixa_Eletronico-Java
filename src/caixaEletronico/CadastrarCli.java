package caixaEletronico;

import javax.swing.JOptionPane;

public class CadastrarCli {
	static Cliente[] cliente = new Cliente[10];
	Cliente c = new Cliente();
	static int contCad = 0;
	int tentativaCli = 0;
	int saldoCliente = 0;
	static int bancoCliente = 0;
	static int itau;
	static int santander;
	static int bradesco;
	static int hsbc;
	
	public int getItau() {
		return itau;
	}

	public void setItau(int itau) {
		CadastrarCli.itau = itau;
	}

	public int getSantander() {
		return santander;
	}

	public void setSantander(int santander) {
		CadastrarCli.santander = santander;
	}

	public int getBradesco() {
		return bradesco;
	}

	public void setBradesco(int bradesco) {
		CadastrarCli.bradesco = bradesco;
	}

	public int getHsbc() {
		return hsbc;
	}

	public void setHsbc(int hsbc) {
		CadastrarCli.hsbc = hsbc;
	}

	public int getSaldoCliente() {
		return saldoCliente;
	}

	public void setSaldoCliente(int saldoCliente) {
		this.saldoCliente = saldoCliente;
	}

	public int getBancoCliente() {
		return bancoCliente;
	}

	public void setBancoCliente(int bancoCliente) {
		CadastrarCli.bancoCliente = bancoCliente;
	}

	public void cadastrar() {
		String nome = JOptionPane.showInputDialog("Digite o nome do cliente");
		String senhaCli = JOptionPane.showInputDialog("Digite uma senha");
		String rg = JOptionPane.showInputDialog("Digite o RG");
		String cpf = JOptionPane.showInputDialog("Digite o CPF");
		String endereco = JOptionPane.showInputDialog("Digite o endereço");
		int telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone"));
		int banco = Integer.parseInt(JOptionPane.showInputDialog(" Itaú (1)"
				+ "\n Santander (2)"
				+ "\n Bradesco (3)"
				+ "\n HSBC (4)"));
		int conta = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta"));
		int saldo = Integer.parseInt(JOptionPane.showInputDialog("Aceitamos somente Valores inteiros.\nDigite o Saldo:"));
		
		Cliente newCli = new Cliente(nome, rg, cpf, endereco, telefone, banco, conta, senhaCli, saldo);
		cliente[contCad] = newCli;	
		
		for(int i = 0; i < cliente.length; i++){
			if(cliente[i] != null) {
				System.out.println("Nome do cliente: " +cliente[i].getNome());
				System.out.println("Valor do contador: " + contCad);
			}
		}
		
		contCad++;			
      }

	public void exibirDados() {
		String nomeBanco = null;
		
	            	switch(cliente[contCad-1].getBanco()) {
	        		case 1:
	        			nomeBanco = "Itaú";
	        		break;
	        		case 2:
	        			nomeBanco = "Santander";
	        		break;
	        		case 3:
	        			nomeBanco = "Bradesco";
	        		break;
	        		case 4:
	        			nomeBanco = "HSBC";
	        		break;
	        		}
	        		
	        		JOptionPane.showMessageDialog(null,"Nome: " + cliente[contCad-1].getNome()
	        		+ "\nSenha: " + cliente[contCad-1].getSenhaCli() + "\nCPF: " + cliente[contCad-1].getCpf()
	        		+ "\nEndereço: " + cliente[contCad-1].getEndereco() + "\nTelefone: " + cliente[contCad-1].getTelefone()
	        		+ "\nBanco: " + nomeBanco + "\nConta: " + cliente[contCad-1].getConta()
	        		+ "\nSaldo: " + cliente[contCad-1].getSaldo()+ "\n");
	        	}
		
	
	public void acessarConta(){
		
		String cpf;
		String nomeBanco = null;
		int i = 0;
		cpf = JOptionPane.showInputDialog("Digite o CPF do Cliente: ");
		
		for(i = 0; i < cliente.length; i++){
			if(cliente[i] != null) {
        		
	            if(cliente[i].getCpf().equals(cpf)){
	            	
	            	switch(cliente[i].getBanco()) {
	        		case 1:
	        			nomeBanco = "Itaú";
	        		break;
	        		case 2:
	        			nomeBanco = "Santander";
	        		break;
	        		case 3:
	        			nomeBanco = "Bradesco";
	        		break;
	        		case 4:
	        			nomeBanco = "HSBC";
	        		break;
	        		}
	        		
	        		JOptionPane.showMessageDialog(null,"Nome: " + cliente[i].getNome()
	        		+ "\nSenha: " + cliente[i].getSenhaCli() + "\nCPF: " + cliente[i].getCpf()
	        		+ "\nEndereço: " + cliente[i].getEndereco() + "\nTelefone: " + cliente[i].getTelefone()
	        		+ "\nBanco: " + nomeBanco + "\nConta: " + cliente[i].getConta()
	        		+ "\nSaldo: " + cliente[i].getSaldo()+ "\n");
	        	}
			}
		}
	}
	
	public void acessarSaque(){
		Saque s = new Saque();
		String senha;
		int i = 0;
		senha = JOptionPane.showInputDialog("Digite a sua senha: ");

			for(i = 0; i < cliente.length; i++){
				if(cliente[i] != null) {
					if(cliente[i].getSenhaCli().equals(senha)){
						saldoCliente = cliente[i].getSaldo();
						bancoCliente = cliente[i].getBanco();
						
						s.sacar();
						
						if(cliente[i].getBanco() == 1) {
							itau++;
						}
						else if(cliente[i].getBanco() == 2) {
							santander++;
						}
						else if(cliente[i].getBanco() == 3) {
							bradesco++;
						}
						else if(cliente[i].getBanco() == 4) {
							hsbc++;
						}
						
						if (s.getSaque() > saldoCliente) {
							JOptionPane.showMessageDialog(null, "Não há saldo suficiente!");
						}else {
							if(s.isVerificacao() == true) {
								int saldoAtual = saldoCliente - s.getSaque();
								if(saldoAtual < 0) {
									int zero = 0;
									cliente[i].setSaldo(zero);
									JOptionPane.showMessageDialog(null, "Você Sacou: " + s.getSaque()
											+ "\nSeu Saldo atual é: " + saldoAtual);
								}else {
									cliente[i].setSaldo(saldoAtual);
									JOptionPane.showMessageDialog(null, "Você Sacou: " + s.getSaque()
											+ "\nSeu Saldo atual é: " + saldoAtual);
								}
							}
						}
					}
				}
			}
	}

}