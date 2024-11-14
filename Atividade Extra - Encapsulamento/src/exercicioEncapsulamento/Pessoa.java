package exercicioEncapsulamento;

public class Pessoa {
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
	
	public void setEndereco ( Endereco endereco ) {
		this.endereco = endereco;
	}
	public Endereco getEndereco () {
		return this.endereco;
	}
	
	public boolean setNome ( String nome ) { //set = usado para pegar um valor
		if ( nome.matches ( "^[a-zA-Z]+$" ) && nome.length() >= 2 ){
			this.nome = nome;
			return true;
		}
		return true;
	}
	public String getNome () { //get = usado para transferir um valor
		return this.nome;
	}

	public boolean setCpf ( String cpf ) { //set = usado para pegar um valor
		if ( cpf.matches ( "^[0-9]+$" ) && cpf.length() == 11 ) {
			this.cpf = cpf;
			return true;
		}
		return false;
	}
	public String getCpf () { //get = usado para transferir um valor
		return this.cpf;
	}
	
	public boolean setRg ( String rg ) { //set = usado para pegar um valor
		if ( rg.matches ( "^[0-9]+$" ) && rg.length() >= 7 ) {
			this.rg = rg;
			return true;
		}
		return true;
	}
	public String getRg () { //get = usado para transferir um valor
		return this.rg;
	}
	
}
