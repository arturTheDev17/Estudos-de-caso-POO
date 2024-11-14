package POO_02;

import java.util.Scanner;

public class Chamada {
	
	public static void main ( String [] args ) {
		Aluno aluno1 = new Aluno ();
		Test test = new Test ();
		String curso , disciplina , data; char escolha;
		Scanner sc = new Scanner ( System.in );
		boolean contem = false;
		if ( Test.professores.isEmpty () ) {//verifica se existem professores cadastrados
			System.out.println ( "Não há professores cadastrados, então ninguém pode cadastrar chamada!" );
			System.out.println ( "Voltando ao menu principal..." );
			contem = false;
		} else {
			contem = true;
		}
		//deveria ter um login aqui
		if ( contem == true ) {
			// essa parte serve para verificar se existem os cursos/disciplinas/datas inseridos
			contem = false;		
			do {
				System.out.println ( "Insira a data: " );
				data = sc.nextLine();
			} while ( !aluno1.validarDataNascimento ( data ) );

			do {
				System.out.println ( "Insira o nome do curso:" );
				curso = sc.nextLine();
				for ( String key : Test.cursos.keySet() ) {
					if ( Test.cursos.get ( key ) [ 0 ].equals ( curso ) ) {
						contem = true;
					}
				}
			} while ( contem == false );
			contem = false;
			
			do {
				System.out.println ( "Insira o nome da matéria: " );
				disciplina = sc.nextLine();
				
				contem = true;
			} while ( contem == false );
			contem = false;
			String [] presenca = new String [ Test.alunos.size() + 1 ];
			int contador = 1;
			Integer tamanho = Test.alunos.size() + 2;
			presenca [ 0 ] = "Data: " + data + " Curso: " + curso + " Disciplina: " + disciplina;
			//faz a chamada
			for ( String key : Test.alunos.keySet() ) {
				System.out.println ( "O aluno " + Test.alunos.get ( key ) [0] + " esteve presente?" );
				System.out.println ( "1 - Sim               2 - Não" );
				escolha = sc.next().charAt ( 0 );
				switch ( escolha ) {
					case '1' :
						presenca [ contador ] = "Presente";
						break;
					case '2' :
						
						presenca [ contador ] = "Falta";
						break;
				}
				contador++;
			}
			Integer codigo = 0;
			
			test.inserirNota ( codigo.toString() , presenca );// insere a chamada no map
			codigo++;
		}
		
	}
}
