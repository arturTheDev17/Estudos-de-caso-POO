package classesEDCV;
/**
 * Classe para criacao de um objeto MotorEletrico, subclasse de ProdutoWEG
 * @author artur_hopner
 *
 */
public class MotorEletrico extends ProdutoWEG {
	
	/** espaco para registrar o tipo de enrolamento da bobina do motor eletrico*/
	private String tipoEnrolamento;
	/** espaco para registrar a eficiencia (%) do motor eletrico*/
	private float eficiencia;
	
	/**
	 * metodo construtor contendo todos atributos da classe pai e mais os proprios
	 * @param codigo
	 * @param tipo
	 * @param potencia
	 * @param tensao
	 * @param capacidade
	 * @param preco
	 */
	public MotorEletrico ( String nome , Object tipo , float potencia , float tensao , float preco , String tipoEnrolamento , float eficiencia ) {
		super ( nome , tipo , potencia , tensao , preco );
		setEficiencia ( eficiencia );
		setTipoEnrolamento ( tipoEnrolamento );
		
	}
	
	/**
	 * Constructor vazio
	 */
	public MotorEletrico () {
		
	}
	
	
	/**
	 * setter do atributo eficiencia
	 * @param eficiencia
	 */
	public void setEficiencia ( float eficiencia ) {
		this.eficiencia = eficiencia;
	}
	
	/**
	 * getter do atributo eficiencia
	 * @return valor de eficiencia
	 */
	public float getEficiencia () {
		return eficiencia;
	}
	
	
	/**
	 * setter do atributo tipoEnrolamento
	 * @param tipoEnrolamento
	 */
	public void setTipoEnrolamento ( String tipoEnrolamento ) {
		this.tipoEnrolamento = tipoEnrolamento;
	}
	
	/**
	 * getter do atributo tipoEnrolamento
	 * @return valor de tipoEnrolamento
	 */
	public String getTipoEnrolamento () {
		return tipoEnrolamento;
	}

}
