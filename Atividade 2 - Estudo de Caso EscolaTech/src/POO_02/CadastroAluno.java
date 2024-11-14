package POO_02;

import java.util.Scanner;

public class CadastroAluno {
	
	public static void main ( String [] args ) {
        String nome = " ", cpf = " ", dataNascimento = " ", matricula = " ", email = " ", senha = " ";
		Scanner sc = new Scanner ( System.in );
		Aluno aluno1 = new Aluno ();
		Test test = new Test();
		do {
			System.out.println ( "Informe o nome do aluno: " );
			nome = sc.nextLine();
		} while ( aluno1.validarNome( nome ) ) ;
		
		do {
			System.out.println ( "Informe o CPF:" );
			cpf = sc.nextLine();
		} while ( !aluno1.validarCPF ( cpf ) );
		
		do {
			System.out.println ( "Informe a data de nascimento:" );
			dataNascimento = sc.nextLine();
		} while ( !aluno1.validarDataNascimento ( dataNascimento ) );
		
		do {
			System.out.println ( "Informe a matricula:" );
			matricula = sc.nextLine();
		} while ( aluno1.validarMatriculas( matricula ) );
				
		do {
			System.out.println ( "Informe o E-mail: " );
			email = sc.nextLine();
		} while ( aluno1.validarEmail( email ) ) ;
		
		do {
			System.out.println ( "Informe a senha:" );
			senha = sc.nextLine ();
		} while ( aluno1.validarSenha ( senha ) );
	    
		
		String alunos [] = new String [ ] { nome , cpf , dataNascimento , email , senha  }; 	
		
		test.inserirAluno ( matricula , alunos );//insere o cadastro no map
	}

}
