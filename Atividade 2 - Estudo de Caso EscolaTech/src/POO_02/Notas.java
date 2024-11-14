package POO_02;

import java.util.Scanner;

public class Notas {
	
	public static void main ( String [] args ) {
		Test test = new Test ();
		Scanner sc = new Scanner ( System.in );
		String curso , prova , disciplina , nome; boolean contem = false; Integer nota ;
		if ( Test.professores.isEmpty () ) {//verifica se existem professores cadastrados
			System.out.println ( "Não há professores cadastrados, então ninguém pode cadastrar notas!" );
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
				for ( String key : Test.cursos.keySet() ) {
					if ( Test.cursos.get ( key ) [ 4 ].contains ( disciplina ) ) {
						contem = true;
					}
				}
			} while ( contem == false );
			contem = false;
			
			do {
				System.out.println ( "Insira o nome do aluno: " );
				nome = sc.nextLine();
				for ( String key : Test.alunos.keySet() ) {
					if ( Test.alunos.get ( key ) [ 0 ].equals ( nome ) ) {
						contem = true;
					}
				}
			} while ( contem == false );
			
			System.out.println ( "Qual o nome da avaliação a qual será atribuída a nota?" );
			prova = sc.nextLine();
			
			
			do {
				System.out.println ( "Insira a nota do aluno " + nome + ":" );
				nota = sc.nextInt();
			} while ( nota < 0 || nota > 10 );
			
			
			String [] avaliacao = new String [] { curso , nota.toString() , prova , disciplina , nome };
			Integer codigo = 0;
			
			test.inserirNota ( codigo.toString() , avaliacao ); //insere a nota no map
			codigo++;
		}
		
	}
	
}
