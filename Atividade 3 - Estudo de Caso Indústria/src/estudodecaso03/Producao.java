package estudodecaso03;

/**
 * Essa classe serve para criar as funções de verificação da produção.
 * @author Saymon Oliveira de Castro
 */

import java.util.ArrayList;

public class Producao {

	private String setor;
	private String status;
	private String tempo;
	private Integer id;
	private String comentario;
	private boolean ativa = false;
	
	/*
	 * Criação das variáveis.
	 */
	
	/**
	 * define o comentário na classe.
	 * @param comentario.
	 */
	
	public void setComentario ( String comentario ) {
		
		this.comentario = comentario;
		
	
	}
	
	public String getComentario() {
		return comentario;
	
	}
	
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
	 * Essa função serve para resgatar o setor da produção.
	 * @param setor.
	 * @return boolean.
	 */
	
	public boolean setSetor ( String setor ) {
		
		if ( setor.length() > 3 ) {
			this.setor = setor;
			return true;
		}
		
		return false;
		
	}
	
	/**
	 *  Essa função serve para resgatar o status da produção.
	 * @param status.
	 * @return boolean.
	 */
	
	public boolean setStatus ( String status ) {
		this.status = status;
		if ( status.length() > 3 ) {
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Essa função serve para resgatar o tempo de ciclo da produção.
	 * @param tempo.
	 * @return boolean.
	 */
	
	public boolean setTempo ( String tempo ) {
		this.tempo = tempo;
		if ( tempo.length() > 0 ) {
			return true;
			
		}
		
		return false;
		
		
	}
	
	/**
	 * Essa função serve para resgatar as máquinas da produção.
	 * @param maquina.
	 */
	
		
	/**
	 *  Essa função serve para resgatar o tempo de atividade da produção.
	 * @param ativa.
	 */
	
	public void setAtiva ( boolean ativa ) {
		
		this.ativa = ativa;
		
	
	}
	
	/**
	 * Essa função serve para guardar o tempo de atividade da produção.
	 * @return ativa.
	 */
	
	public boolean getAtiva() {
		return ativa;
		
		

	}
	
	/**
	 * Essa função serve para guardar o setor da produção.
	 * @return setor.
	 */
	
	public String getSetor() {
		return setor;
		
	}
	
	/**
	 * Essa função serve para guardar o status da produção.
	 * @return status.
	 */
	
	public String getStatus() {
		return status;
		
		
		
	}
	
	/**
	 * Essa função serve para guardar o tempo de ciclo da produção.
	 * @return tempo.
	 */
	
	public String getTempo() {
		return tempo;
		
		
	}
	
	/**
	 *  Essa função serve para guardar o ID da produção.
	 * @return ID.
	 */
	
	public Integer getId() {
		return id;
		
		
	}
	
	/**
	 * Essa função serve para guardar as máquinas da produção.
	 * @return máquinas.
	 */
	

}