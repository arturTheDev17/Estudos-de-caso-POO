package exercicioEncapsulamento;

public class Produto {
	private String descricao;
	private float preco;
	private String nome;
	
	public boolean setDescricao ( String descricao ) {
		this.descricao = descricao;
		return true;
	} 
	public String getDescricao () {
		return this.descricao;
	}
	
	public boolean setNome ( String nome ) {
		this.nome = nome;
		return true;
	} 
	public String getNome () {
		return this.nome;
	}
	
	public boolean setPreco ( float preco ) {
		this.preco = preco;
		return true;
	} 
	public float getPreco () {
		return this.preco;
	}
}
