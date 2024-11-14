package estudodecaso03;

/**
 * Essa classe serve para criar as funções de cadastro da máquina.
 * @author Artur Neves Höpner
 */

public class Maquina {
	
	private String nome;
	private Integer maquinaID;
	private String tipo;
	private String status;
	private String [] dadosDesempenho = new String [ 3 ];
	private Producao linhaDeProducao;
	
	/**
	 * Criação de varíaveis.
	 */
	
	
	/**
	 * Essa função serve para Resgatar verificar e resgatar o nome da máquina.
	 * @param nome.
	 * @return.
	 */
	
	/**
	 * Essa função serve para guardar a linha na qual o produto pertence.
	 * @param linha
	 */
	
	public boolean setLinha ( Producao linha ) {
		this.linhaDeProducao = linha;
		return true;
	}
	/**
	 * Essa função serve para obter a linha na qual o produto pertence.
	 * @return linhaDeProducao (objeto).
	 */
	public Producao getLinhaDeProducao() {
		return linhaDeProducao;
	}
	
	public boolean setNome ( String nome ) {
		
		if ( !nome.isBlank() && !nome.matches ( "^[0-9]+$" ) ) {
			this.nome = nome;
			return true;
		
		}
		
		return false;
		
	}
	
	
	/**
	 * Essa função serve para guardar o nome da máquina.
	 * @return nome.
	 */
	
	public String getNome() {
		return nome;
		
	}
	
	/**
	 * Essa função serve para resgatar o ID da máquina.
	 * @param maquinaID.
	 * @return boolean.
	 */
	public boolean setMaquinaID ( Integer maquinaID ) {
			this.maquinaID = maquinaID;
			return true;
			
	
	}
	
	/**
	 * Essa função serve para guardar o ID da máquina.
	 * @return maquinaID.
	 */
	
	public Integer getMaquinaID() {
		return maquinaID;
		
	}
	
	/**
	 * Essa função serve para resgatar o tipo de máquina.
	 * @param tipo.
	 * @return tipo.
	 */
	
	public boolean setTipo ( String tipo ) {
	
		if ( !nome.isBlank() && !nome.matches ( "^[0-9]+$" ) ) {
			this.tipo = tipo;
			return true;
		
		}
		
		return false;
	
		
	}
	
	/**
	 * Essa função serve para guardar o tipo da máquina.
	 * @return tipo.
	 */
	
	public String getTipo() {
		return tipo;
		
	
	}
	
	/**
	 * Essa função serve para resgatar o status da máquina.
	 * @param status.
	 * @return status.
	 */
	
	public boolean setStatus ( String status ) {
		
		if ( !status.isBlank() ) {
			this.status = status;
			return true;
		
		}
		
		return false;
		
	
	}
	
	/**
	 * Essa função serve para guardar o status da máquina.
	 * @return status.
	 */
	
	public String getStatus() {
		
		return status;
		
	
	}
	
	/**
	 *  Essa função serve para resgatar o tempo de atividade da máquina.	
	 * @param tempoDeAtividade.
	 * @return boolean.
	 */
	
	public boolean setTempoDeAtividade ( String tempoDeAtividade ) {
		
		if ( tempoDeAtividade.matches ( "^[0-9]+$" ) ) {
			if ( Integer.parseInt ( tempoDeAtividade ) > 24 || Integer.parseInt ( tempoDeAtividade ) < 0 ) {
				return false;
			}
			this.dadosDesempenho [ 0 ] = tempoDeAtividade;
			return true;
		}
		
		else

		{
			
			this.dadosDesempenho [ 0 ] = "0";
		
		}
		
		return false;
		
	
	}
	
	/**
	 * Essa função serve para resgatar o tempo de inatividade da máquina.
	 * @param tempoDeInatividade.
	 * @return boolean.
	 */
	
	public boolean setTempoDeInatividade ( String tempoDeInatividade ) {
		
		if ( tempoDeInatividade.matches ( "^[0-9]+$" ) ) {
			if ( Integer.parseInt ( tempoDeInatividade ) > 24 || Integer.parseInt ( tempoDeInatividade ) < 0 ) {
				return false;
			}
			this.dadosDesempenho [ 1 ] = tempoDeInatividade;
			return true;
		} 
		
		else 
		
		{
			this.dadosDesempenho [ 1 ] = "0";
		
		}
		
		return false;
		
	}
	
	/**
	 * Essa função serve para resgatar desempenho da máquina.
	 * @param taxaDeProdutividade.
	 * @return boolean.
	 */
	
	public boolean setTaxaDeProdutividade ( String taxaDeProdutividade ) {
		
		if ( taxaDeProdutividade.matches ( "^[0-9]+$" ) && taxaDeProdutividade.length() < 4 ) {
			
			int percentual = Integer.parseInt ( taxaDeProdutividade );
			
			if ( percentual > 0 && percentual < 101 ) {
				this.dadosDesempenho [ 2 ] = taxaDeProdutividade;
				return true;
			
			}
		
		} 
		
		else
		
		{
			
			this.dadosDesempenho [ 2 ] = "0";
		
		}
		
		return false;
		
	
	}
	
	/**
	 * Essa função serve para guardar os dados de desempenho da máquina.
	 * @return desempenho.
	 */
	
	public String[] getDadosDesempenho() {
		return dadosDesempenho;
		
	}
}