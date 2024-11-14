package estudodecaso03;

/**
 * Essa classe serve para verificar os dados do operarío.
 * @author Saymon Oliveira de Castro
 */

import java.util.ArrayList;

public class Operario {
	
	private Integer id;
	private String nome;
	private String salario;
	private ArrayList <String> habilidade = new ArrayList <String> ();
	
	/*
	 * Criação das variáveis.
	 */
	
	/**
	 * Essa função serve resgatar o ID do operário.
	 * @param id.
	 * @return boolean.
	 */
	
	public boolean setId ( Integer id ) {
		this.id = id;
		return true;	
		
		
	}

	/**
	 *  Essa função serve resgatar o nome do operarío.
	 * @param nome.
	 * @return boolean.
	 */
	
	public boolean setNome ( String nome ) {
		
		if ( nome.length () > 2 && !nome.matches( ("^[0-9]+$" ))) {
			this.nome = nome;
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Essa função serve resgatar o salário do operarío.
	 * @param salario.
	 * @return boolean.
	 */
	
	public boolean setSalario ( String salario ) {
		if ( !salario.isBlank() && salario.matches( ("^[0-9]+$" ))) {
			this.salario = salario;
			return true;
			
		}
		return false;
	}
	
	/**
	 * Essa função serve resgatar as habilidades do operarío.
	 * @param habilidade.
	 */
	
	public void setHabilidade (String habilidade ) {
		this.habilidade.add( habilidade );
		
	}

	
	/**
	 * Essa função serve guardar o ID do operarío.
	 * @return ID.
	 */
	
	public Integer getId() {
		return id;
		
	}
	
	/**
	 * Essa função serve guardar o nome do operarío.
	 * @return nome.
	 */
	
	public String getNome() {
		return nome;
	
	}
	
	/**
	 * Essa função serve guardar o ID do operarío.
	 * @return salario.
	 */
	
	public String getSalario() {
		return salario;
		
	}
	
	/**
	 * Essa função serve guardar as habilidades do operarío.
	 * @return habilidade.
	 */
	
	public ArrayList<String> getHabilidade() {
		return habilidade;
		
	}
}