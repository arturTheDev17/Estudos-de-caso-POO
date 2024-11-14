package estudodecaso03;

/**
 * Essa classe serve para controlar o acesso das pessoas que acessam o nosso sistema.
 * @author Artur Neves Höpner
 */

public class ControleDeAcesso {
	
	
	
	private String userAcesso = "useradmin" ;
	private String senha = "admin" ;
	
	/*
	 * Criação das Variáveis login e senha padrão do sistema.
	 */
	
	/**
	 * Essa função serve para guardar o acesso do usúario.
	 * @param userAcesso.
	 */
	
	public void setUserAcesso ( String userAcesso ) {
		this.userAcesso = userAcesso;
		
		
		
	}
	
	/**
	 * Essa função serve para resgatar o user do usúario.
	 * @return acesso.
	 */
	
	public String getUserAcesso () {
		return userAcesso;
		
		
	}
	
	
	/**
	 * Essa função serve para guardar a senha do usúario.
	 * @param senha.
	 */
	
	public void setSenha ( String senha ) {
		this.senha = senha;
		
	}
	
	/**
	 * Essa função serve para resgatar a senha do usúario.
	 * @return senha.
	 */
	public String getSenha () {
		return senha;
		
	}
	
	/**
	 *  Essa função serve para conferir o login e senha..
	 * @param login.
	 * @param senha.
	 * @return acesso.
	 */
	public boolean acesso ( String login , String senha ) {
		if ( senha.equals ( this.senha ) && login.equals ( this.userAcesso ) ) {
			return true;
		
		} else
			System.out.println ( "Login ou senha incorretos..." );
			return false;
			
	}
}