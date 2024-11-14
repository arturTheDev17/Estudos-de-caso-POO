package POO_02;

//APENAS PARA TESTE
public class DadosTeste {
	    
		 // Disciplina: nome da disciplina, codigo da disciplina, descrição da disciplina
		//dados gerados aleatoriamente por IA
	    //Aluno: matricula, nome, cpf, data de nascimento, email, senha
	    String [] [] [] alunos = { 
	        { { "12345678911" } , { "João Ferreira Lima", "12345678911", "10/10/2000", "joaolima@gmail.com", "123456789" } },
	        { { "12345678912" } , { "Mariana Spindula Santos", "12345678912", "21/05/1965", "mariana@gmail.com", "123456789" } },
	        { { "12345678913" } , { "Joaquim Alves Gonçalves", "12345678913", "25/09/1998", "joaquim@gmail.com", "123456789" } },
	        { { "12345678914" } , { "Yana Amaral", "12345678914", "19/11/2001", "yana@gmail.com", "123456789" } }
	    };

	    // Professor: codigo, nome, cpf, data de nascimento, email, senha
	    String [] [] [] professores = {
	        { { "F3B221" } , { "José Alves De Lima", "22345678910", "20/02/1995", "josealves@gmail.com", "123456789" } },
	        { { "F3B222" } , { "Adriano Silva", "22345678911", "15/04/1990", "adriano@gmail.com", "123456789" } },
	        { { "AAD223" } , { "Guilherme Ferreira", "22345678912", "14/08/1988", "guilherme@gmail.com", "123456789" } }
	    };
	    public void inserirDadosIniciais () {
	        Test teste = new Test();
	        

	        for ( int i = 0; i < alunos.length; i++) {
	        	teste.inserirAluno ( alunos [i][0][0], alunos [i][1] );
	        }
	        
	        for ( int i = 0; i < professores.length; i++) {
	        	teste.inserirProfessor ( professores [i][0][0], professores[i][1] );
	        }
	    }
	}

    

