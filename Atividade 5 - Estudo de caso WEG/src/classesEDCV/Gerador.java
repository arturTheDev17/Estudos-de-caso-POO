package classesEDCV;

/**
 * Classe para criação de um objeto Gerador, subclasse de ProdutoWEG
 * @author artur_hopner
 *
 */
public class Gerador extends ProdutoWEG {

	/** espaco para registrar o tipo de combustivel do gerador*/
	private String tipoCombustivel;
	/** espaco para registrar a autonomia em horas do gerador*/
	private Integer autonomia;
	
	/**
	 * Constructor com todos atributos
	 * @param codigo
	 * @param tipo
	 * @param potencia
	 * @param tensao
	 * @param capacidade
	 * @param preco
	 * @param tipoCombustivel
	 * @param autonomia
	 */
	public Gerador ( String nome , Object tipo , float potencia , float tensao , float preco , String tipoCombustivel , Integer autonomia ) {
		super ( nome , tipo , potencia , tensao , preco );
		setTipoCombustivel ( tipoCombustivel );
		setAutonomia ( autonomia );
	}
	/**
	 * Constructor vazio
	 */
	public Gerador ( ) {
		
	}
	
	/**
	 * getter do atributo tipoCombustivel
	 * @return tipoCombustivel
	 */
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	/**
	* setter do atributo tipoCombustivel 
 	* @param tipoCombustivel
 	*/
	public void setTipoCombustivel ( String tipoCombustivel ) {
		this.tipoCombustivel = tipoCombustivel;
	}

	/**
	 * getter do atributo autonomia
	 * @return autonomia
	 */
	public Integer getAutonomia() {
		return autonomia;
	}
	/**
	 * setter do atributo autonomia
	 * @param autonomia
	 */
	public void setAutonomia ( Integer autonomia ) {
		this.autonomia = autonomia;
	}
	
	
}
