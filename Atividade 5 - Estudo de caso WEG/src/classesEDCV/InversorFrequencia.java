package classesEDCV;


/**
 * Classe para criacao de um objeto InversorFrequencia, subclasse de ProdutoWEG
 * @author artur_hopner
 *
 */
public class InversorFrequencia extends ProdutoWEG {
	
	/** espaco para registrar a capacidade de frequencia do inversor*/
	private Float capacidadeFrequencia;
	/** espaco para registrar o numero de fases do inversor de frequencia*/
	private Integer numeroFases;
	
	/**
	 * Constructor com todos atributos
	 * @param codigo
	 * @param tipo
	 * @param potencia
	 * @param tensao
	 * @param capacidade
	 * @param preco
	 * @param capacidadeFrequencia
	 * @param numeroFases
	 */
	public InversorFrequencia ( String nome , Object tipo , float potencia , float tensao , float preco , Float capacidadeFrequencia , Integer numeroFases ) {
		super ( nome , tipo , potencia , tensao , preco );
		setCapacidadeFrequencia ( capacidadeFrequencia );
		setNumeroFases ( numeroFases );
	}
	/**
	 * Constructor vazio
	 */
	public InversorFrequencia() {
		
	}
	
	/**
	 * getter do atributo capacidadeFrequencia
	 * @return capacidadeFrequencia
	 */
	public Float getCapacidadeFrequencia() {
		return capacidadeFrequencia;
	}
	/**
	 * setter do atributo capacidadeFrequencia
	 * @param capacidadeFrequencia
	 */
	public void setCapacidadeFrequencia(Float capacidadeFrequencia) {
		this.capacidadeFrequencia = capacidadeFrequencia;
	}

	/**
	 * setter do atributo numeroFases
	 * @return numeroFases
	 */
	public Integer getNumeroFases() {
		return numeroFases;
	}
	/**
	 * getter do atributo numeroFases
	 * @param numeroFases
	 */
	public void setNumeroFases(Integer numeroFases) {
		this.numeroFases = numeroFases;
	}
	
}
