package exercicioEncapsulamento;

import java.util.Scanner;

public class EnderecoCadastro {

	private static Endereco ende = new Endereco();
	
	public static void main ( String [] args ) {
		Scanner sc = new Scanner( System.in );
		
		
		do {
			System.out.print ( "Insira a rua: " );
		} while ( !ende.setRua ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira o numero: " );
		} while ( !ende.setNumero ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira o bairro: " );
		} while ( !ende.setBairro ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira o CEP: " );
		} while ( !ende.setCep ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira o complemento ( Não obrigatório): " );
		} while ( !ende.setComplemento ( sc.nextLine() ) );
	}
	
	public Endereco getEndereco () {
		return this.ende;
	}

}
