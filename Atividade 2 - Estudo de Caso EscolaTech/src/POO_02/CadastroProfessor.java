package POO_02;

import java.util.Scanner;

public class CadastroProfessor {

	public static void main ( String [] args ) {
        String nome = " ", cpf = " ", dataNascimento = " ", cadastroProf = " ", email = " ", senha = " ";
		//Entradas de dados:
		Scanner sc = new Scanner ( System.in );
		//Criar um objeto da classe Aluno.
		Professor prof1 = new Professor ();
		Test test = new Test();

		do {
			System.out.println ( "Informe o nome do Professor: " );
			nome = sc.nextLine();
		} while ( prof1.validarNome( nome ) ) ;
		
		do {
			System.out.println ( "Informe o CPF:" );
			cpf = sc.nextLine();
		} while ( !prof1.validarCPF ( cpf ) );
		
		do {
			System.out.println ( "Informe a data de nascimento:" );
			dataNascimento = sc.nextLine();
		} while ( !prof1.validarDataNascimento ( dataNascimento ) );
		
		do {
			System.out.println ( "Informe o cadastro do Professor:" );
			cadastroProf = sc.nextLine();
		} while ( prof1.validarCadastroProf ( cadastroProf ) );
				
		do {
			System.out.println ( "Informe o E-mail: " );
			email = sc.nextLine();
		} while ( prof1.validarEmail( email ) ) ;
		
		do {
			System.out.println ( "Informe a senha:" );
			senha = sc.nextLine();
		} while ( prof1.validarSenha ( senha ) );
	
		String professores [] = new String [ ] { nome , cpf , dataNascimento , email , senha  }; 	

		test.inserirProfessor ( cadastroProf , professores ); //insere o cadastro no map
	}

}
