package classesEDCV;

import java.util.ArrayList;
/**
 * Classe para criacao de um objeto ProdutoWEG
 * @author artur_hopner
 *
 */
public class ProdutoWEG {
	
	/**	nome do produto*/
	private String nome;
	/**	espaco para colocar o codigo do produto (na classe WEG é autogerado)*/
	private Integer codigo;
	/** espaço para registrar a subclasse do produto (ex: {@link MotorEletrico} ) */
	private Object tipo; 
	/** espaco para registrar a potencia em watts do produto */
	private float potencia;
	/** espaco para registrar a tensao em volts do produto */
	private float tensao;
	/** espaco para registrar a capacidade do produto */
	private float capacidade;
	/** espaco para registrar o preco em reais do produto */
	private float preco;
	/** arraylist de todos {@link ServicoManutencao} vinculados à classe */
	private ArrayList<ServicoManutencao> servicosRegistrados = new ArrayList<ServicoManutencao>();
	
	/**
	 * Constructor com todos atributos
	 * @param codigo
	 * @param tipo
	 * @param potencia
	 * @param tensao
	 * @param capacidade
	 * @param preco
	 */
	public ProdutoWEG ( String nome , Integer codigo , Object tipo , float potencia , float tensao , float preco ) {
		setNome ( nome );
		setCodigo ( codigo );
		setPotencia ( potencia );
		setPreco ( preco );
		setTensao ( tensao );
		setTipo ( tipo );
		
		System.out.println ( "ProdutoWEG registrado!" );
	}

	public ProdutoWEG ( String nome , Object tipo , float potencia , float tensao , float preco ) {
		setNome ( nome );
		setPotencia ( potencia );
		setPreco ( preco );
		setTensao ( tensao );
		setTipo ( tipo );
		
		System.out.println ( "ProdutoWEG registrado!" );
	}
	
	/**
	 * Constructor vazio
	 */
	public ProdutoWEG (  ) {
	
		System.out.println ( "ProdutoWEG vazio registrado" );
		
	}	
	
	
	/**
	 * getter do atributo codigo
	 * @return valor de codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * setter do atributo codigo
	 * @param codigo
	 * @return valor de codigo
	 */
	public boolean setCodigo(Integer codigo) {
		if ( codigo < 0 ) {
			return false;
		}
		this.codigo = codigo;
		return true;
	}

	
	/**
	 * getter do atributo tipo
	 * @return objeto tipo
	 */
	public Object getTipo() {
		return tipo;
	}
	/**
	 * setter do atributo tipo
	 * @param tipo
	 * @return valor de tipo
	 */
	public void setTipo(Object tipo) {
		this.tipo = tipo;
	}

	
	/**
	 * getter do atributo potencia
	 * @return valor de potencia
	 */
	public float getPotencia() {
		return potencia;
	}
	/**
	 * setter do atributo potencia
	 * @param potencia
	 * @return 
	 */
	public boolean setPotencia (float potencia) {
		if ( potencia < 0 ) {
			return false;
		}
		this.potencia = potencia;
		return true;
	}

	
	/**
	 * getter do atributo tensao
	 * @return valor de tensao
	 */
	public float getTensao() {
		return tensao;
	}
	/**
	 * setter do atributo tensao
	 * @param tensao
	 * @return 
	 */
	public boolean setTensao(float tensao) {
		if ( tensao < 0 ) {
			return false;
		}
		this.tensao = tensao;
		return true;
	}

	
	/**
	 * getter do atributo capacidade
	 * @return valor de capacidade
	 */	
	public float getCapacidade() {
		return capacidade;
	}
	/**
	 * setter do atributo capacidade
	 * @param capacidade
	 * @return 
	 */
	public boolean setCapacidade(float capacidade) {
		if ( capacidade < 0 ) {
			return false;
		}
		this.capacidade = capacidade;
		return true;
	}
	
	
	/**
	 * getter do atributo preco
	 * @return valor de preco
	 */	
	public float getPreco() {
		return preco;
	}
	/**
	 * setter do atributo preco
	 * @param preco
	 * @return 
	 */
	public boolean setPreco(float preco) {
		if ( preco < 0 ) {
			return false;
		}
		this.preco = preco;
		return true;
	}
	
	
	/**
	 * setter do atributo nome
	 * @param nome
	 * @return 
	 */
	public boolean setNome(String nome) {
		if ( !nome.isBlank() ) {
			this.nome = nome;
			return true;
		}
		return false;
	}
	/**
	 * getter do atributo nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * add um servicoManutencao no atributo arraylist que guarda os servicosManutencao
	 * @param servico
	 */
	public void addServicosRegistrados( ServicoManutencao servico ) {
		servicosRegistrados.add(servico);
	}
	/**
	 * remove um servicoManutencao no atributo arraylist que guarda os servicosManutencao
	 * @param indice
	 */
	public void removeServicosRegistrados( int indice ) {
		servicosRegistrados.remove( indice );
	}
	
	/**
	 * getter do atributo arraylist servicosRegistrados
	 * @return servicosRegistrados
	 */
	public ArrayList<ServicoManutencao> getServicosRegistrados() {
		return servicosRegistrados;
	}
}
