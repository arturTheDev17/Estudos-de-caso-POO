package exercicioEncapsulamento;

import java.util.Scanner;

public class PessoaCadastro {

	private static Pessoa pess = new Pessoa();
	
	public static void main ( String [] args ) {
		Scanner sc = new Scanner ( System.in );
		Endereco ende = new Endereco ();
		EnderecoCadastro endeCa = new EnderecoCadastro();
		do {
			System.out.print ( "Insira o nome: " );
		} while ( !pess.setNome ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira o CPF: " );
		} while ( !pess.setCpf ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira o RG: " );
		} while ( !pess.setRg ( sc.nextLine() ) );
		
		System.out.println ( "Agora para o endereço..." );
		EnderecoCadastro.main ( args );
		
		ende = endeCa.getEndereco();
		pess.setEndereco ( ende );
		
		System.out.println ( "Nome: " + pess.getNome() );
		System.out.println ( "CPF: " + pess.getCpf() );
		System.out.println ( "RG: " + pess.getRg() );
		System.out.println ( "Endereço." );
		System.out.println ( "Rua: " + pess.getEndereco().getRua() );
		System.out.println ( "Numero: " + pess.getEndereco().getNumero() );
		System.out.println ( "Bairro: " + pess.getEndereco().getNumero() );
		System.out.println ( "CEP: " + pess.getEndereco().getCep() );
		System.out.println ( "Complemento: " + pess.getEndereco().getComplemento() );
	}
	
	public Pessoa getPessoa () {
		return this.pess;
	}
}
