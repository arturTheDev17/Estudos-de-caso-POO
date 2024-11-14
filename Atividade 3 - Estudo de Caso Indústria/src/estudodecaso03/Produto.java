package estudodecaso03;

import java.util.ArrayList;

/**
 * Essa classe serve para verificar os dados dos produtos.
 * @author Saymon Oliveira de Castro
 */

public class Produto {

	private Integer id;
	private String nome;
	private String descriçao;
	private String processo;
	private ArrayList <String> componentes = new ArrayList <String> ();
	
	/*
	 * Criação das variáveis.
	 */
	
	/**
	 * Essa função serve para resgatar o ID da produção.
	 * @param id.
	 * @return boolean.
	 */
	
	public boolean setId ( Integer id ) {
			this.id = id;
			return true;
			
	}
	
	/**
	 *  Essa função serve para resgatar o nome da produção.
	 * @param nome.
	 * @return boolean.
	 */
	
	public boolean setNome ( String nome ) {	
		if ( nome.length () > 2 && Character.isAlphabetic((nome.charAt(0))) && Character.isAlphabetic((nome.charAt(nome.length() - 1)))) {
			this.nome = nome;
			return true;
		}	
		
		return false;	
	
	}
	
	/**
	 * Essa função serve para resgatar a descrição da produção.
	 * @param descriçao.
	 */
	
	public void setDescriçao ( String descriçao ) {
		this.descriçao = descriçao;
		
	
	}
	
	/**
	 * Essa função serve para resgatar o processo da produção.
	 * @param processo.
	 * @return boolean.
	 */
	
	public boolean setProcesso ( String processo ) {
		if ( processo.length () > 10 ) {
			this.processo = processo;
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Essa função serve para resgatar os componentes da produção.
	 * @param componente.
	 * @return boolean.
	 */
	
	public boolean addComponente ( String componente ) {
		if ( componente.isBlank() ) {
			return false;
		}
		this.componentes.add ( componente );
		return true;
		
	}
	
	/**
	 * Função para remover um componente da lista de componentes.
	 * @param indice
	 */
	public void removeComponente ( int indice ) {
		componentes.remove ( indice );
	}
	/**
	 * Essa função serve para guardar o ID da produção.
	 * @return ID.
	 */
	
	public Integer getId() {
		return id;
		
	
	}
	
	/**
	 * Essa função serve para guardar o nome da produção.
	 * @return nome.
	 */
	public String getNome() {
		return nome;
		
	}
	
	/**
	 * Essa função serve para guardar a descrição da produção.
	 * @return descrição.
	 */
	
	public String getDescriçao() {
		return descriçao;
		
	
	}
	
	/**
	 * Essa função serve para guardar o processo da produção.
	 * @return processo.
	 */
	
	public String getProcesso() {
		return processo;
		
	}
	
	/**
	 * Essa função serve para pegar os componentes da produção.
	 * @return componentes.
	 */
	
	public ArrayList<String> getComponentes() {
		return componentes;
		
	
	}
	
	
}