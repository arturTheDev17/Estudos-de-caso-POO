package POO_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

	//mapas para guardar informações
	public static Map <String, String []> alunos =     new HashMap < String, String []>();
	public static Map <String, String []> professores =  new HashMap < String, String []>();
	public static Map <String, String []> cursos =     new HashMap < String, String []>();
	public static Map <String, String []> notas = new HashMap < String, String []>();
	public static Map <String, String []> presencas = new HashMap < String, String []>();

	public static void main ( String [] args ) {
		DadosTeste dadosTest = new DadosTeste ();
		char escolha = 10;
		int choice = -1;
		boolean dadosInseridos = false;
		while ( escolha != 'q' ) {
			Scanner sc = new Scanner ( System.in );
			System.out.println ( "--------------------------------------------------------------" );
			System.out.println ( "Bem vindo ao SGN 2.0 da escola Tech! O que gostaria de fazer?" );
			System.out.println ( "--------------------------------------------------------------" );
			System.out.println ( "0. Fazer inserção de teste               q. Sair" );
			System.out.println ( "1. Menu Professor                        2. Menu aluno" );
			System.out.println ( "3. Menu cursos                           " );
			System.out.println ( "--------------------------------------------------------------" );
			escolha = sc.next().charAt(0);
			
			switch ( escolha ) {
			case '0':
				if ( dadosInseridos  != true ) {
					System.out.println ( "Inserindo dados de teste. Aguarde." );
					dadosTest.inserirDadosIniciais ();
					System.out.println ( "Dados de teste inseridos!" );
					dadosInseridos = true;
				} else {
					System.out.println ( "Os dados já foram inseridos!" );
				}
				break; 
			case '1':
			System.out.println ( "--------------------------------------------------------------" );
			System.out.println ( "                        MENU PROFESSOR" );
			System.out.println ( "--------------------------------------------------------------" );
				System.out.println ( "1 - Cadastrar professor        2 - Ver professores cadastrados" );
				System.out.println ( "3 - Registrar notas            4 - Fazer chamada" );
				switch ( sc.nextInt() ) {
				case 1 : 
					System.out.println ( "Tem certeza? Y/N" );
					escolha = sc.next().charAt(0);
					if ( escolha == 'Y' || escolha == 'y' ) {
						CadastroProfessor.main ( args );	
					}
				break;
				case 2 : 
					for ( String key : professores.keySet() ) {
		                mostrarProfessor ( key ) ; }
					break;
				case 3 :
					System.out.println ( "--------------------------------------------------------------" );
					System.out.println ( "                        NOTAS" );
					System.out.println ( "--------------------------------------------------------------" );
					System.out.println ( "1 - Cadastrar notas        2 - Ver notas cadastradas" );
					switch ( sc.nextInt() ) {
					case 1 : 
						System.out.println ( "Tem certeza? Y/N" );
						escolha = sc.next().charAt(0);
						if ( escolha == 'Y' || escolha == 'y' ) {
							Notas.main ( args );
						}
					break;
					case 2 : 
						for ( String key : notas.keySet() ) {
			                mostrarNota ( key ) ; }
						break;
					}
					break; 

				case 4 :
					System.out.println ( "--------------------------------------------------------------" );
					System.out.println ( "                        CHAMADA" );
					System.out.println ( "--------------------------------------------------------------" );
					System.out.println ( "1 - Fazer chamada        2 - Mostrar chamadas feitas" );
					choice = sc.nextInt();
					switch ( choice ) {
						case 1 : 
							System.out.println ( "Tem certeza? Y/N" );
							escolha = sc.next().charAt(0);
							if ( escolha == 'Y' || escolha == 'y' ) {
								Chamada.main ( args );
							}
						break;
						case 2 : 
							for ( String key : alunos.keySet() ) {
								mostrarChamada ( key ) ; }
							break;
					}
				}
				break;
			case '2':
			System.out.println ( "--------------------------------------------------------------" );
			System.out.println ( "                        MENU ALUNO" );
			System.out.println ( "--------------------------------------------------------------" );	
			System.out.println ( "1 - Cadastrar aluno       2 - Ver alunos cadastrados" );
				choice = sc.nextInt();
				switch ( choice ) {
					case 1 : 
						System.out.println ( "Tem certeza? Y/N" );
						escolha = sc.next().charAt(0);
						if ( escolha == 'Y' || escolha == 'y' ) {
							CadastroAluno.main ( args );
						}
					break;
					case 2 : 
						for ( String key : alunos.keySet() ) {
							mostrarAluno ( key ) ; }
						break;
				}
				break;
			case '3':
			System.out.println ( "--------------------------------------------------------------" );
			System.out.println ( "                        MENU CURSOS" );
			System.out.println ( "--------------------------------------------------------------" );	
			System.out.println ( "1 - Cadastrar curso       2 - Ver cursos cadastrados" );
			choice = sc.nextInt();
			switch ( choice ) {
			case 1 : 
				System.out.println ( "Tem certeza? Y/N" );
				escolha = sc.next().charAt(0);
				if ( escolha == 'Y' || escolha == 'y' ) {
					CadastroCurso.main ( args );
				}
			break;
			case 2 : 
				for ( String key : cursos.keySet() ) {
					mostrarCursos ( key ) ; }
				break;
		}	
			break; 
			case 'q':
				break;
			}
		}
	}
	public static void mostrarCursos ( String codigo ) {
		//mudar
		System.out.println ( "INFORMAÇÕES:" );
		System.out.println ( "Código Curso: " + codigo );
		System.out.println ( "Nome: " + cursos.get ( codigo ) [0] );
		System.out.println ( "Descrição: " + cursos.get( codigo ) [1] );
		System.out.println ( "Carga horária: " + cursos.get( codigo ) [2] );
		System.out.println ( "Preço: " + cursos.get( codigo ) [3] );
		System.out.println ( "Matérias: " + cursos.get ( codigo ) [4] );
		System.out.println ();
	}
	public static void mostrarAluno ( String codigo ) {
		System.out.println ( "Matrícula: " + codigo );
		System.out.println ( "Nome: " + alunos.get( codigo ) [0] );
		System.out.println ( "CPF: " + alunos.get( codigo ) [1] );
		System.out.println ( "Data de nascimento: " + alunos.get( codigo ) [2] );
		System.out.println ( "E-mail: " + alunos.get( codigo ) [3] );
		System.out.println ( "Senha (não compartilhar): " + alunos.get( codigo ) [4] );
		System.out.println ();
	}
	public static void mostrarProfessor ( String codigo ) {
		System.out.println ( "INFORMAÇÕES:" );
		System.out.println ( "Código Professor: " + codigo );
		System.out.println ( "Nome: " + professores.get( codigo ) [0] );
		System.out.println ( "CPF: " + professores.get( codigo ) [1] );
		System.out.println ( "Data de nascimento: " + professores.get( codigo ) [2] );
		System.out.println ( "E-mail: " + professores.get( codigo ) [3] );
		System.out.println ( "Senha (não compartilhar): " + professores.get( codigo ) [4] );
		System.out.println ();
	}
	public static void mostrarNota ( String codigo ) {
		System.out.println ( "INFORMAÇÕES:" );
		System.out.println ( "Nome do aluno: " + notas.get ( codigo ) [4] );
		System.out.println ( "Curso: " + notas.get( codigo ) [0] );
		System.out.println ( "Disciplina: " + notas.get( codigo ) [3] );
		System.out.println ( "Nome da avaliação: " + notas.get( codigo ) [2] );
		System.out.println ( "Nota: " + notas.get( codigo ) [1] );
		System.out.println ();
	}
	public static void mostrarChamada ( String codigo ) {
		System.out.println ( "ERRO..." );
		/*System.out.println ( "INFORMAÇÕES:" );
		for ( int contador = 1 ; contador < Test.alunos.size() + 1 ; contador++ ) {
			if ( !presencas.get ( codigo ) [ contador ].isEmpty() ) {
				System.out.println ( presencas.get ( codigo ) [ contador ] );
			}
		}*/
	}
	public void inserirAluno ( String cod, String [] dados ) {
	        alunos.put( cod, dados );
	    }
	public void inserirProfessor ( String cod, String [] dados ) {
	        professores.put ( cod, dados );
	    }
	public void inserirCursos ( String cod, String [] dados ) {
	        cursos.put ( cod, dados );
	    }
	public void inserirNota ( String cod, String[] presenca ) {
        cursos.put ( cod, presenca );
    }
	public void inserirChamada ( String cod, String [] dados ) {
        presencas.put ( cod, dados );
    }

}
