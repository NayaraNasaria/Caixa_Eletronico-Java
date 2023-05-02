package caixaEletronico;

public class Cliente {
	private String nome;
	private String rg;
	private String cpf;
	private String endereco;
	private int telefone;
	private int banco;
	private int conta;
	private String senhaCli;
	private int saldo;
	
	public Cliente(String nome, String rg, String cpf, String endereco, int telefone, int banco, int conta,
		String senhaCli,int saldo) {
		this.setNome(nome);
		this.setRg(rg);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setBanco(banco);
		this.setConta(conta);
		this.setSenhaCli(senhaCli);
		this.setSaldo(saldo);
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getBanco() {
		return banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getSenhaCli() {
		return senhaCli;
	}

	public void setSenhaCli(String senhaCli) {
		this.senhaCli = senhaCli;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}
