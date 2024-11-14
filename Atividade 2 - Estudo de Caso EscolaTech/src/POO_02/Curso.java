package POO_02;

import java.util.Scanner;

public class Curso {
	
	public boolean validarNome ( String nome ) {// impede de deixar vazio
		if ( nome.isEmpty() || !nome.matches ( "^(?!\\s*$).+" ) ) {
			System.out.println ( "NOME INVÁLIDO." );
			return false;
		}
		return true;
	}

	public boolean validarCodigo ( String codigo ) {//deve ser hexadecimal com 6 caracteres
		if ( codigo.matches( "^[a-fA-F0-9]{6}$" ) ) {
			return true;
		}
		System.out.println ( "codigo invalido" );
		return false;
	}
	
	public boolean validarDescricao ( String descricao ) {//limita o tamanho da descricao
		if ( descricao.length() < 500 ) {
			return true;
		}
		System.out.println ( "descricao muito grande" );
		return false;
	}

	public boolean validarCargaHoraria ( String cargaHoraria ) {//apenas numeros
		if ( cargaHoraria.matches ( "^[0-9]+$" ) ) {
			return true;
		}
		return false;
	}
	
	public boolean validarMensalidade ( String mensalidade ) {//apenas numeros
		if ( mensalidade.matches( "^[0-9]+$" ) ) {
			return true;
		}
		return false;
	}
	
	public String disciplina ( ) {//para verificar se as disciplinas estão vazias
		Scanner sc = new Scanner ( System.in );
		String nomeMateria;
		do {
			System.out.println ( "Insira o nome da matéria:" );
			nomeMateria = sc.nextLine();
		} while ( nomeMateria.isEmpty() || !nomeMateria.matches ( "^(?!\\s*$).+" ) );
		
		return nomeMateria;
	}

}
	