package POO_02;

import java.util.Scanner;

public class CadastroCurso {
	
	public static void main ( String [] args ) {
		Scanner sc = new Scanner ( System.in );
		String nome = "" , codigo = "" , descricao = "" , cargaHoraria = "" , valorMensalidade = "" ;
		Curso curso1 = new Curso ();
		Test test = new Test ();
		do {
			System.out.println ( "Informe o nome do curso: " );
			nome = sc.nextLine();
		} while ( !curso1.validarNome ( nome ) );
		
		do {
			System.out.println ( "Informe o código do curso: " );
			codigo = sc.nextLine() ;
		} while ( !curso1.validarCodigo ( codigo ) );
		
		do {
			System.out.println ( "Informe a descrição do curso: " );
			descricao = sc.nextLine() ;
		} while ( !curso1.validarDescricao ( descricao ) );
		
		do {
			System.out.println ( "Informe a carga horaria do curso: " );
			cargaHoraria = sc.nextLine() ;
		} while ( !curso1.validarCargaHoraria ( cargaHoraria ) );
		
		do {
			System.out.println ( "Informe a mensalidade do curso: " );
			valorMensalidade = sc.nextLine();
		} while ( !curso1.validarMensalidade ( valorMensalidade ) );
		
		char escolha; String disciplinas = "";
		
		do {// insere x disciplinas
			String disciplina = curso1.disciplina ( );
			System.out.println ( "Gostaria de inserir mais uma matéria?" );
			escolha = sc.next().charAt(0);
			disciplinas = disciplinas + " " + disciplina;
		} while ( escolha == 'Y' || escolha == 'y' );
		
		String cursos [] = new String [ ] { nome , descricao , cargaHoraria , valorMensalidade , disciplinas }; 	
		
		test.inserirCursos ( codigo , cursos ); //insere o cadastro no map
	}

}
