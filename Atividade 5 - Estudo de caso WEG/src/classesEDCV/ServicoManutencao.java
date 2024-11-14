package classesEDCV;


/**
 * Classe para criacao de um objeto ServicoManutencao
 * @author artur_hopner
 *
 */
public class ServicoManutencao {

	/** espaco para registrar a descricao do servico de manutencao*/
	private String descricao;
	/** espaco para registrar o custo em reais do servico de manutencao*/
	private Float custo;

	
	/**
	 * constructor com todos atributos
	 * @param descricao
	 * @param custo
	 */
	public ServicoManutencao ( String descricao , Float custo ) {
		setCusto ( custo );
		setDescricao ( descricao );
	}
	/**
	 * costructor vazio
	 */
	public ServicoManutencao () {
		
	}
	
	/**
	 * setter do atributo descricao
	 * @param custo
	 */
	public void setCusto(Float custo) {
		this.custo = custo;
	}
	/**
	 * getter do atributo descricao
	 * @return custo
	 */
	public Float getCusto() {
		return custo;
	}
	
	/**
	 * setter do atributo descricao
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * getter do atributo descricao
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
}
