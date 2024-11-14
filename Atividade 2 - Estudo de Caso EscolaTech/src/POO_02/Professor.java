package POO_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;

public class Professor {

public boolean validarSenha ( String senha ) {//mais que 8 caracteres
	if ( senha.length() >= 8 ) {
		return false;
	}
	System.out.println ( "senha errada" );
	return true;
}

public boolean validarNome ( String nome ) {//impede de inserir caracteres estranhos	
	if ( nome.matches ("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])") ) {
		System.out.print ( "nome invalido. contem caracteres especiais" ) ;
		return true ;
    }
	if ( nome.matches ( "^[0-9]+$" ) ) {
		System.out.println ( "nome invalido. contem numeros" );
		return true;
	}
	if ( nome.matches ( "^[a-zA-Z]+$" ) ) {
		return false;
	}
	System.out.println ( "nome inválido" );
	return true;
}

public boolean validarEmail ( String email ) {//email com formato exemplo@exemplo.algo
	if ( email.matches( "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$" ) ) {
		return false;
	}
	System.out.println ( "email inválido" );
	return true;
}

public boolean validarCPF ( String cpf ) {//11 caracteres numeros
	 if ( cpf.length() != 11 ) {
		 System.out.println ( "CPF inválido: " ) ;
         return false;
	    }
	char [] cpfLista = cpf.toCharArray() ;
	
    for ( int i = 0 ; i < cpfLista.length ; i++ ) {
        if ( !Character.isDigit ( cpfLista [i] ) ) {
            System.out.println ( "CPF inválido: " ) ;
            return false;
        }    
    }
	return true;
}

public boolean validarCadastroProf ( String cadastroProf ) {//apenas letras
	if ( cadastroProf.matches ( "^[a-zA-Z]+$" ) ) {
		return false;
	}
	System.out.println ( "cadastro invalida" );
	return true;
	}

public boolean validarDataNascimento ( String data ) {//deve ser uma data válida
	String dateFormat = "dd/MM/uuuu";

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern ( dateFormat ).withResolverStyle(ResolverStyle.STRICT);
    try {
        LocalDate date = LocalDate.parse ( data, dateTimeFormatter );
       
        return true;
    } catch ( DateTimeParseException e ) {
    System.out.println ( "Data inválida" );
        return false;
    }
}
}
